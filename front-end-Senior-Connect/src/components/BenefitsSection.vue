<template>
  <section class="benefits-section">
    <div class="benefits-container">
      <div class="benefits-columns">
        <div
          id="for-seniors"
          class="benefits-column"
          aria-labelledby="seniors-title"
        >
          <h2 id="seniors-title" class="benefits-title">
            Benefits for Seniors
          </h2>
          <div class="benefits-list">
            <BenefitItem
              icon="check"
              title="Flexible Opportunities"
              description="Choose from part-time, seasonal, or volunteer positions that fit your schedule."
            />
            <BenefitItem
              icon="clock"
              title="Age-Friendly Employers"
              description="Connect with organizations that specifically value senior experience and wisdom."
            />
            <BenefitItem
              icon="chat"
              title="Community Support"
              description="Join a network of active seniors sharing experiences and advice."
            />
          </div>
        </div>

        <div
          id="for-recruiters"
          class="benefits-column"
          aria-labelledby="recruiters-title"
        >
          <h2 id="recruiters-title" class="benefits-title">
            Benefits for Recruiters
          </h2>
          <div class="benefits-list">
            <BenefitItem
              icon="briefcase"
              title="Experienced Talent Pool"
              description="Access a diverse pool of skilled professionals with proven track records."
            />
            <BenefitItem
              icon="check-circle"
              title="Reliable Workers"
              description="Find dependable team members with strong work ethics and professional values."
            />
            <BenefitItem
              icon="money"
              title="Cost-Effective Solutions"
              description="Flexible hiring options that fit your budget and business needs."
            />
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import BenefitItem from "./BenefitItem.vue";

export default {
  name: "BenefitsSection",
  components: {
    BenefitItem,
  },
};
</script>

<style scoped>
.benefits-section {
  padding: 4rem 0;
  width: 100%;
}

.benefits-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 1.5rem;
}

.benefits-columns {
  display: flex;
  gap: 3rem;
}

.benefits-column {
  flex: 1;
}

.benefits-title {
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 2rem;
}

.benefits-list {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

@media (max-width: 1024px) {
  .benefits-columns {
    flex-direction: column;
  }
}
</style>
