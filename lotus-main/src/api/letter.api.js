import axios from 'axios'

export const uploadLetter = async (letter) => {
  const response = await axios.post('http://localhost:8085/letter/upload', {
    letter
  })
  return response.data
}

export const createOfficialLetter = async (letter) => {
  const response = await axios.post('http://localhost:8085/letter/create', {
    letter
  })
  return response.data
}

export const getOfficialLetters = async () => {
  const response = await axios.get('http://localhost:8085/letter/get')
  return response.data
}

export const getFindByOL = async (id) => {
  const response = await axios.get(`http://localhost:8085/letter/get/${id}`)
  return response.data
}
