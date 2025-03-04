<script setup lang="ts">
import type { PostDiaryRequest } from '@/generated/api-client';
import { createDiary } from '@/services/diary/diary-service';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { format } from 'date-fns';
/**
 * 日記を作成リクエストを保持するオブジェクトです。
 */
const diary = ref<PostDiaryRequest>({
  content: '',
  date: '',
  title: '',
  userId: 0,
})

/**
 * v-date-input用Dateオブジェクト。
 */
const selectedDate = ref<Date | null>(null);

const router = useRouter();

/**
 * 日記を作成します。作成後に日記の一覧画面に遷移します。
 * @param diary 日記の作成リクエスト。
 */
const createDiaryAsync = async () => {
  if (selectedDate.value) {
    diary.value.date = format(selectedDate.value, 'yyyy-MM-dd');
  }
  await createDiary(diary.value);
  router.push({ name: 'diaries' });
}
</script>
<template>

  <v-sheet class="mx-auto" width="500">
    <v-form @submit.prevent>
      <v-container>
        <v-text-field v-model="diary.title" label="タイトル" required></v-text-field>
        <v-text-field v-model="diary.content" label="内容" required></v-text-field>
        <v-date-input v-model="selectedDate" label="日付"></v-date-input>
        <v-btn type="submit" block @click="createDiaryAsync">作成</v-btn>
      </v-container>
    </v-form>
  </v-sheet>
</template>
