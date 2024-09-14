<template>
  <video autoplay muted loop id="player" style="z-index: -100">
    <source src="../assets/videos/background.mp4" type="video/mp4" />
  </video>
</template>

<style scoped>
#player {
  position: fixed;
  min-width: 100%;
  min-height: 100%;
}
</style>
