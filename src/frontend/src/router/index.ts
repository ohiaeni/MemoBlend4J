import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue'),
    },
    {
      path: '/create',
      name: 'create',
      component: () => import('../views/CreateView.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
    },
    {
      path: '/logout',
      name: 'logout',
      component: () => import('../views/LogoutView.vue'),
    },
    {
      path: '/detail/:id',
      children: [
        {
          path: '',
          name: 'detail',
          component: () => import('../views/DetailView.vue')
        },
        {
          path: 'edit',
          name: 'edit',
          component: () => import('../views/EditView.vue')
        },
        {
          path: 'delete',
          name: 'delete',
          component: () => import('../views/DeleteVIew.vue'),
        },
      ]
    },
  ],
})

export default router
