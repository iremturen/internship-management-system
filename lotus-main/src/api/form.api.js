import axios from 'axios'

export const uploadForm = async (form) => {
  const response = await axios.post('http://localhost:8085/form/upload', {
    form
  })
  return response.data
}

export const getApplicationForms = async () => {
  const response = await axios.get('http://localhost:8085/form/get')
  return response.data
}
