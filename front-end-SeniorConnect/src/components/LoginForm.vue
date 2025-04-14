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
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="input-icon"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"
          />
        </svg>
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
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="input-icon"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
          />
        </svg>
        <button
          type="button"
          @click="togglePasswordVisibility"
          class="password-toggle"
          aria-label="Toggle password visibility"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            class="toggle-icon"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            aria-hidden="true"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              :d="
                showPassword
                  ? 'M13.875 18.825A10.05 10.05 0 0112 19c-4.478 0-8.268-2.943-9.543-7a9.97 9.97 0 011.563-3.029m5.858.908a3 3 0 114.243 4.243M9.878 9.878l4.242 4.242M9.88 9.88l-3.29-3.29m7.532 7.532l3.29 3.29M3 3l3.59 3.59m0 0A9.953 9.953 0 0112 5c4.478 0 8.268 2.943 9.543 7a10.025 10.025 0 01-4.132 5.411m0 0L21 21'
                  : 'M15 12a3 3 0 11-6 0 3 3 0 016 0z M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z'
              "
            />
          </svg>
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
      @mouseenter="handleMouseEnter"
      @mouseleave="handleMouseLeave"
      ref="submitButton"
    >
      Sign In
    </button>
  </form>
</template>

<script>
export default {
  name: "LoginForm",
  data() {
    return {
      showPassword: false,
      formData: {
        email: "",
        password: "",
      },
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
    handleSubmit() {
      if (this.isFormValid) {
        console.log("Form submitted", this.formData);
        // Here you would typically call an API to authenticate the user
      }
    },
    handleMouseEnter(event) {
      if (this.isFormValid) {
        event.target.style.transform = "translateY(-2px)";
      }
    },
    handleMouseLeave(event) {
      event.target.style.transform = "translateY(0)";
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
  height: 24px;
  width: 24px;
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

.toggle-icon {
  height: 24px;
  width: 24px;
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
</style>
