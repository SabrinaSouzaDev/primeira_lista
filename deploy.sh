#!/bin/bash

# Carrega .env ignorando comentários e linhas vazias
export $(grep -E -v '^#|^$' .env | xargs)

# Build com perfil ativo
./mvnw clean package -DskipTests \
  -Dspring.datasource.url=jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB} \
  -Dspring.datasource.username=${POSTGRES_USER} \
  -Dspring.datasource.password=${POSTGRES_PASSWORD}

echo "✅ Build concluído! Verifique o JAR em:"
echo "target/primeiro-0.0.1-SNAPSHOT.jar"