# proyectoAldeamo
Envio de una campana rapida desde Tellit, y posterior validacion desde el modulo de reportes.
Implmentacion en Java, de Page Object Model en Java, con Cucumber y JUnit4.

# Prerequisitos

* Jdk1.8 o superior.
* Apache Maven 3.+.
* Docker 18.+ 

## Installation

1. Clonar el proyecto, desde el repositorio en github.
2. Situarse en la carpeta del proyecto.
3. Ejecutar mvn install para instalar las dependencias.

```java 
mvn install 
```

## Ejecucion

1. Dentro de la raiz del proyecto ejecutar mavan para ejcutar los test.

```java 
mvn clean test 
```

## Tests ditribuidos (Selenium Grid)

Para la ejecucion distribuida del test, es necesario levantar y exponer 3 servicios que se encuentran en el archivo de yml, en la raiz del proeycto. 
Para setear el ambiente es necesario ejecutar:

```docker 
docker-compose -f selenium_grid.yml up
```

## Integracion con Jenkins

Es posible realizar la integracion con Jenkins, para lo cual es necesario instalar los siguientes plugins:

* Cucumber reports (para la generacion de los dashboars)

## Proximo pasos

1. Implementar paralelizacion de los test, en firefox y chrome.
2. Cambiar el runner a TestNG.
3. 


