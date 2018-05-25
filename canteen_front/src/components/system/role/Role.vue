<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.name" placeholder="关键字" label-width="600px"></el-input>
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
        <el-button type="primary" icon="edit" @click="modifyAuth">权限</el-button>
        <el-button type="primary" icon="delete" @click="sync">同步</el-button>
      </el-button-group>
    </div>

    <!--主表-->
    <el-table :data="page.content" highlight-current-row @current-change="selectRow" stripe style="width: 100%">
      <el-table-column type="index" :index="customIndex"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>

    <role-dialog :visible.sync="roleDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="roleDialogTitle"></role-dialog>

    <authority-dialog :visible.sync="authDialogVisible" @submitSuccess="loadMainData" :currentModel="currentRow"
                 :title="authDialogTitle"></authority-dialog>
  </div>
</template>

<script>
  import qs from 'qs'
  import RoleDialog from "./RoleDialog.vue";
  import AuthorityDialog from "./AuthorityDialog.vue";
  import { businessRouters } from "@/router/index"

  export default {
    components: {
      AuthorityDialog,
      RoleDialog
    },
    name: 'role',
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        roleDialogVisible: false,
        currentModel: {},
        roleDialogTitle: "新增角色",

        authDialogVisible: false,
        authDialogTitle: "权限分配"
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.roleDialogVisible = false
        this.authDialogVisible = false
        this.axios.get('/manage/role/list?' + qs.stringify(this.searchForm))
          .then((response) => {
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

        this.roleDialogTitle = "修改角色"
        this.currentModel = this.currentRow
        this.roleDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除角色${this.currentRow.name}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/role/delete/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.roleDialogVisible = true
      },
      modifyAuth: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }
        console.log('currentRow',this.currentRow)

        this.authDialogVisible = true
      },
      sync(){
        this.axios.post('/manage/resource/sync',businessRouters)
          .then((r) => {
            this.$message.success('同步成功!', 2)
          })
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
  @import "src/assets/scss/common.scss";
</style>
