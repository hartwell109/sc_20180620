import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import UserList from '@/components/UserList'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/userlist',
            name: 'UserList',
            component: UserList
        }
    ]
})
