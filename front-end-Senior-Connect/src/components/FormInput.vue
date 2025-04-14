<template>
  <div class="form-field">
    <label :for="inputId" class="field-label">{{ label }}</label>
    <div class="input-container">
      <input
        :id="inputId"
        :type="type"
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
        :placeholder="placeholder"
        class="input-field"
        :aria-invalid="error"
        :aria-describedby="error ? errorId : undefined"
      />
      <svg
        xmlns="http://www.w3.org/2000/svg"
        class="input-icon"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
        aria-hidden="true"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          :d="getIconPath()"
        />
      </svg>
    </div>
    <p v-if="error" :id="errorId" class="error-message" role="alert">
      {{ errorMessage }}
    </p>
  </div>
</template>

<script>
export default {
  name: "FormInput",
  props: {
    label: {
      type: String,
      required: true,
    },
    modelValue: {
      type: String,
      default: "",
    },
    type: {
      type: String,
      default: "text",
    },
    placeholder: {
      type: String,
      default: "",
    },
    icon: {
      type: String,
      required: true,
    },
    error: {
      type: Boolean,
      default: false,
    },
    errorMessage: {
      type: String,
      default: "This field is required",
    },
  },
  emits: ["update:modelValue"],
  computed: {
    inputId() {
      return `input-${this.label.toLowerCase().replace(/\s+/g, "-")}`;
    },
    errorId() {
      return `error-${this.inputId}`;
    },
  },
  methods: {
    getIconPath() {
      switch (this.icon) {
        case "user":
          return "M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z";
        case "email":
          return "M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z";
        case "phone":
          return "M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z";
        default:
          return "";
      }
    },
  },
};
</script>

<style scoped>
.form-field {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.field-label {
  font-size: 18px;
  font-weight: 600;
}

.input-container {
  position: relative;
}

.input-field {
  width: 100%;
  font-size: 16px;
  padding: 16px;
  padding-left: 48px;
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  background-color: white;
  box-sizing: border-box;
}

@media (max-width: 480px) {
  .input-field {
    padding: 12px;
    padding-left: 40px;
    font-size: 14px;
  }
}

.input-field:focus {
  outline: none;
  border-color: #4318d1;
}

.input-icon {
  height: 24px;
  width: 24px;
  position: absolute;
  left: 16px;
  top: 50%;
  transform: translateY(-50%);
  color: #666666;
}

@media (max-width: 480px) {
  .input-icon {
    height: 20px;
    width: 20px;
    left: 12px;
  }
}

.error-message {
  font-size: 14px;
  color: #dc2626;
  margin-top: 4px;
}
</style>
