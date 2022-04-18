# tp3_sca_yko
<h3><b> TP3 du cours de scalabilité conteneurisation et virtualisation

ING3 - EPISEN - 2021/22</b></h3>

# Build 
- ## frontend
Pour builder l'image <b>yko-frontend</b> et le pousser sur le Docker Hub.
Il faut s'assurer d'être dans le repertoire <b>frontend</b> du projet, puis éxécuter les commandes
suivantes:
```console
  1. $ docker build -t yko-frontend .
  2. docker tag 43ba40cb7022 koneyayangolo/frontback-tp-sca:yko-frontend
  3. docker push koneyayangolo/frontback-tp-sca:yko-frontend
```
PS: l'id de l'image 43ba40cb7022 est obtenu après le build en faisant la
commande <b>docker images</b>.
- ## backend
Pour builder l'image <b>yko-backend</b> et le pousser sur le Docker Hub.
Il faut s'assurer d'être dans le repertoire <b>backend</b> du projet, puis éxécuter les commandes
suivantes:
```console
  1. $ docker build -t yko-backend .
  2. docker tag fe36f9ffa586 koneyayangolo/frontback-tp-sca:yko-backend
  3. docker push koneyayangolo/frontback-tp-sca:yko-backend
```
PS: l'id de l'image fe36f9ffa586 est obtenu après le build en faisant la
commande <b>docker images</b>.

# Launch services
Pour lancer les services, il faut se positionner à la racine du projet puis exécuter la commande suivante: 
```console
  $ docker-compose up -d
```
# Call services

- ## frontend
Pour appeler l'API du service <b>frontend</b>, utiliser l'url ci-dessous:
```console
  http://localhost:8080/api/frontend/
```
- ## backend
Pour appeler l'API du service <b>backend</b>, utiliser l'url ci-dessous:
```console
  http://localhost:8080/api/backend/
```
# Check stats and ressources consomations and limits
Pour vérifier les consommations de RAM et CPU des services, il faut éxécuter
la commande suivante: 
```console
  $ docker stats
```

# Packages

- ### backend
Ce package contient le code source du service backend et la configuration
de conteneurisation(DockerFile) de ce service.

- ### frontend
Ce package contient le code source du service frontend et la configuration
de conteneurisation(DockerFile) de ce service.

- ### nginx
Ce package contient la configuration de <b>nginx</b>.</br>
<b>nginx</b> nous permet ici de faire du load balancing et du reverse proxy.
Sachant que nous avons plusieurs replicas(2) pour chaque service.

- ### logs
  Ce package contient les logs des differents services.

  - ##### frontend
       Ce repertoire est un volume qui contient les logs de nginx.
      <b>access.txt</b> pour les logs des appels de service réussi et <b>error.txt</b> pour les appels
      de services qui ont échoué.
  
  - ##### backend
    Ce repertoire est un volume qui contient les logs du services backend.
    <b>backend_log.txt</b> pour tous les logs du backend. 
 
# Repositories

- ## Docker Hub
```console
  https://hub.docker.com/repository/docker/koneyayangolo/frontback-tp-sca
```
- ## GitHub
```console
  https://github.com/KONE-Yaya/tp3_sca_yko
```

# Team Members
- <b style="color:blue">KONE Yaya N'golo</b>