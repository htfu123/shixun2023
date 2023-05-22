import Vue from 'vue'
import Router from 'vue-router'
import Login from "../components/Login";
import Register from "../components/Register";
import UserCenter from "../components/UserCenter";
import Manage from "../components/user/manage";
import Modify from "../components/user/modify";
import Notes from "../components/user/notes";
import User3 from "../components/User3"
import About from "../components/about";
Vue.use(Router)



export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/Login'
    },
    {
      path: '/user3',
      component: User3
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/about',
      component: About
    },
    {
      path: '/userCenter',
      component: UserCenter,
      children:[
        {
          path: 'manage',
          component: Manage
        },
        {
          path: 'modify',
          component: Modify
        },
        {
          path: 'notes',
          component: Notes
        }
      ]
    }
  ]
})
