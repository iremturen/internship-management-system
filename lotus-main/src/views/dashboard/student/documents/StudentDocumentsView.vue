<script>
import { createOfficialLetter } from '../../../../api/officialletter.api'
import useStudentStore from '../../../../stores/student.store'
import { ref } from 'vue'

export default {
  setup() {
    const studentStore = useStudentStore()
    const stuname = studentStore.student.name
    const surname = studentStore.student.surname
    const companyName = ref('')

    const createDocument = async () => {
      let data = {
        name: stuname,
        surname: surname,
        companyName: companyName.value
      }

      const res = await createOfficialLetter(data)
      console.log(data)
      console.log(res)
    }

    return {
      createDocument,
      companyName
    }
  }
}
</script>

<template>
  <section class="content">
    <div class="container-fluid">
      <div class="row" style="margin-top: 20px">
        <div class="col-3 ms-5 me-5 text-center">
          <div class="card card-primary card-outline" style="height: auto">
            <div class="card-body p-0">
              <div class="table-responsive mailbox-messages">
                <table class="table table-striped">
                  <tbody>
                    <div class="col">
                      <button
                        type="button"
                        class="btn btn-lg px-4"
                        style="
                          height: 70px;
                          width: auto;
                          background-color: #dedede;
                          text-align: start;
                          color: white;
                        "
                      >
                        <svg
                          xmlns="http://www.w3.org/2000/svg"
                          width="30"
                          height="30"
                          fill="currentColor"
                          class="bi bi-file-earmark-arrow-down"
                          viewBox="0 0 16 16"
                        >
                          <path
                            d="M8.5 6.5a.5.5 0 0 0-1 0v3.793L6.354 9.146a.5.5 0 1 0-.708.708l2 2a.5.5 0 0 0 .708 0l2-2a.5.5 0 0 0-.708-.708L8.5 10.293V6.5z"
                          />
                          <path
                            d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"
                          />
                        </svg>
                        <span style="font-size: large; margin-left: 10px">Install Transcript</span>
                      </button>
                    </div>
                    <input placeholder="enter company name please!" v-model="companyName" />

                    <div class="col">
                      <button
                        type="button"
                        class="btn btn-lg"
                        style="
                          height: 70px;
                          width: auto;
                          background-color: #0e163d;
                          color: white;
                          text-align: start;
                        "
                        @click="createDocument()"
                      >
                        <span style="margin-left: 0px">Create Official Letter</span>
                      </button>
                    </div>
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
        <div class="col-7 me-5">
          <div class="card card-primary card-outline" style="height: auto">
            <div class="card-body p-0">
              <div class="table-responsive mailbox-messages">
                <table class="table table-striped">
                  <tbody>
                    <div class="login-form" style="height: auto">
                      <form style="margin-top: 0%">
                        <input type="hidden" name="" />

                        <div class="card-body" style="height: 220px; color: #1b6068">
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

                          <div class="form-group mb-4">
                            <label for="files">File:</label>
                            <small
                              >(You can add multiple files by uploading one by one. Adding files is
                              not mandatory.)</small
                            >
                            <div class="MultiFile-wrap" id="files">
                              <input
                                type="file"
                                name="files[]"
                                class="form-control MultiFile-applied"
                                id="files"
                                value=""
                              />
                              <div class="MultiFile-list" id="files_list"></div>
                            </div>
                            <button
                              @click.prevent="submit"
                              class="mb-2 mt-2"
                              type="submit"
                              style="
                                width: 30%;
                                height: 50px;
                                margin-left: 70%;
                                margin-top: 20px !important;
                              "
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
                                />
                              </svg>
                              <Span>Send</Span>
                            </button>
                          </div>
                        </div>
                        <!-- /.card-body -->
                      </form>
                    </div>
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <div class="row" style="margin-top: 20px">
        <div class="col mx-5">
          <div class="card card-primary card-outline" style="height: 630px">
            <div class="card-header">
              <h3 class="card-title" style="color: #2c919c">Documents</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <div class="table-responsive mailbox-messages">
                <table class="table table-striped">
                  <tbody>
                    <div class="doc-box" style="height: 5vw; margin-top: 20px">
                      <div
                        style="
                          padding: 0.5vw;
                          text-align: left;
                          background-color: #a4cace;
                          padding-left: 2.5vw;
                          color: #0e163d;
                          border-radius: 1vw 1vw 0 0;
                          height: 35px;
                        "
                      >
                        <small>Internship Notebook</small>
                      </div>
                      <div
                        style="background-color: #ededed; padding: 1vw; border-radius: 0 0 1vw 1vw"
                      >
                        <div
                          style="
                            display: flex;
                            background-color: #cfd0d0;
                            padding: 0.25vw;
                            padding-left: 2.5vw;
                            padding-right: 1.5vw;
                            align-items: center;
                            align-content: space-around;
                            border-radius: 0.9vw;
                          "
                        >
                          <div style="width: 0.75vw; height: 1.25vw; margin-right: 1vw">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                              <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                              <path
                                d="M364.2 83.8c-24.4-24.4-64-24.4-88.4 0l-184 184c-42.1 42.1-42.1 110.3 0 152.4s110.3 42.1 152.4 0l152-152c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-152 152c-64 64-167.6 64-231.6 0s-64-167.6 0-231.6l184-184c46.3-46.3 121.3-46.3 167.6 0s46.3 121.3 0 167.6l-176 176c-28.6 28.6-75 28.6-103.6 0s-28.6-75 0-103.6l144-144c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-144 144c-6.7 6.7-6.7 17.7 0 24.4s17.7 6.7 24.4 0l176-176c24.4-24.4 24.4-64 0-88.4z"
                              />
                            </svg>
                          </div>
                          <div style="margin-right: 14vw">
                            <small><small>internship-report-template.docx</small></small>
                          </div>
                          <div style="margin-left: auto">
                            <button
                              style="
                                background-color: #a4cace;
                                width: 3vw;
                                height: 3vw;
                                margin-left: 0.5vw;
                                border-radius: 0.9vw;
                                color: white;
                              "
                            >
                              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                <path
                                  d="M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32V274.7l-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7V32zM64 352c-35.3 0-64 28.7-64 64v32c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V416c0-35.3-28.7-64-64-64H346.5l-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352H64zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z"
                                />
                              </svg>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- document box -->
                    <div class="doc-box" style="height: 5vw; margin-top: 75px">
                      <div
                        style="
                          padding: 0.5vw;
                          text-align: left;
                          background-color: #a4cace;
                          padding-left: 2.5vw;
                          color: #0e163d;
                          border-radius: 1vw 1vw 0 0;
                          height: 35px;
                        "
                      >
                        <small>Internship Notebook</small>
                      </div>
                      <div
                        style="background-color: #ededed; padding: 1vw; border-radius: 0 0 1vw 1vw"
                      >
                        <div
                          style="
                            display: flex;
                            background-color: #cfd0d0;
                            padding: 0.25vw;
                            padding-left: 2.5vw;
                            padding-right: 1.5vw;
                            align-items: center;
                            align-content: space-around;
                            border-radius: 0.9vw;
                          "
                        >
                          <div style="width: 0.75vw; height: 1.25vw; margin-right: 1vw">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                              <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                              <path
                                d="M364.2 83.8c-24.4-24.4-64-24.4-88.4 0l-184 184c-42.1 42.1-42.1 110.3 0 152.4s110.3 42.1 152.4 0l152-152c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-152 152c-64 64-167.6 64-231.6 0s-64-167.6 0-231.6l184-184c46.3-46.3 121.3-46.3 167.6 0s46.3 121.3 0 167.6l-176 176c-28.6 28.6-75 28.6-103.6 0s-28.6-75 0-103.6l144-144c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-144 144c-6.7 6.7-6.7 17.7 0 24.4s17.7 6.7 24.4 0l176-176c24.4-24.4 24.4-64 0-88.4z"
                              />
                            </svg>
                          </div>
                          <div style="margin-right: 14vw">
                            <small><small>internship-report-template.docx</small></small>
                          </div>
                          <div style="margin-left: auto">
                            <button
                              style="
                                background-color: #a4cace;
                                width: 3vw;
                                height: 3vw;
                                margin-left: 0.5vw;
                                border-radius: 0.9vw;
                              "
                            >
                              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                <path
                                  d="M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32V274.7l-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7V32zM64 352c-35.3 0-64 28.7-64 64v32c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V416c0-35.3-28.7-64-64-64H346.5l-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352H64zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z"
                                />
                              </svg>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- document box -->
                    <div class="doc-box" style="height: 5vw; margin-top: 75px">
                      <div
                        style="
                          padding: 0.5vw;
                          text-align: left;
                          background-color: #a4cace;
                          padding-left: 2.5vw;
                          color: #0e163d;
                          border-radius: 1vw 1vw 0 0;
                          height: 35px;
                        "
                      >
                        <small>Internship Notebook</small>
                      </div>
                      <div
                        style="background-color: #ededed; padding: 1vw; border-radius: 0 0 1vw 1vw"
                      >
                        <div
                          style="
                            display: flex;
                            background-color: #cfd0d0;
                            padding: 0.25vw;
                            padding-left: 2.5vw;
                            padding-right: 1.5vw;
                            align-items: center;
                            align-content: space-around;
                            border-radius: 0.9vw;
                          "
                        >
                          <div style="width: 0.75vw; height: 1.25vw; margin-right: 1vw">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                              <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                              <path
                                d="M364.2 83.8c-24.4-24.4-64-24.4-88.4 0l-184 184c-42.1 42.1-42.1 110.3 0 152.4s110.3 42.1 152.4 0l152-152c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-152 152c-64 64-167.6 64-231.6 0s-64-167.6 0-231.6l184-184c46.3-46.3 121.3-46.3 167.6 0s46.3 121.3 0 167.6l-176 176c-28.6 28.6-75 28.6-103.6 0s-28.6-75 0-103.6l144-144c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-144 144c-6.7 6.7-6.7 17.7 0 24.4s17.7 6.7 24.4 0l176-176c24.4-24.4 24.4-64 0-88.4z"
                              />
                            </svg>
                          </div>
                          <div style="margin-right: 14vw">
                            <small><small>internship-report-template.docx</small></small>
                          </div>
                          <div style="margin-left: auto">
                            <button
                              style="
                                background-color: #a4cace;
                                width: 3vw;
                                height: 3vw;
                                margin-left: 0.5vw;
                                border-radius: 0.9vw;
                              "
                            >
                              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                <path
                                  d="M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32V274.7l-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7V32zM64 352c-35.3 0-64 28.7-64 64v32c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V416c0-35.3-28.7-64-64-64H346.5l-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352H64zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z"
                                />
                              </svg>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- document box -->
                    <div class="doc-box" style="height: 5vw; margin-top: 75px">
                      <div
                        style="
                          padding: 0.5vw;
                          text-align: left;
                          background-color: #a4cace;
                          padding-left: 2.5vw;
                          color: #0e163d;
                          border-radius: 1vw 1vw 0 0;
                          height: 35px;
                        "
                      >
                        <small>Internship Notebook</small>
                      </div>
                      <div
                        style="background-color: #ededed; padding: 1vw; border-radius: 0 0 1vw 1vw"
                      >
                        <div
                          style="
                            display: flex;
                            background-color: #cfd0d0;
                            padding: 0.25vw;
                            padding-left: 2.5vw;
                            padding-right: 1.5vw;
                            align-items: center;
                            align-content: space-around;
                            border-radius: 0.9vw;
                          "
                        >
                          <div style="width: 0.75vw; height: 1.25vw; margin-right: 1vw">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                              <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                              <path
                                d="M364.2 83.8c-24.4-24.4-64-24.4-88.4 0l-184 184c-42.1 42.1-42.1 110.3 0 152.4s110.3 42.1 152.4 0l152-152c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-152 152c-64 64-167.6 64-231.6 0s-64-167.6 0-231.6l184-184c46.3-46.3 121.3-46.3 167.6 0s46.3 121.3 0 167.6l-176 176c-28.6 28.6-75 28.6-103.6 0s-28.6-75 0-103.6l144-144c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-144 144c-6.7 6.7-6.7 17.7 0 24.4s17.7 6.7 24.4 0l176-176c24.4-24.4 24.4-64 0-88.4z"
                              />
                            </svg>
                          </div>
                          <div style="margin-right: 14vw">
                            <small><small>internship-report-template.docx</small></small>
                          </div>
                          <div style="margin-left: auto">
                            <button
                              style="
                                background-color: #a4cace;
                                width: 3vw;
                                height: 3vw;
                                margin-left: 0.5vw;
                                border-radius: 0.9vw;
                              "
                            >
                              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                <path
                                  d="M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32V274.7l-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7V32zM64 352c-35.3 0-64 28.7-64 64v32c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V416c0-35.3-28.7-64-64-64H346.5l-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352H64zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z"
                                />
                              </svg>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- document box -->
                    <div class="doc-box" style="height: 5vw; margin-top: 75px"></div>
                    <!-- document box -->
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
  </section>
</template>

<style scoped>
@import url('../../../../assets/css/style.css');
.card {
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 10px;
  width: 100%;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  height: 320px;
}
.login-form {
  position: relative;
  width: 100%;
  height: 290px !important;
  background: #e7e7e7;
  padding: 5px 35px 5px;
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
  color: #ffffff;
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
body {
  background-color: #fff;
}

ul,
ol {
  padding-left: 0%;
}
.content {
  height: auto;
}
</style>
