<script>
import { onMounted, ref } from 'vue'
import { createMessage } from '../../../../../src/api/messages.api'
import useCoordinatorStore from '../../../../../src/stores/coordinator.store'

export default {
  setup() {
    const from = ref('')
    const to = ref('')
    const title = ref('')
    const text = ref('')

    const CoordinatorStore = useCoordinatorStore()

    onMounted(async () => {
      from.value = await CoordinatorStore.coordinator.email
    })

    const submit = async () => {
      const message = {
        id: 11234,
        from: from.value,
        to: to.value,
        title: title.value,
        subject: title.value,
        text: text.value
      }

      await createMessage(message)
      alert('Message sent successfully!')
    }

    return {
      submit,
      to,
      title,
      text
    }
  }
}
</script>

<template>
  <div class="card card-primary card-outline" style="height: 610px">
    <div class="card-body p-0">
      <div class="table-responsive mailbox-messages">
        <div class="login-form" style="height: auto">
          <form style="margin-top: 0%"></form>
          <input type="hidden" name="" />

          <div class="card-body" style="height: 350px; color: #1b6068">
            <div class="form-group mb-2">
              <div class="form-group mb-2">
                <label for="contacts">Contacts:</label>
                <input
                  type="text"
                  class="form-control"
                  name="contacts"
                  id="contacts"
                  placeholder="contacts"
                  v-model="to"
                />
              </div>
            </div>
            <div class="form-group mb-2">
              <label for="subject">Subject:</label>
              <input
                type="text"
                class="form-control"
                name="subject"
                id="subject"
                placeholder="Subject"
                v-model="title"
              />
            </div>

            <div class="form-group mb-2">
              <label for="post">Message:</label>
              <textarea
                id="post"
                name="post"
                class="form-control ckeditor"
                placeholder="Message"
                style="max-height: 98px; min-height: 98px"
                v-model="text"
              ></textarea>
            </div>

            <div class="form-group mb-4">
              <label for="files">File:</label>
              <small
                >(You can add multiple files by uploading one by one. Adding files is not
                mandatory.)</small
              >
              <div class="MultiFile-wrap" id="files">
                <input
                  type="file"
                  name="files[]"
                  class="form-control MultiFile-applied"
                  id="files"
                />
                <div class="MultiFile-list" id="files_list"></div>
              </div>
              <button
                @click.prevent="submit"
                class="mb-2 mt-2"
                type="submit"
                style="width: 30%; height: 50px; margin-left: 70%; margin-top: 20px !important"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  class="bi bi-send"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"
                  ></path>
                </svg>
                <span>Send</span>
              </button>
            </div>
          </div>
          <!-- /.card-body -->
        </div>
        <table class="table table-striped">
          <tbody></tbody>
        </table>
      </div>
    </div>
    <!-- /.card-body -->
  </div>
</template>

<style scoped>
ul,
ol {
  padding-left: 0%;
}
.content {
  height: auto;
}

button {
  color: white;
}

.login-form {
  position: relative;
  width: 100%;
  height: 570px !important;
  background: #e7e7e7;
  padding: 35px 35px 60px;
  box-sizing: border-box;
  margin-right: -45px !important;
  border-radius: 5px;
}

.login-form .title {
  position: relative;
  width: 100%;
  height: 60px;
  line-height: 60px;
  font-size: 35px;
  color: #b9b9b9;
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
  color: rgb(211, 211, 211);
  padding: 0 15px;
  border-radius: 0 5px 5px 0;

  background: linear-gradient(#2b8f9a, #0e163d);
}

input:focus {
  color: #0e163d;
  /* box-shadow: 0 0 5px rgba(0,255,0,.2), 
                      inset 0 0 5px rgba(0,255,0,.1);*/
  background: rgb(176, 164, 164);
  animation: glow 0.8s ease-out infinite alternate;
}

.form-control:focus {
  color: #0e163d;
  /* box-shadow: 0 0 5px rgba(0,255,0,.2), 
                      inset 0 0 5px rgba(0,255,0,.1);*/
  background: #dbf6f6;
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

button {
  margin-top: 10px;
  border-radius: 5px !important;

  letter-spacing: 1px;
  cursor: pointer;
  background: linear-gradient(#2b8f9a, #0e163d);
}

/* button:hover {
    color: #2c919c;
    border: 1px solid #2c919c;
    /* box-shadow: 0 0 5px rgba(0,255,0,.3),  
                      0 0 10px rgba(0,255,0,.2),
                      0 0 15px rgba(0,255,0,.1),
                      0 2px 0 black;
  } */
</style>
