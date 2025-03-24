import { defineStore } from 'pinia';
import { userApi } from '@/api-client';

/**
 * 認証状態のストアです。
 */
export const useAuthenticationStore = defineStore(
  'authentication',
  {
    state: () => ({
      authenticationState:
        JSON.parse(sessionStorage.getItem('isAuthenticated') || 'false',) as boolean,
      name:
        JSON.parse(sessionStorage.getItem('name') || '""') as string,
    }),
    actions: {
      /**
       * アプリケーションにログインします。
       * セッションストレージに認証状態を保存します。
       */
      async signInAsync() {
        const response = await userApi.getUser(1);
        const { name } = response.data;
        this.authenticationState = true;
        sessionStorage.setItem('isAuthenticated', JSON.stringify(this.authenticationState));
        sessionStorage.setItem('name', JSON.stringify(name));
      },
      /**
       * アプリケーションからログアウトします。
       * セッションストレージから認証状態を削除します。
       */
      async signOutAsync() {
        this.name = '';
        this.authenticationState = false;
        sessionStorage.removeItem('isAuthenticated');
        sessionStorage.removeItem('name');
      },
    },
    getters: {
      /**
       * ユーザーが認証済みかどうかを取得します。
       * @param state 状態。
       * @returns 認証済みかどうかを表す真理値。
       */
      isAuthenticated(state) {
        return state.authenticationState;
      },
    },
  }
);
