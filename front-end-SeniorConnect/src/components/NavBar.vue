<template>
  <nav class="navbar" aria-label="Main navigation">
    <div class="navbar-container">
      <img
        src="https://placehold.co/40x40"
        alt="SeniorConnect Logo"
        class="navbar-logo"
      />
      <span class="navbar-brand">SeniorConnect</span>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style>
.navbar {
  width: 100%;
  background-color: white;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.navbar-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1rem 1.5rem;
  display: flex;
  align-items: center;
  gap: 1rem;
}

.navbar-logo {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.navbar-brand {
  font-size: 24px;
  font-weight: bold;
  color: #2c3e50;
}
</style>
