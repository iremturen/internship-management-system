<script>
import { onMounted, ref } from 'vue'
import useMessagesStore from '../../../../stores/messages.store'
import useStudentStore from '../../../../stores/student.store'

import MessageDetails from '../../../../components/MessageDetails.vue'

export default {
  components: { MessageDetails },
  setup() {
    const messagesStore = useMessagesStore()
    const studentStore = useStudentStore()
    const Student = 'Student'

    const messages = ref([])

    onMounted(async () => {
      const mail = await studentStore.student.email
      messages.value = await messagesStore.setMessagesOutgoing(mail)
    })

    return {
      messages,
      Student
    }
  }
}
</script>
<template>
  <div class="card card-primary card-outline" style="height: 630px">
    <div class="card-header">
      <h3 class="card-title" style="color: #2c919c">Outgoing Messages</h3>
    </div>
    <!-- /.card-header -->
    <div data-v-e48d1d00="" class="card-body p-0">
      <div data-v-e48d1d00="" class="table-responsive mailbox-messages">
        <table data-v-e48d1d00="" class="table table-striped">
          <tbody data-v-e48d1d00="">
            <MessageDetails
              v-for="message in messages"
              :key="message.id"
              :message="message"
              :typ="Student"
            />
          </tbody>
        </table>
      </div>
    </div>

    <div class="card-footer p-0">
      <div class="mailbox-controls"></div>
    </div>
  </div>
</template>
<style scoped>
@import url('../../../../assets/css/student.css');
.material-symbols-outlined {
  font-variation-settings: 'FILL' 0, 'wght' 500, 'GRAD' 0, 'opsz' 48;
  color: #0e163d;
}

.button4 {
  background-color: #4fa3ac;
  padding-right: 40px;
  width: 50px;
  height: 40px;
  margin-right: 50px;
  text-align: center;
  border-radius: 4px;
}

.button4:hover {
  background-color: #4fa3ac;
  padding-right: 40px;
  width: 50px;
  height: 40px;
  margin-right: 50px;
  text-align: center;
  border-radius: 4px;
}
.login-form {
  position: relative;
  width: 900px;
  height: 600px;
  background: #d3d3d3;
  padding: 40px 35px 60px;
  box-sizing: border-box;

  border-radius: 5px;
}

.login-form .title {
  position: relative;
  width: 100%;
  height: 60px;
  line-height: 60px;
  font-size: 35px;
  color: #f9f8ff;
  font-weight: 600;
  letter-spacing: 1px;
  margin-bottom: 60px;
}

.text {
  font-size: 10px;
  color: #ff9671;
  font-weight: 600;
  letter-spacing: 2px;
}

form {
  margin-top: 50px;
}

form .field {
  margin-top: 20px;
  display: flex;
}

.field label {
  height: 30px;
  width: 30px;
  color: #868686;
  font-size: 20px;
  line-height: 50px;
  border: 1px solid #444;
  border-right: none;
  border-radius: 5px 0 0 5px;
  background: linear-gradient(#2b8f9a, #0e163d);
}

.field input,
form button {
  height: 30px;
  width: 100%;
  outline: none;
  font-size: 19px;
  color: #fff;
  padding: 0 15px;
  border-radius: 0 5px 5px 0;

  background: linear-gradient(#2b8f9a, #0e163d);
}

input:focus {
  color: #0e163d;
  /* box-shadow: 0 0 5px rgba(0,255,0,.2), 
                                inset 0 0 5px rgba(0,255,0,.1);*/
  background: #fff;
  animation: glow 0.8s ease-out infinite alternate;
}

.form-control:focus {
  color: #0e163d;
  /* box-shadow: 0 0 5px rgba(0,255,0,.2), 
                                inset 0 0 5px rgba(0,255,0,.1);*/
  background: #fff;
  animation: glow 0.8s ease-out infinite alternate;
}

@keyframes glow {
  0% {
    border-color: #2c919c;
    box-shadow: 0 0 5px rgb(44, 145, 156, 0.2), inset 0 0 5px rgba(0, 0, 0, 0.1);
  }

  100% {
    border-color: #2c919c;
    box-shadow: 0 0 20px rgb(44, 145, 156, 0.6), inset 0 0 10px rgb(44, 145, 156, 0.4);
  }
}

.button5 {
  margin-top: 10px;
  border-radius: 5px !important;

  letter-spacing: 1px;
  cursor: pointer;
  background: linear-gradient(#2b8f9a, #0e163d);
}

.button5:hover {
  color: #2c919c;
  border: 1px solid #2c919c;
  /* box-shadow: 0 0 5px rgba(0,255,0,.3),  
                                0 0 10px rgba(0,255,0,.2),
                                0 0 15px rgba(0,255,0,.1),
                                0 2px 0 black;*/
}
</style>
