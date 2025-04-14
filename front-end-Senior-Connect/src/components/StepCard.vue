<template>
  <div class="step-card">
    <div class="step-number">
      {{ number }}
    </div>
    <h3 class="step-title">{{ title }}</h3>
    <p class="step-description">{{ description }}</p>
  </div>
</template>

<script>
export default {
  name: "StepCard",
  props: {
    number: {
      type: String,
      required: true,
    },
    title: {
      type: String,
      required: true,
    },
    description: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.step-card {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding: 1.5rem;
  border-radius: 16px;
  background-color: #f8f9fa;
}

.step-number {
  width: 64px;
  height: 64px;
  background-color: #4318d1;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 1rem;
}

.step-title {
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 1rem;
}

.step-description {
  font-size: 18px;
  color: #666666;
}
</style>
