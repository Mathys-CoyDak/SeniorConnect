<template>
  <nav class="navbar" aria-label="Main navigation">
    <div class="navbar-container">
      <div class="navbar-logo">
        <img :src="logoUrl" :alt="logoAlt" class="logo-image" />
        <span class="logo-text">{{ logoText }}</span>
      </div>

      <div class="navbar-links">
        <a v-for="(link, index) in computedLinks" :key="index" :href="link.href" class="nav-link">
          {{ link.label }}
        </a>

        <template v-if="!isLoggedIn">
          <button
            class="sign-in-button"
            @mouseenter="animateButton"
            @mouseleave="resetButton"
            @click="redirectToLogin"
          >
            Connexion
          </button>
        </template>

        <template v-else>
          <button class="sign-in-button logout" @click="logout">Déconnexion</button>
        </template>
      </div>

      <button
        class="menu-toggle"
        @click="toggleMenu"
        :aria-expanded="isMenuOpen.toString()"
        aria-controls="mobile-menu"
        aria-label="Toggle menu"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="menu-icon"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M4 6h16M4 12h16M4 18h16"
          />
        </svg>
      </button>
    </div>

    <div
      id="mobile-menu"
      class="mobile-menu"
      :class="{ 'is-open': isMenuOpen }"
      v-show="isMenuOpen"
    >
      <a
        v-for="(link, index) in computedLinks"
        :key="'mobile-' + index"
        :href="link.href"
        class="mobile-nav-link"
      >
        {{ link.label }}
      </a>
      <button v-if="!isLoggedIn" class="mobile-sign-in-button" @click="redirectToLogin">
        Connexion
      </button>
      <button v-else class="mobile-sign-in-button" @click="logout">Déconnexion</button>
    </div>
  </nav>
</template>

<script setup>
import { ref, computed } from 'vue'

// 🔐 À remplacer par votre store ou logique réelle d'auth
const isLoggedIn = ref(false)

const logoUrl = '/logo.png'
const logoAlt = 'Logo de SeniorConnect'
const logoText = 'SeniorConnect'

const guestLinks = [
  { label: 'Accueil', href: '/' },
  { label: 'À propos', href: '/about' },
  { label: 'Contact', href: '/contact' },
]

const userLinks = [
  { label: 'Accueil', href: '/' },
  { label: 'Tableau de bord', href: '/dashboard' },
  { label: 'Profil', href: '/profile' },
]

const computedLinks = computed(() => (isLoggedIn.value ? userLinks : guestLinks))

const isMenuOpen = ref(false)

function toggleMenu() {
  isMenuOpen.value = !isMenuOpen.value
}

function redirectToLogin() {
  window.location.href = '/login'
}

function logout() {
  // 🔐 Implémente ta logique ici
  console.log('Déconnexion')
  isLoggedIn.value = false
}

function animateButton(event) {
  event.target.style.transform = 'scale(1.05)'
}

function resetButton(event) {
  event.target.style.transform = 'scale(1)'
}
</script>

<style scoped>
.navbar {
  width: 100%;
  background-color: white;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  z-index: 50;
}

.navbar-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1rem 1.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navbar-logo {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.logo-image {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.logo-text {
  font-size: 24px;
  font-weight: bold;
  color: #2c3e50;
}

.navbar-links {
  display: flex;
  align-items: center;
  gap: 2rem;
}

.nav-link {
  font-size: 18px;
  font-weight: 500;
  text-decoration: none;
  color: #333333;
}

.nav-link:hover,
.nav-link:focus {
  text-decoration: underline;
}

.sign-in-button {
  background-color: #4318d1;
  color: white;
  border: none;
  border-radius: 8px;
  padding: 0.75rem 1.5rem;
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  transition: transform 0.2s ease;
}

.sign-in-button:hover,
.sign-in-button:focus {
  outline: none;
  box-shadow: 0 4px 8px rgba(67, 24, 209, 0.3);
}

.menu-toggle {
  display: none;
  background: none;
  border: none;
  cursor: pointer;
}

.menu-icon {
  height: 32px;
  width: 32px;
}

.mobile-menu {
  display: none;
  background-color: white;
  width: 100%;
  padding: 1rem 1.5rem;
  flex-direction: column;
  gap: 1rem;
}

.mobile-nav-link {
  font-size: 18px;
  font-weight: 500;
  text-decoration: none;
  color: #333333;
}

.mobile-sign-in-button {
  background-color: #4318d1;
  color: white;
  border: none;
  border-radius: 8px;
  padding: 0.75rem 1.5rem;
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  width: 100%;
}

@media (max-width: 1024px) {
  .navbar-links {
    display: none;
  }

  .menu-toggle {
    display: block;
  }

  .mobile-menu {
    display: flex;
  }

  .mobile-menu.is-open {
    display: flex;
  }
}
</style>
