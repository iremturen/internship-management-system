import axios from 'axios'

export const getNotifications = async () => {
  const response = await axios.get('http://localhost:8085/notifications')
  return response.data
}

export const createNotification = async (notification) => {
  const response = await axios.post(
    'http://localhost:8085/notifications',

    {
      id: notification.id,
      from: notification.from,
      to: notification.to,
      date: notification.date,
      time: notification.time,
      title: notification.title,
      text: notification.text
    }
  )
  return response.data
}

export const deleteNotification = async (id) => {
  const response = await axios.delete(`http://localhost:8085/notifications/${id}`)
  return response.data
}
