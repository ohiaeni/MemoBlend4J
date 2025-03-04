<script setup lang="ts">
import { XMarkIcon } from '@heroicons/vue/24/outline';

/**
 * ユーザーに実行可否を確認するモーダルコンポーネントです。
 */
const props = defineProps<{
  show: boolean;
  message: string;
}>();
const emit = defineEmits(['close', 'confirm', 'cancel']);
</script>

<template>
  <div v-if="props.show" class="fixed z-1 bg-gray-500/75 w-full h-full" @click.self="emit('close')">
    <div>
      <div
        class="relative z-2 bg-white p-5 rounded-lg w-1/2 top-50 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
        <XMarkIcon class="absolute top-0 right-0 block m-2 w-6 h-6 hover:outline " @click="emit('close')"></XMarkIcon>
        <h2 class="mb-5">{{ props.message }}</h2>
        <div>
          <button class="bg-gray-800 px-4 py-2 rounded-lg text-white mr-1" @click="emit('confirm')">はい</button>
          <button class="bg-gray-800 px-4 py-2 rounded-lg text-white" @click="emit('cancel')">いいえ</button>
        </div>
      </div>
    </div>
  </div>
</template>
