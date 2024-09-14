<script>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getOpportunityById } from '../../../../api/opportunity.api'

export default {
  setup() {
    const router = useRouter()
    const route = useRoute()
    const opportunities = ref([])

    const goBack = () => {
      router.go(-1)
    }

    onMounted(async () => {
      opportunities.value = await getOpportunityById(route.params.id)
    })

    return {
      goBack,

      opportunities
    }
  }
}
</script>
<template>
  <section class="content">
    <div class="container-fluid">
      <div class="rows-2" style="margin-top: 20px">
        <div class="row">
          <div class="col-md-9">
            <button
              class="btn btn-inner btnBack backIcon col-2 mb-3"
              @click.prevent="goBack()"
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
            <br />
            <div style="margin-left: 20px" class="px-5">
              <h1>Internship Task</h1>
              <span>
                Your profile could be a good fit if it meets the following requirements:
                <br />
                <br />
                • At least 18 years old.
                <br />
                <br />
                • Enrolled in an undergraduate, graduate or PhD programme, or have graduated within
                the past two years.
                <br />
                <br />
                • Proficient in at least one of languages: English, French or Spanish. Fluency in
                the working language of the office you are applying to, may also be required.
                <br />
                <br />
                • Have strong academic performance and motivation
                <br />
                <br />
                • Additional consideration will be given to any professional experience relevant to
                the function you’re applying for.
              </span>
            </div>
          </div>
          <div class="col-md-3">
            <div
              class="card"
              style="
                margin-left: -10%;
                height: auto;
                background: rgba(34, 155, 156, 0.2);
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                border-radius: 9px;
              "
            >
              <div class="card-header" style="background-color: #b0dbdb">
                <img src="../../../../assets/images/user.png" alt="" />
                <span style="margin-left: 10px">Company Name</span>
                <div style="margin-left: 80px">Location</div>
              </div>
              <div class="card-body" style="background-color: #d3ebeb">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="50"
                  height="50"
                  fill="currentColor"
                  class="bi bi-hourglass"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M2 1.5a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-1v1a4.5 4.5 0 0 1-2.557 4.06c-.29.139-.443.377-.443.59v.7c0 .213.154.451.443.59A4.5 4.5 0 0 1 12.5 13v1h1a.5.5 0 0 1 0 1h-11a.5.5 0 1 1 0-1h1v-1a4.5 4.5 0 0 1 2.557-4.06c.29-.139.443-.377.443-.59v-.7c0-.213-.154-.451-.443-.59A4.5 4.5 0 0 1 3.5 3V2h-1a.5.5 0 0 1-.5-.5zm2.5.5v1a3.5 3.5 0 0 0 1.989 3.158c.533.256 1.011.791 1.011 1.491v.702c0 .7-.478 1.235-1.011 1.491A3.5 3.5 0 0 0 4.5 13v1h7v-1a3.5 3.5 0 0 0-1.989-3.158C8.978 9.586 8.5 9.052 8.5 8.351v-.702c0-.7.478-1.235 1.011-1.491A3.5 3.5 0 0 0 11.5 3V2h-7z"
                  />
                </svg>
                <span> Application Deadline dd/mm/yyyy </span>
              </div>

              <button class="button1">Apply</button>
            </div>
          </div>
        </div>
        <!-- /.col -->
      </div>
    </div>
    <!-- /.row -->
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
.button1 {
  padding: 15px 25px;
  font-size: 13px;
  width: 100%;

  cursor: pointer;
  outline: none;

  height: 55px;

  background: linear-gradient(180deg, #2c919c 0%, #0e163d 100%);
  backdrop-filter: blur(2px);
}

.button1:hover {
  background-color: #3e8e41;
}

.button1:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
}
ul,
ol {
  padding-left: 0%;
}
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
  color: white;
  background-color: #d3ecec;
}

.content {
  height: auto;
}
</style>
