<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="优惠券名" >
        <el-input v-model="currentModel.vvName"></el-input>
      </el-form-item>
      <el-form-item label="图片" prop="imgUrl" enctype="multipart/form-data" style="">
        <el-upload
          class="upload-demo"
          :action="imageUploadSrc"
          :on-remove="fileHandleRemove"
          :file-list="fileList2"
          :on-exceed="fileHandleExceed"
          :on-success="fileHandleSuccess"
          :limit="1"
          list-type="picture"
          :multiple="mutil">
          <i class="el-icon-upload"></i>
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-form-item>
      <el-form-item label="折扣" >
        <el-input v-model="currentModel.discount"></el-input>
      </el-form-item>
      <el-form-item label="有效天数" >
        <el-input v-model="currentModel.validDays"></el-input>
      </el-form-item>
      <el-form-item label="说明" >
        <el-input v-model="currentModel.vvRemark"></el-input>
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
  import {imageUpload, imageView, imageDeleteShort, postUpload} from '@/api/http'
  import qs from 'qs'

  export default {
    name: 'goodsDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {
        imageUploadSrc: imageUpload,
        fileList2: [],
        mutil: true,
        dialogForm: {
          bgImgUrl: 'http://www.baidu.com'
        },
        rules: {
          bgImgUrl: [
            {required: true, message: '请输入背景图片', trigger: 'blur'}
          ]
        }
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {

      // loadMainData: function () {
      //
      //   this.axios.get('/manage/valueVoucher/list?' + qs.stringify(this.searchForm))
      //     .then((response) => {
      //       console.log('response', response);
      //       this.page = response.data.content.page;
      //     })
      //     .catch(err => {
      //       this.$message.error('列表加载出错' + err, 2)
      //     })
      // },

      be:function(file){
        //console.log(file);
      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },

      onSubmit:function () {
        console.log('this.currentModel',this.currentModel);
        this.axios.post('/manage/valueVoucher/merge',qs.stringify(this.currentModel, { skipNulls: true }))
          .then((r) => {
            this.$emit("submitSuccess")
          })
      },

      //背景图片相关
      fileHandleRemove(file, fileList) {
        this.axios.get(this.imageDeleteShortSrc + file.name).then((r) => {
          if (r.data.ok || r.data.code == 104) {
            this.fileL = fileList
          }
        })
      },
      fileHandleSuccess(response, file, fileList) {
        console.log('response', response);
        file.name = response.content.data[0];
        file.url = imageView + file.name + '.jpg';
        this.fileL = fileList;
        this.dialogForm.bgImgUrl = fileList;
      },
      fileBeforeRemove(file, fileList) {
        return this.$confirm(`确定删除？？？？？ ${ file.name }？`);
      },
      fileHandleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      handlePost(file){
        console.log(file);
        var data = document.getElementById('upload');
        const fd = new window.FormData(data)
        fd.append('file', file)
        this.axios.post('/file/uploadImg',qs.stringify(file))
          .then((r) => {
            this.$emit("submitSuccess")
          })
        // 配置post请求的参数。参数名file,后面跟要传的文件，参数名fileType，值为category（看后端的具体要求）
        // fd.append('file', file)
        // postUpload(fd).then(response => {
        //   console.log(1);
        //   console.log(response);
        //   console.log(file);
        //   console.log(2);
        // })
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
