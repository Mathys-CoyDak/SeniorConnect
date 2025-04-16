<template>
  <div class="benefit-item">
    <div class="benefit-icon">
      <i
        v-if="icon === 'check'"
        class="bi bi-check-lg"></i>
      <i
        v-else-if="icon === 'clock'"
        class="bi bi-clock"></i>
      <i
        v-else-if="icon === 'chat'"
        class="bi bi-chat-dots"></i>
      <i
        v-else-if="icon === 'briefcase'"
        class="bi bi-briefcase"></i>
      <i
        v-else-if="icon === 'check-circle'"
        class="bi bi-check-circle"></i>
      <i
        v-else-if="icon === 'money'"
        class="bi bi-cash-coin"></i>
    </div>
    <div class="benefit-content">
      <h3 class="benefit-title">{{ title }}</h3>
      <p class="benefit-description">{{ description }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "BenefitItem",
  props: {
    icon: {
      type: String,
      required: true,
      validator: (value) => [
        "check",
        "clock",
        "chat",
        "briefcase",
        "check-circle",
        "money",
      ].includes(value),
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
.benefit-item {
  display: flex;
  align-items: flex-start;
  gap: 1rem;
}

.benefit-icon {
  width: 48px;
  height: 48px;
  background-color: #4318d1;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
}

.benefit-icon .bi {
  font-size: 24px;
  color: white;
}

.benefit-content {
  flex: 1;
}

.benefit-title {
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 0.5rem;
}

.benefit-description {
  font-size: 18px;
  color: #666666;
}
</style>
