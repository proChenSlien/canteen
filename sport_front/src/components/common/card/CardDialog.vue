<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="名称" >
        <el-input v-model="currentModel.name"></el-input>
      </el-form-item>

      <el-form-item label="类型">
        <el-select v-model="currentModel.type" placeholder="类型">
          <el-option label="成人卡" :value="1"></el-option>
          <el-option label="儿童卡" :value="2"></el-option>
        </el-select>
      </el-form-item>

      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-remove="handleRemove"
        :on-success="successUpload"
        :file-list="fileList2"
        :multiple=false
        list-type="picture">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>

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
    name: 'CardDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {

      }
    },
    computed: {
      fileList2 : function() {
        return [
          {name: this.currentModel.name, url: this.currentModel.bgImgUrl}
        ]
      }
    },
    mounted: function () {

    },
    methods: {
      handleRemove(file, fileList) {
        if(file.status === 'success'){
          this.currentModel.bgImgUrl = null
        }
      },
      successUpload(response, file, fileList){
          if(fileList.length > 1){
            fileList.splice(0,1);
          }
        this.currentModel.bgImgUrl = response.id
      },
      onSubmit:function () {
        console.log('this.currentModel',this.currentModel)
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
</style>
