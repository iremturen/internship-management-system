import axios from 'axios'

export const getFiles = async () => {
  const response = await axios.get('http://localhost:8085/files')
  return response.data
}

export const getFilesByID = async (id) => {
  const response = await axios.get(`http://localhost:8085/files/${id}`)
  return response.data
}
