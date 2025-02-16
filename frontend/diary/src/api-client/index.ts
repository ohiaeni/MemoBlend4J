import axios from 'axios';
import * as apiClient from '@/generated/api-client';

/** api-client の共通の Configuration があればここに定義します。 */
function createConfig(): apiClient.Configuration {
  const config = new apiClient.Configuration();
  return config;
}

/** axios の共通の設定があればここに定義します。 */
const axiosInstance = axios.create({
  baseURL: import.meta.env.VITE_AXIOS_BASE_ENDPOINT_ORIGIN,
  headers: {
    'Content-Type': 'application/json',
  },
  withCredentials: true,
});

const diaryApi = new apiClient.DiaryApi(
  createConfig(),
  '',
  axiosInstance,
);
const userApi = new apiClient.UserApi(
  createConfig(),
  '',
  axiosInstance,
);

export {
  diaryApi,
  userApi
};
