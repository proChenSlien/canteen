<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <!--<input type="hidden" :model="currentModel.id">-->
    <el-form ref="form" :model="currentModel" label-width="80px" >
      <el-form-item label="商品名" >
        <el-input v-model="currentModel.goodsName"></el-input>
      </el-form-item>
      <el-form-item label="商品类型">
        <el-select v-model="currentModel.typeId" placeholder="商品类型">
          <el-option
            v-for="item in page.content"
            :key="item.id"
            :label="item.typeName"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="单价" >
        <el-input v-model="currentModel.price"></el-input>
      </el-form-item>
      <el-form-item label="说明" >
        <el-input v-model="currentModel.remark"></el-input>
      </el-form-item>
      <el-form-item label="库存" >
        <el-input v-model="currentModel.stock"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="currentModel.state" placeholder="状态">
          <el-option label="上架" :value="1"></el-option>
          <el-option label="下架" :value="0"></el-option>
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
    name: 'goodsDialog',
    mixins:[ Popup ],
    props: {
      currentModel: Object,
      title: String ,
    },
    data() {
      return {
        sexTagTypes: ['','primary','warning']
      }
    },
    mounted: function () {
      this.loadMainData();
    },
    methods: {

      loadMainData: function () {

        this.axios.get('/manage/goodsType/list?' + qs.stringify(this.searchForm))
          .then((response) => {
            console.log('response', response);
            this.page = response.data.content.page;
          })
          .catch(err => {
            this.$message.error('列表加载出错' + err, 2)
          })
      },

      onSubmit:function () {
        console.log('this.currentModel',this.currentModel);
        this.axios.post('/manage/goods/merge',qs.stringify(this.currentModel, { skipNulls: true }))
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
