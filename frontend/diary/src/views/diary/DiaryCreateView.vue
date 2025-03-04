<script setup lang="ts">
import type { PostDiaryRequest } from '@/generated/api-client';
import { createDiary } from '@/services/diary/diary-service';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

/**
 * 日記を作成リクエストを保持するオブジェクトです。
 */
const diary = ref<PostDiaryRequest>({
  content: '',
  date: '',
  title: '',
  userId: 0,
})

const router = useRouter();

/**
 * 日記を作成します。作成後に日記の一覧画面に遷移します。
 * @param diary 日記の作成リクエスト。
 */
const createDiaryAsync = async (diary: PostDiaryRequest) => {
  await createDiary(diary);
  router.push({ name: 'diaries' });
}
</script>
<template>
  <form class="max-w-sm mx-auto" @submit.prevent="createDiaryAsync(diary)">
    <div class="my-5">
      <label for="title" class="block mb-2 text-sm font-medium text-gray-900">タイトル</label>
      <input type="text" id="title"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        required v-model="diary.title" />
    </div>

    <div class="mb-5">
      <label for="content" class="block mb-2 text-sm font-medium text-gray-900 ">内容</label>
      <textarea type="text" id="content"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        rows="15" required v-model="diary.content"></textarea>
    </div>

    <div class="mb-5">
      <label for="date" class="block mb-2 text-sm font-medium text-gray-900 ">日付</label>
      <input type="date" id="date"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
        required v-model="diary.date" />
    </div>
    <button type="submit"
      class="text-white bg-gray-800 hover:bg-gray-400 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">
      作成
    </button>
  </form>

</template>
