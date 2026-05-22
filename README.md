# 🎮 Square Games API

> API REST développée en Java avec Spring Boot dans le cadre de ma formation **Concepteur Développeur d’Applications (Bac+3)** au Campus Numérique in the Alps, Grenoble.

---

# 📖 Description

Square Games API est une API REST permettant de créer et gérer des parties de jeux de plateau.

Le projet utilise un moteur de jeu externe (`square-games-engine`) afin de manipuler des parties, des joueurs et des plateaux de jeu.

L’objectif pédagogique du projet est de découvrir :

* Spring Boot
* les APIs REST
* l’injection de dépendances
* Maven
* les services et controllers
* les UUID
* les tests HTTP avec Bruno

---

# 🚀 Fonctionnalités

## ❤️ Heartbeat

Endpoint permettant de simuler un rythme cardiaque aléatoire.

```http
GET /heartbeat
```

Exemple de réponse :

```json
72
```

---

## 🎲 Catalogue des jeux

Récupération des jeux disponibles.

```http
GET /games
```

Réponse :

```json
[
  "tictactoe"
]
```

---

## 🏗️ Création d’une partie

Création d’une nouvelle partie de TicTacToe.

```http
POST /games
```

Body JSON :

```json
{
  "playerCount": 2,
  "boardSize": 3
}
```

Réponse :

```json
"550e8400-e29b-41d4-a716-446655440000"
```

Chaque partie reçoit un UUID unique.

---

## 🎮 Récupération d’une partie

```http
GET /games/{gameId}
```

Exemple :

```http
GET /games/550e8400-e29b-41d4-a716-446655440000
```

---

# 🏗️ Architecture

Le projet utilise une architecture Spring Boot classique :

```text
Controller
    ↓
Service
    ↓
GameFactory
    ↓
Game Engine
```

---

# 📂 Structure du projet

```text
src/main/java/com/example/heartbeat
│
├── config/
│   └── GameConfig
│
├── controller/
│   ├── GameCatalogController
│   ├── GameController
│   └── HeartbeatController
│
├── dto/
│   └── CreateGameRequest
│
├── catalog/
│   ├── GameCatalog
│   └── GameCatalogImpl
│
├── service/
│   ├── GameService
│   ├── GameServiceImpl
│   ├── HeartbeatSensor
│   └── RandomHeartbeat
│
└── HeartbeatApplication
```

---

# 🧠 Concepts Spring Boot appris

## ✅ @RestController

Création d’endpoints REST.

---

## ✅ @Service

Déclaration des services métier Spring.

---

## ✅ Injection de dépendances

Utilisation de :

* `@Autowired`
* injection par constructeur

---

## ✅ @RequestBody

Transformation automatique du JSON en objet Java.

---

## ✅ @PathVariable

Récupération dynamique des valeurs dans l’URL.

---

## ✅ UUID

Gestion d’identifiants uniques pour les parties.

---

# 🛠️ Technologies utilisées

| Technologie     | Usage                   |
| --------------- | ----------------------- |
| Java 21         | Langage principal       |
| Spring Boot     | Framework backend       |
| Maven           | Gestion des dépendances |
| Bruno           | Test des endpoints HTTP |
| IntelliJ IDEA   | IDE                     |
| GitHub Packages | Dépendance privée       |
| Git             | Versioning              |

---

# 🚀 Installation du projet

## 📦 Prérequis

* Java 21+
* Maven
* IntelliJ IDEA
* Git
* Bruno (optionnel mais recommandé)

---

# 1️⃣ Cloner le projet

```bash
git clone <url-du-repository>
```

Puis entrer dans le dossier :

```bash
cd square-games-api
```

---

# 2️⃣ Configurer GitHub Packages

Le projet utilise une dépendance privée Maven.

Créer un Personal Access Token GitHub avec :

```text
read:packages
```

---

# 3️⃣ Créer le fichier Maven

Créer le fichier :

```text
~/.m2/settings.xml
```

---

# 4️⃣ Ajouter la configuration Maven

```xml
<settings>

    <servers>
        <server>
            <id>github</id>
            <username>VOTRE_USERNAME_GITHUB</username>
            <password>VOTRE_TOKEN_GITHUB</password>
        </server>
    </servers>

</settings>
```

---

# 5️⃣ Télécharger les dépendances

Depuis le dossier du projet :

```bash
./mvnw dependency:resolve -U
```

---

# ▶️ Lancer le projet

Depuis IntelliJ IDEA :

Lancer :

```text
HeartbeatApplication
```

Ou en terminal :

```bash
./mvnw spring-boot:run
```

---

# ✅ Vérification du démarrage

Le terminal doit afficher :

```text
Started HeartbeatApplication
```

---

# 🧪 Tester l’API avec Bruno

## Lancer Bruno sous Linux

Rendre l’AppImage exécutable :

```bash
chmod +x bruno_3.4.0_x86_64_linux.AppImage
```

Lancer Bruno :

```bash
./bruno_3.4.0_x86_64_linux.AppImage --no-sandbox
```

---

# 📡 Endpoints disponibles

| Méthode | URL               | Description                            |
| ------- | ----------------- | -------------------------------------- |
| GET     | `/heartbeat`      | Retourne un rythme cardiaque aléatoire |
| GET     | `/games`          | Liste les jeux disponibles             |
| POST    | `/games`          | Crée une nouvelle partie               |
| GET     | `/games/{gameId}` | Retourne une partie                    |

---

# 🎯 Exemple de workflow API

## Création d’une partie

```http
POST /games
```

Body :

```json
{
  "playerCount": 2,
  "boardSize": 3
}
```

Réponse :

```json
"550e8400-e29b-41d4-a716-446655440000"
```

---

## Récupération de la partie

```http
GET /games/550e8400-e29b-41d4-a716-446655440000
```

---

# ⚠️ Difficultés rencontrées

Pendant le développement,j'ai rencontré plusieurs erreurs:

* Bean Spring introuvable
* Injection de dépendances incorrecte
* Mauvaise configuration Maven
* Problème GitHub Packages
* UUID invalide
* Erreur HTTP 400
* Erreur ECONNREFUSED
* Configuration AppImage Linux

Ces erreurs m'ont permis de mieux comprendre l’écosystème Spring Boot.

---

# 📚 Concepts Java appliqués

* ✅ Interfaces et implémentations
* ✅ Injection de dépendances
* ✅ Architecture Controller / Service
* ✅ Collections Java (`Map`, `HashMap`)
* ✅ UUID
* ✅ APIs REST
* ✅ JSON
* ✅ Maven
* ✅ Spring Boot

---

# 👩‍💻 Auteur

**Sylvie Bal** — Développeuse Java/Web en formation CDA (Bac+3)

---

# 📄 Licence

Projet réalisé dans le cadre de la formation CDA — Campus Numérique in the Alps, Grenoble 2025-2026.

