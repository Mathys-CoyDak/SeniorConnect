import { mount } from "@vue/test-utils";
import { describe, it, expect, vi } from "vitest";
import ForgotPasswordForm from "./ForgotPasswordForm.vue";

describe("ForgotPasswordForm", () => {
  it("renders correctly", () => {
    const wrapper = mount(ForgotPasswordForm);

    // Check if form elements are rendered
    expect(wrapper.find("form").exists()).toBe(true);
    expect(wrapper.find('input[type="email"]').exists()).toBe(true);
    expect(wrapper.find(".cancel-button").exists()).toBe(true);
    expect(wrapper.find(".submit-button").exists()).toBe(true);

    // Check if the title and description are rendered
    expect(wrapper.find(".reset-title").text()).toBe("Reset Password");
    expect(wrapper.find(".reset-description").text()).toContain(
      "Enter your email address",
    );
  });

  it("emits cancel event", async () => {
    const wrapper = mount(ForgotPasswordForm);
    const cancelButton = wrapper.find(".cancel-button");

    // Click the cancel button
    await cancelButton.trigger("click");

    // Check if the event was emitted
    expect(wrapper.emitted("cancel")).toBeTruthy();
  });

  it("submits the form with email", async () => {
    const wrapper = mount(ForgotPasswordForm);

    // Mock console.log
    console.log = vi.fn();

    // Fill in the email field
    await wrapper.find('input[type="email"]').setValue("test@example.com");

    // Submit the form
    await wrapper.find("form").trigger("submit");

    // Check if console.log was called with the email
    expect(console.log).toHaveBeenCalledWith(
      "Reset password for:",
      "test@example.com",
    );
  });

  it("applies transform on button hover", async () => {
    const wrapper = mount(ForgotPasswordForm);
    const submitButton = wrapper.find(".submit-button");

    // Mock the ref
    wrapper.vm.$refs.submitButton = { style: { transform: "" } };

    // Trigger mouseenter event
    await submitButton.trigger("mouseenter");

    // Check if transform style was applied
    expect(wrapper.vm.$refs.submitButton.style.transform).toBe(
      "translateY(-2px)",
    );

    // Trigger mouseleave event
    await submitButton.trigger("mouseleave");

    // Check if transform style was reset
    expect(wrapper.vm.$refs.submitButton.style.transform).toBe("translateY(0)");
  });
});
