import { createRouter, createWebHistory } from 'vue-router'
import SeniorConnectApp from '@/components/SeniorConnectApp.vue'
import SignupForm from '@/components/SignupForm.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: SeniorConnectApp,
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupForm,
    },
  ],
})

export default router
