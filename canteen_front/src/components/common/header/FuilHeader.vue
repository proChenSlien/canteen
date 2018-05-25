<template>
  <div class="fuil-header">
    <el-row>
      <el-col :span="4" :offset="1">
        <div class="grid-content bg-purple">
        <span class="logo">
          <img src="../../../assets/sj_logo.png">
        </span>
          <span class="title">
          <slot name="appName">{{ appName }}</slot>
        </span>
        </div>
      </el-col>
      <el-col :span="3" :offset="14" class="container">
        <el-menu class="header-menu" mode="horizontal" @select="handleSelect" background-color="#324157" text-color="#BBB" active-text-color="#BBB" height="30px">
          <el-submenu index="1">
            <template slot="title" class="title">{{ userName }}</template>
            <el-menu-item index="modifypass" @click="passwordDialogVisible = true">个人信息</el-menu-item>
            <el-menu-item index="modifypass" @click="handleSelect">修改密码</el-menu-item>
            <el-menu-item index="logoff">注销</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
    </el-row>

    <modify-password-form :fuil-visible.sync="passwordDialogVisible"></modify-password-form>
  </div>
</template>

<script>
  import {appName} from '@/api/base.js'
  import ModifyPasswordForm from "./ModifyPassword.vue";
  import * as types from '@/store/mutation-types'

  export default {
    components: { ModifyPasswordForm },
    name: 'fuilHeader',
    data() {
      return {
        userName: this.$store.getters.authInfo.user.username,
        appName: appName,
        passwordDialogVisible: false,
      }
    },
    methods: {
      handleSelect(key ) {
        if (key == 'logoff') {
          this.$confirm('确定注销？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$store.commit(types.LOGOUT)
            this.$router.replace('/')
          })
        }else if(key == 'modifypass'){
          this.passwordDialogVisible = true
        }
      }
    }
  }
</script>

<style scoped lang="scss">

  $backgroundColor: #324157;
  $head-hight: 30px;

  .el-row {
    background-color: $backgroundColor;
    line-height: $head-hight;
    height: $head-hight;
    width: 100%;
    margin: 0;
    .el-col {
      background-color: $backgroundColor;
      .logo img {
        height: $head-hight * 0.5;
        vertical-align: middle;
        opacity: 0.8;
      }

      .title {
        line-height: $head-hight * 0.7;
        font-size: 12px;
        margin-left: 10px;
        vertical-align: middle;
        color: #bfcbd9;
      }

    }
  }
</style>
