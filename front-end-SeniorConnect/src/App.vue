<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script setup>
</script>

<style scoped>
nav {
  padding: 1rem;
  background-color: #f0f0f0;
}

nav a {
  margin-right: 1rem;
  text-decoration: none;
  color: #333;
  font-weight: bold;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
