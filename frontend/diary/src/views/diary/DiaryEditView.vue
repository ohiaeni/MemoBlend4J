<script setup lang="ts">
import type { PutDiaryRequest } from '@/generated/api-client';
import { getDiary, updateDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { format } from 'date-fns';
import { useCustomErrorHandler } from '@/shared/error-handler/use-custom-error-handler';

const customErrorHandler = useCustomErrorHandler();
const route = useRoute();
const id = Number(route.params.id);

/**
 * 日記の更新リクエストを保持するオブジェクトです。
 */
const diary = ref<PutDiaryRequest>({
  content: '',
  date: '',
  id: id,
  title: '',
  userId: 0,
});

/**
 * v-date-input用Dateオブジェクト。
 */
const selectedDate = ref<Date | null>(null);

const router = useRouter();

/**
 * 日記を更新します。
 * 更新後に日記の一覧画面に遷移します。
 */
const updateDiaryAsync = async () => {
  if (selectedDate.value) {
    diary.value.date = format(selectedDate.value, 'yyyy-MM-dd');
  }
  await updateDiary(diary.value);
  router.push({ name: 'diaries' });
};

onMounted(async () => {
  try {
    const response = await getDiary(id);
    selectedDate.value = response.date ? new Date(response.date) : null;
    diary.value = response;
  }
  catch (error) {
    customErrorHandler.handle(error, () => {
      router.push({ name: 'error' });
    });
  }
});
</script>

<template>
  <v-sheet class="mx-auto" width="500">
    <v-form @submit.prevent>
      <v-container>
        <v-text-field v-model="diary.title" label="タイトル" required></v-text-field>
        <v-text-field v-model="diary.content" label="内容" required></v-text-field>
        <v-date-input v-model="selectedDate" label="日付"></v-date-input>
        <v-btn type="submit" block @click="updateDiaryAsync">更新</v-btn>
      </v-container>
    </v-form>
  </v-sheet>
</template>
