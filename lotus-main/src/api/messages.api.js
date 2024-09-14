import axios from 'axios'

export const getMessages = async () => {
  const response = await axios.get('http://localhost:8085/messages')
  return response.data
}

export const getMessageByEmailTo = async (email) => {
  const response = await axios.get(`http://localhost:8085/messageTo/${email}`)
  return response.data
}

export const getMessageByEmailFrom = async (email) => {
  const response = await axios.get(`http://localhost:8085/messageFrom/${email}`)
  return response.data
}

export const getMessageById = async (id) => {
  const response = await axios.get(`http://localhost:8085/message/${id}`)
  return response.data
}

export const deleteMessageById = async (id) => {
  const response = await axios.delete(`http://localhost:8085/messages/${id}`)
  return response.data
}

export const createMessage = async (message) => {
  const response = await axios.post(
    'http://localhost:8085/message',

    {
      id: 123,
      from: message.from,
      to: message.to,
      date: new Date().getDate() + '/' + new Date().getMonth() + '/' + new Date().getFullYear(),
      time: '' + new Date().getHours() + ':' + new Date().getMinutes(),
      title: message.title,
      file: '',
      text: message.text
    }
  )
  return response.data
}

export const deleteMessage = async (id) => {
  const response = await axios.delete(`http://localhost:8085/messages/${id}`)
  return response.data
}

export const getMsgTo = async (to) => {
  const response = await axios.get(`http://localhost:8085/messages/${to}`)
  return response.data
}

export const getMsgFrom = async (from) => {
  const response = await axios.get(`http://localhost:8085/messages/${from}`)
  return response.data
}
