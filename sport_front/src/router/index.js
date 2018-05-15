import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/common/auth/Login'
import Container from '@/components/common/container/Container'
import Sub from '@/components/common/container/Sub'
import Home from '@/components/system/home/Home'
import User from '@/components/system/user/User'
import Role from '@/components/system/role/Role'
import store from '@/store'
import AdImgInfo from '@/components/common/advertisement/AdImgInfo'
import Record from '@/components/common/conversionCard/Record'

Vue.use(Router)


let businessRouters = [
  {
    path: '/home',
    name: '首页',
    icon: 'icon-home',
    component: Home
  },
  {
    path: '/system',
    name: '权限管理',
    icon: 'icon-lock',
    component: Sub,
    children: [
      {
        path: 'user',
        component: User,
        name: '用户管理',
        icon: 'icon-user'
      }, {
        path: 'role',
        component: Role,
        name: '角色管理',
        icon: ' icon-user-md'
      }, /*{
        path: 'resource',
        component: ResourceManager,
        name: '资源管理',
        hidden: true,
        icon: 'icon-lightbulb'
      }*/
    ]
  },
  {
    path: '/advertisement',
    name: '广告管理',
    icon: 'icon-lock',
    component: Sub,
    children: [
      {
        path: 'ad',
        component: AdImgInfo,
        name: '广告管理',
        icon: 'icon-user'
      }
    ]
  },
  {
    path: '/conversionCard',
    name: '兑换卡',
    icon: 'icon-lock',
    component: Sub,
    children: [
      {
        path: 'record',
        component: Record,
        name: '兑换记录',
        icon: 'icon-user'
      }
    ]
  }
]


var control = {}


//遍历设置路由显示
control.mapIt = function (router, path) {
  let currentHidden = true

  router.map((one) => {
    if (one.children) {
      // one.hidden = control.mapIt(one.children, path)
    one.hidden = false
    } else {
      if (one.path == path) {
        one.hidden = false
        currentHidden = false
      }
      one.hidden = one.hidden == undefined ? true : one.hidden
    }
  })
  return currentHidden
}

let router =  new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/con',
      component: Container,
      name: '容器页',
      hidden: true,
      children: businessRouters
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path === '/' || (store.getters.authInfo && store.getters.authInfo.access_token)) {
    next()
  } else {
    next({
      path: '/',
      query: {redirect: to.fullPath}
    })
  }
})

export default router

export {
  businessRouters,
  control
}
