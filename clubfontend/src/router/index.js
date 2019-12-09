import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Registered from '@/components/Registered'
import Home from '@/components/UserHome'

// eslint-disable-next-line no-unused-vars
import PersonalIndex from '../components/personal/PersonalIndex'
import PasswordIndex from "../components/changePwd/PasswordIndex";
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
import UserManager from "../components/user/UserManager";
import RecruitNotice from "../components/association/RecruitNotice";
import ViewAnnouncementUser from "../components/announcement/ViewAnnouncementUser";
import clubIndex from "../components/association/clubIndex";
import clubnotice from "../components/notice/clubnotice";
import ViewActivityAdmin from "../components/activity/ViewActivityAdmin";
import clubManagement from "../components/association/clubManagement";
import applyClub from "../components/association/applyClub";
import AssociationUser from "../components/association/AssociationUser";
import SignedActivity from "../components/activity/SignedActivity";
import contacts from "../components/member/contacts";
import ClubActivity from "../components/activity/ClubActivity";
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect:'/login',
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
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          // 首页
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          // 个人信息
          path: '/personal',
          name: 'Personal',
          component: PersonalIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          // 修改密码
          path: '/changePwd',
          name: 'Password',
          component: PasswordIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          // 招新界面
          path: '/recruitnotice',
          name: 'RecruitNotice',
          component: RecruitNotice,
          meta: {
            requireAuth: true
          }
        },
        {
          // 创建社团
          path: '/createAssociation',
          name: 'CreateAssociation',
          component: CreateAssociation,
          meta: {
            requireAuth: true
          }
        },
        {
          // 用户查看学校活动
          path: '/viewActivityUser',
          name: 'ViewActivityUser',
          component: ViewActivityUser,
          meta: {
            requireAuth: true
          }
        },
        {
          // 用户查看学校活动
          path: '/SignedActivity',
          name: 'SignedActivity',
          component: SignedActivity,
          meta: {
            requireAuth: true
          }
        },
        {
          // 用户查看学校公告
          path: '/ViewAnnouncementUser',
          name: 'ViewAnnouncementUser',
          component: ViewAnnouncementUser,
          meta: {
            requireAuth: true
          }
        },
        {
          // 社团主界面
          path: '/clubIndex',
          name: 'clubIndex',
          component: clubIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          // 社团公告
          path: '/clubnotice',
          name: 'clubnotice',
          component: clubnotice,
          meta: {
            requireAuth: true
          }
        },
        {
          // 社团查看通讯录
          path: '/contacts',
          name: 'contacts',
          component: contacts,
          meta: {
            requireAuth: true
          }
        },
        {
          // 社团活动
          path: '/ClubActivity',
          name: 'ClubActivity',
          component: ClubActivity,
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
          // 管理员用户管理
          path: '/usermanager',
          name: 'UserManager',
          component: UserManager,
          meta: {
            requireAuth: true
          }
        },
        {
          // 管理员查看社团,社团管理
          path:'/clubManagement',
          name: 'clubManagement',
          component: clubManagement,
          meta: {
            requireAuth: true
          }
        },
        {
          // 审核社团申请
          path:'/applyClub',
          name: 'applyClub',
          component: applyClub,
          meta: {
            requireAuth: true
          }
        },
        {
          // 审核活动申请
          path: '/Audit_Activity',
          name: 'Audit_Activity',
          component: Audit_Activity,
          meta: {
            requireAuth: true
          }
        },
        {
          // 修改活动
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
          // 管理员查看活动
          path: '/ViewActivityAdmin',
          name: 'ViewActivityAdmin',
          component: ViewActivityAdmin,
          meta: {
            requireAuth: true
          }
        },
        {
          // 管理员发布公告
          path: '/Create_Announcement',
          name: 'Create_Announcement',
          component: Create_Announcement,
          meta: {
            requireAuth: true
          }
        },
        {
          // 管理员查看公告
          path: '/Query_Announcement',
          name: 'Query_Announcement',
          component: Query_Announcement,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})
