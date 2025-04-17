<template>
  <nav class="navbar">
    <div class="navbar-container">
      <!-- Logo Section -->
      <div class="navbar-logo">
        <img src="" alt="Logo" class="logo-image" />
        <span class="logo-text">SeniorConnect</span>
      </div>

      <!-- Links Section -->
      <div class="navbar-links">
        <template v-if="isLoggedIn">
          <button class="nav-link" @click="logout">Déconnexion</button>
        </template>
        <template v-else>
          <router-link to="/signup" class="nav-link">Inscription</router-link>
          <router-link to="/login" class="nav-link">Connexion</router-link>
        </template>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return localStorage.getItem("jwtToken") !== null;
    },
  },
  methods: {
    logout() {
      localStorage.removeItem("jwtToken");
      this.$router.push("/login");
    },
  },
};
</script>
<style></style>
