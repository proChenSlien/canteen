<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px">
      <el-form-item label="名称">
        <el-input v-model="currentModel.name"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="currentModel.description"></el-input>
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
    name: 'roleDialog',
    mixins: [Popup],
    props: {
      currentModel: Object,
      title: String,
    },
    data() {
      return {}
    },
    mounted: function () {

    },
    methods: {
      onSubmit: function () {

        this.axios.post('/manage/role/merge', qs.stringify(this.currentModel, {skipNulls: true}))
          .then((r) => {
            this.$message.success('操作成功!', 2)
            this.$emit("submitSuccess")
          })
      }
    }
  }
</script>


<style scoped lang="scss">
  .root {
    .el-input, .el-select {
      width: 300px;
    }
  }
</style>
