<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <div class="fixed">
    <header class="header">
      <div class="header-right">
        <RouterLink :to="{ name: 'AdminHome' }">
          <div class="admin-panel">Admin Panel</div></RouterLink
        >
      </div>
      <div class="logo">
        <img
          src="../assets/images/uskudar-universitesi-logo.png"
          alt="Logo"
          class="img-fluid"
          style="width: 5 rem; height: 5rem"
        />
      </div>
    </header>
  </div>
</template>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  background-color: rgb(14, 22, 61);
}

.header-right {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  position: absolute;
  right: 0px;
}

.header-right a {
  margin-left: 10px;
}

.admin-panel {
  font-weight: bold;
  color: #fff;
  background-color: rgb(14, 22, 61);
  padding: 10px;
  border-radius: 5px;
  margin-right: 100px;
}

.fixed {
  position: fixed;
  width: 100%;
  z-index: 1;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.3rem;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
