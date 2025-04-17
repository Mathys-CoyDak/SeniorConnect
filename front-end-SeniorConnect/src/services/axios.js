import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080", // Remplacez par l'URL de votre backend
  headers: {
    "Content-Type": "application/json",
  },
});

export default instance;
