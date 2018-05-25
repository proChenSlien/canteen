<template>
  <div class="container">
    <el-container>
      <el-header>
        <fuil-header></fuil-header>
      </el-header>
      <el-container>
          <el-aside :width="asideWidth">
            <fuil-left :fuil-collapse.sync="isCollapse"></fuil-left>
          </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import FuilHeader from '../header/FuilHeader.vue'
  import FuilLeft from "../left/FuilLeft.vue";

  export default {
    name: 'Container',
    components: {
      FuilLeft,
      FuilHeader
    },
    data() {
      return {
        isCollapse: false,
        asideWidth: '200px',
      }
    },
    watch: {
      isCollapse(val) {
        if (val) {
          this.asideWidth = '50px';
        } else {
          this.asideWidth = '200px';
        }
      }
    }

  }

</script>

<style scoped lang="scss">
  .container {
    position: absolute;
    width: 100%;
    height: 100%;

    .el-container {
      width: 100%;
      height: 100%;
    }

    .el-header {
      max-height: 30px;
      line-height: 30px;
      padding: 0;
    }
    .el-aside {
      overflow: visible;
      background-color: #eef1f6;
    }

  }

  .el-header {
    /*background-color: #B3C0D1;*/
    /*color: #333;*/
    /*text-align: center;*/
    /*line-height: 30px;*/
  }

  .el-main {
    /*background-color: #E9EEF3;*/
    color: #333;
    line-height: 100%;
  }
</style>
