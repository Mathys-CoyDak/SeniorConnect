import { createRouter, createWebHistory } from 'vue-router'
import SeniorConnectApp from '@/components/SeniorConnectApp.vue'
import SignupForm from '@/components/SignupForm.vue'
import LoginPage from "@/components/LoginPage.vue";
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
    {
      path: '/login',
      name: 'login',
      component: LoginPage,
    },
  ],
})

export default router
