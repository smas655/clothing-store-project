Keycloak
В проекте используется как OAuth 2.0/OIDC-сервер для авторизации сервисов и аутентификации пользователей.

Запуск в Docker:
docker run --name store-keycloak -p 8082:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -v /config/keycloak/import:/opt/keycloak/data/import quay.io/keycloak/keycloak:23.0.7 start-dev --import-realm

PostgreSQL

В проекте используется в качестве БД модуля каталога.

Запуск в Docker:
docker run --name catalogue-db -p 5432:5432 -e POSTGRES_USER=catalogue -e POSTGRES_PASSWORD=catalogue -e POSTGRES_DB=catalogue postgres:16

