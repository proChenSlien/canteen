<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-select v-model="searchForm.enabled" placeholder="是否启用">
          <el-option
            v-for="item in [{label:'全部'},{label:'启用',value: true},{label:'禁用',value: false}]"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchIt">查询</el-button>
      </el-form-item>
    </el-form>

    <!--工具条-->
    <div class="tool-bar">
      <el-button-group>
        <el-button type="primary" icon="edit" @click="modifyOne">修改</el-button>
        <el-button type="primary" icon="share" @click="createOne">新增</el-button>
        <el-button type="primary" icon="delete" @click="deleteOne">删除</el-button>
        <el-button type="primary" icon="delete" @click="modifyRole">分配角色</el-button>
      </el-button-group>
    </div>

    <!--主表-->
    <el-table :data="page.content" highlight-current-row @current-change="selectRow" stripe style="width: 100%"
              align="left">
      <el-table-column
        type="index"
        :index="customIndex">
      </el-table-column>
      <el-table-column prop="username" label="用户名" width="180"></el-table-column>
      <el-table-column prop="enabled" label="是否启用" width="180">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.enabled ? 'primary' : 'warning'"
            close-transition>{{ scope.row.enabled ? '启用' : '禁用'}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="最后登录时间">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.lastLoginTime }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="lastLoginIp" label="最后登录IP"></el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>

    <user-dialog :visible.sync="userDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="userDialogTitle"></user-dialog>

    <user-role-dialog :visible.sync="userRoleDialogVisible" @submitSuccess="loadMainData" :currentModel="currentRow"> </user-role-dialog>
  </div>
</template>

<script>
  import qs from 'qs'
  import UserDialog from "./UserDialog.vue";
  import UserRoleDialog from "./UserRoleDialog.vue";

  export default {
    components: {
      UserRoleDialog,
      UserDialog},
    name: 'user',
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        userDialogVisible: false,
        userRoleDialogVisible: false,
        currentModel: {},
        userDialogTitle: "新增用户"
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.userDialogVisible = false
        this.userRoleDialogVisible = false

        this.axios.get('/manage/user/list?' + qs.stringify(this.searchForm))
          .then((response) => {
          console.log('response',response)
            this.page = response.data.content.page;
          })
          .catch(err => {
            this.$message.error('列表加载出错' + err, 2)
          })
      },

      // search
      searchIt: function () {
        this.loadMainData()
      },

      // tool-bar
      modifyOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.userDialogTitle = "修改用户"
        this.currentModel = this.currentRow
        this.userDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除用户${this.currentRow.username}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/user/delete/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.userDialogVisible = true
      },
      modifyRole: function () {
        if (this.currentRow == null) {
          this.$message.error('请选择用户', 2)
          return
        }
        this.userRoleDialogVisible = true
      },

      // table
      customIndex: function (index) {
        return index * this.page.number + 1
      },

      selectRow: function (val) {
        this.currentRow = val
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../../../src/assets/scss/common.scss";
</style>
