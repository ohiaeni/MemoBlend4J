import { diaryApi } from "@/api-client";

export async function getDiaries() {
  const response = await diaryApi.getDiaries();
  return response.data;
}
