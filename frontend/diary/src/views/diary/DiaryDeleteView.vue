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

const goToDiaries = () => {
  router.push({ name: 'diaries' });
}
</script>

<template>
  <div class="m-5">
    <p>{{ diary.date }}の『{{ diary.title }}』を削除しますか？</p>
    <button type="button" class="rounded-lg bg-gray-800 px-4 py-2 mr-3 font-bold text-white hover:bg-gray-400"
      @click="deleteDiaryAsync">はい</button>
    <button type="button" class="rounded-lg bg-gray-800 px-4 py-2 font-bold text-white hover:bg-gray-400"
      @click="goToDiaries">いいえ</button>
  </div>
</template>
