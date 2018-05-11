import * as types from '../mutation-types'

const AUTH_KEY = 'ADMIN_AUTH'

const state = {
  authInfo: {}
}

const getters = {
  authInfo: state => {
    if (!state.authInfo.access_token) {

      let authInfo = window.sessionStorage.getItem('ADMIN_AUTH')
      authInfo = JSON.parse(authInfo)
      state.authInfo = authInfo
    }
    return state.authInfo
  }
}

const mutations = {
  [types.LOGIN]: (state, {authInfo}) => {
    window.sessionStorage.setItem(AUTH_KEY, JSON.stringify(authInfo))
    state.authInfo = authInfo
  },
  [types.LOGOUT]: (state) => {
    window.sessionStorage.removeItem(AUTH_KEY)
    state.authInfo = {}
  }
}

const actions = {}

export default {
  state,
  getters,
  mutations,
  actions
}
