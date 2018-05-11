<template>
  <el-dialog :title="title" :visible.sync="opened" width="500px">
    <el-tree
      :data="authorityData"
      show-checkbox
      default-expand-all
      node-key="id"
      ref="tree"
      highlight-current
      :default-expanded-keys="defaultCheckedKeys"
      :default-checked-keys="defaultCheckedKeys"
      :props="defaultProps">
    </el-tree>
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
    name: 'authorityDialog',
    mixins: [Popup],
    props: {
      currentModel: Object,
      title: String,
    },
    data() {
      return {
        authorityData: [],
        defaultCheckedKeys: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    mounted: function () {
      console.log('dialogmounted')
      this.loadResource()
    }

    ,
    methods: {
      onSubmit: function () {
        var ids = [];  //只存叶子节点

        this.$refs.tree.getCheckedNodes().forEach(function (item) {
          if (!item.children || item.children.length == 0) {
            ids.push(item.id)
          }
        })

        this.axios.post('/manage/role/auth', `resourceIds=${ids}&userId=${this.currentModel.id}`)
          .then((r) => {
            this.$message.success('操作成功!', 2)
            this.$emit("submitSuccess")
          })
      },

      loadResource() {
        this.axios.get('/manage/resource/root')
          .then((r) => {
            this.authorityData = r.data.content.root
          })
      },

      setDefaultCheckedKeys(resources){
        let that = this
        this.defaultCheckedKeys = []
        resources.map(function (item) {
          that.defaultCheckedKeys.push(item.id)
        })
      }
    },
    watch: {
      currentModel(val) {
        if (val){
          this.setDefaultCheckedKeys(val.resources)
        }
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
