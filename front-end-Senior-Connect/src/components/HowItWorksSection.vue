<template>
  <section
    id="how-it-works"
    class="how-it-works-section"
    aria-labelledby="how-it-works-title"
  >
    <div class="section-container">
      <h2 id="how-it-works-title" class="section-title">How It Works</h2>
      <div class="steps-container">
        <StepCard
          number="1"
          title="Create Your Profile"
          description="Share your experience, skills, and preferences for work or volunteering."
        />
        <StepCard
          number="2"
          title="Browse Opportunities"
          description="Explore part-time jobs and volunteer positions that match your interests."
        />
        <StepCard
          number="3"
          title="Connect & Apply"
          description="Apply directly through our platform and start your new journey."
        />
      </div>
    </div>
  </section>
</template>

<script>
import StepCard from "./StepCard.vue";

export default {
  name: "HowItWorksSection",
  components: {
    StepCard,
  },
};
</script>

<style scoped>
.how-it-works-section {
  background-color: white;
  padding: 4rem 0;
  width: 100%;
}

.section-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 1.5rem;
}

.section-title {
  font-size: 36px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 3rem;
}

.steps-container {
  display: flex;
  gap: 2rem;
  justify-content: space-between;
}

@media (max-width: 1024px) {
  .steps-container {
    flex-direction: column;
  }
}
</style>
