<script setup lang="ts">
import { ref } from 'vue';

const showMenu = ref(false);

const menuAction = () => {
  if (showMenu.value) {
    showMenu.value = false;
  } else {
    showMenu.value = true;
  }
}
</script>

<template>
  <v-app>
    <v-app-bar rounded>
      <template v-slot:prepend>
        <v-app-bar-nav-icon @click="menuAction"></v-app-bar-nav-icon>
      </template>
      <v-app-bar-title bold>
        <RouterLink to="/" class="font-weight-bold text-decoration-none text-black">MemoBlend</RouterLink>
      </v-app-bar-title>
    </v-app-bar>

    <v-navigation-drawer v-model="showMenu">
      <v-list nav>
        <v-list-item>
          <v-list-item-title>
            <RouterLink to="/" class="text-decoration-none text-black">HOME</RouterLink>
          </v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>
            <RouterLink to="#" class="text-decoration-none text-black">ANALYSIS</RouterLink>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <RouterView />
    </v-main>
  </v-app>
</template>
