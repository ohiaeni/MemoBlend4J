<script setup lang="ts">
import type { GetDiaryResponse } from '@/generated/api-client';
import { getDiary } from '@/services/diary/diary-service';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const id = Number(route.params.id);

const diary = ref<GetDiaryResponse>({
  content: '',
  date: '',
  id: id,
  title: '',
  userId: 0,
});

onMounted(async () => {
  diary.value = await getDiary(id);
});
</script>
