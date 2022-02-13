<h1 align="center"> NoSePOP </h1>

El repositorio ha sido para poder desarrollar el tercer trabajo de la asignatura Acceso a Datos.
Se puede clonar y examinar el código. Si los cambios se consideran oportunos, se hará merge con la rama principal.

Integrantes:
  - [Adrián Carneiro](https://github.com/acarneirod) (Código,Readme y presentación)
  - [José Bayona](https://github.com/jguilmar) (Readme Y BBDD)
  - [Javi Cevallos]() (Presentacion)
  - [Samuel Calvo]() (Presentación y BBDD)

------------

## Contenidos
- [Introdución](#introduci%C3%B3n)
- [Herramientas utilizadas](#herramientas-utilizadas)
- [Hibernate ORM](#hibernate-orm)
- [Java Swing](#java-swing)

## Introdución
Nuestra empresa NoSePOP esta dedicada a la gestión de una base de datos que contiene los datos de empleados y departamentos pertenecientes a una empresa.
El programa te da la opción de manegar la base de datos tanto por consola como por una intefaz gráfica de tipo Swing. Presenta las siguientes opciones:
  - Mostrar tabla Empleados
  - Mostrar tabla Departamentos 
  - Mostrar una combinacion de las tablas Empleados y departamentos
  - Introducir un nuevo Empleado
  - Eliminar un Empleado existente
  - Introducir un nuevo Departamento
  - Eliminar un Departamento existente


## Herramientas utilizadas
Las herramientas que hemos utilizado son las siguientes:
- [Java Swing](https://es.wikipedia.org/wiki/Swing_(biblioteca_gráfica)) Biblioteca gráfica para Java.
- [PGModeler 0.9.4-beta1](https://pgmodeler.io/) Modelador de bases de datos PostgreSQL.
- [pgAdmin 4 6.4](https://www.pgadmin.org/) Gestor de bases de datos PostgreSQL.
- [PostgreSQL 14](https://www.postgresql.org/) Sistema para gestionar bases de datos relacionales orientado a objectos de muy alto nivel.
- [Maven](https://maven.apache.org/)  Herramienta de software para la gestión y construcción de proyectos Java. Manejador de dependencias.
- [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) Entorno de desarrollo integrado(IDE) para el desarrollo de software.
- [Hibernate ORM 5.6.4.Final](http://handlebarsjs.com/) Herramienta de mapeo objecto-relacional para Java.


## Hibernate ORM
La implementación de Hibernate en el codigo se ha llevado a cabo mediante el uso de [Maven](https://maven.apache.org/). 
```
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.6.4.Final</version>
        </dependency>
```
En este caso hemos utilizado PostgreSQL para el manejo de la base de datos. El conector utilizado es:
```
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.3.1 </version>
        </dependency>
```
Guia completa: [PostgreSQL Database](https://github.com/acarneirod/NoSePOP/blob/main/Database.md)

Se ha creado una clase HibernateUtil con toda la configuracion y métodos estándar de Hibernate, además se ha creado una clase especificamente mapeada por cada tabla que queremos extrar de la base de datos utilizando Hibernate.

Guia completa: [Hibernate ORM](https://github.com/acarneirod/NoSePOP/blob/main/Hibernate.md)

## Java Swing
Se ha creado una interfaz especifica por cada opción disponible en el programa. Además se ha creado una a mayores para mensajes de informacion del programa.
El programa termina unicamente cuando cierras la ventana de menú principal. Mientras el programa se ejecute está continuará abierta, permitiendo el uso de varias opciónes a la vez, como por ejemplo la visualizacion de la tabla empleados y la insercion de un empleado. Cada vez que se actualice la base de datos se deberán cerrar y volver a abrir las ventanas de visualizacion de cada tabla en uso, de no ser asi la tabla mostrará el contenido desactualizado.
Al insertar o borrar un empleado o departamento de forma satisfactoria, el programa mostrará un mensaje al respecto y cerrará dicha ventana. Si algun dato es incorrecto está permanecerá abierta y saltara un mensaje indicando que campo no es correcto.










