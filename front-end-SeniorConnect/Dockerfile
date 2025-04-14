# Étape 1 : build Vue.js
FROM node:18 AS build-stage
WORKDIR /app
COPY . .
RUN npm install && npm run build

# Étape 2 : serve avec Nginx
FROM nginx:stable-alpine AS production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
