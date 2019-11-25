import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Registered from '@/components/Registered'
import Home from '@/components/UserHome'
// eslint-disable-next-line no-unused-vars
import PersonalIndex from '../components/personal/PersonalIndex'
import CreateAssociation from '../components/association/CreateAssociation'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/personal',
          name: 'Personal',
          component: PersonalIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/createAssociation',
          name: 'CreateAssociation',
          component: CreateAssociation,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/registered',
      name: 'Registered',
      component: Registered
    }
  ]
})
