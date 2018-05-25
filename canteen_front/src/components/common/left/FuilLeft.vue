<template>
  <div class="left-menu">
    <el-menu background-color="#eef1f6" active-text-color="#878d99">
      <el-menu-item class="shift" @click="isCollapse = !isCollapse" index="shift">
        <i :class="isCollapse ? 'icon-indent-left' : 'icon-indent-right'"></i>
      </el-menu-item>
    </el-menu>
    <el-menu background-color="#eef1f6" :collapse="isCollapse" :unique-opened="uniqueOpened" router >

      <template v-for="(route,index) in menu">

        <el-menu-item :index="route.path" v-if="!route.children && !route.hidden">
          <i :class="route.icon"></i>
          <span slot="title">{{route.name}}</span>
        </el-menu-item>


        <el-submenu :index="route.path" v-if="route.children  && !route.hidden">
          <template slot="title">
            <i :class="route.icon"></i>
            <span slot="title">{{route.name}}</span>
          </template>

          <el-menu-item :index="route.path + '/' + childRoute.path" childRoute
                        v-for="(childRoute, ind) in route.children" :key="route.children.id"
                        v-if="!childRoute.hidden">
            {{ childRoute.name }}
          </el-menu-item>

        </el-submenu>

      </template>
    </el-menu>
  </div>
</template>

<script>

  import {businessRouters, control} from '@/router/index'

  export default {
    name: 'fuilLeft',
    props: {
      fuilCollapse: {
        type: Boolean,
        default: false
      },
    },
    data() {
      return {
        isCollapse: false,
        uniqueOpened: true,
        menu: businessRouters,
        width:null
      }
    },
    created: function () {

      let resources = []

      this.$store.getters.authInfo.user.roles.map((role) =>{
        resources = resources.concat(role.resources)
      })

      resources.map((one) => {
        control.mapIt(businessRouters, one.path)
      })
    },
    watch: {
      isCollapse(val) {
        this.$emit("update:fuilCollapse", this.isCollapse)
        if (val){
          this.width = '49px'
        }else {
          this.width = '100%'
        }
      }
    },
    methods: {}
  }
</script>
<style scoped lang="scss">
  .left-menu {

    .shift {
      height: 30px;
      max-height: 30px;
      line-height: 30px;
      text-align: center;
      border-bottom: 1px solid #CCC;
    }
  }
  .el-menu--collapse{
    width: 49px;
  }

  .el-menu{
    border-right: none;
  }
</style>
