<script setup lang="ts">
import { useRoute } from 'vue-router';

const route = useRoute(); // 現在のルートを取得
const id = route.params.id as string; // パラメータからidを取得
</script>

<template>
  <h2>DETAIL</h2>
  DETAILページです。

  <!-- baseUrlを直接使ってリンクを組み立て -->
  <RouterLink :to="`/detail/${id}/edit`">edit</RouterLink>
  <RouterLink :to="`/detail/${id}/delete`">delete</RouterLink>
</template>
