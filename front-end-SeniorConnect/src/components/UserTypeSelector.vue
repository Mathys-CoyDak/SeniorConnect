<template>
  <div class="user-type-selector">
    <h2 class="selector-title">I am a:</h2>
    <div class="selector-options">
      <button
        type="button"
        @click="selectUserType('senior')"
        class="selector-option"
        :class="{ selected: modelValue === 'senior' }"
        aria-pressed="modelValue === 'senior'"
      >
        <i
          class="bi bi-person-circle option-icon"
          :class="{ 'selected-icon': modelValue === 'senior' }"
        ></i>
        <span
          class="option-text"
          :class="{ 'selected-text': modelValue === 'senior' }"
        >
          Senior
        </span>
      </button>
      <button
        type="button"
        @click="selectUserType('recruiter')"
        class="selector-option"
        :class="{ selected: modelValue === 'recruiter' }"
        aria-pressed="modelValue === 'recruiter'"
      >
        <i
          class="bi bi-briefcase option-icon"
          :class="{ 'selected-icon': modelValue === 'recruiter' }"
        ></i>
        <span
          class="option-text"
          :class="{ 'selected-text': modelValue === 'recruiter' }"
        >
          Recruiter
        </span>
      </button>
    </div>
    <p v-if="error" class="error-message" role="alert">
      Please select your user type
    </p>
  </div>
</template>

<script>
export default {
  name: "UserTypeSelector",
  props: {
    modelValue: {
      type: String,
      default: "",
    },
    error: {
      type: Boolean,
      default: false,
    },
  },
  emits: ["update:modelValue"],
  methods: {
    selectUserType(type) {
      this.$emit("update:modelValue", type);
    },
  },
};
</script>

<style scoped>
.user-type-selector {
  margin-bottom: 32px;
}

.selector-title {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 16px;
}

.selector-options {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
  width: 100%;
  box-sizing: border-box;
}

@media (max-width: 480px) {
  .selector-options {
    gap: 8px;
  }
}

.selector-option {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
  padding: 20px 16px;
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  background-color: transparent;
  cursor: pointer;
  transition: all 0.2s ease;
  width: 100%;
  box-sizing: border-box;
}

@media (max-width: 480px) {
  .selector-option {
    padding: 16px 8px;
    gap: 8px;
  }
}

.selector-option.selected {
  border-color: #4318d1;
  background-color: rgba(67, 24, 209, 0.1);
}

.option-icon {
  height: 32px;
  width: 32px;
  color: #666666;
}

.option-icon.selected-icon {
  color: #4318d1;
}

.option-text {
  font-size: 18px;
  font-weight: 600;
  color: #333333;
}

.option-text.selected-text {
  color: #4318d1;
}

.error-message {
  font-size: 14px;
  color: #dc2626;
  margin-top: 8px;
}
</style>
