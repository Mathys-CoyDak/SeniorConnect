import { mount } from "@vue/test-utils";
import { describe, it, expect, vi } from "vitest";
import LoginForm from "./LoginForm.vue";

describe("LoginForm", () => {
  it("renders correctly", () => {
    const wrapper = mount(LoginForm);

    // Check if form elements are rendered
    expect(wrapper.find("form").exists()).toBe(true);
    expect(wrapper.find('input[type="email"]').exists()).toBe(true);
    expect(wrapper.find('input[id="password"]').exists()).toBe(true);
    expect(wrapper.find(".forgot-password-link").exists()).toBe(true);
    expect(wrapper.find(".submit-button").exists()).toBe(true);
  });

  it("validates form correctly", async () => {
    const wrapper = mount(LoginForm);
    const submitButton = wrapper.find(".submit-button");

    // Initially, the form should be invalid
    expect(submitButton.classes()).toContain("disabled");
    expect(submitButton.attributes("disabled")).toBeDefined();

    // Fill in the email field
    await wrapper.find('input[type="email"]').setValue("test@example.com");
    expect(submitButton.classes()).toContain("disabled");

    // Fill in the password field
    await wrapper.find('input[id="password"]').setValue("password123");

    // Now the form should be valid
    expect(submitButton.classes()).not.toContain("disabled");
    expect(submitButton.attributes("disabled")).toBeUndefined();
  });

  it("toggles password visibility", async () => {
    const wrapper = mount(LoginForm);
    const passwordInput = wrapper.find('input[id="password"]');
    const toggleButton = wrapper.find(".password-toggle");

    // Initially, the password should be hidden
    expect(passwordInput.attributes("type")).toBe("password");

    // Click the toggle button
    await toggleButton.trigger("click");

    // Now the password should be visible
    expect(passwordInput.attributes("type")).toBe("text");

    // Click the toggle button again
    await toggleButton.trigger("click");

    // The password should be hidden again
    expect(passwordInput.attributes("type")).toBe("password");
  });

  it("emits forgot-password event", async () => {
    const wrapper = mount(LoginForm);
    const forgotPasswordLink = wrapper.find(".forgot-password-link");

    // Click the forgot password link
    await forgotPasswordLink.trigger("click");

    // Check if the event was emitted
    expect(wrapper.emitted("forgot-password")).toBeTruthy();
  });

  it("submits the form with valid data", async () => {
    const wrapper = mount(LoginForm);

    // Mock console.log
    console.log = vi.fn();

    // Fill in the form
    await wrapper.find('input[type="email"]').setValue("test@example.com");
    await wrapper.find('input[id="password"]').setValue("password123");

    // Submit the form
    await wrapper.find("form").trigger("submit");

    // Check if console.log was called with the form data
    expect(console.log).toHaveBeenCalledWith("Form submitted", {
      email: "test@example.com",
      password: "password123",
    });
  });
});
