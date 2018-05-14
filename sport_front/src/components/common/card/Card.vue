<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.name" placeholder="名称"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-select v-model="searchForm.type" placeholder="是否启用">
          <el-option
            v-for="item in [{label:'全部'},{label:'成人卡',value: 1},{label:'儿童卡',value: 2}]"
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
      </el-button-group>
    </div>

    <!--主表-->
    <el-table :data="page.content" highlight-current-row @current-change="selectRow" stripe style="width: 100%"
              align="left">
      <el-table-column
        type="index"
        :index="customIndex">
      </el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="type" label="类型" width="180">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.type ? 'primary' : 'warning'"
            close-transition>{{ scope.row.type == 1 ? '成人卡' : '儿童卡'}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="bgImgUrl"
        label="背景图"
        sortable
        width="180">
        <template slot-scope="scope">
          <img  :src="scope.row.bgImgUrl" alt="" style="width: 50px;height: 50px">
        </template>
      </el-table-column>
      <el-table-column label="创建时间">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.updateTime }}</span>
        </template>
      </el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>

    <card-dialog :visible.sync="dialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="dialogTitle"></card-dialog>

  </div>
</template>

<script>
  import qs from 'qs'

  import CardDialog from "./CardDialog.vue";
  export default {
    components: {
      CardDialog
    },
    name: 'user',
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        dialogVisible: false,
        currentModel: {},
        dialogTitle: "新增会员卡"
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.dialogVisible = false
        this.axios.get('/manage/system/card/list?' + qs.stringify(this.searchForm))
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

        this.dialogTitle = "修改会员卡"
        this.currentModel = this.currentRow
        this.dialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除${this.currentRow.username}, 是否继续?`, '提示', {
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
        this.dialogVisible = true
      },
      modifyRole: function () {
        if (this.currentRow == null) {
          this.$message.error('请选择用户', 2)
          return
        }
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
