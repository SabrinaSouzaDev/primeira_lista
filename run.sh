#!/bin/bash

# Carrega .env seguro
export $(grep -E -v '^#|^$' .env | xargs)

# Executa com todas as variáveis
java -jar target/primeiro-0.0.1-SNAPSHOT.jar \
  --server.port=${APP_PORT} \
  --spring.datasource.url=jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB} \
  --spring.datasource.username=${POSTGRES_USER} \
  --spring.datasource.password=${POSTGRES_PASSWORD} \
  --app.allowed-origins-pattern=${ALLOWED_ORIGINS_PATTERN} \
  --app.path-prefix=${PATH_PREFIX}