<script setup>

import AppBackground from '../../components/AppBackground.vue'

</script>

<template>
  <AppBackground />
  <div class="container">
    <div class="row justify-content-center align-items-center vh-100">
      <div class="col-md-6 text-center">
        <img
          src="../../assets/images/uskudar-universitesi-logo.png"
          alt="Logo"
          class="img-fluid mb-3"
          style="width: 14rem; height: 14rem"
        />
        <div class="entText text-uppercase mb-4 fw-bolder">Internshıp Applıcatıon System</div>

        <RouterLink
          to="/student-login"
          class="btn btn-link text-reset text-decoration-none btn-md d-block mb-3 entBtnText"
          >Student</RouterLink
        >
        <RouterLink
          to="/coordinator-login"
          class="btn btn-link text-reset text-decoration-none btn-md d-block mb-3 entBtnText"
          >Internship Coordinator</RouterLink
        >

        <RouterLink
          to="/staff-login"
          class="btn btn-link text-reset text-decoration-none btn-md d-block mb-3 entBtnText"
          >Career Center Staff</RouterLink
        >
      </div>
    </div>
  </div>
</template>

<style scoped>
.btn:focus,
.btn:active {
  outline: none !important;
  box-shadow: 6px 6px 12px #ccf7ff42, -6px -6px 12px #ffffff4c;
}

.entBtnText {
  position: relative;
  font-size: 16px;
  font-weight: 600;
  padding: 12px 24px;
  border: none;
  color: rgb(14, 22, 61);
  border-radius: 48px;
  box-shadow: 6px 6px 12px #ccf7ff42, -6px -6px 12px #ffffff4c;
  z-index: 1;
  overflow: hidden;
  cursor: pointer;
  transition: 0.3s;
  font-family: 'PT Serif', system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen,
    Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.entBtnText:hover {
  color: #c6f1fa;
}

.entBtnText::before {
  content: '';
  display: block;
  position: absolute;
  height: 100%;
  width: 0;
  top: 0;
  left: 0;
  background-image: linear-gradient(to right, #a9f2ff9d 0%, #08b2ac 100%);
  transition: 0.5s ease;
  z-index: -1;
}

.entBtnText:hover::before {
  width: 100%;
}

.entText {
  color: rgb(14, 22, 61);
  font-size: 1.5rem;
  line-height: 1.5rem;
  font-family: 'Roboto Slab', system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
</style>
