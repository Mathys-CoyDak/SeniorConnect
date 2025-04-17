<template>
  <form
    @submit.prevent="handleSubmit"
    class="login-form"
    aria-labelledby="login-heading"
  >
    <div class="form-group">
      <label for="email" class="form-label">Email Address</label>
      <div class="input-container">
        <input
          id="email"
          type="email"
          v-model="formData.email"
          placeholder="Enter your email"
          class="form-input"
          required
          aria-required="true"
        />
        <!-- Remplacement du SVG par l'icône Bootstrap -->
        <i class="bi bi-envelope input-icon" aria-hidden="true"></i>
      </div>
    </div>

    <div class="form-group">
      <label for="password" class="form-label">Password</label>
      <div class="input-container">
        <input
          id="password"
          :type="showPassword ? 'text' : 'password'"
          v-model="formData.password"
          placeholder="Enter your password"
          class="form-input"
          required
          aria-required="true"
        />
        <!-- Remplacement du SVG par l'icône Bootstrap -->
        <i class="bi bi-lock input-icon" aria-hidden="true"></i>
        <button
          type="button"
          @click="togglePasswordVisibility"
          class="password-toggle"
          aria-label="Toggle password visibility"
        >
          <!-- Remplacement du SVG par une icône conditionnelle Bootstrap -->
          <i
            :class="showPassword ? 'bi bi-eye-slash toggle-icon' : 'bi bi-eye toggle-icon'"
          ></i>
        </button>
      </div>
    </div>

    <div class="forgot-password-container">
      <button
        type="button"
        @click="$emit('forgot-password')"
        class="forgot-password-link"
      >
        Forgot Password?
      </button>
    </div>

    <button
      type="submit"
      class="submit-button"
      :class="{ disabled: !isFormValid }"
      :disabled="!isFormValid"
    >
      Sign In
    </button>
    <div v-if="errorMessage" class="error-message">
      {{ errorMessage }}
    </div>

  </form>
</template>

<script>
import axios from "@/services/axios";

export default {
  name: "LoginForm",
  data() {
    return {
      showPassword: false,
      formData: {
        email: "",
        password: "",
      },
      errorMessage: "", // Gérer les erreurs du login
    };
  },
  computed: {
    isFormValid() {
      return this.formData.email && this.formData.password;
    },
  },
  methods: {
    togglePasswordVisibility() {
      this.showPassword = !this.showPassword;
    },
    async handleSubmit() {
      if (!this.isFormValid) {
        return;
      }

      try {
        const response = await axios.post("/api/auth/login", this.formData); // Requête vers l'API backend
        const token = response.data; // Le token JWT est retourné
        localStorage.setItem("jwtToken", token); // Stocker le token dans localStorage
        this.$router.push("/"); // Rediriger l'utilisateur sur la page d'accueil après le succès
      } catch (error) {
        if (error.response && error.response.status === 401) {
          this.errorMessage = "Email ou mot de passe incorrect.";
        } else {
          this.errorMessage = "Une erreur interne est survenue. Réessayez plus tard.";
        }
      }
    },
  },
};
</script>

<style>
.login-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.form-label {
  font-size: 18px;
  font-weight: 600;
}

.input-container {
  position: relative;
}

.form-input {
  width: 100%;
  font-size: 18px;
  padding: 1rem;
  padding-left: 3rem;
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  background-color: white;
  transition: border-color 0.2s ease;
}

.form-input:focus {
  outline: none;
  border-color: #4318d1;
}

.input-icon {
  font-size: 1.5rem; /* Ajustez cette taille selon le besoin */
  position: absolute;
  left: 1rem;
  top: 50%;
  transform: translateY(-50%);
  color: #666666;
}

.password-toggle {
  position: absolute;
  right: 1rem;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  color: #666666;
  display: flex;
  align-items: center;
  justify-content: center;
}

/* Icône de l'œil ajustable */
.toggle-icon {
  font-size: 1.5rem; /* Ajustez cette taille selon le besoin */
  color: #333;
}


.forgot-password-container {
  display: flex;
  justify-content: flex-end;
}

.forgot-password-link {
  color: #4318d1;
  font-size: 16px;
  font-weight: 600;
  background: none;
  border: none;
  cursor: pointer;
  padding: 0;
}

.forgot-password-link:hover {
  text-decoration: underline;
}

.submit-button {
  background-color: #4318d1;
  color: white;
  border-radius: 8px;
  padding: 1rem 1.5rem;
  font-size: 18px;
  font-weight: 600;
  border: none;
  cursor: pointer;
  transition:
    transform 0.2s ease,
    background-color 0.2s ease;
}

.submit-button:hover:not(.disabled) {
  background-color: #3612b0;
}

.submit-button:focus {
  outline: 2px solid #4318d1;
  outline-offset: 2px;
}

.submit-button.disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
.error-message {
  color: #dc2626;
  font-size: 14px;
  margin-top: -1rem;
  margin-bottom: 1rem;
}
</style>
