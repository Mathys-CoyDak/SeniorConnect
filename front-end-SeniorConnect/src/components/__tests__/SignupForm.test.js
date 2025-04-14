import { mount } from "@vue/test-utils";
import { describe, it, expect, vi } from "vitest";
import SignupForm from "../SignupForm.vue";
import UserTypeSelector from "../UserTypeSelector.vue";
import FormInput from "../FormInput.vue";
import PasswordInput from "../PasswordInput.vue";

// Mock console.log to verify form submission
console.log = vi.fn();

describe("SignupForm", () => {
  it("renders correctly", () => {
    const wrapper = mount(SignupForm);
    expect(wrapper.find(".signup-container").exists()).toBe(true);
    expect(wrapper.find(".form-title").text()).toBe("Create Account");
    expect(wrapper.findComponent(UserTypeSelector).exists()).toBe(true);
    expect(wrapper.findAllComponents(FormInput).length).toBe(3);
    expect(wrapper.findAllComponents(PasswordInput).length).toBe(2);
  });

  it("disables submit button when form is invalid", async () => {
    const wrapper = mount(SignupForm);
    const submitButton = wrapper.find(".submit-button");
    expect(submitButton.attributes("disabled")).toBeDefined();
    expect(submitButton.classes()).toContain("disabled");
  });

  it("enables submit button when form is valid", async () => {
    const wrapper = mount(SignupForm);

    // Fill out the form
    await wrapper.setData({
      userType: "senior",
      formData: {
        fullName: "John Doe",
        email: "john@example.com",
        phone: "123-456-7890",
        password: "password123",
        confirmPassword: "password123",
        agreeToTerms: true,
      },
    });

    const submitButton = wrapper.find(".submit-button");
    expect(submitButton.attributes("disabled")).toBeUndefined();
    expect(submitButton.classes()).not.toContain("disabled");
  });

  it("shows error when passwords do not match", async () => {
    const wrapper = mount(SignupForm);

    // Set mismatched passwords
    await wrapper.setData({
      formData: {
        password: "password123",
        confirmPassword: "password456",
      },
    });

    // Find the password input components
    const passwordInputs = wrapper.findAllComponents(PasswordInput);
    const confirmPasswordInput = passwordInputs[1];

    // Check if error message is displayed
    expect(confirmPasswordInput.props("error")).toBe(true);
    expect(confirmPasswordInput.props("errorMessage")).toBe(
      "Passwords do not match",
    );
  });

  it("submits the form when valid", async () => {
    const wrapper = mount(SignupForm);

    // Fill out the form
    await wrapper.setData({
      userType: "senior",
      formData: {
        fullName: "John Doe",
        email: "john@example.com",
        phone: "123-456-7890",
        password: "password123",
        confirmPassword: "password123",
        agreeToTerms: true,
      },
    });

    // Submit the form
    await wrapper.find("form").trigger("submit");

    // Check if console.log was called with form data
    expect(console.log).toHaveBeenCalledWith(
      "Form submitted",
      expect.objectContaining({
        fullName: "John Doe",
        email: "john@example.com",
      }),
    );
  });

  it("toggles password visibility", async () => {
    const wrapper = mount(SignupForm);

    // Initially password should be hidden
    expect(wrapper.vm.showPassword).toBe(false);

    // Find password input components
    const passwordInputs = wrapper.findAllComponents(PasswordInput);

    // Trigger toggle visibility event
    await passwordInputs[0].vm.$emit("toggle-visibility");

    // Password should now be visible
    expect(wrapper.vm.showPassword).toBe(true);
  });
});
