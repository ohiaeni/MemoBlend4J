<script setup lang="ts">
import type { GetDiaryResponse } from '@/generated/api-client';
import { deleteDiary, getDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const id = Number(route.params.id);

const diary = ref<GetDiaryResponse>({
  content: '',
  date: '',
  id: id,
  title: '',
  userId: 0,
})

onMounted(async () => {
  diary.value = await getDiary(id);
});

const router = useRouter();
const deleteDiaryAsync = async () => {
  deleteDiary(id);
  router.push({ name: 'diaries' });
}
</script>

<template>
  <div>
    <h1>日記の削除</h1>
    <div>
      <p>日付: {{ diary.date }}</p>
      <p>タイトル: {{ diary.title }}</p>
      <p>本文: {{ diary.content }}</p>
    </div>
    <button type="button" class="rounded bg-red-600 px-4 py-2 font-bold text-white hover:bg-red-800"
      @click="deleteDiaryAsync">削除</button>
  </div>
</template>
