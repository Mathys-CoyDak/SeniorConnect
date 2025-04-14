import { mount } from "@vue/test-utils";
import { describe, it, expect } from "vitest";
import NavBar from "./NavBar.vue";

describe("NavBar", () => {
  it("renders correctly", () => {
    const wrapper = mount(NavBar);

    // Check if the logo is rendered
    const logo = wrapper.find(".navbar-logo");
    expect(logo.exists()).toBe(true);
    expect(logo.attributes("src")).toBe("https://placehold.co/40x40");
    expect(logo.attributes("alt")).toBe("SeniorConnect Logo");

    // Check if the brand name is rendered
    const brand = wrapper.find(".navbar-brand");
    expect(brand.exists()).toBe(true);
    expect(brand.text()).toBe("SeniorConnect");

    // Check if the navigation has proper accessibility attributes
    const nav = wrapper.find("nav");
    expect(nav.attributes("aria-label")).toBe("Main navigation");
  });
});
