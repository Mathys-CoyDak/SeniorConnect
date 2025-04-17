import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080", // Remplacez par l'URL de votre backend
  headers: {
    "Content-Type": "application/json",
  },
});

// Ajouter le token JWT dans le header Authorization
instance.interceptors.request.use((config) => {
  const token = localStorage.getItem("jwtToken");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default instance;
