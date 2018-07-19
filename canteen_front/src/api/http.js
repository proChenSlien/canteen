import axios from 'axios'
import store from '../store'
import {Notification, Message} from 'element-ui'
import * as types from '../store/mutation-types'
import router from '../router'

const adminApiGateway = '/api'

const imageServer = `${adminApiGateway}`
const imageUpload = `${adminApiGateway}/file/uploadImg/`
const imageDeleteShort = '/file/imgDelete/'
const imageView = `${adminApiGateway}/file/image/`

axios.defaults.timeout = 115000
axios.defaults.baseURL = adminApiGateway
axios.defaults.headers.common['Content-Type'] = 'application/json'


// http request 拦截器

axios.interceptors.request.use(
  config => {
    let authInfo = store.state.auth.authInfo
    if (authInfo) {
      console.log('access_token',authInfo.access_token);
      config.headers.Authorization = `${authInfo.access_token}`
    }
    return config
  },
  err => {
    return Promise.reject(err)
  }
)

axios.interceptors.response.use(
  response => {
    let model = response.data
    if (model && !model.ok) {   //status false 或者 true

      Message.error(model.msg, 2)
      return Promise.reject({response})
    }
    console.log("model",model);
    return response
  },
  err => {

    let response = err.response
    if (response) {
      let data = response.data
      let message = data.message
      switch (response.status) {
        case 401 :
          // 401 清除token信息并跳转到登录页面
          store.commit(types.LOGOUT)
          router.replace({
            path: '/',
            query: {redirect: router.currentRoute.fullPath}
          })
          message = '登录超时，请重新登录'
          break
        default:
      }
      Notification.error({
        title: '提示',
        message: message
      })
    }
    return Promise.reject(err)
  }
)

const postUpload = params => {
  return Promise.post(`${adminApiGateway}/file/uploadImg/`, params).then(res => res.data)
}

export {axios, imageServer, adminApiGateway, imageUpload, imageView, imageDeleteShort, postUpload}
// export default axios









