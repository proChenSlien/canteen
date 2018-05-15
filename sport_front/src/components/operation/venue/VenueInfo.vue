<template>
  <div class="root">

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
      <el-table-column prop="venueName" label="场馆名称" width="width: 50%" ></el-table-column>
      <el-table-column prop="endTime" label="租赁到期时间" width="width: 50%" ></el-table-column>

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



    <user-dialog :visible.sync="venueDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="venueDialogTitle"></user-dialog>

    <!--添加-->
    <!--<el-dialog :title="title" :visible.sync="dialogShow" width="50%">
      <el-form ref="form" :model="dialogForm" :rules="rules" label-width="100px">

        <el-form-item label="场馆名称" prop="name" style="margin-top: 25px;">
          <el-input v-model="dialogForm.venueName" style="width: 50%;"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogShow = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit('form')">确 定</el-button>
      </div>
    </el-dialog>-->


  </div>
</template>

<script>
  import qs from 'qs'

    export default {
      name: "venueInfo",
      data() {
        return {
          searchForm: {},  //搜索
          page: {},       // 分页和数据
          currentRow: null, // 当前选中行
          venueDialogVisible: false,
          currentModel: {},
          venueDialogTitle: "新增场馆"
        }
      },
      mounted: function () {
        this.loadMainData();
      },

      methods: {
        // 主表数据加载
        loadMainData: function () {
          this.venueDialogVisible = false

          this.axios.get('/manage/venue/venueInfo/list?' + qs.stringify(this.searchForm))
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

          this.venueDialogTitle = "修改场馆"
          this.currentModel = this.currentRow
          this.venueDialogVisible = true
        },
        deleteOne: function () {
          if (this.currentRow == null) {
            this.$message.error('请先选中数据', 2)
            return
          }

          this.$confirm(`永久删除场馆${this.currentRow.username}, 是否继续?`, '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.axios.get(`/manage/venue/delete/${this.currentRow.id}`)
              .then((response) => {
                this.$message.success('删除成功!')
                this.loadMainData()
              })
          })
        },
        createOne: function () {
          this.currentModel = {}
          this.venueDialogVisible = true
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
