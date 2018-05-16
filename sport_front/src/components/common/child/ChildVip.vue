<template>
  <div class="root">
    <!--查询条件-->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="姓名">
        <el-input v-model="searchForm.babyName" placeholder="名称"></el-input>
      </el-form-item>
      <el-form-item label="认证状态">
        <el-select v-model="searchForm.authState" clearable placeholder="请选择">
          <el-option
            v-for="item in cardGroups"
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
        <el-button type="primary" icon="verify" @click="verify">审核</el-button>
        <el-button type="primary" icon="recharge" @click="recharge">充值</el-button>
      </el-button-group>
    </div>

    <!--主表-->
    <el-table :data="page.content" highlight-current-row @current-change="selectRow" stripe style="width: 100%"
              align="left">
      <el-table-column
        type="index"
        :index="customIndex">
      </el-table-column>
      <el-table-column prop="babyName" label="姓名" width="180"></el-table-column>
      <el-table-column prop="authState.msg" label="认证状态" width="180" ></el-table-column>
      <el-table-column prop="useState.msg" label="使用状态" width="180" ></el-table-column>
      <el-table-column prop="babySex" label="性别" width="180">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.babySex == 1 ? 'primary' : 'warning'"
            close-transition>{{ scope.row.babySex == 1 ? '男' : '女'}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="到期时间" width="180">
        <template slot-scope="scope">
          <span>{{ scope.row.endDate }}</span>
        </template>
      </el-table-column>

      <el-table-column label="第一次开通时间">
        <template slot-scope="scope">
          <span>{{ scope.row.activeTime }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="mainUserId" label="创建人" width="180"></el-table-column>

    </el-table>

    <!--分页-->
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>

    <child-vip-dialog :visible.sync="dialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                 :title="dialogTitle"></child-vip-dialog>

    <child-vip-recharge-dialog :visible.sync="rechargeDialogVisible" @submitSuccess="loadMainData" :currentModel="currentModel"
                               :title="dialogTitle" ></child-vip-recharge-dialog>
  </div>
</template>

<script>
  import qs from 'qs'
  import ChildVipDialog from "./ChildVipDialog.vue"
  import ChildVipRechargeDialog from "./ChildVipRechargeDialog.vue"
  export default {
    components: {
      ChildVipDialog,
      ChildVipRechargeDialog
    },
    name: 'AdultVip',
    data() {
      return {
        searchForm: {},  //搜索
        page: {},       // 分页和数据
        currentRow: null, // 当前选中行
        dialogVisible: false,
        rechargeDialogVisible : false,
        currentModel: {
          authState:{},
          useState:{}
        },
        dialogTitle: "新增会员卡",
        cardGroups:[]
      }
    },
    mounted: function () {
      this.loadMainData();
      this.loadCardGroups();
    },
    methods: {
      // 主表数据加载
      loadMainData: function (res) {
        if(res && res.ok){
          this.currentModel = res.content
        }
        this.dialogVisible = false
        this.axios.get('/manage/system/vip/child/query/list?' + qs.stringify(this.searchForm))
          .then((response) => {
            console.log('list',response)
            this.page = response.data.content.page;
          })
          .catch(err => {
            this.$message.error('列表加载出错' + err, 2)
          })
      },
      loadCardGroups: function () {
        this.axios.get('/manage/system/sysDictionary/findDictionaryInfoByGroupId/3')
          .then((response) => {
            console.log('response',response)
            this.cardGroups = response.data.content;
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
      verify: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.dialogTitle = "会员审核"
        this.currentModel = this.currentRow
        this.dialogVisible = true
      },

      recharge: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }
        this.dialogTitle = "会员充值"
        this.currentModel = this.currentRow
        this.rechargeDialogVisible = true
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
