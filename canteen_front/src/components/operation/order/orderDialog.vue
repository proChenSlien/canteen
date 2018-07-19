<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="背景图片" prop="bgImgUrl" style="">
        <el-upload
          class="upload-demo"
          :action="imageUploadSrc"
          :on-remove="fileHandleRemove"
          :file-list="fileList2"
          :on-exceed="fileHandleExceed"
          :on-success="fileHandleSuccess"
          :limit="1"
          list-type="picture"
          multiple>
          <i class="el-icon-upload"></i>
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
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
  import * as types from '@/store/mutation-types'
  import {imageUpload, imageView, imageDeleteShort} from '@/api/http'
  import qs from 'qs'

  export default {
    name: 'orderDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {
        imageUploadSrc: imageUpload,
        fileList2: [],
        dialogForm: {
          bgImgUrl: ''
        },
        rules: {
          bgImgUrl: [
            {required: true, message: '请输入背景图片', trigger: 'blur'}
          ]
        }
      }
    },
    mounted: function () {

    },
    methods: {
      onSubmit:function () {
        console.log('this.currentModel',this.currentModel)
        this.axios.post('/manage/goodsType/merge',qs.stringify(this.currentModel, { skipNulls: true }))
          .then((r) => {
            this.$emit("submitSuccess")
          })
      },

      fileHandleRemove(file, fileList) {
        this.axios.get(this.imageDeleteShortSrc + file.name).then((r) => {
          if (r.data.ok || r.data.code == 104) {
            this.fileL = fileList
          }
        })
      },
      fileHandleSuccess(response, file, fileList) {
        file.name = response.content.data[0]
        file.url = imageView + file.name + '.jpg'
        this.fileL = fileList;
        this.dialogForm.bgImgUrl = fileList;
      },
      fileBeforeRemove(file, fileList) {
        return this.$confirm(`确定删除？？？？？ ${ file.name }？`);
      },
      fileHandleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
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
