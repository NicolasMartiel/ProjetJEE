# ProjetJEE
Application web avec java EE  
Groupe projet : E-Gallery  
Auteur: Nicolas Martiel  
  
Technologies utilisées:  
-Spring Boot pour le back-end (l'api)   
-Thymeleaf pour le front-end  
-H2 pour la base de données  
  
Pour accéder à la base de donnée embarquée avec l'api:   
-Demarrer l'api  
-Se rendre à localhost:8081/h2  
-Entrer l'url de la bdd ainsi que les identifiants trouvable à src/main/resources/applications.properties  
  
Pour voir le projet (on se situe a la racine) :  
-Builder l'api soit via un ide soit en utilisant le terminal:  
`$cd projetjee`  
`$ mvn clean install` il faut bien sûr avoir mvn d'installé (prendre une version compatible avec java 17+)  
-Puis démarrer l'api avec la commande:  
`$ java -jar target/projetjeeAPI-0.0.1-SNAPSHOT.jar`  
  
le projet est compatible avec java 17+ donc il faut exécuter la commande précedente en ayant  
le jre ou le jdk à la bonne version (17+)  
  
ensuite  pour démarrer l'application web :
-Builder l'application web comme pour l'api mais en se rendant sur webapp (`$ cd ../webapp`)  
-Démarrer l'application web avec la commande:  
`$ java -jar target/webapp-0.0.1-SNAPSHOT.jar`  
  
Si tout se passe bien, en se rendant sur localhost:8082, on arrive à la page d'accueil.  
  
A propos des consignes du projet, les élement notés Work In progress dans l'application n'ont pas été implémentés.  
