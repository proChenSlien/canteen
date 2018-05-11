<template>
  <div class="home">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>浏览量</span>
        <el-button style="float: right;" type="mini">周</el-button>
      </div>
      <div class="text item">
        2222
      </div>
    </el-card>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>浏览量</span>
        <el-button style="float: right;" type="mini">周</el-button>
      </div>
      <div class="text item">
        2222
      </div>
    </el-card>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>浏览量</span>
        <el-button style="float: right;" type="mini">周</el-button>
      </div>
      <div class="text item">
        2222
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'Home'
  }
</script>

<style lang="scss">
  .home {
    .el-card__header {
      padding: 5px 20px;
    }

    .box-card {
      width: 280px;
      margin: 20px;
      display: block;
      float: left;
    }
  }


</style>
