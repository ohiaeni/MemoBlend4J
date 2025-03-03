<script setup lang="ts">

</script>

<template>
  <v-app>
    <v-app-bar rounded>
      <template v-slot:prepend>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
      </template>
      <v-app-bar-title>
        <RouterLink to="/">MemoBlend</RouterLink>
      </v-app-bar-title>
    </v-app-bar>
    <v-main>
      <RouterView />
    </v-main>
  </v-app>
</template>
