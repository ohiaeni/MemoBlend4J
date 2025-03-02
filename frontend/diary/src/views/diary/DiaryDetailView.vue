<script setup lang="ts">
import type { GetDiaryResponse } from '@/generated/api-client';
import { getDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import PencilIcon from '@/components/atoms/PencilIcon.vue';
import TrashIcon from '@/components/atoms/TrashIcon.vue';

const route = useRoute();
const id = Number(route.params.id);

const diary = ref<GetDiaryResponse>({
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
const goToEditDiary = () => {
  router.push({ name: 'edit' });
}

const goToDeleteDiary = () => {
  router.push({ name: 'delete' });
}
</script>

<template>
  <div class="m-5 relative">
    <h1 class="text-2xl font-bold mb-5">{{ diary.title }}</h1>
    <p class="mb-5">{{ diary.content }}</p>
    <p class="text-gray-400">{{ diary.date }}</p>
    <div class="absolute bottom-0 right-0">
      <button type="button"
        class="text-white bg-gray-800 hover:bg-gray-500 px-4 py-2 rounded-lg focus:ring-4 focus:outline-none focus:ring-gray-200 mx-1"
        @click="goToEditDiary">
        <PencilIcon />
      </button>
      <button type="button"
        class="text-white bg-gray-800 hover:bg-gray-500 px-4 py-2 rounded-lg focus:ring-4 focus:outline-none focus:ring-gray-200"
        @click="goToDeleteDiary">
        <TrashIcon />
      </button>
    </div>
  </div>
</template>
