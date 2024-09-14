<script>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getMessageById } from '../api/messages.api'

export default {
  setup() {
    const router = useRouter()
    const route = useRoute()
    const messageId = route.params.id
    const message = ref({})

    const backToMessages = () => {
      router.go(-1)
    }

    onMounted(async () => {
      message.value = await getMessageById(messageId)
    })

    return {
      backToMessages,

      message
    }
  }
}
</script>

<template>
  <section class="content">
    <div class="container-fluid">
      <div class="rows-2" style="margin-top: 20px">
        <div class="row">
          <button
            class="btn btn-inner btnBack backIcon col-2 mb-3"
            @click="backToMessages()"
            style="width: 100px; padding-left: 3px; padding-right: 12px; margin-left: 55px"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              class="icon icon-tabler icon-tabler-chevron-left"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              stroke-width="2"
              stroke="currentColor"
              fill="none"
              stroke-linecap="round"
              stroke-linejoin="round"
              style="pointer-events: none"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
              <path d="M15 6l-6 6l6 6"></path>
            </svg>
            <span style="pointer-events: none">Back</span>
          </button>

          <div class="col-10 mb-3" style="height: 65px; margin-left: 21px">
            <div
              class="card open-message pt-0 pb-5"
              style="width: 100%; height: 65px; padding-bottom: 4rem !important"
            >
              <div class="card-body mb-5">
                <div class="table-responsive mailbox-messages">
                  <table class="table">
                    <tbody>
                      <tr class="open-message">
                        <td width="50"></td>
                        <td width="40" style="padding-bottom: 5rem !important">
                          <img
                            src="../assets/images/user.png"
                            alt=""
                            height="40"
                            style="margin-top: -8px"
                          />
                        </td>
                        <td class="mailbox-name">
                          <small>
                            from
                            {{ message?.from }}
                            to
                            {{ message?.to }}
                          </small>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td width="100" class="mailbox-date">
                          <small>
                            {{ message?.date }}
                          </small>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col ms-4 me-4">
          <div class="card card-primary card-outline" style="height: 350px">
            <div class="card-header pt-3">
              <h6 class="card-title mailbox-subject" style="color: #0e163d">
                {{ message?.subject }}
              </h6>
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <div class="rows-2">
                <div class="row">
                  <div class="col ps-4 pe-4 pt-3">
                    <p class="mailbox-content">
                      {{ message?.text }}
                    </p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-7">
                    <div style="padding: 10px">
                      <ul class="mailbox-attachments" style="list-style-type: none">
                        <li class="docBack text-decoration-none text-reset p-3">
                          <div class="mailbox-attachment-info">
                            <a
                              href="#"
                              class="mailbox-attachment-name text-decoration-none text-reset"
                              ><i class="fa fa-paperclip"></i> Document.pdf</a
                            >

                            <a
                              href="#"
                              class="btn btn-default bttn-inner btn-sm"
                              style="margin-left: 40vb"
                              ><small
                                ><small>
                                  <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    class="icon icon-tabler icon-tabler-download"
                                    width="24"
                                    height="24"
                                    viewBox="0 0 24 24"
                                    stroke-width="2"
                                    stroke="currentColor"
                                    fill="none"
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                  >
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                    <path d="M4 17v2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-2"></path>
                                    <path d="M7 11l5 5l5 -5"></path>
                                    <path d="M12 4l0 12"></path>
                                  </svg> </small></small
                            ></a>
                          </div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- /.card-body -->
          <div class="card-footer p-0">
            <div class="mailbox-controls"></div>
          </div>
          <!-- /.card-footer -->
        </div>
        <!-- /. box -->
      </div>
      <!-- /.col -->
    </div>

    <!-- /.row -->
    <!-- /.container-fluid -->
  </section>
</template>

<style scoped>
.btn-inner {
  position: relative;
  overflow: hidden;
}

.btn-inner::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

ul,
ol {
  padding-left: 0;
}

.content {
  height: auto;
}
.docBack {
  background-color: #d5f2f2;
  border-radius: 6px;
}

.card {
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 10px;
  width: 100%;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  height: 320px;
}
</style>
