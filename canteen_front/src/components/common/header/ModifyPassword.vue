<template>
  <el-dialog title="修改密码"  :visible.sync="innerVisible">
    <el-form :model="pass" ref="formvalid" :rules="rules">
      <el-form-item label="当前密码" prop="nowpass">
        <el-input v-model="pass.nowpass" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newpass">
        <el-input v-model="pass.newpass" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认新密码" prop="sureNewpass">
        <el-input v-model="pass.sureNewpass" auto-complete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="innerVisible = false">取 消</el-button>
      <el-button type="primary" @click="onsubmit('formvalid')">确 定</el-button>
    </div>
  </el-dialog>
</template>
<script>
  export default {
    name: 'ModifyPasswordForm',
    props: {
      fuilVisible: {
        type: Boolean,
        default: false
      },
    },
    data() {
      return {
        innerVisible: this.fuilVisible,
        pass: {},
        rules: {},
      }
    },
    watch: {
      fuilVisible(val) {
        this.innerVisible = val
      },
      innerVisible(val){
        this.$emit("update:fuilVisible", val)
      }
    },
    methods: {
      onsubmit() {

      }
    }
  }
</script>
