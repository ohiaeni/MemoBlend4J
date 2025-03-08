<script setup lang="ts">
import { ref, onMounted } from 'vue'
import type { GetDiariesResponse } from '@/generated/api-client';
import { getDiaries } from '@/services/diary/diary-service';
import { useRouter } from 'vue-router';
import { Calendar } from '@/components/organisms/Calendar';
import type { CalendarEvent } from '@/types';

const diariesResponse = ref<GetDiariesResponse>({
  diaries: [],
});

const router = useRouter();

const goToDiaryDetail = (id: number) => {
  router.push({ name: 'detail', params: { id: id } });
};

const goToCreateDiary = () => {
  router.push({ name: 'create' });
};

const events = ref<CalendarEvent[]>([]);

onMounted(async () => {
  diariesResponse.value = await getDiaries();
  const eventsList: CalendarEvent[] = [];
  if (diariesResponse.value.diaries) {
    for (const diary of diariesResponse.value.diaries) {
      const event = {
        id: diary.id,
        title: diary.title,
        date: new Date(diary.date),
        color: 'red',
        allDay: false
      }
      eventsList.push(event)
    }
  }
  events.value = eventsList
});
</script>

<template>
  <Calendar :diaryData="events" :onEventClick="goToDiaryDetail" />
  <v-btn icon="$plus" class="position-fixed bottom-0 right-0 ma-4" fab color="blue-grey"
    @click="goToCreateDiary"></v-btn>
</template>
