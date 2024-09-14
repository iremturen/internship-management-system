import axios from 'axios'

export const uploadLogo = async (logo) => {
  const response = await axios.post('http://localhost:8085/logo/upload', {
    logo
  })
  return response.data
}
