import '@rushstack/eslint-patch/modern-module-resolution';
import { defineConfigWithVueTs } from 'eslint-define-config';

export default defineConfigWithVueTs({
  root: true,
  extends: ['../eslint.config.js'],
});
