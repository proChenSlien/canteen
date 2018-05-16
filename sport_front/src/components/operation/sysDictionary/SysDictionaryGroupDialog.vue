<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :rules="rules" :model="dialogForm" label-width="80px" >
      <el-form-item label="名称" >
        <span class="form-value">{{currentModel.groupName}}</span>
      </el-form-item>

      <el-form-item label="描述" >
        <span class="form-value">{{currentModel.groupRemark}}</span>
      </el-form-item>



    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="opened = false">取 消</el-button>
      <el-button type="primary" @click="onSubmit('form')">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
  import Popup from '@/components/common/utils/popup'
  import qs from 'qs'

  export default {
    name: 'SysDictionaryGroupDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String
    },
    data() {
      return {


      }
    },
    computed: {

    },
    mounted: function () {
      this.loadAuthGroups()
    },
    watch: {
      currentModel: function (model) {
        console.log('model',model)
        this.dialogForm.authState = model.authState.status
      }
    },
    methods: {
      onSubmit:function (formName) {
        console.log('this.currentModel',this.currentModel)
        this.axios.post('/manage/system/sysDictionaryGroup/merge',qs.stringify(this.currentModel, { skipNulls: true }))
          .then((r) => {
            this.$emit("submitSuccess")
          })
      },

    }
  }
</script>


<style scoped lang="scss">
  .root{
    .el-input, .el-select {
      width:300px;
    }
  }
  .form-value{
    margin-left: 20px;
  }
</style>
