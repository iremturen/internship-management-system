import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { getCoordinatorById, loginCoordinator } from '../api/coordinator.api'

export default defineStore('coordinator', () => {
  const coordinator = ref(null)

  const setCoordinator = async (username, password) => {
    const status = await loginCoordinator(username, password)
    if (status === 200) {
      coordinator.value = await getCoordinatorById(username)
      console.log(coordinator.value)
    } else {
      coordinator.value = null
    }

    return coordinator.value
  }

  const isCoordinatorLoggedIn = computed(() => coordinator.value !== null)

  const logoutCoordinator = () => {
    coordinator.value = null
  }

  return {
    coordinator,
    setCoordinator,
    isCoordinatorLoggedIn,
    logoutCoordinator
  }
})
