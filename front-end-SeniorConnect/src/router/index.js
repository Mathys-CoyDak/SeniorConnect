import { createRouter, createWebHistory } from 'vue-router'
import SeniorConnectLanding from "@/components/SeniorConnectLanding.vue";
import LoginPage from "@/components/LoginPage.vue";
import RegisterForm from "@/components/RegisterForm.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: SeniorConnectLanding,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginPage,
    },
    {
      path: '/signup',
      name: 'signup',
      component: RegisterForm,
    },
  ],
})

export default router
