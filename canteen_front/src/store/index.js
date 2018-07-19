import Vue from 'vue'
import "babel-polyfill"
import Vuex from 'vuex'
import auth from './modules/auth'
// import menu from './modules/menu'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {},
  modules: {auth},
  action: {},
  mutations: {}
})
