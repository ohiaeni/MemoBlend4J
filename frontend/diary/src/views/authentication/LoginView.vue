<script setup lang="ts">
import { ref } from 'vue';

const email = ref('');
const password = ref('');
const login = () => {
  console.log('Logging in with', email.value, password.value);
};
</script>
<template>
  <v-card class="mx-auto my-8" max-width="400">
    <v-card-item>
      <v-card-title>
        ログイン
      </v-card-title>

      <v-card-subtitle>
        メールアドレスとパスワードを入力してください
      </v-card-subtitle>
    </v-card-item>

    <v-card-text>
      <v-form>
        <v-text-field v-model="email" label="メールアドレス" outlined dense required></v-text-field>

        <v-text-field v-model="password" label="パスワード" outlined dense required type="password"></v-text-field>

        <v-btn block color="primary" class="mt-4" @click="login">
          ログイン
        </v-btn>
      </v-form>
    </v-card-text>
  </v-card>
</template>
