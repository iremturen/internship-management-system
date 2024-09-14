<script>
import { onMounted, ref } from 'vue'
import { getOpportunities } from '../../../../api/opportunity.api'

export default {
  setup() {
    const opportunities = ref([])

    onMounted(async () => {
      opportunities.value = await getOpportunities()
    })

    return {
      opportunities
    }
  }
}
</script>

<template>
  <section class="content">
    <div class="container-fluid">
      <div class="row" style="margin-top: 20px">
        <div class="col mx-5">
          <div class="card card-primary card-outline" style="height: auto">
            <div class="card-header">
              <h3 class="card-title" style="color: #2c919c">Internship Opportunities</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <div class="table-responsive mailbox-messages">
                <table class="table table-striped">
                  <tbody>
                    <div>
                      <div class="" style="margin-top: 15px" v-for="opportunity in opportunities">
                        <div
                          style="
                            background-color: #ededed;
                            padding: 1vw;
                            border-radius: 9px;
                            min-height: 55px !important;
                            display: flex;
                            justify-content: space-between;
                          "
                        >
                          <div style="display: flex">
                            <img
                              src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Eti_logo.png/160px-Eti_logo.png"
                              alt="company image"
                              style="margin-left: 3%; margin-right: 28px"
                            />
                            <div>
                              <div style="margin-bottom: 19px; margin-top: 2%; color: #2c919c">
                                {{ opportunity.date }}
                              </div>
                              <div style="display: flex; margin-bottom: 7px">
                                <svg
                                  xmlns="http://www.w3.org/2000/svg"
                                  viewBox="0 0 384 512"
                                  style="width: 23px; height: 23px"
                                >
                                  <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                  <path
                                    d="M48 0C21.5 0 0 21.5 0 48V464c0 26.5 21.5 48 48 48h96V432c0-26.5 21.5-48 48-48s48 21.5 48 48v80h96c26.5 0 48-21.5 48-48V48c0-26.5-21.5-48-48-48H48zM64 240c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H80c-8.8 0-16-7.2-16-16V240zm112-16h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H176c-8.8 0-16-7.2-16-16V240c0-8.8 7.2-16 16-16zm80 16c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H272c-8.8 0-16-7.2-16-16V240zM80 96h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H80c-8.8 0-16-7.2-16-16V112c0-8.8 7.2-16 16-16zm80 16c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H176c-8.8 0-16-7.2-16-16V112zM272 96h32c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H272c-8.8 0-16-7.2-16-16V112c0-8.8 7.2-16 16-16z"
                                  />
                                </svg>
                                <p style="margin-left: 5px">
                                  {{ opportunity.companyName }}
                                </p>
                              </div>
                              <div style="display: flex; margin-bottom: 7px">
                                <svg
                                  xmlns="http://www.w3.org/2000/svg"
                                  viewBox="0 0 384 512"
                                  style="width: 23px; height: 23px"
                                >
                                  <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                  <path
                                    d="M215.7 499.2C267 435 384 279.4 384 192C384 86 298 0 192 0S0 86 0 192c0 87.4 117 243 168.3 307.2c12.3 15.3 35.1 15.3 47.4 0zM192 128a64 64 0 1 1 0 128 64 64 0 1 1 0-128z"
                                  />
                                </svg>
                                <p style="margin-left: 5px">
                                  {{ opportunity.location }}
                                </p>
                              </div>
                              <div style="display: flex">
                                <svg
                                  xmlns="http://www.w3.org/2000/svg"
                                  viewBox="0 0 512 512"
                                  style="width: 23px; height: 23px"
                                >
                                  <!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                  <path
                                    d="M464 256A208 208 0 1 1 48 256a208 208 0 1 1 416 0zM0 256a256 256 0 1 0 512 0A256 256 0 1 0 0 256zM232 120V256c0 8 4 15.5 10.7 20l96 64c11 7.4 25.9 4.4 33.3-6.7s4.4-25.9-6.7-33.3L280 243.2V120c0-13.3-10.7-24-24-24s-24 10.7-24 24z"
                                  />
                                </svg>
                                <span style="margin-left: 5px"
                                  >Application Deadline:
                                  <small>
                                    {{ opportunity.deadline }}
                                  </small></span
                                >
                              </div>
                            </div>
                          </div>
                          <div style="right: 0">
                            <RouterLink
                              :to="{
                                name: 'StudentOpportunityDetails',
                                params: { id: opportunity.id }
                              }"
                            >
                              <button
                                style="background-color: #2c919c; border-radius: 10px; width: 155px"
                              >
                                More Details
                              </button>
                            </RouterLink>
                          </div>
                        </div>
                      </div>
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
@import url('../../../../assets/css/student.css');
button {
  background-color: #0e163d;
  color: #fff;
  padding: 8px 16px;
  width: 40%;
  border: none;

  cursor: pointer;
}

button:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  color: #0e163d;
  background-color: #d3ecec;
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
