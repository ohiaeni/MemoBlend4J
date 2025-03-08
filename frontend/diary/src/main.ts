import 'vuetify/styles';
import '@mdi/font/css/materialdesignicons.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createVuetify } from 'vuetify'
import App from './App.vue'
import { router } from './router'
import { VDateInput } from 'vuetify/labs/VDateInput';
import { globalErrorHandler } from './shared/error-handler/global-error-handler';

const app = createApp(App)
const vuetify = createVuetify({
  components: {
    VDateInput,
  },
});

app.use(createPinia())
app.use(router)
app.use(vuetify)
app.use(globalErrorHandler)

app.mount('#app')
