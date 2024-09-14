import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { loginStudent, getStudentById } from '../api/student.api'
// loginCoordinator ,getCoordinatorById 
export default defineStore('student', () => {
  const student = ref(null)

  const setStudent = async (username, password) => {
    const status = await loginStudent(username, password)
    console.log(status)
    if (status === 200) {
      student.value = await getStudentById(username)
      console.log(student.value)
    } else {
      student.value = null
    }

    return student.value
  }

  const isStudentLoggedIn = computed(() => student.value !== null)

  const logoutStudent = () => {
    student.value = null
  }

  return {
    student,
    setStudent,
    isStudentLoggedIn,
    logoutStudent
  }
})
