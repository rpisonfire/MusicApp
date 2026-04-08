# 🎵 Music App — Microservices & Engineering Lab
> Projekt realizowany w ramach przedmiotu **Inżynieria Oprogramowania** (Semestr VI, Informatyka Przemysłowa).
> *Software Engineering project developed during the 6th semester of Industrial IT.*

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## 🚀 O Projekcie / About The Project
Kompleksowe **REST API** do zarządzania ekosystemem muzycznym (utwory, artyści, playlisty). Aplikacja demonstruje nowoczesne podejście do budowy systemów rozproszonych, kładąc nacisk na bezpieczeństwo, skalowalność i kulturę DevOps.

*A comprehensive REST API for managing a music ecosystem (tracks, artists, playlists). The application demonstrates a modern approach to building distributed systems, emphasizing security, scalability, and DevOps culture.*

---

## 🛠️ Stack Technologiczny / Tech Stack
* **Core:** Java 21 & Spring Boot 3.1.4
* **Persistence:** Spring Data JPA (Hibernate) + MySQL 8.0
* **Security:** Spring Security (BCrypt, JDBC Authentication, RBAC)
* **Monitoring:** Spring Boot Actuator
* **Frontend:** Thymeleaf (Server-Side Rendering)
* **Infrastructure:** Docker & Docker Compose
* **Linguistic:** i18n (Obsługa 🇵🇱 PL, 🇬🇧 EN, 🇮🇹 IT)

---

## 🏗️ Architektura i Funkcje / Features

### 🔄 Zarządzanie Transakcjami / Transaction Management
* **Deklaratywne / Declarative:** `@Transactional` (Spring context)
* **Imperatywne / Imperative:** `PlatformTransactionManager`
* **Propagacja / Propagation:** `MANDATORY` at the repository level.

### 🔐 Security Matrix
| Metoda / Method | Endpoint | Uprawnienia / Access |
| :--- | :--- | :--- |
| `GET` | `/webapi/**` | 🔓 Public |
| `POST/PUT/DELETE` | `/webapi/**` | 🛡️ `ROLE_ADMIN` |

**Konta testowe / Test Accounts:**
* `admin` / `admin123` (Full Access)
* `user` / `user123` (Read Only)

### 🐳 Konteneryzacja / Dockerization
* **MySQL:** Kontener z persistent storage / *Container with persistent storage*.
* **Multi-Instance:** Konfiguracja pod Load Balancing / *Configuration for Load Balancing tests*.

```bash
# Szybki start infrastruktury / Quick start
docker-compose up -d
```
---

## 📡 Diagnostyka / Diagnostics (Actuator)
Aplikacja udostępnia zaawansowane endpointy monitorujące pod ścieżką `/actuator`:
*Aplication provides advanced monitoring endpoints under the `/actuator` path:*

* `health` – Status systemu / *System status*.
* `metrics` – Szczegółowe statystyki JVM / *Detailed JVM metrics*.
* `mappings` – Pełna mapa drogowa API / *Full API roadmap*.
* `beans` – Wgląd w graf zależności Springa / *Spring bean dependency graph*.

---

## 📦 Instalacja i Uruchomienie / Installation & Setup
1. **Clone:** `git clone https://github.com/rpisonfire/MusicApp.git`
2. **Infrastructure:** `docker-compose up -d`
3. **Build:** `./mvnw clean package -DskipTests`
4. **Run:** `java -jar target/music-app.jar`

---

**👨‍💻 Made By:** [rpisonfire](https://github.com/rpisonfire)  
**🏫 University:** Politechnika Śląska / Silesian University of Technology
