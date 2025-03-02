<script setup lang="ts">
import type { GetDiariesResponse } from '@/generated/api-client';
import { getDiaries } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const diariesResponse = ref<GetDiariesResponse>({
  diaries: [],
});

onMounted(async () => {
  diariesResponse.value = await getDiaries();
});

const goToDiaryDetail = (id: number) => {
  router.push({ name: 'detail', params: { id: id } });
};

const goToCreateDiary = () => {
  router.push({ name: 'create' });
}
</script>

<template>
  <button @click="goToCreateDiary">新規作成</button>
  <h1>日記の一覧</h1>
  <table class="table-auto">
    <thead>
      <tr>
        <th>日付</th>
        <th>タイトル</th>
        <th>本文</th>
        <th>詳細</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="diary in diariesResponse.diaries" :key="diary.id">
        <td class="border">{{ diary.date }}</td>
        <td class="border">{{ diary.title }}</td>
        <td class="border">{{ diary.content }}</td>
        <td class="border"><button type="button"
            class="rounded bg-blue-600 px-4 py-2 font-bold text-white hover:bg-blue-800"
            @click="goToDiaryDetail(diary.id)">詳細</button></td>
      </tr>
    </tbody>
  </table>

</template>
