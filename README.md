Square Games API

Projet Spring Boot réalisé dans le cadre de l’apprentissage des APIs REST avec Java et Spring Boot.

Objectifs du projet

Ce projet permet de :

découvrir Spring Boot
créer des endpoints REST
utiliser l’injection de dépendances
communiquer avec un moteur de jeu externe
tester une API avec Bruno
manipuler des UUID
organiser une architecture Controller / Service
Technologies utilisées
Java 21
Spring Boot
Maven
Bruno
IntelliJ IDEA
GitHub Packages
Structure du projet
src/main/java/com/example/heartbeat
│
├── config
│   └── GameConfig
│
├── controller
│   ├── GameCatalogController
│   ├── GameController
│   └── HeartbeatController
│
├── dto
│   └── CreateGameRequest
│
├── catalog
│   ├── GameCatalog
│   └── GameCatalogImpl
│
├── service
│   ├── GameService
│   ├── GameServiceImpl
│   ├── HeartbeatSensor
│   └── RandomHeartbeat
│
└── HeartbeatApplication
Fonctionnement général
Heartbeat

Le endpoint /heartbeat retourne une valeur aléatoire simulant un rythme cardiaque.

Exemple :

72
Catalogue des jeux

Le endpoint /games (GET) retourne les jeux disponibles.

Exemple :

[
  "tictactoe"
]
Création d’une partie

Le endpoint POST /games permet de créer une nouvelle partie.

Body JSON :

{
  "playerCount": 2,
  "boardSize": 3
}

Réponse :

"550e8400-e29b-41d4-a716-446655440000"

L’UUID représente l’identifiant unique de la partie.

Récupération d’une partie

Le endpoint GET /games/{gameId} retourne l’état d’une partie.

Exemple :

GET /games/550e8400-e29b-41d4-a716-446655440000
Concepts Spring Boot appris
@RestController

Permet de créer un contrôleur REST.

@Service

Permet de déclarer une classe de service Spring.

@Autowired

Permet l’injection automatique de dépendances.

Injection par constructeur

Méthode recommandée pour injecter les dépendances.

Exemple :

public GameController(GameService gameService) {
    this.gameService = gameService;
}
@PathVariable

Permet de récupérer une valeur présente dans l’URL.

Exemple :

@GetMapping("/games/{gameId}")
public Game getGame(@PathVariable UUID gameId)
@RequestBody

Transforme automatiquement un JSON en objet Java.

Installation du projet sur un nouveau PC
1. Installer Java 21

Vérifier l’installation :

java -version

Le projet utilise Java 21.

2. Installer IntelliJ IDEA

Télécharger IntelliJ IDEA Community Edition.

3. Cloner le projet
git clone <url-du-repository>

Puis entrer dans le dossier :

cd square-games-api
Configuration GitHub Packages

Le projet utilise une dépendance privée hébergée sur GitHub Packages.

Il faut donc configurer Maven.

4. Créer un Personal Access Token GitHub

Créer un token GitHub avec accès :

read:packages
5. Créer le fichier Maven settings.xml

Créer le fichier :

~/.m2/settings.xml
6. Ajouter la configuration suivante
<settings>


    <servers>
        <server>
            <id>github</id>
            <username>VOTRE_USERNAME_GITHUB</username>
            <password>VOTRE_TOKEN_GITHUB</password>
        </server>
    </servers>


</settings>
Vérifier les dépendances Maven

Depuis le dossier du projet :

./mvnw dependency:resolve -U

Si tout fonctionne, Maven télécharge les dépendances.

Lancer le projet

Depuis IntelliJ :

Lancer :

HeartbeatApplication

Ou en terminal :

./mvnw spring-boot:run
Vérification du démarrage

Le terminal doit afficher :

Started HeartbeatApplication
Tester l’API avec Bruno
Installation Bruno Linux

Télécharger l’AppImage.

Rendre le fichier exécutable :

chmod +x bruno_3.4.0_x86_64_linux.AppImage

Lancer Bruno :

./bruno_3.4.0_x86_64_linux.AppImage --no-sandbox
Endpoints disponibles
GET /heartbeat

Retourne un rythme cardiaque aléatoire.

GET /games

Retourne la liste des jeux.

POST /games

Crée une nouvelle partie.

Body :

{
  "playerCount": 2,
  "boardSize": 3
}
GET /games/{gameId}

Retourne l’état d’une partie.

Difficultés rencontrées

Pendant le développement, j'ai rencontrée plusieurs erreurs :

erreur de bean Spring introuvable
problème d’injection de dépendances
mauvaise configuration Maven
problème GitHub Packages
UUID invalide dans les URLs
erreur 400 Bad Request
erreur ECONNREFUSED dans Bruno
problème de lancement AppImage Linux

Ces erreurs m'ont permis de mieux comprendre Spring Boot et l’écosystème Java.

Ce que j'ai appris
créer une API REST
utiliser Spring Boot
comprendre les controllers et services
utiliser Maven
manipuler des UUID
tester une API HTTP
utiliser Bruno
organiser un projet Java proprement
utiliser GitHub Packages
Auteur

Projet réalisé dans le cadre de la formation CDA.
