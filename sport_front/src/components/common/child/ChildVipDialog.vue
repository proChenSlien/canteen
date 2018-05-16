<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :rules="rules" :model="dialogForm" label-width="80px" >
      <el-form-item label="姓名" >
        <span class="form-value">{{currentModel.babyName}}</span>
      </el-form-item>

      <el-form-item label="性别">
        <span class="form-value"><el-tag :type="sexTagTypes[currentModel.babySex]">
          {{ currentModel.babySex == 1 ? '男' : '女'}}
        </el-tag></span>
      </el-form-item>

      <el-form-item label="创建人" >
        <span class="form-value">{{currentModel.mainUserId}}</span>
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

      <el-form-item label="是否通过" prop="authState">
        <el-select clearable v-model="dialogForm.authState" placeholder="请选择是否通过">
          <el-option
            v-for="item in authGroups"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
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
    name: 'AdultVipDialog',
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
        sexTagTypes: ['','primary','warning'],
        dialogForm:{
          authState: ''
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
    watch: {
      currentModel: function (model) {
        console.log('model',model)

        if(model.authState.status){
          if(model.authState.status == 2 || model.authState.status ==3){
            this.dialogForm.authState = model.authState.status
          }else{
            this.dialogForm.authState = ''
          }
        }
      }
    },
    methods: {
      onSubmit:function (formName) {
        this.loading = true
        var formData = this.dialogForm
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios({
              url: `/manage/system/vip/child/verify/${this.currentModel.id}`,
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
