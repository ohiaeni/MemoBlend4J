import { diaryApi } from "@/api-client";
import type { GetDiariesResponse, PutDiaryRequest } from "@/generated/api-client";

export async function getDiaries(): Promise<GetDiariesResponse> {
  const response = await diaryApi.getDiaries();
  return response.data;
}

export async function getDiary(id: number) {
  const response = await diaryApi.getDiary(id);
  return response.data;
}

export async function updateDiary(diary: PutDiaryRequest) {
  await diaryApi.putDiary(diary);
}
