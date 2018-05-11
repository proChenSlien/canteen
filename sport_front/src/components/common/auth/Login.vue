<template>
  <div class="fullscreen">
    <div class="login">
      <div class="box">
        <el-form v-bind:model="User" ref="User" v-bind:rules="loginRules">
          <h3 class="title">系统登录</h3>
          <el-form-item prop="name">
            <el-input type="text" v-model="User.name" autoComplete="off" placeholder="账号" autofocus />
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" v-model="User.password" autoComplete="off" placeholder="密码"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" v-on:click="submitForm()" v-bind:loading="loading" style="width: 100%;">
              登录
            </el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import {validate} from '../utils/validate'
  import * as types from '@/store/mutation-types'

  export default {
    name: 'Login',
    data() {
      return {
        loading: false,  // loading
        User: {
          name: '',
          password: ''
        },
        loginRules: {
          name: validate.userName(),
          password: validate.password()
        }
      }
    },

    mounted: function () {
      this.enterListener()
    },

    methods: {
      submitForm: function () {
        this.$refs['User'].validate((valid) => {
            if (valid) {

              this.loading = true  //蒙板
              this.axios.post('/login', `username=${this.User.name}&password=${this.User.password}`)
                .then((response) => {
                  let authInfo = response.data.content

                  if (authInfo.access_token) {
                    this.$store.commit(types.LOGIN, {authInfo})   //持久化用户信息
                    let redirect = decodeURIComponent(this.$route.query.redirect || '/home')   //重定向到登陆后页面
                    this.$router.push({
                      path: redirect
                    })
                  }

                }).catch(err => {

                this.$message.error('登录出错' + err, 2)
              })

              this.loading = false
              return true
            }

            return false
          }
        )
      },

      enterListener: function () {
          let that = this

          window.addEventListener('keydown', function (event) {
//            console.log(event.keyCode)
            if (event.keyCode === 13) {
              that.submitForm()
            }
          })
      }

    }
  }
</script>

<style scoped lang="scss">

  .fullscreen {
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 100%;

    .login {
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      background: url("../../../assets/bg.jpg") no-repeat;
      background-size: 100% 100%;

      .box {
        margin-top: -20%;
        border: 1px solid red;
        width: 350px;
        border: 1px solid #8492A6;
        padding: 35px 35px 15px 35px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        -moz-border-radius: 5px;
        background-clip: padding-box;
        background-color: #F9FAFC;

        .title {
          margin-bottom: 20px;
        }
      }
    }
  }


</style>

























