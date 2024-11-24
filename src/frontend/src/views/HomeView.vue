<script setup lang="ts">
import { RouterLink } from 'vue-router';
</script>

<template>
  <h2>HOME</h2>
  HOMEページです。
  <v-list lines="two">
    <v-list-item v-for="n in 10" :key="n" :title="'日記 ' + n" subtitle="日記のサブタイトルです。">
      <RouterLink :to="'/detail/' + n">DETAIL</RouterLink>
    </v-list-item>
  </v-list>
</template>
