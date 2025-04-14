<template>
  <div id="app">
    <nav>
      <GlobalNavBar></GlobalNavBar>
    </nav>
    <router-view />
  </div>
</template>

<script setup>
import GlobalNavBar from './components/GlobalNavBar.vue'
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
