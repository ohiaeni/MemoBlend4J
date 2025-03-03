<script setup lang="ts">
import type { GetDiaryResponse } from '@/generated/api-client';
import { deleteDiary, getDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

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
  <v-container>
    <h1>{{ diary.title }}</h1>
    <p>{{ diary.date }}</p>
    <p>{{ diary.content }}</p>
    <div class="mt-4">
      <v-btn class="mr-4" @click="goToEditDiary">編集</v-btn>
      <v-dialog max-width="500">
        <template v-slot:activator="{ props: activatorProps }">
          <v-btn v-bind="activatorProps" text="削除"></v-btn>
        </template>
        <template v-slot:default="{ isActive }">
          <v-card title="削除確認">
            <v-card-text>
              削除してもよろしいですか？
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn text="はい" @click="deleteDiaryAsync"></v-btn>
              <v-btn text="いいえ" @click="isActive.value = false"></v-btn>
            </v-card-actions>
          </v-card>
        </template>
      </v-dialog>
    </div>
  </v-container>
</template>
