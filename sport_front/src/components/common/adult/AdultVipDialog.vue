<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="名称" >
        <span class="form-value">{{currentModel.loginName}}</span>
      </el-form-item>

      <el-form-item label="手机号码" >
        <span class="form-value">{{currentModel.phone}}</span>
      </el-form-item>

      <el-form-item label="认证状态">
        <span class="form-value"><el-tag :type="authTagTypes[currentModel.authState.status]">{{currentModel.authState.msg}}</el-tag></span>
      </el-form-item>

      <el-form-item label="使用状态">
        <span class="form-value"><el-tag :type="useTagTypes[currentModel.useState.status]">{{currentModel.useState.msg}}</el-tag></span>
      </el-form-item>

      <el-form-item label="到期时间" >
        <span class="form-value">{{currentModel.endDate}}</span>
      </el-form-item>

      <el-form-item label="认证头像" >
        <img class="form-value" style="width: 200px;height: 200px" src="https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100"/>
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
    name: 'AdultVipDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String
    },
    data() {
      return {
        authTagTypes : ['info', 'warning', 'success', 'danger'],// 未认证，认证中，已认证，认证失败
        useTagTypes: ['info', 'success', 'danger']// 未开通，已开通，已到期
      }
    },
    computed: {

    },
    mounted: function () {

    },
    methods: {
      onSubmit:function () {
        this.axios.post('/manage/system/card/merge',qs.stringify(this.currentModel, { skipNulls: true }))
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
  .form-value{
    margin-left: 20px;
  }
</style>
