import { ref } from 'vue'
import { defineStore } from 'pinia'
import { getMessageByEmailTo, getMessageByEmailFrom } from '../api/messages.api'

export default defineStore('messages', () => {
  const messages = ref(null)

  const setMessagesIncoming = async (email) => {
    messages.value = await getMessageByEmailTo(email)
    console.log(messages.value)
    return messages.value
  }

  const setMessagesOutgoing = async (email) => {
    messages.value = await getMessageByEmailFrom(email)
    console.log(messages.value)
    return messages.value
  }

  return {
    setMessagesIncoming,
    setMessagesOutgoing
  }
})
