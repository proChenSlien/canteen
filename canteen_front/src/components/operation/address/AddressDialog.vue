<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="地址" >
        <el-input v-model="currentModel.address"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="currentModel.state" placeholder="状态">
          <el-option label="启用" :value="1"></el-option>
          <el-option label="停用" :value="0"></el-option>
        </el-select>
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
  import qs from 'qs'

  export default {
    name: 'addressDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {
      }
    },
    mounted: function () {
    },
    methods: {

      onSubmit:function () {
        debugger;
        console.log('this.currentModel',this.currentModel);
        this.axios.post('/manage/address/merge',qs.stringify(this.currentModel, { skipNulls: true }))
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
