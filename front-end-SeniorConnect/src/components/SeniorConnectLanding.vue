<template>
<Navbar_home></Navbar_home>
  <div class="senior-connect-landing">
    <HeroSection />
    <HowItWorksSection />
    <BenefitsSection />
  </div>
</template>

<script>
import HeroSection from "./HeroSection.vue";
import HowItWorksSection from "./HowItWorksSection.vue";
import BenefitsSection from "./BenefitsSection.vue";
import Navbar_home from "@/components/Navbar_home.vue";

export default {
  name: "SeniorConnectLanding",
  components: {
    Navbar_home,
    HeroSection,
    HowItWorksSection,
    BenefitsSection,
  },
  data() {
    return {
      isMenuOpen: false,
    }
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen
    }
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap");

body {
  margin: 0;
  padding: 0;
  font-family: "Inter", sans-serif;
  color: #333333;
  background-color: #fafafa;
}

.senior-connect-landing {
  min-height: 100vh;
  width: 100%;
}
</style>
