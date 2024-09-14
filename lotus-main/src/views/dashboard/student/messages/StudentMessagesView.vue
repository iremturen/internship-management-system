<script>
import { ref, onMounted } from 'vue'

export default {
  setup() {
    const optionMenu = ref(null)
    const selectBtn = ref(null)
    const options = ref(null)
    const sBtn_text = ref(null)

    onMounted(() => {
      selectBtn.value.addEventListener('click', () => optionMenu.value.classList.toggle('active'))

      options.value = optionMenu.value.querySelectorAll('.option')

      options.value.forEach((option) => {
        option.addEventListener('click', () => {
          sBtn_text.value.innerHTML = option.querySelector('span').innerHTML
          optionMenu.value.classList.remove('active')
        })
      })
    })
    return {
      optionMenu,
      selectBtn,
      options,
      sBtn_text
    }
  }
}
</script>

<template>
  <section class="content">
    <div class="container-fluid">
      <div class="row" style="margin-top: 20px">
        <div class="col-md-3">
          <RouterLink
            :to="{ name: 'StudentNewMessages' }"
            class="button2"
            style="width: 250px; height: 55px; margin-left: 40px; text-align: start"
            >New Message</RouterLink
          >
          <div>
            <div>
              <div class="select-menu" style="margin-left: 40px" ref="optionMenu">
                <div class="select-btn" ref="selectBtn">
                  <span class="sBtn-text" ref="sBtn_text"> Messages</span>
                  <i class="bx bx-chevron-down"></i>
                </div>
                <ul class="options" ref="options">
                  <RouterLink :to="{name: 'StudentIncomingMessages'}">
                  <li class="option">
                    
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      class="icon icon-tabler icon-tabler-mail-up"
                      width="21"
                      height="21"
                      viewBox="0 0 24 24"
                      stroke-width="2"
                      stroke="currentColor"
                      fill="none"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    >
                      <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                      <path
                        d="M12 19h-7a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5.5"
                      ></path>
                      <path d="M19 22v-6"></path>
                      <path d="M22 19l-3 -3l-3 3"></path>
                      <path d="M3 7l9 6l9 -6"></path>
                    </svg>
                    <span class="option-text"><small>Incoming Messages</small></span>
                  </li>
                  </RouterLink>
                  <RouterLink :to="{name: 'StudentOutgoingMessages'}">
                  <li class="option">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      class="icon icon-tabler icon-tabler-mail-down"
                      width="21"
                      height="21"
                      viewBox="0 0 24 24"
                      stroke-width="2"
                      stroke="currentColor"
                      fill="none"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    >
                      <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                      <path
                        d="M12 19h-7a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5.5"
                      ></path>
                      <path d="M19 16v6"></path>
                      <path d="M22 19l-3 3l-3 -3"></path>
                      <path d="M3 7l9 6l9 -6"></path>
                    </svg>
                    <span class="option-text"><small>Outgoing Messages</small></span>
                  </li>
                  </RouterLink>
                </ul>
              </div>
            </div>

            <!-- /.card-body -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <RouterView />

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
.content {
  height: auto;
  display: block;
}

.button2 {
  background-color: #0e163d;
  border: 1px;
  height: 60px;
  border-radius: 4px;
  color: #fff;
  width: 380px;
  padding: 15px 32px;
  text-align: start;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}

.button2:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
}

.select-menu {
  width: 250px;
  margin-top: 30px;
}
.select-menu .select-btn {
  display: flex;
  height: 55px;
  border-radius: 4px;
  background: #0e163d;
  color: #fff;
  padding: 20px;
  font-size: 16px;
  align-items: center;
  cursor: pointer;
  justify-content: space-between;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}
.select-btn i {
  font-size: 25px;
  transition: 0.3s;
}
.select-menu.active .select-btn i {
  transform: rotate(-180deg);
}
.select-menu .options {
  position: relative;
  padding: 20px;
  margin-top: 10px;
  border-radius: 4px;
  color: #0e163d;
  background: #d6d6d6;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
  display: none;
}
.select-menu.active .options {
  display: block;
}
.options .option {
  display: flex;
  height: 55px;
  cursor: pointer;
  padding: 0 16px;
  border-radius: 8px;
  align-items: center;
  background: #d6d6d6;
}
.options .option:hover {
  background: #f2f2f2;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
}
.option i {
  font-size: 25px;
  margin-right: 12px;
}
.option .option-text {
  font-size: 16px;
  color: #333;
}
</style>
