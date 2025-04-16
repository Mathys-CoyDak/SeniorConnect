<template>
  <form
    @submit.prevent="handleSubmit"
    class="forgot-password-form"
    aria-labelledby="reset-heading"
  >
    <div class="reset-header">
      <h2 id="reset-heading" class="reset-title">Reset Password</h2>
      <p class="reset-description">
        Enter your email address and we'll send you instructions to reset your
        password.
      </p>
    </div>

    <div class="form-group">
      <label for="reset-email" class="form-label">Email Address</label>
      <div class="input-container">
        <input
          id="reset-email"
          type="email"
          v-model="email"
          placeholder="Enter your email"
          class="form-input"
          required
          aria-required="true"
        />
        <!-- Remplacement de SVG par l'icône Bootstrap -->
        <i class="bi bi-envelope input-icon" aria-hidden="true"></i>
      </div>
    </div>

    <div class="button-group">
      <button type="button" @click="$emit('cancel')" class="cancel-button">
        Cancel
      </button>
      <button
        type="submit"
        class="submit-button"
        @mouseenter="handleMouseEnter"
        @mouseleave="handleMouseLeave"
        ref="submitButton"
      >
        Send Instructions
      </button>
    </div>
  </form>
</template>

<script>
export default {
  name: "ForgotPasswordForm",
  data() {
    return {
      email: "",
    };
  },
  methods: {
    handleSubmit() {
      console.log("Reset password for:", this.email);
      // Here you would typically call an API to send reset instructions
    },
    handleMouseEnter(event) {
      event.target.style.transform = "translateY(-2px)";
    },
    handleMouseLeave(event) {
      event.target.style.transform = "translateY(0)";
    },
  },
};
</script>

<style>
.forgot-password-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.reset-header {
  text-align: center;
  margin-bottom: 0.5rem;
}

.reset-title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.reset-description {
  font-size: 16px;
  color: #666666;
}

.form-group {
  position: relative;
}

.input-container {
  position: relative;
}

.form-input {
  width: 100%;
  font-size: 16px;
  padding: 16px;
  padding-left: 48px; /* Adjusted for the new icon */
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  background-color: white;
  box-sizing: border-box;
}

.form-input:focus {
  outline: none;
  border-color: #4318d1;
}

.input-icon {
  font-size: 1.5rem; /* Taille normalisée */
  position: absolute;
  left: 16px;
  top: 50%;
  transform: translateY(-50%);
  color: #666666; /* Couleur par défaut */
}

.button-group {
  display: flex;
  gap: 1rem;
}

.cancel-button {
  flex: 1;
  padding: 1rem 1.5rem;
  font-size: 18px;
  font-weight: 600;
  border: 2px solid #e2e8f0;
  background-color: white;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.cancel-button:hover {
  background-color: #f8f9fa;
}

.cancel-button:focus {
  outline: 2px solid #4318d1;
  outline-offset: 2px;
}

/* Note: .submit-button styles are inherited from LoginForm.vue */
</style>
