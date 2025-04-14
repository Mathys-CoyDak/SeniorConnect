import { mount } from "@vue/test-utils";
import { describe, it, expect, vi } from "vitest";
import LoginPage from "./LoginPage.vue";
import LoginForm from "./LoginForm.vue";
import ForgotPasswordForm from "./ForgotPasswordForm.vue";
import NavBar from "./NavBar.vue";

describe("LoginPage", () => {
  it("renders correctly", () => {
    const wrapper = mount(LoginPage);

    // Check if NavBar is rendered
    expect(wrapper.findComponent(NavBar).exists()).toBe(true);

    // Check if LoginForm is rendered by default
    expect(wrapper.findComponent(LoginForm).exists()).toBe(true);

    // Check if ForgotPasswordForm is not rendered by default
    expect(wrapper.findComponent(ForgotPasswordForm).exists()).toBe(false);

    // Check if the title is rendered
    expect(wrapper.find(".form-title").text()).toBe("Welcome Back");
  });

  it("switches to forgot password form when triggered", async () => {
    const wrapper = mount(LoginPage);

    // Initially, LoginForm should be visible and ForgotPasswordForm should not
    expect(wrapper.findComponent(LoginForm).exists()).toBe(true);
    expect(wrapper.findComponent(ForgotPasswordForm).exists()).toBe(false);

    // Trigger the forgot-password event
    await wrapper.findComponent(LoginForm).vm.$emit("forgot-password");

    // Now, LoginForm should not be visible and ForgotPasswordForm should be
    expect(wrapper.findComponent(LoginForm).exists()).toBe(false);
    expect(wrapper.findComponent(ForgotPasswordForm).exists()).toBe(true);
  });

  it("switches back to login form when cancel is clicked", async () => {
    const wrapper = mount(LoginPage);

    // Switch to forgot password form
    await wrapper.findComponent(LoginForm).vm.$emit("forgot-password");
    expect(wrapper.findComponent(ForgotPasswordForm).exists()).toBe(true);

    // Trigger the cancel event
    await wrapper.findComponent(ForgotPasswordForm).vm.$emit("cancel");

    // Now, LoginForm should be visible again and ForgotPasswordForm should not
    expect(wrapper.findComponent(LoginForm).exists()).toBe(true);
    expect(wrapper.findComponent(ForgotPasswordForm).exists()).toBe(false);
  });
});
