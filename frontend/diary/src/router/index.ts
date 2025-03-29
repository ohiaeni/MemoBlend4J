import { createRouter, createWebHistory } from 'vue-router'
import { diaryRoutes } from './diary'
import { errorRoutes } from './error'
import { authenticationRoutes } from './authentication'
import { analysisRoutes } from './analysis'

export const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    ...diaryRoutes,
    ...analysisRoutes,
    ...errorRoutes,
    ...authenticationRoutes,
  ],
})
