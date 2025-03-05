<script setup lang="ts">
import type { GetDiariesResponse } from '@/generated/api-client';
import { getDiaries } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

/**
 * 日記の一覧を保持するオブジェクトです。
 */
const diariesResponse = ref<GetDiariesResponse>({
  diaries: [],
});

const router = useRouter();

/**
 * 日記の詳細画面に遷移します。
 * @param id 日記の ID 。
 */
const goToDiaryDetail = (id: number) => {
  router.push({ name: 'detail', params: { id: id } });
};

/**
 * 日記の作成画面に遷移します。
 */
const goToCreateDiary = () => {
  router.push({ name: 'create' });
};

onMounted(async () => {
  diariesResponse.value = await getDiaries();
});
</script>

<template>
  <v-container>
    <v-card class="ma-4" v-for="diary in diariesResponse.diaries" :key="diary.id" @click="goToDiaryDetail(diary.id)">
      <v-card-title class="bg-blue-grey-lighten-5">{{ diary.title }}</v-card-title>
      <v-card-text>{{ diary.content }}</v-card-text>
      <v-card-subtitle>{{ diary.date }}</v-card-subtitle>
    </v-card>
  </v-container>
  <v-btn icon="$plus" class="position-fixed bottom-0 right-0 ma-4" fab color="blue-grey" @click="goToCreateDiary">
  </v-btn>
</template>
