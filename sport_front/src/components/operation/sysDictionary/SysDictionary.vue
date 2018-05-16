<template>
  <div class="root">


    <!--列表展示-->
    <div class="align-left">
      <el-button-group>
        <!-- 字典信息添加放在字典组 -->
        <!--<el-button type="primary" icon="plus" @click="createOne">添加</el-button>
        <el-button type="primary" icon="edit" @click="modifyOne">修改</el-button>-->
        <el-button type="primary" icon="delete" @click="deleteOne">删除</el-button>
      </el-button-group>
    </div>
    <el-table :data="page.content" ref="singleTable" highlight-current-row @current-change="selectRow" stripe style="width: 100%">
      <el-table-column type="index" width="100"></el-table-column>
      <el-table-column prop="value" label="字典值" width="width: 50%" ></el-table-column>
      <el-table-column prop="label" label="字典描述" width="width: 50%" ></el-table-column>
      <el-table-column prop="sdg_groupId" label="字典组id" width="width: 50%" ></el-table-column>
      <el-table-column prop="sdg_groupName" label="字典组值" width="width: 50%" ></el-table-column>
      <el-table-column prop="status" label="状态" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.status=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.status==1 ? '有效' : '无效'}}
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



    <sys-dictionary-dialog :visible.sync="dictionaryDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="dictionaryTitle"></sys-dictionary-dialog>

  </div>
</template>

<script>
  import qs from 'qs'
  import SysDictionaryDialog from "./SysDictionaryDialog.vue";

  export default {
    components: {
      SysDictionaryDialog,
      },
    name: "sysDictionary",
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        dictionaryDialogVisible: false,
        currentModel: {},
        dictionaryTitle: "新增字典"
      }
    },
    mounted: function () {
      this.loadMainData();
    },

    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.dictionaryDialogVisible = false

        this.axios.get('/manage/system/sysDictionary/findDictionaryList?' + qs.stringify(this.searchForm))
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

        this.dictionaryTitle = "修改字典信息"
        this.currentModel = this.currentRow
        this.dictionaryDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除字典${this.currentRow.value}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/system/sysDictionary/delete/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.dictionaryDialogVisible = true
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
