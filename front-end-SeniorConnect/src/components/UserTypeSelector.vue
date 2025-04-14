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
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="option-icon"
          :class="{ 'selected-icon': modelValue === 'senior' }"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"
          />
        </svg>
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
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="option-icon"
          :class="{ 'selected-icon': modelValue === 'recruiter' }"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M21 13.255A23.931 23.931 0 0112 15c-3.183 0-6.22-.62-9-1.745M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v2m4 6h.01M5 20h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"
          />
        </svg>
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
