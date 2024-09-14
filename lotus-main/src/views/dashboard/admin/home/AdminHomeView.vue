<template>
  <section class="content">
    <div class="container-fluid">
      <div class="row" style="margin-top: 20px">
        <div class="col">
          <div class="card card-primary card-outline" style="height: auto">
            <div class="card-body p-0">
              <div class="table-responsive mailbox-messages">
                <table class="table table-striped">
                  <tbody>
                    <div class="row position-relative">
                      <RouterLink :to="{ name: 'AdminAssignCoord' }">
                        <button class="button" style="text-align: start">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon icon-tabler icon-tabler-user-plus position-absolute"
                            width="30"
                            height="30"
                            viewBox="0 0 24 24"
                            stroke-width="2"
                            stroke="currentColor"
                            fill="none"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            style="
                              margin-left: 30px;
                              left: 1rem !important;
                              margin-top: -1rem !important;
                            "
                          >
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0"></path>
                            <path d="M16 19h6"></path>
                            <path d="M19 16v6"></path>
                            <path d="M6 21v-2a4 4 0 0 1 4 -4h4"></path>
                          </svg>
                          <strong
                            style="
                              margin-left: 10px;
                              margin-right: 0px;
                              left: 5rem !important;
                              margin-top: -1rem !important;
                            "
                            class="position-absolute start-0"
                            >Assign New Internship Coordinator</strong
                          >
                          <img
                            class="img1 position-absolute end-0 text-end"
                            src="../../../../assets/images/arrow-right.png"
                            width="30"
                            height="30"
                            alt=""
                            style="
                              margin-left: 125px !important;
                              right: 3rem !important;
                              margin-top: -1rem !important;
                            "
                          />
                        </button>
                      </RouterLink>
                    </div>
                    <div class="row position-relative">
                      <RouterLink :to="{ name: 'AdminAssignStaff' }">
                        <button class="button" style="margin-top: 30px">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon icon-tabler icon-tabler-users-plus position-absolute"
                            width="30"
                            height="30"
                            viewBox="0 0 24 24"
                            stroke-width="2"
                            stroke="currentColor"
                            fill="none"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            style="
                              margin-left: 30px;
                              left: 1rem !important;
                              margin-top: -1rem !important;
                            "
                          >
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M5 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0"></path>
                            <path d="M3 21v-2a4 4 0 0 1 4 -4h4c.96 0 1.84 .338 2.53 .901"></path>
                            <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                            <path d="M16 19h6"></path>
                            <path d="M19 16v6"></path>
                          </svg>
                          <strong
                            style="
                              margin-left: 10px;
                              margin-right: 0px;
                              left: 5rem !important;
                              margin-top: -1rem !important;
                            "
                            class="position-absolute start-0"
                            >Assign Career Center Staff</strong
                          >
                          <img
                            class="img2 position-absolute end-0 text-end"
                            src="../../../../assets/images/arrow-right.png"
                            width="30"
                            height="30"
                            alt=""
                            style="right: 3rem !important; margin-top: -1rem !important"
                          />
                        </button>
                      </RouterLink>
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
      <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
  </section>
</template>

<style scoped>
@import url('../../../../assets/css/style.css');

section {
  height: 100vh;
  width: 100vw;
  padding-top: 150px;
}

.material-symbols-outlined {
  font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
}
</style>
