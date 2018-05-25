<template>
  <div class="root">
    <el-form :inline="true" :model="personForm" class="form-person">
      <el-form-item label="">
        <el-input v-model="personForm.userName" placeholder="关键字"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <div class="align-left">
      <el-button-group>
        <el-button type="primary" icon="edit">修改</el-button>
        <el-button type="primary" icon="share" @click="createUser">新增</el-button>
        <el-button type="primary" icon="delete">删除</el-button>
        <el-button type="primary" icon="delete" @click="sync">同步</el-button>
      </el-button-group>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="date" label="日期" width="180"> </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage1"
      :page-size="100"
      layout="total, prev, pager, next"
      :total="1000"
      class="page">
    </el-pagination>


    <el-dialog title="新增用户" :visible.sync="createUserDialog">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="活动名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="活动区域">
          <el-select v-model="form.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2"
                            style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="即时配送">
          <el-switch on-text="" off-text="" v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="活动性质">
          <el-checkbox-group v-model="form.type">
            <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
            <el-checkbox label="地推活动" name="type"></el-checkbox>
            <el-checkbox label="线下主题活动" name="type"></el-checkbox>
            <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="特殊资源">
          <el-radio-group v-model="form.resource">
            <el-radio label="线上品牌商赞助"></el-radio>
            <el-radio label="线下场地免费"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="活动形式">
          <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="createUserDialog = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import {authority} from '@/router/authority'
  export default {
    name: 'resourceManager',
    data () {
      return {
        personForm: {},
        currentPage1: 5,
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        createUserDialog: false
      }
    },
    methods: {
      onSubmit () {
        alert()
      },
      sync(){
        this.axios.post('/manage/resource/sync', authority)
          .then((r) => {
            this.$message({
              type: 'success',
              message: '同步成功!'
            }, 2)
          })
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`)
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`)
      },
      createUser (){
        this.createUserDialog = true
      },
      userClick () {
        this.axios.get('/manage/user/list')
          .then((response) => {
            console.log(response.data);
          }).catch(err => {
          this.$message.error('用户列表出错' + err, 2)
        })
      }



    }
  }
</script>

<style scoped lang="scss">

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
  }
</style>
