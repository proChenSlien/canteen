<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="">
        <el-input v-model="searchForm.userId" placeholder="用户ID"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="searchForm.address" placeholder="地址"></el-input>
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
      <el-table-column prop="userId" label="用户" width="width: 50%" ></el-table-column>
      <el-table-column prop="address" label="地址" width="width: 50%" ></el-table-column>
      <el-table-column prop="isDefault" label="是否默认" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.isDefault=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.isDefault==1 ? '默认' : '非默认'}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="state" label="状态" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.state=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.state==1 ? '启用' : '停用'}}
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




    <address-dialog :visible.sync="addressDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                  :title="addressDialogTitle"></address-dialog>


  </div>
</template>

<script>
  import qs from 'qs'
  import AddressDialog from "./AddressDialog";

  export default {
    components: {
      AddressDialog,
    },
    name: "address",
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        addressDialogVisible: false,
        currentModel: {},
        addressDialogTitle: "新增地址"
      }
    },
    mounted: function () {
      this.loadMainData();
    },

    methods: {
      // 主表数据加载
      loadMainData: function () {
        this.addressDialogVisible = false

        this.axios.get('/manage/address/list?' + qs.stringify(this.searchForm))
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

        this.addressDialogTitle = "修改地址"
        this.currentModel = this.currentRow
        this.addressDialogVisible = true
      },
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`永久删除地址${this.currentRow.address}, 是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/manage/address/deleteAddress/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadMainData()
            })
        })
      },
      createOne: function () {
        this.currentModel = {}
        this.addressDialogVisible = true
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
