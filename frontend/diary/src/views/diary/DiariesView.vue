<script setup lang="ts">
import type { GetDiariesResponse } from '@/generated/api-client';
import { getDiaries } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';


const diariesResponse = ref<GetDiariesResponse>({
  diaries: [],
});

onMounted(async () => {
  diariesResponse.value = await getDiaries();
});

</script>

<template>
  <h1>日記の一覧</h1>
  <table class="table-auto">
    <thead>
      <tr>
        <th>日付</th>
        <th>タイトル</th>
        <th>本文</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="diary in diariesResponse.diaries" :key="diary.id">
        <td class="border">{{ diary.date }}</td>
        <td class="border">{{ diary.title }}</td>
        <td class="border">{{ diary.content }}</td>
      </tr>
    </tbody>
  </table>

</template>
