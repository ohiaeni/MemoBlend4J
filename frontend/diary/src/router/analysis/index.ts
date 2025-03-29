import RecommendScheduleView from "@/views/analysis/RecommendScheduleView.vue";
import type { RouteRecordRaw } from "vue-router";

export const analysisRoutes: RouteRecordRaw[] = [
  {
    path: '/analysis/recommend-schedule',
    name: 'recommend-schedule',
    component: RecommendScheduleView
  }
]
