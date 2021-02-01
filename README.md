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

# Desafio enviado

```
Proyecto creado con el proposito de ir midiendo a nuestros próximos talentos 
ಠ⌣ಠ ಠ⌣ಠ ಠ⌣ಠ ಠ⌣ಠ

## Introducción

Si llegaste aquí es porque quieres postular al cargo de Desarrollador Full Stack, para esto debemos comenzar con la parte parte técnica. Este TEST medirá tres competencias que se detallan a continuación.

1. Manejo de backend meidante algun lenguaje/framework (ejemplo: java/Spring Boot).
2. Conocimiento de uso de API's.
3. Manejo de frontend mediante alguna combinacion lenguaje/framework (ejemplo: javascript/react js).
4. Conocimiento de Javascript

### Herramientas Necesarias

1. Algún IDE que permita compilar el codigo generado (Intellij, Eclipse, Visual Studio Code, otro)
2. Maven o Gradle

### Instrucción preliminar

**PASO 1**: Clonar este repo.

**PASO 2**: Crear una rama con la siguiente nomenclatura; anteponer "fb/" de Feature Branch seguido de la letra del primer nombre seguido del apellido, por ejemplo en mi caso, mi nombre es Diego Pinto mi rama se llamará fb/dpinto.

**Ruta API**: (Documentacion Swagger) [Dummy Api](https://sistemas.forus.cl/forus/challenge/dummy-api/swagger-ui.html)

Cada ejercicio tendra una carpeta dentro del proyecto/rama. Es decir, la rama base tendra la siguiente estructura:

- ejercicio_1
- ejercicio_2
- ejercicio_3
- README.md

### Ejercicio Número 1

Crear un backend API utilizando algun Framework de backend que tenga una entidad/clase/modelo que represente nuestros productos con los campos:

1. productoId
2. productoNombre
3. productoDescripcion
4. productoCantidad
5. productoUbicacion

Esta API debe tener un controlador capaz de listar, llamar por id, crear, editar y borrar productos mediante REST endpoints.

### Ejercicio Número 2

"Crear un CRUD de productos apuntando a nuestra API"

Actualmente tenemos una [API Mock](https://sistemas.forus.cl/forus/challenge/dummy-api/swagger-ui.html) que permite conectarse a ella por los verbos propios de una API Rest, en base a esta API se ha visto como necesario que se cree una interfaz que permita listar, crear, editar y borrar productos, es por esto que se te pide a ti que puedas crear una interfaz dentro del proyecto, haciendo uso de nuestra API.

### Ejercicio Número 3

"Aplicando un poco de Javascript"

En este ejercicio vamos a retomar el CRUD del ejercicio 1, ya que nuestro cliente es una persona que no le gusta esperar, se ha visto como necesario que las acciones sean realizadas mediante AJAX 😃 de esta forma nuestro cliente piensa que el sistema funciona de forma mas eficiente (nuestro cliente quiere que la página no se refresque al crear, editar y eliminar productos 😄)

Para este ejercicio se podrá usar lo que se estime conveniente en Frameworks Javascript.

> THE END 


:fire: :fire: :fire: Mucha suerte! y estamos ansiosos de ver lo que puedes hacer :fire: :fire: :fire:

```