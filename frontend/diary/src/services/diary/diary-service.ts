import { diaryApi } from "@/api-client";
import type { GetDiariesResponse } from "@/generated/api-client";

export async function getDiaries(): Promise<GetDiariesResponse> {
  const response = await diaryApi.getDiaries();
  return response.data;
}

export async function getDiary(id: number) {
  const response = await diaryApi.getDiary(id);
  return response.data;
}
