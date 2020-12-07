Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Por ahora el programa esta en la etapa donde el modelo y el controlador estan implementados
pero falta la vista, por lo que la ejecucion del programa se limita a correr los test para 
revisar el coverage.
Para la logica dentro del programa se decidio el uso de interfaces como nexos entre distintas 
clases que compartian comportamientos, tales como las distintas armas o los distintos
personajes, luego se crearon clases abstractas que contenian los valores necesarios a guardar
e implementaban parte de las funciones de las interfaces, finalmente se crea uno por uno los
personajes usables y las armas para poder hacerlas tener sus comportamientos unicos, como 
las armas solo poder equiparse a ciertas clases o los personajes ver que se pueden equipar.
Los factory creados tienen una logica de construccion similar pero su utilidad es a la hora de 
implementar el controlador donde se crean y guardas los personajes que pertenecen al juego,
donde permiten crean muchas instancias de distintas clases con mucha facilidad en el caso de 
crear muchos enemigos de un tipo especifico, o armas extra.
el controlador contiene listas de los personajes, los enemigos e inventario, dentro de sus metodos 
maneja la logica del juego y permite que los modelos interactuen entre si.
