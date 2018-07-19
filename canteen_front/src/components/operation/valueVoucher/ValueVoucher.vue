<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.vvName" placeholder="优惠券名"></el-input>
      </el-form-item>

      <el-form-item label="">
        <el-select v-model="searchForm.valid" placeholder="有效性">
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
      <el-table-column prop="vvName" label="优惠券名" width="width: 50%" ></el-table-column>
      <el-table-column prop="discount" label="折扣" width="width: 50%" ></el-table-column>
      <el-table-column prop="validTime" label="有效日期" width="width: 50%" ></el-table-column>
      <el-table-column prop="vvRemark" label="说明" width="width: 50%" ></el-table-column>
      <el-table-column prop="validDays" label="有效天数" width="width: 50%" ></el-table-column>

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

    <value-voucher-dialog :visible.sync="valueVoucherDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                  :title="valueVoucherDialogTitle"></value-voucher-dialog>


  </div>
</template>

<script>
  import qs from 'qs'
  import ValueVoucherDialog from "./ValueVoucherDialog";

  export default {
    components: {
      ValueVoucherDialog,
    },
    name: "valueVoucher",
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        valueVoucherDialogVisible: false,
        currentModel: {},
        valueVoucherDialogTitle: "新增优惠券"
      }
    },
    mounted: function () {
      this.loadMainData();
    },

    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.valueVoucherDialogVisible = false

        this.axios.get('/manage/valueVoucher/list?' + qs.stringify(this.searchForm))
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

        this.valueVoucherDialogTitle = "修改优惠券"
        this.currentModel = this.currentRow
        this.valueVoucherDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除优惠券${this.currentRow.vvName}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/valueVoucher/deleteVoucher/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.valueVoucherDialogVisible = true
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
