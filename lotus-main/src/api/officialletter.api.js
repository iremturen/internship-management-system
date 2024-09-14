import axios from 'axios'

export const createOfficialLetter = async (data) => {
  const response = await axios.post(
    'http://localhost:8085/officialLetter',

    {
      name: data.name,
      surname: data.surname,
      comName: data.companyName,
      date: new Date(),
      pdf: ''
    }
  )
  return response.data
}
