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
    </div>
  </nav>
  <div class="register-form">
    <main class="main-content" aria-label="Registration form">
      <div class="form-container">
        <div class="form-card">
          <div class="form-header">
            <h1 class="form-title">Create Account</h1>
            <p class="form-subtitle">
              Join our community and start your journey
            </p>
          </div>
          <form @submit.prevent="handleSubmit" class="registration-form">
            <div class="user-type-section">
              <h2 class="section-title">I am a:</h2>
              <div class="user-type-options">
                <button
                  type="button"
                  class="user-type-button"
                  :class="{ selected: userType === 'senior' }"
                  @click="setUserType('senior')"
                  aria-pressed="userType === 'senior'"
                >
                  <i class="bi bi-person user-type-icon"></i>
                  <span class="user-type-label">Senior</span>
                </button>
                <button
                  type="button"
                  class="user-type-button"
                  :class="{ selected: userType === 'recruiter' }"
                  @click="setUserType('recruiter')"
                  aria-pressed="userType === 'recruiter'"
                >
                  <i class="bi bi-briefcase user-type-icon"></i>
                  <span class="user-type-label">Recruiter</span>
                </button>
              </div>
              <p
                v-if="!userType && formSubmitted"
                class="error-message"
                aria-live="polite"
              >
                Please select a user type
              </p>
            </div>
            <div class="form-row">
              <div class="form-group">
                <label for="firstName" class="form-label">First Name</label>
                <div class="input-group">
                  <i class="bi bi-person input-icon"></i>
                  <input
                    type="text"
                    id="firstName"
                    v-model="formData.firstName"
                    placeholder="Enter first name"
                    class="form-input"
                    :class="{ error: formSubmitted && !formData.firstName }"
                    aria-required="true"
                  />
                </div>
                <p
                  v-if="formSubmitted && !formData.firstName"
                  class="error-message"
                  aria-live="polite"
                >
                  First name is required
                </p>
              </div>
              <div class="form-group">
                <label for="lastName" class="form-label">Last Name</label>
                <div class="input-group">
                  <i class="bi bi-person input-icon"></i>
                  <input
                    type="text"
                    id="lastName"
                    v-model="formData.lastName"
                    placeholder="Enter last name"
                    class="form-input"
                    :class="{ error: formSubmitted && !formData.lastName }"
                    aria-required="true"
                  />
                </div>
                <p
                  v-if="formSubmitted && !formData.lastName"
                  class="error-message"
                  aria-live="polite"
                >
                  Last name is required
                </p>
              </div>
            </div>
            <div class="form-group" v-if="userType === 'recruiter'">
              <label for="enterprise" class="form-label">Enterprise Name</label>
              <div class="input-group">
                <i class="bi bi-building input-icon"></i>
                <input
                  type="text"
                  id="enterprise"
                  v-model="formData.enterprise"
                  placeholder="Enter your enterprise name"
                  class="form-input"
                  :class="{
                    error:
                      formSubmitted &&
                      userType === 'recruiter' &&
                      !formData.enterprise,
                  }"
                  aria-required="userType === 'recruiter'"
                />
              </div>
              <p
                v-if="
                  formSubmitted &&
                  userType === 'recruiter' &&
                  !formData.enterprise
                "
                class="error-message"
                aria-live="polite"
              >
                Enterprise name is required
              </p>
            </div>
            <div class="form-group">
              <label for="email" class="form-label">Email Address</label>
              <div class="input-group">
                <i class="bi bi-envelope input-icon"></i>
                <input
                  type="email"
                  id="email"
                  v-model="formData.email"
                  placeholder="Enter your email"
                  class="form-input"
                  :class="{ error: formSubmitted && !formData.email }"
                  aria-required="true"
                />
              </div>
              <p
                v-if="formSubmitted && !formData.email"
                class="error-message"
                aria-live="polite"
              >
                Email is required
              </p>
            </div>
            <div class="form-group">
              <label for="phone" class="form-label">Phone Number</label>
              <div class="input-group">
                <i class="bi bi-telephone input-icon"></i>
                <input
                  type="tel"
                  id="phone"
                  v-model="formData.phone"
                  placeholder="Enter your phone number"
                  class="form-input"
                  :class="{ error: formSubmitted && !formData.phone }"
                  aria-required="true"
                />
              </div>
              <p
                v-if="formSubmitted && !formData.phone"
                class="error-message"
                aria-live="polite"
              >
                Phone number is required
              </p>
            </div>
            <div class="form-group">
              <label for="password" class="form-label">Password</label>
              <div class="input-group">
                <i class="bi bi-lock input-icon"></i>
                <input
                  :type="showPassword ? 'text' : 'password'"
                  id="password"
                  v-model="formData.password"
                  placeholder="Create a password"
                  class="form-input"
                  :class="{ error: formSubmitted && !formData.password }"
                  aria-required="true"
                />
                <button
                  type="button"
                  class="password-toggle"
                  @click="togglePasswordVisibility"
                  aria-label="Toggle password visibility"
                >
                  <i
                    :class="showPassword ? 'bi bi-eye-slash' : 'bi bi-eye'"
                  ></i>
                </button>
              </div>
              <p
                v-if="formSubmitted && !formData.password"
                class="error-message"
                aria-live="polite"
              >
                Password is required
              </p>
            </div>
            <div class="form-group">
              <label for="confirmPassword" class="form-label"
              >Confirm Password</label
              >
              <div class="input-group">
                <i class="bi bi-lock input-icon"></i>
                <input
                  :type="showPassword ? 'text' : 'password'"
                  id="confirmPassword"
                  v-model="formData.confirmPassword"
                  placeholder="Confirm your password"
                  class="form-input"
                  :class="{
                    error:
                      formSubmitted &&
                      (!formData.confirmPassword ||
                        formData.password !== formData.confirmPassword),
                  }"
                  aria-required="true"
                />
              </div>
              <p
                v-if="formSubmitted && !formData.confirmPassword"
                class="error-message"
                aria-live="polite"
              >
                Please confirm your password
              </p>
              <p
                v-else-if="
                  formData.confirmPassword &&
                  formData.password !== formData.confirmPassword
                "
                class="error-message"
                aria-live="polite"
              >
                Passwords do not match
              </p>
            </div>
            <div class="terms-agreement">
              <input
                type="checkbox"
                id="agreeToTerms"
                v-model="formData.agreeToTerms"
                class="terms-checkbox"
                :class="{ error: formSubmitted && !formData.agreeToTerms }"
                aria-required="true"
              />
              <label for="agreeToTerms" class="terms-label">
                I agree to the
                <a href="#" class="terms-link">Terms of Service</a> and
                <a href="#" class="terms-link">Privacy Policy</a>
              </label>
            </div>
            <p
              v-if="formSubmitted && !formData.agreeToTerms"
              class="error-message"
              aria-live="polite"
            >
              You must agree to the terms
            </p>
            <button
              type="submit"
              class="submit-button"
              aria-label="Create Account"
            >
              Create Account
            </button>
          </form>
          <p class="sign-in-prompt">
            Already have an account?
            <a href="#" class="sign-in-link">Sign In</a>
          </p>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
import { ref } from "vue";

const userType = ref("");
const showPassword = ref(false);
const formSubmitted = ref(false);
const formData = ref({
  firstName: "",
  lastName: "",
  email: "",
  phone: "",
  password: "",
  confirmPassword: "",
  agreeToTerms: false,
  enterprise: "",
});

function validateForm() {
  formSubmitted.value = true;

  return (
    userType.value &&
    formData.value.firstName &&
    formData.value.lastName &&
    formData.value.email &&
    formData.value.phone &&
    formData.value.password &&
    formData.value.confirmPassword &&
    formData.value.password === formData.value.confirmPassword &&
    formData.value.agreeToTerms &&
    (userType.value === "recruiter" ? formData.value.enterprise : true)
  );
}

function handleSubmit() {
  if (validateForm()) {
    console.log("Form submitted", {
      userType: userType.value,
      ...formData.value,
    });
    // Here you would typically send the data to your API
  }
}

function setUserType(type) {
  userType.value = type;
}

function togglePasswordVisibility() {
  showPassword.value = !showPassword.value;
}
</script>

<style scoped>
/* Import Bootstrap Icons */
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css");

/* Import Inter font */
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap");

/* Base styles */
.register-form {
  min-height: 100vh;
  width: 100%;
  background-color: #fafafa;
  font-family: "Inter", sans-serif;
  color: #333333;
  display: flex;
  flex-direction: column;
  padding-top: 100px;
}


/* Main content styles */
.main-content {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 3rem 1.5rem;
  margin-top: -3px;
}

.form-container {
  max-width: 600px;
  width: 100%;
}

.form-card {
  background-color: white;
  border-radius: 1rem;
  box-shadow:
    0 4px 6px rgba(0, 0, 0, 0.1),
    0 1px 3px rgba(0, 0, 0, 0.08);
  padding: 2rem;
}

.form-header {
  text-align: center;
  margin-bottom: 2rem;
}

.form-title {
  font-size: 2.25rem;
  font-weight: 700;
  margin-bottom: 0.5rem;
}

.form-subtitle {
  font-size: 1.125rem;
  color: #666666;
}

.registration-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

/* User type section */
.user-type-section {
  margin-bottom: 2rem;
}

.section-title {
  font-size: 1.125rem;
  font-weight: 600;
  margin-bottom: 1rem;
}

.user-type-options {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1rem;
}

.user-type-button {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.75rem;
  padding: 1.5rem;
  border-radius: 0.5rem;
  border: 2px solid #e2e8f0;
  background-color: white;
  transition: all 0.2s ease;
  cursor: pointer;
}

.user-type-button:hover {
  border-color: #4318d1;
  background-color: #f3f0ff;
}

.user-type-button.selected {
  border-color: #4318d1;
  background-color: #f3f0ff;
}

.user-type-icon {
  font-size: 2rem;
}

.user-type-label {
  font-size: 1.125rem;
  font-weight: 600;
}

/* Form row for grid layout */
.form-row {
  display: grid;
  grid-template-columns: 1fr;
  gap: 1rem;
}

@media (min-width: 768px) {
  .form-row {
    grid-template-columns: 1fr 1fr;
  }
}

/* Form group styles */
.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.form-label {
  font-size: 1.125rem;
  font-weight: 600;
}

.input-group {
  position: relative;
}

.input-icon {
  position: absolute;
  left: 1rem;
  top: 50%;
  transform: translateY(-50%);
  color: #666666;
  font-size: 1.25rem;
}

.form-input {
  width: 100%;
  font-size: 1.125rem;
  padding: 1rem;
  padding-left: 3rem;
  border-radius: 0.5rem;
  border: 2px solid #e2e8f0;
  background-color: white;
  transition: border-color 0.2s ease;
}

.form-input:focus {
  border-color: #4318d1;
  outline: none;
}

.form-input.error {
  border-color: #dc2626;
}

.password-toggle {
  position: absolute;
  right: 1rem;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  color: #666666;
  cursor: pointer;
  font-size: 1.25rem;
}

/* Terms agreement styles */
.terms-agreement {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.terms-checkbox {
  width: 1.25rem;
  height: 1.25rem;
  border-radius: 0.25rem;
  border: 2px solid #e2e8f0;
}

.terms-label {
  font-size: 1rem;
}

.terms-link {
  color: #4318d1;
  text-decoration: none;
}

.terms-link:hover {
  text-decoration: underline;
}

/* Submit button styles */
.submit-button {
  background-color: #4318d1;
  color: white;
  border: none;
  border-radius: 0.5rem;
  padding: 1rem 1.5rem;
  font-size: 1.125rem;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.submit-button:hover {
  background-color: #3612a9;
}

/* Sign in prompt styles */
.sign-in-prompt {
  text-align: center;
  margin-top: 1.5rem;
  font-size: 1rem;
}

.sign-in-link {
  color: #4318d1;
  font-weight: 600;
  text-decoration: none;
}

.sign-in-link:hover {
  text-decoration: underline;
}

/* Error message styles */
.error-message {
  font-size: 0.875rem;
  color: #dc2626;
  margin-top: 0.25rem;
}
</style>
