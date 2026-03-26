# 🎵 Music App — Inżynieria Oprogramowania (sem VI)

Projekt aplikacji webowej realizowanej na zajęciach z **Inżynierii Oprogramowania** w semestrze VI Informatyki Przemysłowej.

## 📖 Opis projektu

REST API do zarządzania muzyką — trackami, artystami i playlistami.  
Aplikacja zbudowana w oparciu o **Spring Boot** z warstwą walidacji, obsługą internacjonalizacji (i18n), zarządzaniem transakcjami oraz monitoringiem przez Actuator.

## 🛠️ Technologie

- **Java 21**
- **Spring Boot 3.1.4**
- **Spring Web MVC** — REST API
- **Spring Data JPA / Hibernate** — warstwa dostępu do danych (MySQL)
- **Spring Transactions** — transakcje imperatywne i deklaratywne (`@Transactional`)
- **Spring Boot Actuator** — monitoring i diagnostyka aplikacji (`/actuator/*`)
- **Spring Validation (Hibernate Validator)** — walidacja danych
- **Thymeleaf** — widoki HTML
- **Lombok** — redukcja boilerplate
- **i18n** — obsługa komunikatów w językach: 🇵🇱 PL, 🇬🇧 EN, 🇮🇹 IT
- **MySQL** — baza danych (Docker)
- **DevTools** — automatyczny restart aplikacji

## 🔄 Transakcje

- Transakcje **imperatywne** z użyciem `PlatformTransactionManager`
- Transakcje **deklaratywne** z adnotacją `@Transactional` (Spring)
- Propagacja `MANDATORY` na warstwie repozytorium

## 📡 Actuator

Dostępne endpointy diagnostyczne pod `/actuator`:

| Endpoint | Opis |
|---|---|
| `/actuator/health` | Status aplikacji |
| `/actuator/info` | Informacje o aplikacji |
| `/actuator/beans` | Lista beanów Spring |
| `/actuator/env` | Zmienne środowiskowe |
| `/actuator/metrics` | Metryki JVM |
| `/actuator/mappings` | Lista endpointów REST |
