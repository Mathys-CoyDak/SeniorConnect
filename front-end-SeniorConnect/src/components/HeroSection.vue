<template>
  <section class="hero-section">
    <div class="hero-container">
      <div class="hero-content">
        <h1 class="hero-title">
          <span>Your Experience Matters.</span><br />
          <span>Find Your Perfect Match.</span>
        </h1>
        <p class="hero-description">
          Connect with organizations that value your lifetime of experience.
          Part-time jobs and volunteer opportunities tailored for active
          seniors.
        </p>
        <div class="hero-buttons">
          <button
            class="primary-button"
            @mouseenter="animateButton"
            @mouseleave="resetButton"
            aria-label="Find a job"
          >
            Find a Job
          </button>
          <button
            class="secondary-button"
            @mouseenter="animateButton"
            @mouseleave="resetButton"
            aria-label="Post a job offer"
          >
            Post a Job Offer
          </button>
        </div>
      </div>
      <div class="hero-image-container">
        <img
          src="https://placehold.co/600x400"
          alt="Senior professionals in various work settings"
          class="hero-image"
        />
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "HeroSection",
  methods: {
    animateButton(event) {
      event.target.style.transform = "translateY(-2px)";
    },
    resetButton(event) {
      event.target.style.transform = "translateY(0)";
    },
  },
};
</script>

<style scoped>
.hero-section {
  padding-top: 80px;
  width: 100%;
}

.hero-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 4rem 1.5rem;
  display: flex;
  align-items: center;
  gap: 3rem;
}

.hero-content {
  flex: 1;
}

.hero-title {
  font-size: 48px;
  font-weight: bold;
  line-height: 1.2;
  margin-bottom: 1.5rem;
}

.hero-description {
  font-size: 24px;
  color: #666666;
  margin-bottom: 2rem;
}

.hero-buttons {
  display: flex;
  gap: 1rem;
}

.primary-button {
  background-color: #4318d1;
  color: white;
  border: none;
  border-radius: 8px;
  padding: 1rem 2rem;
  font-size: 20px;
  font-weight: 600;
  cursor: pointer;
  transition: transform 0.2s ease;
}

.secondary-button {
  background-color: white;
  color: #4318d1;
  border: 2px solid #4318d1;
  border-radius: 8px;
  padding: 1rem 2rem;
  font-size: 20px;
  font-weight: 600;
  cursor: pointer;
  transition: transform 0.2s ease;
}

.hero-image-container {
  flex: 1;
}

.hero-image {
  width: 100%;
  border-radius: 16px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

@media (max-width: 1024px) {
  .hero-container {
    flex-direction: column;
  }

  .hero-title {
    font-size: 36px;
  }

  .hero-description {
    font-size: 20px;
  }
}

@media (max-width: 640px) {
  .hero-buttons {
    flex-direction: column;
  }
}
</style>
