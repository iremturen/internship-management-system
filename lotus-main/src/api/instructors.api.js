import axios from 'axios'

export const getInstructors = async () => {
  const response = await axios.get('http://localhost:8085/instructors')
  return response.data
}
