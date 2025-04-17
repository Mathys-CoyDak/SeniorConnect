<template>
  <main class="account-creation" :class="{ 'has-errors': hasErrors }">
    <div class="account-creation__container">
      <header class="account-creation__header">
        <h1 class="account-creation__title">Create Your Account</h1>
        <p class="account-creation__subtitle">
          Join our community and discover opportunities that match your
          experience
        </p>
      </header>

      <form class="account-form" @submit.prevent="submitForm" novalidate>
        <div class="account-type-selector">
          <button
            type="button"
            class="account-type-button"
            :class="{ 'account-type-button--active': accountType === 'senior' }"
            @click="accountType = 'senior'"
            aria-pressed="accountType === 'senior'"
          >
            Senior
          </button>
          <button
            type="button"
            class="account-type-button"
            :class="{
              'account-type-button--active': accountType === 'recruiter',
            }"
            @click="accountType = 'recruiter'"
            aria-pressed="accountType === 'recruiter'"
          >
            Recruiter
          </button>
        </div>

        <div class="form-row">
          <div class="form-group">
            <label for="firstName" class="form-label">First Name</label>
            <input
              type="text"
              id="firstName"
              v-model="firstName"
              class="form-input"
              :class="{ 'form-input--error': errors.firstName }"
              placeholder="Enter your first name"
              aria-required="true"
              aria-invalid="errors.firstName ? true : false"
              aria-describedby="firstName-error"
            />
            <span
              v-if="errors.firstName"
              id="firstName-error"
              class="form-error"
              role="alert"
            >
              {{ errors.firstName }}
            </span>
          </div>

          <div class="form-group">
            <label for="lastName" class="form-label">Last Name</label>
            <input
              type="text"
              id="lastName"
              v-model="lastName"
              class="form-input"
              :class="{ 'form-input--error': errors.lastName }"
              placeholder="Enter your last name"
              aria-required="true"
              aria-invalid="errors.lastName ? true : false"
              aria-describedby="lastName-error"
            />
            <span
              v-if="errors.lastName"
              id="lastName-error"
              class="form-error"
              role="alert"
            >
              {{ errors.lastName }}
            </span>
          </div>
        </div>

        <div class="form-group">
          <label for="email" class="form-label">Email Address</label>
          <input
            type="email"
            id="email"
            v-model="email"
            class="form-input"
            :class="{ 'form-input--error': errors.email }"
            placeholder="Enter your email address"
            aria-required="true"
            aria-invalid="errors.email ? true : false"
            aria-describedby="email-error"
          />
          <span
            v-if="errors.email"
            id="email-error"
            class="form-error"
            role="alert"
          >
            {{ errors.email }}
          </span>
        </div>

        <div class="form-group">
          <label for="phone" class="form-label">Phone Number</label>
          <input
            type="tel"
            id="phone"
            v-model="phone"
            class="form-input"
            :class="{ 'form-input--error': errors.phone }"
            placeholder="Enter your phone number"
            aria-required="true"
            aria-invalid="errors.phone ? true : false"
            aria-describedby="phone-error"
          />
          <span
            v-if="errors.phone"
            id="phone-error"
            class="form-error"
            role="alert"
          >
            {{ errors.phone }}
          </span>
        </div>

        <div class="form-group">
          <label for="password" class="form-label">Password</label>
          <div class="password-input-wrapper">
            <input
              :type="showPassword ? 'text' : 'password'"
              id="password"
              v-model="password"
              class="form-input"
              :class="{ 'form-input--error': errors.password }"
              placeholder="Create a password"
              aria-required="true"
              aria-invalid="errors.password ? true : false"
              aria-describedby="password-error"
            />
            <button
              type="button"
              class="password-toggle"
              @click="showPassword = !showPassword"
              aria-label="Toggle password visibility"
            >
              {{ showPassword ? "Hide" : "Show" }}
            </button>
          </div>
          <span
            v-if="errors.password"
            id="password-error"
            class="form-error"
            role="alert"
          >
            {{ errors.password }}
          </span>
        </div>

        <div class="form-group">
          <label for="confirmPassword" class="form-label"
          >Confirm Password</label
          >
          <div class="password-input-wrapper">
            <input
              :type="showConfirmPassword ? 'text' : 'password'"
              id="confirmPassword"
              v-model="confirmPassword"
              class="form-input"
              :class="{ 'form-input--error': errors.confirmPassword }"
              placeholder="Confirm your password"
              aria-required="true"
              aria-invalid="errors.confirmPassword ? true : false"
              aria-describedby="confirmPassword-error"
            />
            <button
              type="button"
              class="password-toggle"
              @click="showConfirmPassword = !showConfirmPassword"
              aria-label="Toggle confirm password visibility"
            >
              {{ showConfirmPassword ? "Hide" : "Show" }}
            </button>
          </div>
          <span
            v-if="errors.confirmPassword"
            id="confirmPassword-error"
            class="form-error"
            role="alert"
          >
            {{ errors.confirmPassword }}
          </span>
        </div>

        <button type="submit" class="submit-button" aria-label="Create account">
          Create Account
        </button>

        <p class="login-link">
          Already have an account?
          <router-link to="login" class="login-link__anchor">Sign In</router-link>
        </p>
      </form>
    </div>
  </main>
</template>

<script>
import axios from "@/services/axios";

export default {
  name: "AccountCreationForm",
  data() {
    return {
      accountType: "senior",
      firstName: "",
      lastName: "",
      email: "",
      phone: "",
      password: "",
      confirmPassword: "",
      showPassword: false,
      showConfirmPassword: false,
      errors: {},
    };
  },
  computed: {
    hasErrors() {
      return Object.keys(this.errors).length > 0;
    },
  },
  methods: {
    validateForm() {
      this.errors = {};

      if (!this.firstName.trim()) {
        this.errors.firstName = "First name is required";
      }

      if (!this.lastName.trim()) {
        this.errors.lastName = "Last name is required";
      }

      if (!this.email.trim()) {
        this.errors.email = "Email is required";
      } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.email)) {
        this.errors.email = "Please enter a valid email";
      }

      if (!this.phone.trim()) {
        this.errors.phone = "Phone number is required";
      }

      if (!this.password) {
        this.errors.password = "Password is required";
      } else if (this.password.length < 8) {
        this.errors.password = "Password must be at least 8 characters";
      }

      if (!this.confirmPassword) {
        this.errors.confirmPassword = "Please confirm your password";
      } else if (this.password !== this.confirmPassword) {
        this.errors.confirmPassword = "Passwords do not match";
      }

      return Object.keys(this.errors).length === 0;
    },
    async submitForm() {
      if (this.validateForm()) {
        this.clearErrors();

        // Construire les données utilisateur
        const userData = {
          firstName: this.firstName,
          lastName: this.lastName,
          email: this.email,
          password: this.password,
          phone: this.phone,
          userType: this.accountType.toUpperCase(),

        };

        try {
          // Envoyer les données vers l'API backend
          const response = await axios.post("/api/auth/register", userData);

          // Gérer la réussite
          alert(response.data); // Affiche "Utilisateur enregistré avec succès !"
          this.resetForm();
          this.$router.push("/login");
        } catch (error) {
          // Gestion des erreurs de validation
          if (error.response && error.response.data) {
            this.errors = error.response.data; // Par exemple, { email: "Email déjà utilisé" }
          } else {
            alert("Une erreur s'est produite lors de l'inscription.");
          }
        }
      }
    },
    resetForm() {
      this.firstName = "";
      this.lastName = "";
      this.email = "";
      this.phone = "";
      this.password = "";
      this.confirmPassword = "";
      this.errors = {};
    },
    clearErrors() {
      this.errors = {};
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap");

.account-creation {
  min-height: 100vh;
  width: 100%;
  background-color: #fafafa;
  font-family: "Inter", sans-serif;
  color: #333;
  display: flex;
  justify-content: center;
  padding: 40px 20px 60px;
}

.account-creation__container {
  width: 100%;
  max-width: 600px;
}

.account-creation__header {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 40px;
}

.account-creation__title {
  font-size: 36px;
  font-weight: 700;
  margin-bottom: 16px;
  text-align: center;
}

.account-creation__subtitle {
  font-size: 20px;
  color: #666;
  text-align: center;
}

.account-form {
  background-color: white;
  border-radius: 16px;
  padding: 32px;
  box-shadow:
    0px 4px 6px rgba(0, 0, 0, 0.1),
    0px 10px 15px rgba(0, 0, 0, 0.1);
}

.account-type-selector {
  display: flex;
  gap: 16px;
  margin-bottom: 32px;
}

.account-type-button {
  flex: 1;
  padding: 16px;
  font-size: 20px;
  font-weight: 600;
  border-radius: 8px;
  border: 2px solid #4318d1;
  background-color: #fff;
  color: #4318d1;
  cursor: pointer;
  transition: all 0.2s ease;
}

.account-type-button--active {
  background-color: #4318d1;
  color: #fff;
}

.form-row {
  display: flex;
  gap: 16px;
  margin-bottom: 24px;
}

.form-group {
  flex: 1;
  margin-bottom: 24px;
}

.form-label {
  display: block;
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 8px;
}

.form-input {
  width: 100%;
  height: 56px;
  padding: 0 16px;
  font-size: 18px;
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  outline: none;
  transition: border-color 0.2s ease;
}

.form-input:focus {
  border-color: #4318d1;
}

.form-input--error {
  border-color: #dc2626;
}

.form-error {
  display: block;
  color: #dc2626;
  font-size: 16px;
  margin-top: 4px;
}

.password-input-wrapper {
  position: relative;
}

.password-toggle {
  position: absolute;
  right: 16px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  color: #666;
  cursor: pointer;
  font-size: 16px;
  padding: 0;
}

.submit-button {
  width: 100%;
  background-color: #4318d1;
  color: white;
  font-size: 20px;
  font-weight: 600;
  padding: 16px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.submit-button:hover {
  background-color: #3614a7;
}

.login-link {
  text-align: center;
  font-size: 16px;
  color: #666;
  margin-top: 24px;
}

.login-link__anchor {
  color: #4318d1;
  font-weight: 600;
  text-decoration: none;
}

/* Responsive adjustments */
@media (max-width: 640px) {
  .form-row {
    flex-direction: column;
    gap: 24px;
  }

  .account-creation__title {
    font-size: 28px;
  }

  .account-creation__subtitle {
    font-size: 18px;
  }

  .account-form {
    padding: 24px;
  }
}

/* Focus styles for accessibility */
.form-input:focus,
.account-type-button:focus,
.password-toggle:focus,
.submit-button:focus,
.login-link__anchor:focus {
  outline: 2px solid #4318d1;
  outline-offset: 2px;
}
</style>
