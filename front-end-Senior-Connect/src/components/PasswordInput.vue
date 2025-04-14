<template>
  <div class="form-field">
    <label :for="inputId" class="field-label">{{ label }}</label>
    <div class="input-container">
      <input
        :id="inputId"
        :type="showPassword ? 'text' : 'password'"
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
          d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
        />
      </svg>
      <button
        type="button"
        @click="$emit('toggle-visibility')"
        class="toggle-visibility"
        :aria-label="showPassword ? 'Hide password' : 'Show password'"
        aria-pressed="showPassword"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="toggle-icon"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            :d="
              showPassword
                ? 'M13.875 18.825A10.05 10.05 0 0112 19c-4.478 0-8.268-2.943-9.543-7a9.97 9.97 0 011.563-3.029m5.858.908a3 3 0 114.243 4.243M9.878 9.878l4.242 4.242M9.88 9.88l-3.29-3.29m7.532 7.532l3.29 3.29M3 3l3.59 3.59m0 0A9.953 9.953 0 0112 5c4.478 0 8.268 2.943 9.543 7a10.025 10.025 0 01-4.132 5.411m0 0L21 21'
                : 'M15 12a3 3 0 11-6 0 3 3 0 016 0z M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z'
            "
          />
        </svg>
      </button>
    </div>
    <p v-if="error" :id="errorId" class="error-message" role="alert">
      {{ errorMessage }}
    </p>
  </div>
</template>

<script>
export default {
  name: "PasswordInput",
  props: {
    label: {
      type: String,
      required: true,
    },
    modelValue: {
      type: String,
      default: "",
    },
    placeholder: {
      type: String,
      default: "",
    },
    showPassword: {
      type: Boolean,
      default: false,
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
  emits: ["update:modelValue", "toggle-visibility"],
  computed: {
    inputId() {
      return `input-${this.label.toLowerCase().replace(/\s+/g, "-")}`;
    },
    errorId() {
      return `error-${this.inputId}`;
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
  padding-right: 48px;
  border-radius: 8px;
  border: 2px solid #e2e8f0;
  background-color: white;
  box-sizing: border-box;
}

@media (max-width: 480px) {
  .input-field {
    padding: 12px;
    padding-left: 40px;
    padding-right: 40px;
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

.toggle-visibility {
  position: absolute;
  right: 16px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  color: #666666;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
}

.toggle-icon {
  height: 24px;
  width: 24px;
}

@media (max-width: 480px) {
  .toggle-icon {
    height: 20px;
    width: 20px;
  }
}

.error-message {
  font-size: 14px;
  color: #dc2626;
  margin-top: 4px;
}
</style>
