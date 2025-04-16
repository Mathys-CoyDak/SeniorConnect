<template>
  <div class="password-input">
    <label :for="id" class="input-label">{{ label }}</label>
    <div class="input-wrapper">
      <input
        :id="id"
        :type="showPassword ? 'text' : 'password'"
        :value="modelValue"
        class="password-input-field"
        @input="$emit('update:modelValue', $event.target.value)"
        aria-labelledby="password-visibility-toggle"
      />
      <i
        :class="showPassword ? 'bi bi-eye-slash password-toggle-icon' : 'bi bi-eye password-toggle-icon'"
        @click="toggleVisibility"
        role="button"
        aria-label="Toggle password visibility"
      ></i>
    </div>
    <p v-if="error" class="error-message">{{ error }}</p>
  </div>
</template>

<script>
export default {
  name: "PasswordInput",
  props: {
    id: {
      type: String,
      required: true,
    },
    label: {
      type: String,
      required: true,
    },
    modelValue: {
      type: String,
      required: true,
    },
    error: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      showPassword: false,
    };
  },
  methods: {
    toggleVisibility() {
      this.showPassword = !this.showPassword;
    },
  },
};
</script>

<style scoped>
.password-input {
  display: flex;
  flex-direction: column;
  margin: 16px 0;
}

.input-label {
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 8px;
}

.input-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.password-input-field {
  flex: 1;
  padding: 10px 16px;
  border: 1px solid #e2e8f0;
  border-radius: 4px;
  font-size: 16px;
}

.password-toggle-icon {
  position: absolute;
  right: 12px;
  cursor: pointer;
  font-size: 18px;
  color: #666666;
}
.password-toggle-icon:hover {
  color: #333333;
}

.error-message {
  color: #dc2626;
  font-size: 14px;
  margin-top: 8px;
}
</style>
