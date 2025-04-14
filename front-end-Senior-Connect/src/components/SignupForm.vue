<template>
  <div class="signup-container">
    <main class="main-content">
      <div class="form-container">
        <div class="form-card">
          <div class="form-header">
            <h1 class="form-title">Create Account</h1>
            <p class="form-subtitle">Join our community and start your journey</p>
          </div>
          <form @submit.prevent="handleSubmit" class="signup-form">
            <UserTypeSelector v-model="userType" :error="submitted && !userType" />

            <FormInput
              label="Full Name"
              v-model="formData.fullName"
              placeholder="Enter your full name"
              icon="user"
            />

            <FormInput
              label="Email Address"
              v-model="formData.email"
              type="email"
              placeholder="Enter your email"
              icon="email"
            />

            <FormInput
              label="Phone Number"
              v-model="formData.phone"
              type="tel"
              placeholder="Enter your phone number"
              icon="phone"
            />

            <PasswordInput
              label="Password"
              v-model="formData.password"
              placeholder="Create a password"
              :show-password="showPassword"
              @toggle-visibility="showPassword = !showPassword"
            />

            <PasswordInput
              label="Confirm Password"
              v-model="formData.confirmPassword"
              placeholder="Confirm your password"
              :show-password="showPassword"
              @toggle-visibility="showPassword = !showPassword"
              :error="formData.confirmPassword && formData.password !== formData.confirmPassword"
              error-message="Passwords do not match"
            />

            <div class="terms-checkbox">
              <input type="checkbox" id="terms" v-model="formData.agreeToTerms" class="checkbox" />
              <label for="terms" class="terms-label">
                <span>I agree to the </span>
                <a href="#" class="link">Terms of Service</a>
                <span> and </span>
                <a href="#" class="link">Privacy Policy</a>
              </label>
            </div>

            <button
              type="submit"
              class="submit-button"
              :class="{ disabled: !isFormValid }"
              :disabled="!isFormValid"
              @mouseenter="handleButtonHover"
              @mouseleave="handleButtonLeave"
              ref="submitButton"
            >
              Create Account
            </button>
          </form>
          <p class="login-link">
            <span>Already have an account? </span>
            <a href="#" class="link">Sign In</a>
          </p>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import UserTypeSelector from './UserTypeSelector.vue'
import FormInput from './FormInput.vue'
import PasswordInput from './PasswordInput.vue'

export default {
  name: 'SignupForm',
  components: {
    UserTypeSelector,
    FormInput,
    PasswordInput,
  },
  data() {
    return {
      userType: '',
      showPassword: false,
      submitted: false,
      formData: {
        fullName: '',
        email: '',
        phone: '',
        password: '',
        confirmPassword: '',
        agreeToTerms: false,
      },
    }
  },
  computed: {
    isFormValid() {
      return (
        this.userType &&
        this.formData.fullName &&
        this.formData.email &&
        this.formData.phone &&
        this.formData.password &&
        this.formData.confirmPassword &&
        this.formData.password === this.formData.confirmPassword &&
        this.formData.agreeToTerms
      )
    },
  },
  methods: {
    handleSubmit() {
      this.submitted = true
      if (this.isFormValid) {
        console.log('Form submitted', this.formData)
        // Here you would typically send the data to your API
      }
    },
    handleButtonHover(event) {
      if (this.isFormValid) {
        event.target.style.transform = 'translateY(-2px)'
      }
    },
    handleButtonLeave(event) {
      event.target.style.transform = 'translateY(0)'
    },
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');

.signup-container {
  min-height: 100vh;
  width: 100%;
  background-color: #fafafa;
  font-family: 'Inter', sans-serif;
  color: #333333;
  display: flex;
  flex-direction: column;
}

.navbar {
  width: 100%;
  background-color: white;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
}

.navbar-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 16px 24px;
  display: flex;
  align-items: center;
  gap: 16px;
}

.logo {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.brand-name {
  font-size: 24px;
  font-weight: 700;
  color: #2c3e50;
}

.main-content {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 48px 16px;
  box-sizing: border-box;
}

.form-container {
  max-width: 600px;
  width: 100%;
}

.form-card {
  background-color: white;
  border-radius: 16px;
  box-shadow:
    0 4px 6px rgba(0, 0, 0, 0.1),
    0 1px 3px rgba(0, 0, 0, 0.08);
  padding: 32px 24px;
  width: 100%;
  box-sizing: border-box;
}

@media (max-width: 480px) {
  .form-card {
    padding: 24px 16px;
  }
}
.form-header {
  text-align: center;
  margin-bottom: 32px;
}

.form-title {
  font-size: 36px;
  font-weight: 700;
  margin-bottom: 8px;
}

.form-subtitle {
  font-size: 18px;
  color: #666666;
}

.signup-form {
  display: flex;
  flex-direction: column;
  gap: 24px;
}

.terms-checkbox {
  display: flex;
  align-items: center;
  gap: 12px;
}

.checkbox {
  width: 20px;
  height: 20px;
  border-radius: 4px;
  border: 2px solid #e2e8f0;
}

.terms-label {
  font-size: 16px;
}

.link {
  color: #4318d1;
  text-decoration: none;
}

.link:hover {
  text-decoration: underline;
}

.submit-button {
  background-color: #4318d1;
  color: white;
  border: none;
  border-radius: 8px;
  padding: 16px 24px;
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  transition:
    transform 0.2s ease,
    background-color 0.2s ease;
}

.submit-button:hover:not(.disabled) {
  background-color: #3a14b8;
}

.submit-button.disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.login-link {
  text-align: center;
  margin-top: 24px;
  font-size: 16px;
}
</style>
