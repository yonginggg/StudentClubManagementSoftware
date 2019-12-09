import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      userId: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userId,
      userPwd: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userPwd
    },
    associationId:1,
    associationName:'luoluo',
    associationsIntroduction:'hahaha',
    departmentId:1
  },
  mutations: {
    login (state, user) {
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    associationName(state, associationName){
      state.associationName = associationName
    },
    associationId(state, associationId){
      state.associationId = associationId
    },
    associationsIntroduction(state,associationsIntroduction){
      state.associationsIntroduction = associationsIntroduction
    },
    departmentId(state,departmentId){
      state.departmentId = departmentId
    }
  }
})
