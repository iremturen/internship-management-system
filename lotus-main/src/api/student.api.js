import axios from 'axios'

export const loginStudent = async (username, password) => {
  const response = await axios.post('http://localhost:8085/student/login', {
    username,
    password
  })
  return response.status
}

export const getStudentById = async (id) => {
  const response = await axios.get(`http://localhost:8085/student/${id}`)
  return response.data
}