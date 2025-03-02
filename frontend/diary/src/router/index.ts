import DiariesView from '@/views/diary/DiariesView.vue'
import DiaryDetailView from '@/views/diary/DiaryDetailView.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'diaries',
      component: DiariesView,
    }, {
      path: '/detail/:id',
      name: 'detail',
      component: DiaryDetailView,
    },
  ],
})

export default router
