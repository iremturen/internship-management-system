<script>
import { ref } from 'vue'
import { RouterLink } from 'vue-router'
import { deleteMessageById } from '../api/messages.api';

export default {
    name: "MessageDetails",
    props: {
        message: {
            type: String,
            required: true
        },
        typ: {
            type: String,
            required: true
        }
    },
    setup(props) {
        const messageDetails = ref(props.message);
        const routeType = ref(props.typ);
        console.log(messageDetails.value);

        const deleteMessage = async (id) => {
          const confirmDelete = confirm('Are you sure you want to delete this message?');

          if (confirmDelete)  await deleteMessageById(id);
          else return;
        }

        return {
            messageDetails,
            routeType,
            deleteMessage
        };
    },
    components: { RouterLink }
}
</script>

<template>
  <tr data-v-e48d1d00="" class="new-message">
    <td data-v-e48d1d00="" width="50"></td>
    <td data-v-e48d1d00="" width="50">
      <img
        data-v-e48d1d00=""
        src="https://obs.uskudar.edu.tr/oibs/zfoto.aspx?gkm=10113315036324363123734334228373363845635250342003630634224"
        alt=""
        height="50"
      />
    </td>
    <td data-v-e48d1d00="" class="mailbox-name">
      <br data-v-e48d1d00="" />
      {{ messageDetails?.from }}
    </td>
    <td data-v-e48d1d00="" class="mailbox-subject">
      {{ messageDetails?.subject }}
    </td>
    <td data-v-e48d1d00="" class="mailbox-attachment"></td>
    <td data-v-e48d1d00="" class="mailbox-date">{{ messageDetails?.time }}</td>

    <td data-v-e48d1d00="" width="100">
      <RouterLink
        :to="{ name: `${routeType}MessageDetails`, params: { id: messageDetails?.id } }"
        data-v-e48d1d00=""
        href="#"
        class="btn btn-sm text-white"
        style="background-color: rgb(44, 145, 156)"
        ><i data-v-e48d1d00="" class="fa fa-search"></i></RouterLink
      ><a
        data-v-e48d1d00=""
        href="#"
        @click="deleteMessage(messageDetails?.id)"
        class="btn btn-sm btn-danger"
        style="margin-left: 3px"
        ><i data-v-e48d1d00="" class="fa fa-trash-o"></i
      ></a>
    </td>
  </tr>
</template>
