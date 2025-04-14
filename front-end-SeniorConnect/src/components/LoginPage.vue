<template>
  <div class="login-page">
    <nav-bar />
    <main class="main-content">
      <div class="form-container">
        <div class="form-card">
          <div class="form-header">
            <h1 class="form-title">Welcome Back</h1>
            <p class="form-subtitle">Sign in to continue</p>
          </div>

          <login-form
            v-if="!showForgotPassword"
            @forgot-password="showForgotPassword = true"
          />

          <forgot-password-form v-else @cancel="showForgotPassword = false" />

          <p class="signup-prompt">
            <span>Don't have an account? </span>
            <a href="#" class="signup-link">Create Account</a>
          </p>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";
import LoginForm from "./LoginForm.vue";
import ForgotPasswordForm from "./ForgotPasswordForm.vue";

export default {
  name: "LoginPage",
  components: {
    NavBar,
    LoginForm,
    ForgotPasswordForm,
  },
  data() {
    return {
      showForgotPassword: false,
    };
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap");

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: "Inter", sans-serif;
  color: #333333;
}

.login-page {
  min-height: 100vh;
  width: 100%;
  background-color: #fafafa;
  display: flex;
  flex-direction: column;
}

.main-content {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 3rem 1.5rem;
}

.form-container {
  max-width: 450px;
  width: 100%;
}

.form-card {
  background-color: white;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  padding: 2rem;
}

.form-header {
  text-align: center;
  margin-bottom: 2rem;
}

.form-title {
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 0.5rem;
  color: #333333;
}

.form-subtitle {
  font-size: 18px;
  color: #666666;
}

.signup-prompt {
  text-align: center;
  margin-top: 1.5rem;
  font-size: 16px;
}

.signup-link {
  color: #4318d1;
  font-weight: 600;
  text-decoration: none;
}

.signup-link:hover {
  text-decoration: underline;
}

@media (max-width: 480px) {
  .form-card {
    padding: 1.5rem;
  }

  .form-title {
    font-size: 28px;
  }

  .form-subtitle {
    font-size: 16px;
  }
}
</style>
