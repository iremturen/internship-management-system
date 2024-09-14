import axios from 'axios'

export const loginCareerCenter = async (username, password) => {
  const response = await axios.post('http://localhost:8085/careerCenter/login', {
    username,
    password
  })
  return response.status
}

export const assignCareerCenter = async (username) => {
  const response = await axios.post('http://localhost:8085/careerCenter/assign', {
    username
  })
  return response.data
}

export const getCareerCenterById = async (id) => {
  const response = await axios.get(`http://localhost:8085/careerCenter/${id}`)
  return response.data
}
