<template>
  <div class="senior-connect-landing">
    <NavBar />
    <HeroSection />
    <HowItWorksSection />
    <BenefitsSection />
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";
import HeroSection from "./HeroSection.vue";
import HowItWorksSection from "./HowItWorksSection.vue";
import BenefitsSection from "./BenefitsSection.vue";

export default {
  name: "SeniorConnectLanding",
  components: {
    NavBar,
    HeroSection,
    HowItWorksSection,
    BenefitsSection,
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
