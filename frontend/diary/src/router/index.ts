import DiariesView from '@/views/diary/DiariesView.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/diaries',
      name: 'diaries',
      component: DiariesView,
    },
  ],
})

export default router
