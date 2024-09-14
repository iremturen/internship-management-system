<script>
import AdminHeader from '../../../components/AdminHeader.vue'
import useAdminStore from '../../../stores/admin.store'
import { RouterLink, useRouter } from 'vue-router'

export default {
  components: { AdminHeader, RouterLink },
  setup() {
    const adminStore = useAdminStore()
    const router = useRouter()

    const adminLoggedIn = adminStore.isAdminLoggedIn

    if (!adminLoggedIn) {
      router.push({ name: 'LoginNavigation' })
    }

    function logout() {
      adminStore.logoutAdmin()
      router.push({ name: 'LoginNavigation' })
    }

    return {
      logout
    }
  }
}
</script>

<template>
  <AdminHeader logout="logout" />
  <div class="container cnt d-flex justify-content-center align-items-center" style="height: 100vh">
    <RouterView />
  </div>
</template>
