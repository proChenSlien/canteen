<template>
  <div class="root">
    <el-form :inline="true" :model="searchForm" class="form-person" label-width="600px">
      <el-form-item label="" label-width="600px">
        <el-input v-model="searchForm.name"  placeholder="关键字" label-width="600px"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <div class="align-left">
      <el-button-group>
        <el-button type="primary" icon="edit" @click="modifyItem">修改</el-button>
        <el-button type="primary" icon="share" @click="createItem">新增</el-button>
        <el-button type="primary" icon="delete" @click="deleteItem">删除</el-button>
        <el-button type="primary" icon="edit" @click="modifyResource">权限</el-button>
        <el-button type="primary" icon="delete" @click="sync">同步</el-button>
      </el-button-group>
    </div>
    <el-table :data="tableData" ref="singleTable" highlight-current-row  @current-change="selectRow" stripe style="width: 100%">
      <el-table-column type="index"  width="180"> </el-table-column>
      <el-table-column prop="name" label="名称" width="180"> </el-table-column>
      <el-table-column prop="description" label="描述" > </el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-show="tableData.length > 0"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>


    <el-dialog title="新增角色" :visible.sync="dialogShow">
      <el-form ref="form" :model="dialogForm" label-width="80px">
        <el-form-item label="名称">
          <el-input v-model="dialogForm.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="dialogForm.description"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogShow = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="权限分配" :visible.sync="authorityDialogShow">
      <el-tree
        :data="authorityData"
        show-checkbox
        default-expand-all
        node-key="id"
        ref="tree"
        highlight-current
        :default-checked-keys="defaultCheckedKeys"
        :props="defaultProps">
      </el-tree>
      <div slot="footer" class="dialog-footer">
        <el-button @click="authorityDialogShow = false">取 消</el-button>
        <el-button type="primary" @click="setAuth">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>

  import {authority} from '@/router/authority'

  export default {
    name: 'roleManager',
    data () {
      return {
        searchForm: {},  //搜索框
        tableData: [],   //列表
        dialogForm: {},   //对话框属性
        page:{},         //分页
        dialogShow: false,
        currentRow: null, //选中的行
        authorityDialogShow: false,
        authorityData: [],
        defaultCheckedKeys: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    mounted: function () {
      this.loadData()  //加载表数据
      this.loadResourceData()  //加载所有权限数据
    },
    methods: {
      setAuth() {
        var ids = [];  //只存叶子节点
        this.$refs.tree.getCheckedNodes().forEach(function (item ) {
          if (!item.children || item.children.length == 0){
            ids.push(item.id)
          }
        })

        this.axios.post('/manage/role/auth',`resourceIds=${ids}&userId=${this.currentRow.id}`)
          .then((r) => {
          this.authorityDialogShow = false
            this.$message.success('设置成功!', 2)
        })

      },


//      setSelected(){
//        this.$refs.tree.setCheckedNodes([{
//          path:'/home'
//        }])
//      },
      onSubmit () {
        this.axios({
          url: '/manage/role/merge',
          method: 'post',
          data: this.dialogForm,
          transformRequest: [function (data) {
            let ret = ''
            for (let it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            return ret
          }],
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        }).then((r) => {
          this.dialogShow = false
          this.loadData()
        })
      },
      sync(){
        this.axios.post('/manage/resource/sync',authority)
          .then((r) => {
            this.$message({
              type: 'success',
              message: '同步成功!'
            }, 2)
          })
      },
      //选中行
      selectRow(val) {
        this.currentRow = val
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`)
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`)
      },
      //新建对象
      createItem() {
        this.dialogShow = true
        this.dialogForm = {      //弹层 form
          name: '',
          description: '',
          enabled: 'true'
        }
      },

      //修改对象
      modifyItem() {
        if (this.currentRow == null) {
          this.$message.error('请选择要修改的数据', 2)
          return
        }

        this.dialogShow = true
        this.dialogForm = this.currentRow

      },

      //删除对象
      deleteItem() {
        if (this.currentRow == null) {
          this.$message.error('请选择要删除的数据', 2)
          return
        }

        this.$confirm(`删除角色${this.currentRow.name}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/role/delete/${this.currentRow.id}`)
            .then((response) => {

              this.$message({
                type: 'success',
                message: '删除成功!'
              }, 2)
              this.loadData()
            })
        })

      },
      modifyResource() {
        if (this.currentRow == null) {
          this.$message.error('请选择要编辑的数据', 2)
          return
        }

        this.authorityDialogShow =true;
        let keys = [];
        this.currentRow.resources.map(function (item) {
          keys.push(item.id)
        })
        this.defaultCheckedKeys = keys;    //默认只能设置一次
        try {
          this.$refs.tree.setCheckedKeys(this.defaultCheckedKeys);
        }catch(e) {}

      },

      loadResourceData() {
        this.axios.get('/manage/resource/root')
          .then((r) => {
            this.authorityData = [r.data.content.root]
          })
      },

      //加载数据
      loadData() {
        this.axios.get('/manage/role/list')
          .then((response) => {
            this.tableData = response.data.content.page.content
            this.page = response.data.content.page
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
