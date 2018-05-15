<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <el-form ref="form" :rules="rules" :model="dialogForm" label-width="80px" >
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
    name: 'AdultVipRechargeDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String
    },
    data() {
      return {
        authGroups: [],
        authTagTypes : ['info', 'warning', 'success', 'danger'],// 未认证，认证中，已认证，认证失败
        useTagTypes: ['info', 'success', 'danger'],// 未开通，已开通，已到期
        dialogForm:{

        },
        rules: {
          authState: [
            { required: true, message: '请选择认证状态', trigger: 'blur' },
            {
              validator: (rule, value, callback) => {
                if(value==undefined) {
                  callback(new Error('请选择认证状态'))
                } else {
                  callback()
                }
              }
            }
          ]
        }
      }
    },
    computed: {

    },
    mounted: function () {
      this.loadAuthGroups()
    },
    methods: {
      onSubmit:function (formName) {
        this.loading = true
        var formData = this.dialogForm
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios({
              url: `/manage/system/vip/adult/verify/${this.currentModel.id}`,
              method: 'post',
              data: formData,
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
              this.$message({
                message: '操作成功',
                type: 'success'
              });
              //this.$refs[formName].resetFields()
              this.fileL= []
              this.$emit("submitSuccess")
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      loadAuthGroups: function () {
        this.axios.get('/manage/system/sysDictionary/findDictionaryInfoByGroupId/4')
          .then((response) => {
            console.log('response',response)
            this.authGroups = response.data.content;
          })
          .catch(err => {
            this.$message.error('列表加载出错' + err, 2)
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
