<template>
  <nav class="navbar">
    <div class="navbar-container">
      <div class="navbar-logo">
        <img src="" alt="Logo" class="logo-image" />
        <span class="logo-text">SeniorConnect</span>
      </div>

      <div class="navbar-links">
        <router-link to="/signup" class="nav-link">Inscription</router-link>
        <router-link to="/login" class="nav-link">Connexion</router-link>
        <router-link to="/about" class="nav-link">À propos</router-link>
      </div>

      <button class="menu-toggle" @click="toggleMenu" aria-label="Toggle menu">
        <svg xmlns="http://www.w3.org/2000/svg" class="menu-icon">
          <path d="M4 6h16M4 12h16M4 18h16"/>
        </svg>
      </button>
    </div>

    <div v-show="isMenuOpen" class="mobile-menu">
      <router-link to="/signup" class="mobile-nav-link">Inscription</router-link>
      <router-link to="/login" class="mobile-nav-link">Connexion</router-link>
      <button class="mobile-sign-in-button">Sign In</button>
    </div>
  </nav>
  <div class="senior-connect-landing">
    <HeroSection />
    <HowItWorksSection />
    <BenefitsSection />
  </div>
</template>

<script>
import HeroSection from "./HeroSection.vue";
import HowItWorksSection from "./HowItWorksSection.vue";
import BenefitsSection from "./BenefitsSection.vue";

export default {
  name: "SeniorConnectLanding",
  components: {
    HeroSection,
    HowItWorksSection,
    BenefitsSection,
  },
  data() {
    return {
      isMenuOpen: false,
    }
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen
    }
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap");

body {
  margin: 0;
  padding: 0;
  font-family: "Inter", sans-serif;
  color: #333333;
  background-color: #fafafa;
}

.senior-connect-landing {
  min-height: 100vh;
  width: 100%;
}
</style>
