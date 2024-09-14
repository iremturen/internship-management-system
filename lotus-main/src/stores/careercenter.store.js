import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { getCareerCenterById, loginCareerCenter } from '../api/careerCenter.api'
// loginCoordinator ,getCoordinatorById
export default defineStore('careerCenter', () => {
  const staff = ref(null)

  const setCareerCenter = async (username, password) => {
    const status = await loginCareerCenter(username, password)

    if (status === 200) {
      staff.value = await getCareerCenterById(username)
    } else {
      staff.value = null
    }

    return staff.value
  }

  const isCareerCenterLoggedIn = computed(() => staff.value !== null)

  const logoutCareerCenter = () => {
    staff.value = null
  }

  return {
    staff,
    setCareerCenter,
    isCareerCenterLoggedIn,
    logoutCareerCenter
  }
})
