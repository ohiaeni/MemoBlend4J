<script setup lang="ts">
import type { GetDiaryResponse } from '@/generated/api-client';
import { deleteDiary, getDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { PencilSquareIcon, TrashIcon } from '@heroicons/vue/24/outline';
import TestModal from '@/components/ConfirmationModal.vue';

const route = useRoute();
const id = Number(route.params.id);

/**
 * 日記の詳細を保持するオブジェクトです。
 */
const diary = ref<GetDiaryResponse>({
  content: '',
  date: '',
  id: id,
  title: '',
  userId: 0,
});

/**
 * 削除モーダルを表示するかどうかを保持するオブジェクトです。
 */
const showDeleteModal = ref(false);

/**
 * 削除モーダルを表示します。
 */
const openDeleteModal = () => {
  showDeleteModal.value = true;
}

/**
 * 削除モーダルを非表示にします。
 */
const closeDeleteModal = () => {
  showDeleteModal.value = false;
}

const router = useRouter();

/**
 * 日記を削除します。
 * 削除した後に日記の一覧画面に遷移します。
 */
const deleteDiaryAsync = async () => {
  await deleteDiary(id);
  router.push({ name: 'diaries' });
}

/**
 * 編集画面に遷移します。
 */
const goToEditDiary = () => {
  router.push({ name: 'edit' });
}

onMounted(async () => {
  diary.value = await getDiary(id);
});
</script>

<template>
  <TestModal :show="showDeleteModal" message="削除してもよろしいですか？" @close="closeDeleteModal" @confirm="deleteDiaryAsync"
    @cancel="closeDeleteModal" />
  <div class="m-5 relative">
    <h1 class="text-2xl font-bold mb-5">{{ diary.title }}</h1>
    <p class="mb-5">{{ diary.content }}</p>
    <p class="text-gray-400">{{ diary.date }}</p>
    <div class="absolute bottom-0 right-0">
      <button type="button"
        class="text-white bg-gray-800 hover:bg-gray-500 px-4 py-2 rounded-lg focus:ring-4 focus:outline-none focus:ring-gray-200 mx-1"
        @click="goToEditDiary">
        <PencilSquareIcon class="block w-6 h-6 stroke-white" />
      </button>
      <button type="button"
        class="text-white bg-gray-800 hover:bg-gray-500 px-4 py-2 rounded-lg focus:ring-4 focus:outline-none focus:ring-gray-200"
        @click="openDeleteModal">
        <TrashIcon class="block w-6 h-6 stroke-white" />
      </button>
    </div>
  </div>
</template>
