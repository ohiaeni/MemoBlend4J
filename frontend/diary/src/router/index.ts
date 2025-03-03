import DiariesView from '@/views/diary/DiariesView.vue'
import DiaryCreateView from '@/views/diary/DiaryCreateView.vue'
import DiaryDetailView from '@/views/diary/DiaryDetailView.vue'
import DiaryEditView from '@/views/diary/DiaryEditView.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'diaries',
      component: DiariesView,
    },
    {
      path: '/detail/:id',
      name: 'detail',
      component: DiaryDetailView,
    },
    {
      path: '/detail/:id/edit',
      name: 'edit',
      component: DiaryEditView,
    },
    {
      path: '/create',
      name: 'create',
      component: DiaryCreateView,
    },
  ],
})

export default router
