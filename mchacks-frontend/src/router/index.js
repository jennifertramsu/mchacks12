import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Home from '@/components/Home'
import Game from '@/components/Game'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/template',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path:'/game',
      name: 'Game',
      component: Game
      }

  ]
})
