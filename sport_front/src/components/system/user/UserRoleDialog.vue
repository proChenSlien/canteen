<template>
  <el-dialog title="分配角色" :visible.sync="opened" width="700px">

    <el-table ref="multipleTable" :data="page.content"  @selection-change="rolesHandleSelectionChange" row-key="id"
              tooltip-effect="dark" stripe style="width: 100%">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
    </el-table>


    <!--分页-->
    <el-pagination v-show="page.content && page.content.length > 0"
                   :current-page.sync="page.number"
                   :page-size="page.size"
                   layout="total, prev, pager, next"
                   :total="page.totalElements"
                   class="page">
    </el-pagination>



    <div slot="footer" class="dialog-footer">
      <el-button @click="opened = false">取 消</el-button>
      <el-button type="primary" @click="onSubmit">确 定</el-button>
    </div>
  </el-dialog>


</template>

<script>
  import Popup from '@/components/common/utils/popup'
  import qs from 'qs'

  export default {
    name: 'userRoleDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
    },
    data() {
      return {
        page:{},
        selectedRoles: null,
      }
    },
    mounted: function () {
      this.loadRoleData()
    },
    methods: {
      onSubmit:function () {

        let ids = []
        this.selectedRoles.map(function (item) {
          ids.push(item.id)
        })

        console.log('this.currentModel',this.currentModel)

        this.axios.post('/manage/user/roles', `roleIds=${ids}&userId=${this.currentModel.id}`)
          .then((r) => {
            this.$message.success('设置成功!', 2)
            this.$emit("submitSuccess")
          })
      },

      //加载数据
      loadRoleData() {
        this.axios.get('/manage/role/list')
          .then((r) => {
            this.page = r.data.data
          })
      },
      //选中角色
      rolesHandleSelectionChange(val) {
        this.selectedRoles = val;
      },

      setCurrentUserRole(roles){

        this.$nextTick(function () {
          // 清除之前的选中状态
          this.$refs.multipleTable.clearSelection()

          this.page.content.forEach(row => {
            this.currentModel.roles.forEach(userRole => {
              if (row.id == userRole.id) {
                console.log("id", userRole.id)
                this.$refs.multipleTable.toggleRowSelection(row);
              }
            })
          })


        })

      }
    },
    watch: {
      opened(val) {
        if (val){
          this.setCurrentUserRole()
        }
      }
    }
  }
</script>


<style scoped lang="scss">
  .page {
    text-align: center;
  }
</style>
