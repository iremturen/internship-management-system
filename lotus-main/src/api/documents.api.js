import axios from 'axios'

export const getDocuments = async () => {
  const response = await axios.get('http://localhost:8085/documents')
  return response.data
}

export const createDocument = async (document) => {
  const response = await axios.post(
    'http://localhost:8085/documents',

    {
      file_name: document.file_name,
      file_data: 'desktop/n.pdf'
    }
  )
  return response.data
}

export const uploadDocument = async (document) => {
  const response = await axios.post(
    'http://localhost:8085/documents/upload',

    {
      file_name: document.file_name,
      file_data: document.file_data
    }
  )
  return response.data
}
