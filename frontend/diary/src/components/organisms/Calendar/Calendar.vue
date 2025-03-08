<script setup lang="ts">
import { EventList } from '@/components/molecules/EventList';
import type { CalendarEvent } from '@/types';
import { ref, computed } from 'vue';
/**
 * コンポーネントのプロパティ
 * @type {{ diaryData: CalendarEvent[] }}
 */
const props = defineProps<{
  diaryData: CalendarEvent[],
  onEventClick: (id: number) => void
}>()

/**
 * カレンダーに表示する現在の日付
 */
const currentDate = ref(new Date())
/**
 * 本日の日付
 */
const today = ref(new Date())

/**
 * 現在表示している年
 * @type {import("vue").ComputedRef<number>}
 */
const currentYear = computed(() => currentDate.value.getFullYear())
/**
 * 現在表示している月（0～11）
 * @type {import("vue").ComputedRef<number>}
 */
const currentMonth = computed(() => currentDate.value.getMonth())

/**
 * 現在の月の日付一覧
 * @type {import("vue").ComputedRef<number[]>}
 */
const daysInMonth = computed(() => {
  const year = currentYear.value
  const month = currentMonth.value
  return Array.from({ length: new Date(year, month + 1, 0).getDate() }, (_, i) => i + 1)
})

/**
 * 今月の最初の曜日までの空セルを表す配列
 * @type {import("vue").ComputedRef<any[]>}
 */
const blankDays = computed(() => {
  const year = currentYear.value
  const month = currentMonth.value
  const firstDayOfWeek = new Date(year, month, 1).getDay()
  return Array.from({ length: firstDayOfWeek })
})

/**
 * カレンダーグリッドの行末に不足するセルを補うための配列
 * @type {import("vue").ComputedRef<any[]>}
 */
const trailingDays = computed(() => {
  const totalCells = blankDays.value.length + daysInMonth.value.length
  const remainder = totalCells % 7
  return remainder === 0 ? [] : Array.from({ length: 7 - remainder })
})

/**
 * 曜日ラベルの配列
 * @type {string[]}
 */
const weekDays = ['日', '月', '火', '水', '木', '金', '土']

/**
 * 指定した日のISO形式の日付文字列(YYYY-MM-DD)を返す
 * @param {number} day - 日付（1～31）
 * @returns {string} ISO形式の日付文字列
 */
const getDateString = (day: number): string => {
  return new Date(currentYear.value, currentMonth.value, day).toISOString().slice(0, 10)
}

/**
 * 前の月に移動する
 */
function prevMonth() {
  const year = currentYear.value
  const month = currentMonth.value
  currentDate.value = new Date(year, month - 1, 1)
}

/**
 * 次の月に移動する
 */
function nextMonth() {
  const year = currentYear.value
  const month = currentMonth.value
  currentDate.value = new Date(year, month + 1, 1)
}

/**
 * カレンダーを本日の表示に更新する
 */
function goToday() {
  currentDate.value = new Date()
}

// 日記エントリを日付のキーでキャッシュする computed プロパティを追加
const eventMap = computed(() => {
  const map: Record<string, CalendarEvent[]> = {};
  (props.diaryData ?? []).forEach(event => {
    const dateKey = new Date(event.date).toISOString().slice(0, 10);
    if (!map[dateKey]) map[dateKey] = [];
    map[dateKey].push(event);
  });
  return map;
});

/**
 * 指定した日に日記エントリが存在するか判定する
 * @param {number} day - 日付（1～31）
 * @returns {boolean} 日記エントリが存在するかどうか
 */
function hasDiaryEntry(day: number): boolean {
  const dateStr = getDateString(day);
  return !!eventMap.value[dateStr]?.length;
}

/**
 * 指定した日が本日であるか判定する
 * @param {number} day - 日付（1～31）
 * @returns {boolean} 本日であればtrue、そうでなければfalse
 */
function isToday(day: number): boolean {
  return (
    currentYear.value === today.value.getFullYear() &&
    currentMonth.value === today.value.getMonth() &&
    day === today.value.getDate()
  )
}

/**
 * 指定した日の日記エントリを取得する
 * @param {number} day - 日付（1～31）
 * @returns {CalendarEvent[]} 指定日の日記エントリの配列
 */
function getDiaryEvents(day: number): CalendarEvent[] {
  return eventMap.value[getDateString(day)] || [];
}

const weeks = computed(() => {
  const cells = [...blankDays.value, ...daysInMonth.value, ...trailingDays.value];
  const result = [];
  for (let i = 0; i < cells.length; i += 7) {
    result.push(cells.slice(i, i + 7));
  }
  return result;
});
</script>

<template>
  <v-container>
    <v-row>
      <v-col class="text-left">
        <v-btn @click="prevMonth">
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
      </v-col>
      <v-col class="text-center">
        <span>{{ currentYear }}年 {{ currentMonth + 1 }}月</span>
      </v-col>
      <v-col class="text-right">
        <v-btn @click="nextMonth">
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-col>
    </v-row>

    <div class="mt-3 mb-3">
      <v-btn @click="goToday">TODAY</v-btn>
    </div>

    <div class="ma-3">
      <v-row>
        <v-col v-for="(day, index) in weekDays" class="text-center font-weight-bold">
          {{ day }}
        </v-col>
      </v-row>

      <v-row v-for="week in weeks">
        <v-col v-for="cell in week" :class="['border', { 'today-cell': typeof cell === 'number' && isToday(cell) }]">
          <template v-if="cell !== undefined">
            <span>{{ cell }}</span>
            <EventList v-if="typeof cell === 'number' && hasDiaryEntry(cell)" :event-list="getDiaryEvents(cell)"
              :onEventClick="onEventClick" />
          </template>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<style scoped>
.today-cell {
  background-color: rgb(100, 100, 100, 0.2);
}
</style>
