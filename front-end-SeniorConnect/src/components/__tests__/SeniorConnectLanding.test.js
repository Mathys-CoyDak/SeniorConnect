import { describe, it, expect } from "vitest";
import { mount } from "@vue/test-utils";
import SeniorConnectLanding from "../SeniorConnectLanding.vue";
import HomePageNavBar from "./HomePageNavBar.vue";
import HeroSection from "../HeroSection.vue";
import HowItWorksSection from "../HowItWorksSection.vue";
import BenefitsSection from "../BenefitsSection.vue";

// Mock the child components to simplify testing
vi.mock("./HomePageNavBar.vue", () => ({
  default: {
    name: "NavBar",
    render: () => null,
  },
}));

vi.mock("./HeroSection.vue", () => ({
  default: {
    name: "HeroSection",
    render: () => null,
  },
}));

vi.mock("./HowItWorksSection.vue", () => ({
  default: {
    name: "HowItWorksSection",
    render: () => null,
  },
}));

vi.mock("./BenefitsSection.vue", () => ({
  default: {
    name: "BenefitsSection",
    render: () => null,
  },
}));

describe("SeniorConnectLanding", () => {
  it("renders the component", () => {
    const wrapper = mount(SeniorConnectLanding);
    expect(wrapper.exists()).toBe(true);
  });

  it("includes all required sections", () => {
    const wrapper = mount(SeniorConnectLanding);

    // Check that all child components are included
    expect(wrapper.findComponent(HomePageNavBar).exists()).toBe(true);
    expect(wrapper.findComponent(HeroSection).exists()).toBe(true);
    expect(wrapper.findComponent(HowItWorksSection).exists()).toBe(true);
    expect(wrapper.findComponent(BenefitsSection).exists()).toBe(true);
  });
});
