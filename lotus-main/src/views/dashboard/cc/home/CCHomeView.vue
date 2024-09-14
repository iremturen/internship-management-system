<template>
  <div style="margin-left: 10px; margin-right: 10px; margin-top: 30px">
    <section class="content">
      <div class="container-fluid">
        <div class="row" style="margin-top: 20px">
          <div class="col">
            <div class="card card-primary card-outline" style="height: auto">
              <div class="card-body p-0">
                <div class="table-responsive mailbox-messages">
                  <RouterLink :to="{ name: 'CCNewOpportunity' }">
                    <div class="row position-relative">
                      <button class="button" style="text-align: start">
                        <svg
                          xmlns="http://www.w3.org/2000/svg"
                          width="30"
                          height="30"
                          fill="currentColor"
                          class="bi bi-bar-chart position-absolute start-0"
                          viewBox="0 0 16 16"
                          style="
                            margin-left: 30px;
                            margin-top: -1rem !important;
                            left: 1rem !important;
                          "
                        >
                          <path
                            d="M4 11H2v3h2v-3zm5-4H7v7h2V7zm5-5v12h-2V2h2zm-2-1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1h-2zM6 7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V7zm-5 4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-3z"
                          ></path>
                        </svg>
                        <strong
                          style="
                            margin-left: 10px;
                            margin-right: 0px;
                            left: 5rem !important;
                            margin-top: -1rem !important;
                          "
                          class="position-absolute start-0"
                          >Internship Opportunities Page</strong
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
                      </button></div
                  ></RouterLink>

                  <table class="table table-striped">
                    <tbody></tbody>
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

    <section class="content">
      <div class="container-fluid">
        <div class="row" style="margin-top: 20px">
          <div class="col">
            <div class="card card-primary card-outline" style="height: auto">
              <div class="card-header">
                <h4 class="card-title" style="color: #2c919c">
                  <i class="fa fa-bell" aria-hidden="true"></i> Notifications
                </h4>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <div class="table-responsive mailbox-messages">
                  <table class="table table-striped">
                    <tbody>
                      <ul style="list-style: none">
                        <li
                          class="noti ps-3"
                          style="margin-left: -30px; height: 30px; background-color: #d6d6d6"
                        >
                          default
                        </li>
                        <li
                          class="noti ps-3"
                          style="
                            margin-top: 3px;
                            margin-left: -30px;
                            height: 30px;
                            background-color: #d6d6d6;
                          "
                        >
                          default
                        </li>
                        <li
                          class="noti ps-3"
                          style="
                            margin-top: 3px;
                            margin-left: -30px;
                            height: 30px;
                            background-color: #d6d6d6;
                          "
                        >
                          default
                        </li>
                        <li
                          class="noti ps-3"
                          style="
                            margin-top: 3px;
                            margin-left: -30px;
                            height: 30px;
                            background-color: #d6d6d6;
                          "
                        >
                          default
                        </li>
                      </ul>
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
  </div>
</template>
<style scoped>
.button {
  background-color: #d3ecec;
  border: 1px;
  border-radius: 5px;
  color: #0e163d;
  width: 100%;
  padding: 15px 32px;
  height: 100px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}

.button:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.card7 {
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 10px;
  width: 600px;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  height: 320px;
  margin-top: 50px;
  margin-left: 50px;
  display: flex;
  justify-content: center;
  flex-direction: column;
}
.card {
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 10px;
  width: 100%;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  height: 320px;
}

</style>
