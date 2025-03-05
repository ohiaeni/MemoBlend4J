import 'vuetify/styles';
import '@mdi/font/css/materialdesignicons.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createVuetify } from 'vuetify'

import App from './App.vue'
import router from './router'
import { VDateInput } from 'vuetify/labs/VDateInput';
import { VCalendar } from 'vuetify/labs/VCalendar';

const app = createApp(App)
const vuetify = createVuetify({
  components: {
    VDateInput,
    VCalendar
  },
});

app.use(createPinia())
app.use(router)
app.use(vuetify)

app.mount('#app')
