<script setup lang="ts">
const props = defineProps<{
  showLoading: boolean;
}>();
</script>
<template>
  <v-overlay v-model="props.showLoading" />
  <div class="d-flex align-center justify-center fill-height">
    <v-progress-circular :size="50" indeterminate />
  </div>
</template>
