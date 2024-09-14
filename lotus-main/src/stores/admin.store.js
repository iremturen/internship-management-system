import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { loginAdmin, getAdminById } from '../api/admin.api'
// loginCoordinator ,getCoordinatorById
export default defineStore('admin', () => {
  const admin = ref(null)

  const setAdmin = async (username, password) => {
    const status = await loginAdmin(username, password)
    if (status === 200) {
      admin.value = await getAdminById(username)
      console.log(admin.value)
    } else {
      admin.value = null
    }

    return admin.value
  }

  const isAdminLoggedIn = computed(() => admin.value !== null)

  const logoutAdmin = () => {
    admin.value = null
  }

  return {
    admin,
    setAdmin,
    isAdminLoggedIn,
    logoutAdmin
  }
})
