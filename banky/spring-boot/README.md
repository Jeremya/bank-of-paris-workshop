# 04.01 — Start the application

![Java](https://img.shields.io/badge/Made_with-Java-orange.svg?style=for-the-badge&logo=java)
![Cassandra](https://img.shields.io/badge/-Cassandra-orange.svg?style=for-the-badge&logo=apache-cassandra)
![Maven](https://img.shields.io/badge/-Maven-orange.svg?style=for-the-badge&logo=apache-maven)
![Spring-boot](https://img.shields.io/badge/-Springboot-orange.svg?style=for-the-badge&logo=spring)
![Docker](https://img.shields.io/badge/-Docker-orange.svg?style=for-the-badge&logo=docker)

### Environnement 
Il est nécessaire d'avoir au minimum java 8 installé ainsi que maven 3.x.

### Démarrage

Placez le bundle de connexion Astra dans le dossier `banky`, à la racine de l'application. Ensuite, dans le fichier `src/main/resources/application.yml` renseignez 
```properties
datastax.astra:
  secure-connect-bundle: secure-connect-bank-of-paris.zip
```
et renseignez le login password de votre base Astra dans le même fichier.

Ensuite, lancez la commande suivante :
 ```shell script
./mvnw clean install 
./mvnw spring-boot:run
```
Serveur disponible sur [localhost:8081](http://localhost:8081)

# 04.02 — Banky in a container

### But de cette étape
Nous allons dans cette étape mettre l'application Banky dans une image docker que nous allons ensuite déployer dans un container. Cette étape est simplifiée par Spring Boot.

### Spring-boot dans Docker
Pour cette étape il sera nécessaire d'avoir Docker installé. Si ce n'est pas le cas, vous pouvez l'installer en suivant les instructions de [cette page](https://docs.docker.com/get-docker/).

Une simple commande permet de containerizer l'application : 
```shell script
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=bank-of-paris/banky
```

A noter que Spring-boot générera lui-même un `Dockerfile` et ignorera celui présent dans le projet. Si ce comportement n'est pas celui désiré, il faudra utiliser un autre plugin comme par exemple [dockerfile-maven](https://github.com/spotify/dockerfile-maven) ou tout simplement Docker avec cette commande :

```shell script
docker build -t bank-of-paris/banky .
```

### Lancer les containers avec Docker Compose
Pour la suite, il sera nécessaire d'avoir `docker-compose` installé. Si ce n'est pas le cas, suivez les instructions de [cette page](https://docs.docker.com/compose/install/).

Ensuite, lancez la commande suivante pour que docker-compose lance tous les containers nécessaire. A savoir Cassandra et Banky.
 ```shell script
docker-compose up -d
```



Serveur disponible sur [localhost:8081](http://localhost:8081)
