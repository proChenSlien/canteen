<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.orderNum" placeholder="订单号"></el-input>
      </el-form-item>

      <el-form-item label="">
        <el-select v-model="searchForm.state" placeholder="有效性">
          <el-option
            v-for="item in [{label:'全部'},{label:'有效',value: 1},{label:'无效',value: 0}]"
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

    <!--列表展示-->
    <div class="align-left">
      <el-button-group>
        <el-button type="primary" icon="plus" @click="createOne">添加</el-button>
        <el-button type="primary" icon="edit" @click="modifyOne">修改</el-button>
        <el-button type="primary" icon="delete" @click="deleteOne">删除</el-button>
      </el-button-group>
    </div>
    <el-table :data="page.content" ref="singleTable" highlight-current-row @current-change="selectRow" stripe style="width: 100%">
      <el-table-column type="index" width="100"></el-table-column>
      <el-table-column prop="orderNum" label="订单号" width="width: 50%" ></el-table-column>

      <el-table-column prop="valid" label="有效性" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.valid=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.valid==1 ? '有效' : '无效'}}
          </el-tag>
        </template>
      </el-table-column>
    </el-table>


    <!--分页-->
    <el-pagination v-show="page.content.length > 0"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page.sync="currentPage"
                   :page-sizes="[5, 10, 15, 20]"
                   :page-size="pageSize"
                   layout="total, sizes, prev, pager, next, jumper"
                   :total="totalCount"
                   class="page">
    </el-pagination>

    <goods-dialog :visible.sync="goodsDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                  :title="goodsDialogTitle"></goods-dialog>


  </div>
</template>

<script>
  import qs from 'qs'
  import OrderDialog from "./OrderDialog";

  export default {
    components: {
      OrderDialog,
    },
    name: "order",
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        orderDialogVisible: false,
        currentModel: {},
        orderDialogTitle: "新增订单"
      }
    },
    mounted: function () {
      this.loadMainData();
    },

    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.orderDialogVisible = false

        this.axios.get('/manage/order/list?' + qs.stringify(this.searchForm))
          .then((response) => {
            console.log('response', response)
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

        this.orderDialogTitle = "修改订单"
        this.currentModel = this.currentRow
        this.orderDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除订单${this.currentRow.orderNum}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/order/deleteOrder/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.orderDialogVisible = true
      },

      customIndex: function (index) {
        return index * this.page.number + 1
      },

      selectRow: function (val) {
        this.currentRow = val
      }
    }
  }
</script>

<style scoped>

</style>
