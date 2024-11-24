<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>

  <v-app>
    <v-app-bar :elevation="5">
      <v-app-bar-title>
        <RouterLink to="/">MemoBlend</RouterLink>
      </v-app-bar-title>
      <RouterLink to="/create">CREATE</RouterLink>
      <RouterLink to="/login">LOG-IN</RouterLink>
      <RouterLink to="/logout">LOG-OUT</RouterLink>
    </v-app-bar>

    <v-main>
      <v-container>
        <RouterView />
      </v-container>
    </v-main>
  </v-app>
</template>
