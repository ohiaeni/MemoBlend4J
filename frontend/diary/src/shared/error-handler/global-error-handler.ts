import type { App, ComponentPublicInstance } from 'vue';
import { router } from '@/router';

export const globalErrorHandler = {
  install(app: App) {
    app.config.errorHandler = (
      err: unknown,
      instance: ComponentPublicInstance | null,
      info: string,
    ) => {
      console.log(err, instance, info);
      router.replace({ name: 'error' });
    };

    window.addEventListener('error', (event) => {
      console.log(event);
    });

    window.addEventListener('unhandledrejection', (event) => {
      console.log(event);
    });
  },
};
