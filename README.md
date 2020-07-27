# Full Stack Challenge ಠ⌣ಠ

Proyecto realizado para postular a la empresa Forus

## Frameworks escogidos
- Ejercicio 1 (Spring Boot)
- Ejercicio 2 (Spring Boot)
- Ejercicio 3 (Vue JS)

## Ejecutar proyecto
### Opción 1
#### Requisitos:
- Maven
- Docker Compose (Opcional)
- Java 8

Para facilitar la ejecución del proyecto se adiciono al desafío la herramienta "Docker Compose", para esto debemos situarnos en el directorio del repositorio y ejecutar los siguientes comandos:
```
#Para compilar el código y crear los paquetes .jar del ejercicio 1 y 2
mvn -f ejercicio_1/pom.xml clean package
mvn -f ejercicio_2/pom.xml clean package
#Levantar Backends y FrontEnd mediante Dockers
sudo docker-compose up
```

Puertos utilizados por defecto en cada proyecto:
- Ejercicio 1 (Backend): **http://localhost:8085**
- Ejercicio 2 (Backend Api Rest Forus): **http://localhost:8086**
- Ejercicio 3 (Frontend): **http://localhost:8080**

### Opción 2
#### Ejercicio 1
Para ejecutar el Backend del ejercicio 1 debe ejecutar los siguientes comandos.
```
mvn -f ./ejercicio_1/pom.xml clean package
java -jar ./ejercicio_1/target/challenge-backend-1.jar 
```
#### Ejercicio 2
Para ejecutar el Backend del ejercicio 1 debe ejecutar los siguientes comandos.
```
mvn -f ./ejercicio_2/pom.xml clean package
java -jar ./ejercicio_2/target/challenge-backend-2.jar 
```

#### Ejercicio 3
Para ejecutar el frontend ir a la carpeta del ejercicio 3 y ejecutar el siguiente comando:
```
#Omitir "--prefix ./ejercicio_3" en caso de estar en el directorio ejercicio_3 del repositorio
npm install --prefix ./ejercicio_3
npm run serve --prefix ./ejercicio_3
```


```
NOTA: Algunas cosas se pudieron hacer más simples pero se implemento de esa manera
solo para mostrar mostrar conocimientos como las clases Genéricas, etc...
```