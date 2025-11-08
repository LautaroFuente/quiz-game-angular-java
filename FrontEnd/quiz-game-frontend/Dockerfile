# Etapa 1: Construcción del proyecto Angular
FROM node:20 AS build

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Etapa 2: Servir con Nginx
FROM nginx:alpine

# Copiamos los archivos compilados desde la etapa anterior
COPY --from=build /app/dist/quiz-game-frontend/browser /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
