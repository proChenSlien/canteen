<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.goodsName" placeholder="商品名"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="searchForm.typeId" placeholder="类型名"></el-input>
      </el-form-item>

      <el-form-item label="">
        <el-select v-model="searchForm.state" placeholder="状态">
          <el-option
            v-for="item in [{label:'全部'},{label:'上架',value: 1},{label:'下架',value: 0}]"
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
      <el-table-column prop="goodsName" label="商品名" width="width: 50%" ></el-table-column>
      <el-table-column prop="typeName" label="商品类型" width="width: 50%" ></el-table-column>
      <el-table-column prop="price" label="单价" width="width: 50%" ></el-table-column>
      <el-table-column prop="remark" label="说明" width="width: 50%" ></el-table-column>
      <el-table-column prop="stock" label="库存" width="width: 50%" ></el-table-column>
      <el-table-column prop="volumeDay" label="日销量" width="width: 50%" ></el-table-column>
      <el-table-column prop="volumeMonth" label="月销量" width="width: 50%" ></el-table-column>
      <el-table-column prop="volumeYear" label="年销量" width="width: 50%" ></el-table-column>

      <el-table-column prop="state" label="状态" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.state=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.state==1 ? '上架' : '下架'}}
          </el-tag>
        </template>
      </el-table-column>
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
  import GoodsDialog from "./GoodsDialog";

  export default {
    components: {
      GoodsDialog,
    },
    name: "goods",
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        goodsDialogVisible: false,
        currentModel: {},
        goodsDialogTitle: "新增类型"
      }
    },
    mounted: function () {
      this.loadMainData();
    },

    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.goodsDialogVisible = false

        this.axios.get('/manage/goods/goodsList?' + qs.stringify(this.searchForm))
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

        this.goodsDialogTitle = "修改类型"
        this.currentModel = this.currentRow
        this.goodsDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除类型${this.currentRow.goodsName}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/goods/deleteGoods/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.goodsDialogVisible = true
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
