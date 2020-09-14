# Rock Paper Scissors

Proyecto con aplicacion basada en DDD

Este proyecto se basara en un ejemplo del desarrollo del juego de Piedra, Papel y Tijera.
Para ello se compone de dos partes principales:
  - El cliente web: Que dispone del interfaz desde el que realizar peticiones al game-backend
  - Servidor Backend: Que dispondra de toda la logica de negocios ademas de la persistencia de los datos.
  
En este ejemplo, el front podra decidir que tipo de usuarios van a jugar una partida. Por defecto, tendra un usuario que siempre juegue Piedra y otro que saque una mano aleatoria, pero esto podra ser configurable dentro de las propiedades del servidor Web con los campos:
  - const.player1Hand=rock
  - const.player2Hand=random
Los valores posibles para estos campos son: rock, paper, scissor y random

A parte de poder realizarse las peticiones al servidor de backend desde la web, o desde un cliente REST propio, Swagger nos facilita un sencillo cliente desde el que ver el formato de las peticiones, para acceder a este usar la direccion bastara con abrir en el navegador con la base al puerto que se haya definido en el Backend, por defecto el 8888:
  http://localhost:8888/


Para compilar el proyecto, ejecutar:
  mvn clean install 
en el proyecto padre

El proyecto ha generado las API la documentacion mediante la libreria Swagger.
En game-backend, podras ejectura el profile de swagger para generar las clases propias del endpoint, haciendolo mas escalable.
Para lanzarlo, ejecutar la siguiente sentencia
  mvn clean install -P generate-swagger

En el caso del proyecto rest-client, que tendra toda la logica para hacer peticiones al servidor de game-backend, so podra generar directamente desde el mismo cliente de swagger en la siguiente direccion:
  https://app.swaggerhub.com/apis/Ggmartin/RockPaperScissors/1.0.1

Para el desarrollo de game-backend ha seguido la arquitectura DDD con Arquitectura hexagonal para desacoplar la aplicacion
