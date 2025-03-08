<script setup lang="ts">
import { useRouter } from 'vue-router';

const router = useRouter();
</script>
<template>
  <v-container>
    <h1>エラーが発生しました。</h1>
    <v-btn @click="router.push({ name: 'diaries' })">日記一覧に戻る</v-btn>
  </v-container>
</template>
