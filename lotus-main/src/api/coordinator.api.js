import axios from 'axios'

export const loginCoordinator = async (username, password) => {
  const response = await axios.post('http://localhost:8085/coordinator/login', {
    username,
    password
  })
  return response.status
}

export const assignCoordinator = async (username, password) => {
  const response = await axios.post('http://localhost:8085/coordinator/assign', {
    username,
    password
  })
  return response.data
}
export const getCoordinatorById = async (id) => {
  const response = await axios.get(`http://localhost:8085/student/${id}`)
  return response.data
}
