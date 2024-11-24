<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">MemoBlend</RouterLink>
      <RouterLink to="/create">CREATE</RouterLink>
    </nav>
  </header>
  <RouterView />
</template>
