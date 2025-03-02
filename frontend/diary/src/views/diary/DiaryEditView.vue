<script setup lang="ts">
import type { PutDiaryRequest } from '@/generated/api-client';
import { getDiary, updateDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const id = Number(route.params.id);

const diary = ref<PutDiaryRequest>({
  content: '',
  date: '',
  id: id,
  title: '',
  userId: 0,
});

onMounted(async () => {
  diary.value = await getDiary(id);
});

const router = useRouter();
const updateDiaryAsync = async () => {
  await updateDiary(diary.value);
  router.push({ name: 'detail' });
};

</script>
<template>
  <form class="max-w-sm mx-auto" @submit.prevent="updateDiaryAsync()">
    <div class=" mb-5 mt-5">
      <label for="title" class="block mb-2 text-sm font-medium text-gray-900">タイトル</label>
      <input type="text" id="title"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        required v-model="diary.title" />
    </div>
    <div class="mb-5">
      <label for="content" class="block mb-2 text-sm font-medium text-gray-900">内容</label>
      <input type="text" id="content"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        required v-model="diary.content" />
    </div>
    <div class="mb-5">
      <label for="date" class="block mb-2 text-sm font-medium text-gray-900">日付</label>
      <input type="date" id="date"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        required v-model="diary.date" />
    </div>
    <button type="submit"
      class="text-white bg-gray-800 hover:bg-gray-500 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg text-sm px-4 py-2.5"
      @click="updateDiaryAsync">更新</button>
  </form>

</template>
