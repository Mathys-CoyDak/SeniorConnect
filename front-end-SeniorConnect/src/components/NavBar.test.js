import { describe, it, expect, beforeEach } from "vitest";
import { mount } from "@vue/test-utils";
import NavBar from "./NavBar.vue";

describe("NavBar", () => {
  let wrapper;

  beforeEach(() => {
    wrapper = mount(NavBar);
  });

  it("renders the component", () => {
    expect(wrapper.exists()).toBe(true);
  });

  it("displays the logo and brand name", () => {
    expect(wrapper.find(".logo-image").exists()).toBe(true);
    expect(wrapper.find(".logo-text").text()).toBe("SeniorConnect");
  });

  it("shows navigation links", () => {
    const links = wrapper.findAll(".nav-link");
    expect(links.length).toBe(3);
    expect(links[0].text()).toBe("How It Works");
    expect(links[1].text()).toBe("For Seniors");
    expect(links[2].text()).toBe("For Recruiters");
  });

  it("shows sign in button", () => {
    const button = wrapper.find(".sign-in-button");
    expect(button.exists()).toBe(true);
    expect(button.text()).toBe("Sign In");
  });

  it("toggles mobile menu when menu button is clicked", async () => {
    // Initially menu should be closed
    expect(wrapper.vm.isMenuOpen).toBe(false);
    expect(wrapper.find(".mobile-menu").isVisible()).toBe(false);

    // Click the menu toggle button
    await wrapper.find(".menu-toggle").trigger("click");

    // Menu should now be open
    expect(wrapper.vm.isMenuOpen).toBe(true);
    expect(wrapper.find(".mobile-menu").isVisible()).toBe(true);

    // Click again to close
    await wrapper.find(".menu-toggle").trigger("click");
    expect(wrapper.vm.isMenuOpen).toBe(false);
  });
});
