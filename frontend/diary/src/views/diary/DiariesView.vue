<script setup lang="ts">
import type { GetDiariesResponse } from '@/generated/api-client';
import { getDiaries } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import { PencilSquareIcon } from '@heroicons/vue/24/outline';

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
}

onMounted(async () => {
  diariesResponse.value = await getDiaries();
});
</script>

<template>
  <div class="m-5">
    <button class="fixed z-10 px-4 py-4 bottom-10 right-10 rounded-full bg-gray-800 text-white hover:bg-gray-500"
      @click="goToCreateDiary">
      <PencilSquareIcon class="block w-8 h-8 stroke-white" />
    </button>
    <div class="border rounded-lg mb-4 relative border-gray-200 hover:border-gray-400 hover:shadow-lg"
      v-for="diary in diariesResponse.diaries" :key="diary.id" @click="goToDiaryDetail(diary.id)">
      <h2 class="rounded p-2 font-bold text-2xl">{{ diary.title }}</h2>
      <p class="rounded p-2">{{ diary.content }}</p>
      <p class="rounded p-2 text-gray-400">{{ diary.date }}</p>
    </div>
  </div>
</template>
