<template>
  <div class="root">

    <!--查询-->
    <el-form :inline="true" :model="searchForm" class="form-person" label-width="600px" size="small">
      <el-form-item label="" label-width="600px">
        <el-input v-model="searchForm.userName" placeholder="员工姓名" label-width="600px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="search" @click="searchData">查询</el-button>
      </el-form-item>
    </el-form>

    <!--列表-->
    <el-table :data="tableData" ref="singleTable" highlight-current-row @current-change="selectRow" stripe
              style="width: 100%">
      <el-table-column type="index" width="80"></el-table-column>
      <el-table-column prop="userName" label="用户名"></el-table-column>
      <el-table-column prop="days" label="兑换天数"></el-table-column>
      <el-table-column prop="createTime" label="兑换时间"></el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-show="tableData.length > 0"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page.sync="currentPage"
                   :page-sizes="[5, 10, 15, 20]"
                   :page-size="pageSize"
                   layout="total, sizes, prev, pager, next, jumper"
                   :total="totalCount"
                   class="page">
    </el-pagination>

  </div>
</template>

<script>
  import * as types from '@/store/mutation-types'

  export default {
    data() {
      return {
        searchForm: {
          userName: ''
        },
        title: '',
        tableData: [],   // 数据列表
        dialogForm: {
          leaveTypeName: '',
          id: ''
        },
        pageSize: 10, // 默认每页数据量
        currentPage: 1, // 当前页码
        start: 1, // 查询的页码
        totalCount: 0,  // 默认数据总数
        dialogShow: false,
        currentRow: null, // 选中的行
      }
    },
    mounted: function () {
      this.loadData()  // 加载表数据
    },
    methods: {
      // 选中行
      selectRow(val) {
        this.currentRow = val
      },

      searchData() {
        this.loadData()
      },

      //调整每页条数
      handleSizeChange: function (val) {
        this.pageSize = val;
        this.loadData();
      },

      //调整页数
      handleCurrentChange: function (val) {
        this.currentPage = val;
        this.loadData();
      },

      //加载数据
      loadData() {
        this.axios.get('/manage/conversion/record/list', {
          params: {
            'userName': this.searchForm.userName.trim(),
            size: this.pageSize,
            page: this.currentPage
          }
        })
          .then((response) => {
            this.tableData = response.data.content.page.content;
            this.page = response.data.content.page;
            this.totalCount = this.page.totalElements;
          }).catch(err => {
          this.$message.error('列表加载出错' + err, 2)
        })
      }

    }
  }
</script>

<style scoped lang="scss">

  .root {
    margin-left: 20px;
    margin-right: 20px;
    margin-top: 5px;
    .el-form-item {
      margin-bottom: 3px;
    }

    .el-button-group {
      border-right: 1px solid #FFFFFF;
      border-right-color: rgba(255, 255, 255, .5);
    }

  }

  .align-left {
    text-align: left;
    margin-bottom: 3px;
    background-color: #20A0FF;
    .el-button {
      border-radius: 0 !important;
    }
  }

  .form-person {
    text-align: left;
  }

  .page {
    margin-top: 10px;
    text-align: center;
  }
</style>

