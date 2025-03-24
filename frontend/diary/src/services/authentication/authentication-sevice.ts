import { useAuthenticationStore } from "@/stores/authentication";

export async function signInAsync() {
  const authenticationStore = useAuthenticationStore();
  authenticationStore.signInAsync();
}

export async function signOutAsync() {
  const authenticationStore = useAuthenticationStore();
  authenticationStore.signOutAsync();
}
