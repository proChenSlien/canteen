<template>
  <div class="root">

    <!--列表展示-->
    <div class="align-left">
      <el-button-group>
        <el-button type="primary" icon="plus" @click="createItem">添加</el-button>
      </el-button-group>
    </div>
    <el-table :data="tableData" ref="singleTable" highlight-current-row @current-change="selectRow" stripe style="width: 100%">
      <el-table-column type="index" width="100"></el-table-column>
      <el-table-column prop="title" label="广告标题" width="120" ></el-table-column>
      <el-table-column prop="type" label="广告类型" width="130" ></el-table-column>

      <el-table-column prop="urlXCX" label="跳转小程序链接" ></el-table-column>
      <el-table-column prop="urlH5" label="跳转h5链接" ></el-table-column>
      <el-table-column prop="status" label="状态" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.status=='1' ? 'primary' : 'warning'"
            close-transition>{{ scope.row.status==1 ? '有效' : '无效'}}
          </el-tag>
        </template>
      </el-table-column>

      <el-table-column label="操作" width="100">
        <template slot-scope="scope">
          <el-button type="text" @click="updateFlag(scope.row)">{{ scope.row.status=='1' ? '无效' : '有效'}}</el-button>
        </template>
      </el-table-column>


    </el-table>

    <!--分页-->
    <el-pagination v-show="tableData.length > 0"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page.sync="currentPage"
                   :page-sizes="[5, 10, 15, 20]"
                   :page-size="pageSize"
                   layout="total, sizes, prev, pager, next, jumper"
                   :total="totalCount"
                   class="page">
    </el-pagination>

    <!--添加-->
    <el-dialog :title="title" :visible.sync="dialogShow" width="60%">
      <el-form ref="form" :model="dialogForm" :rules="rules" label-width="100px">

        <el-form-item label="广告名称" prop="name" style="margin-top: 25px;">
          <el-input v-model="dialogForm.name" style="width: 50%;"></el-input>
        </el-form-item>

        <el-form-item label="图片" prop="imageUrl" style="margin-top: 25px;">
          <el-upload
            drag
            :action="imageUploadSrc"
            :on-remove="fileHandleRemove"
            :before-remove="fileBeforeRemove"
            :on-exceed="fileHandleExceed"
            :on-success="fileHandleSuccess"
            :limit="10"
            :file-list="fileL"
            list-type="picture-card"
            multiple>
            <i class="el-icon-upload"></i>
          </el-upload>
        </el-form-item>

        <el-form-item label="跳转小程序地址" prop="pageUrlXCX" style="margin-top: 25px;">
          <el-input v-model="dialogForm.pageUrlXCX" style="width: 90%;"></el-input>
        </el-form-item>
        <el-form-item label="跳转h5地址" prop="pageUrlH5" style="margin-top: 25px;">
          <el-input v-model="dialogForm.pageUrlH5" style="width: 90%;"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogShow = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit('form')">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
  import * as types from '@/store/mutation-types'
  import {imageUpload, imageView, imageDeleteShort} from '@/api/http'

  export default {
    data() {
      return {
        imageUploadSrc: imageUpload,
        searchForm: {
          name: '',
          type: '',
          flag: ''
        },
        title: '',
        tableData: [],   // 数据列表
        fileL: [],
        dialogForm: {
          name: '',
          type: '',
          imageUrl: '',
          pageUrlXCX: '',
          pageUrlH5: '',
          flag: ''
        },
        types:[{
          value: '0',
          label: '请选择'
        }, {
          value: '1',
          label: '商城首页'
        }, {
          value: '2',
          label: '积分中心入口'
        }, {
          value: '3',
          label: '积分首页'
        }, {
          value: '4',
          label: '签到页广告'
        }],
        flags:[{
          value: '2',
          label: '请选择'
        }, {
          value: '1',
          label: '启用'
        }, {
          value: '0',
          label: '禁用'
        }],
        rules: {
          name: [
            {required: true, message: '请输入广告名称', trigger: 'blur'},
            {
              validator: (rule, value, callback) => {
                if(value.trim()=='') {
                  callback(new Error('请输入广告名称'))
                } else {
                  callback()
                }
              }
            }
          ],
          type: [
            {type: 'number', required: true, message: '请选择广告类型', trigger: 'blur'},
            {
              validator: (rule, value, callback) => {
                if(value==undefined) {
                  callback(new Error('请选择广告类型'))
                } else {
                  callback()
                }
              }
            }
          ],
          pageUrlXCX: [
            {required: true, message: '请输入跳转小程序页面地址', trigger: 'blur'},
            {
              validator: (rule, value, callback) => {
                if(value.trim()=='') {
                  callback(new Error('请输入跳转小程序页面地址'))
                } else {
                  callback()
                }
              }
            }
          ],
          pageUrlH5: [
            {required: true, message: '请输入跳转h5页面地址', trigger: 'blur'},
            {
              validator: (rule, value, callback) => {
                if(value.trim()=='') {
                  callback(new Error('请输入跳转h5页面地址'))
                } else {
                  callback()
                }
              }
            }
          ],
          type: [
            {type: 'number', required: true, message: '请选择广告类型', trigger: 'blur'},
            {
              validator: (rule, value, callback) => {
                if(value==undefined) {
                  callback(new Error('请选择广告类型'))
                } else {
                  callback()
                }
              }
            }
          ]
        },

        pageSize: 10, // 默认每页数据量
        currentPage: 1, // 当前页码
        start: 1, // 查询的页码
        totalCount: 0,  // 默认数据总数
        dialogShow: false,
        currentRow: null, // 选中的行
        authorityData: [],
        defaultCheckedKeys: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    computed: {
      editor() {
        return this.$refs.myQuillEditor.quill
      }
    },
    mounted: function () {
      this.loadData()  // 加载表数据
    },
    methods: {
      onEditorReady(editor) {
      },
      // 选中行
      selectRow(val) {
        this.currentRow = val
      },

      searchData() {
        this.loadData()
      },

      fileHandleRemove(file, fileList) {
        console.log('file2',file);
        console.log('fileList2',fileList);
        return;
        this.axios.get(this.imageDeleteShort + file.name).then((r) => {
          if (r.data.ok || r.data.code == 104) {
            this.fileL = fileList
          }
        })
      },
      fileHandleSuccess(response, file, fileList) {
        console.log('file',file);
        console.log('fileList',fileList);
        file.name = response.content.data[0]
        file.url = imageView + file.name + '.jpg'
        this.fileL = fileList;
      },
      fileBeforeRemove(file, fileList) {
        return this.$confirm(`确定删除？？？？？ ${ file.name }？`);
      },
      fileHandleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 10 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },

      //新建对象
      createItem() {
        this.fileL=[];
        this.title = '添加广告配置'
        this.dialogForm = {
          type:'1',
          flag:'1',
          name: '',
          imageUrl: '',
          pageUrlXCX: '',
          pageUrlH5: '',
        }
        this.dialogShow = true;
      },
      strToFileList(str) {
        let imgList = str.split("|")
        let that = this
        that.fileL = []
        imgList.map(function (val) {
          if (val.length > 1) {
            var file = {}
            file.name = val
            file.url = imageView + file.name + '.jpg'
            that.fileL.push(file);
          }
        })
      },
      //删除
      deleteOne: function () {
        if (this.currentRow == null) {
          this.$message.error('请先选中数据', 2)
          return
        }

        this.$confirm(`确定删除?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.get(`/shop/sysAdvertisement/delete/${this.currentRow.id}`)
            .then((response) => {
              this.$message.success('删除成功!')
              this.loadData()
            })
        })
      },

      //请假操作
      onSubmit(formName) {
        let that =this;
        this.loading = true
        var formData = this.dialogForm
        this.$refs[formName].validate((valid) => {
            if (valid) {


              that.dialogForm.imageUrl = ''
              this.fileL.map(function (val) {
                that.dialogForm.imageUrl = that.dialogForm.imageUrl + val.name
              })
              this.axios({
                url: '/shop/sysAdvertisement/merge',
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
                this.$refs[formName].resetFields()
                this.fileL= []
                this.loadData()
              })
            } else {
              console.log('valid fail')
              this.loading = false
              return false
            }
          }
        )
      },


      //调整每页条数
      handleSizeChange: function (val) {
        this.pageSize = val;
        this.loadData();
      },

      //调整页数
      handleCurrentChange: function (val) {
        this.currentPage = val;
        this.loadData();
      },

      //加载数据
      loadData() {
        this.axios.get('/manage/adImgInfo/list', {
          params: {
            size: this.pageSize,
            page: this.currentPage
          }
        })
          .then((response) => {
          this.tableData = response.data.content.page.content;
          this.page = response.data.content.page;
          this.totalCount = this.page.totalElements;
        }).catch(err => {
          this.$message.error('列表加载出错' + err, 2)
        })
      },


    }
  }
</script>



<style scoped lang="scss">
  .wanmei {
    height: 100px;
  }

  .root {
    margin-left: 20px;
    margin-right: 20px;
    margin-top: 5px;
    .el-form-item {
      margin-bottom: 3px;
    }

    .el-button-group {
      border-right: 1px solid #FFFFFF;
      border-right-color: rgba(255, 255, 255, .5);
    }

  }

  .align-left {
    text-align: left;
    margin-bottom: 3px;
    background-color: #20A0FF;
    .el-button {
      border-radius: 0 !important;
    }
  }

  .form-person {
    text-align: left;
  }

  .page {
    margin-top: 10px;
    text-align: center;
  }

  ql-snow {
    height: 300px;
  }
</style>

