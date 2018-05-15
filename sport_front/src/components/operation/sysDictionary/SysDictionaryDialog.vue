<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="字典值">
        <el-input v-model="currentModel.val"></el-input>
      </el-form-item>

      <el-form-item label="字典说明">
        <el-input v-model="currentModel.remark"></el-input>
      </el-form-item>

      <el-form-item label="序号">
        <el-input v-model="currentModel.label"></el-input>
      </el-form-item>

    </el-form>
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
    name: 'sysDictionaryDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {
      }
    },
    mounted: function () {

    },
    methods: {
      onSubmit:function () {
        console.log('this.currentModel',this.currentModel)
        this.axios.post('/manage/system/sysDictionary/merge',qs.stringify(this.currentModel, { skipNulls: true }))
          .then((r) => {
            this.$emit("submitSuccess")
          })
      }
    }
  }
</script>


<style scoped lang="scss">
  .root{
    .el-input, .el-select {
      width:300px;
    }
  }
</style>
