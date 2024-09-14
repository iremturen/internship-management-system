<script setup>

import AppBackground from '../../components/AppBackground.vue'
import { ref } from 'vue'
import useAdminStore from '../../stores/admin.store'
import { useRouter } from 'vue-router'

const adminId = ref('')
const password = ref('')
const adminStore = useAdminStore()
const router = useRouter()

async function submit() {
  if (adminId.value === '' || password.value === '') {
    alert('Please fill all the fields')
  } else {
    const data = await adminStore.setAdmin(adminId.value, password.value)
    console.log(data)
    if (data) {
      router.push({ name: 'AdminDashboard' })
    } else {
      alert('Invalid admin id or password')
    }
  }
}

</script>

<template>
  <AppBackground />
  <div class="container cnt d-flex justify-content-center align-items-center" style="height: 100vh">

  <div class="c">
    <div class="container-form">
      <form
        style="border-top-right-radius: 0%; border-bottom-right-radius: 0%"
        @submit.prevent="submit"
      >
        <label for="iCoorId">Admin Id</label>
        <input
          type="text"
          id="stId"
          placeholder="Enter your id"
          autofocus
          required
          v-model="adminId"
        />

        <label for="password" class="mt-2">Password</label>
        <input
          required
          type="password"
          id="password"
          placeholder="Enter your password"
          v-model="password"
        />

        <button id="button2" type="submit">Submit</button>
      </form>
    </div>
  </div>

  </div>
</template>



<style scoped>
.c .container-label {
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-size: 1.75rem;
  color: #ffffff;
  background: linear-gradient(180deg, rgb(32, 45, 108), rgb(44, 145, 156));
  border-top-left-radius: 8px;
  border-bottom-left-radius: 8px;
  padding: 1.75rem;
}

.c .container-form form {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  color: rgb(32, 45, 108);
  background: #eeeeee;
  padding: 4rem;
  width: 450px;
  border-top-right-radius: 8px;
  border-bottom-right-radius: 8px;
}

.c .container-form input::placeholder {
  color: rgb(35, 122, 131);
}

.crd .container-form #stId {
  margin-bottom: 2rem;
}

.c .container-form button {
  color: #ffffff;
  background: linear-gradient(180deg, rgb(32, 45, 108), rgb(44, 145, 156));
  padding: 12px 16px;
  margin-top: 2rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.container-form button[type='submit'] {
  color: #ffffff;
  background-color: blue;
  padding: 12px 16px;
  margin-top: 2rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

@media (max-width: 768px) {
  .cnt {
    padding: 1rem;
  }

  .c {
    flex-direction: column;
    width: 90%;
  }

  .c::before {
    display: none;
  }

  .c::after {
    display: none;
  }

  .c .container-label {
    border-top-right-radius: 8px;
    border-bottom-left-radius: 0;
  }

  .c .container-form form {
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    border-bottom-left-radius: 8px;
    width: auto;
  }

  .footer {
    display: none;
  }
}

.cnt {
  display: flex;
  align-items: center;
  justify-content: center;
}

.c {
  display: flex;
  border-radius: 8px;
  box-shadow: 0px 0px 16px 14px rgba(0, 0, 0, 0.072);
}

.c .container-form input {
  color: rgb(32, 45, 108);
  background-color: transparent;
  padding: 8px;
  border: none;
  border-bottom: 1px solid rgb(32, 45, 108);
  width: 100%;
}

.c .container-form input:focus {
  border-color: rgb(22, 30, 72);
  outline: none !important;
}
</style>
