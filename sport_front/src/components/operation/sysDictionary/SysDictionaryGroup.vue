<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.groupName" placeholder="名称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchIt">查询</el-button>
      </el-form-item>
    </el-form>

    <!--工具条-->
    <div class="tool-bar">
      <el-button-group>
        <el-button type="primary" icon="plus" @click="createOne">添加</el-button>
        <el-button type="primary" icon="edit" @click="modifyOne">修改</el-button>
        <el-button type="primary" icon="delete" @click="deleteOne">删除</el-button>
        <el-button type="primary" icon="createDictionary" @click="createDictionary">添加字典信息</el-button>
      </el-button-group>
    </div>

    <!--主表-->
    <el-table :data="page.content" highlight-current-row @current-change="selectRow" stripe style="width: 100%"
              align="left">
      <el-table-column
        type="index"
        :index="customIndex">
      </el-table-column>
      <el-table-column prop="groupName" label="字典组名称" width="width: 50%" ></el-table-column>
      <el-table-column prop="groupRemark" label="字典组描述" width="width: 50%" ></el-table-column>
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
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>

    <sys-dictionary-dialog :visible.sync="dictionaryDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                           :title="dictionaryTitle"></sys-dictionary-dialog>

    <sys-dictionary-group-dialog :visible.sync="dictionaryDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                           :title="dictionaryTitle"></sys-dictionary-group-dialog>
  </div>
</template>

<script>
  import qs from 'qs'
  import SysDictionaryDialog from "./SysDictionaryDialog.vue";
  import SysDictionaryGroupDialog from "./SysDictionaryGroupDialog.vue";
  export default {
    components: {
      SysDictionaryDialog,
      SysDictionaryGroupDialog
    },
    name: 'sysDictionaryGroup',
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        dialogVisible: false,
        dictionaryDialogVisible : false,
        currentModel: {
        },
        dictionaryTitle: "新增字典组信息",
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {
      // 主表数据加载
      loadMainData: function (res) {
        if(res && res.ok){
          this.currentModel = res.content
        }
        this.dialogVisible = false
        this.axios.get('/manage/system/sysDictionaryGroup/list?' + qs.stringify(this.searchForm))
          .then((response) => {
            console.log('list',response)
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

        this.dialogTitle = "修改字典组信息"
        this.currentModel = this.currentRow
        this.dialogVisible = true
      },


      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除${this.currentRow.username}及其该字典组下的字典值, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/system/sysDictionaryGroup/deleteGAndD/${this.currentRow.groupId}`)
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

      createDictionary: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.currentModel = this.currentRow
        this.dictionaryDialogVisible = true
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
