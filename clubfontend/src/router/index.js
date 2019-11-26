import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Registered from '@/components/Registered'
import Home from '@/components/UserHome'

// eslint-disable-next-line no-unused-vars
import PersonalIndex from '../components/personal/PersonalIndex'
import CreateAssociation from '../components/association/CreateAssociation'
import AdminHome from '../components/AdminHome'
// eslint-disable-next-line camelcase
import Audit_Activity from '../components/activity/Audit_Activity'
// eslint-disable-next-line camelcase
import Modify_Activity from '../components/activity/Modify_Activity'
// eslint-disable-next-line camelcase
import Query_Activity from '../components/activity/Query_Activity'
// eslint-disable-next-line camelcase
import Create_Announcement from '../components/announcement/Create_Announcement'
// eslint-disable-next-line camelcase
import Query_Announcement from '../components/announcement/Query_Announcement'
import ViewActivityUser from "../components/activity/ViewActivityUser";
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
        },
        {
          path: '/viewActivityUser',
          name: 'ViewActivityUser',
          component: ViewActivityUser,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/AdminHome',
      name: 'AdminHome',
      component: AdminHome,
      // home页面并不需要被访问
      redirect: '/AdminIndex',
      children: [
        {
          path: '/Audit_Activity',
          name: 'Audit_Activity',
          component: Audit_Activity,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/Modify_Activity',
          name: 'Modify_Activity',
          component: Modify_Activity,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/Query_Activity',
          name: 'Query_Activity',
          component: Query_Activity,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/Create_Announcement',
          name: 'Create_Announcement',
          component: Create_Announcement,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/Query_Announcement',
          name: 'Query_Announcement',
          component: Query_Announcement,
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
