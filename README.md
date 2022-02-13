<h1 align="center"> NoSePOP </h1>

El repositorio ha sido para poder desarrollar el tercer trabajo de la asignatura Acceso a Datos.
Se puede clonar y examinar el código. Si los cambios se consideran oportunos, se hará merge con la rama principal.

Integrantes:
  - [Adrián Carneiro](https://github.com/acarneirod) (Código,Readme.md y presentación)
  - [José Bayona](https://github.com/jguilmar) (Readme.md, Database.md e Hibernate.md)
  - [Javi Cevallos]() (Presentacion)
  - [Samuel Calvo]() (Presentación y BBDD)

------------

## Contidos
- [Introdución](#introduci%C3%B3n)
- [Herramientas utilizadas](#herramientas-utilizadas)
- [Proceso para la realización del proyecto](#proceso-para-la-realización-del-proyecto)
  - [Análisis y creación de la Base de Datos](#análisis-y-creación-de-la-base-de-datos)
  - [Elegir IDE](#elegir-ide)
  - [Implementación del Hibernate](#implementación-del-hibernate)
  - [Código para las funcionalidades de nuestro proyecto y la comunicación con la Base de Datos](#código-para-las-funcionalidades-de-nuestro-proyecto-y-la-comunicación-con-la-base-de-datos)



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
- [PGModeler 0.9.4-beta1](https://pgmodeler.io/) Modelador de bases de datos PostgreSQL.
- [pgAdmin 4 6.4](https://www.pgadmin.org/) Gestor de bases de datos PostgreSQL.
- [PostgreSQL 14](https://www.postgresql.org/) Sistema para gestionar bases de datos relacionales orientado a objectos de muy alto nivel.
- [Maven](https://maven.apache.org/)  Herramienta de software para la gestión y construcción de proyectos Java. Manejador de dependencias.
- [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) Entorno de desarrollo integrado(IDE) para el desarrollo de software.
- [Hibernate ORM 5.6.4.Final](http://handlebarsjs.com/) Herramienta de mapeo objecto-relacional para Java.

## Proceso para la realización del proyecto 

- [x] Análisis y creación de la Base de datos.
- [x] Elegir un IDE para la realización del proyecto.
- [x] Implementar en el IDE la configuración del mapeo objeto-relacional [Hibernate](https://es.wikipedia.org/wiki/Hibernate).
- [x] Código para las funcionalidades de nuestro proyecto y la comunicación con la Base de Datos.
- [x] Pruebas del funcionamiento de nuestro proyecto.
- [x] Documentación.

## Análisis y creación de la Base de Datos

- Entre las opciones a elegir para la realización de la Base de Datos pusimos sobre la mesa 3 sistemas de gestión de base de datos, que son unas de las más utilizadas.
- Dos son gratuitas(**MySql** y **PostgreSQL**) y una es de pago(**Oracle**), por lo que por ahora descartamos Oracle ya que es de pago y nos centraremos en buscar diferencias en las gratuitas. 
- La explicación de la Base de satos esta mejor detallada en el documento [DataBase.md](https://github.com/acarneirod/NoSePOP/blob/main/DataBase.md).


## Elegir IDE

Instalar un IDE para abrir el proyecto.

> - [Apache NetBeans](https://netbeans.apache.org/download/nb124/nb124.html)
> - [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/#section=windows)
> - [VS Code](https://code.visualstudio.com/Download)

El IDE que hemos elegido para la realización de este proyecto es [IntelliJ IDEA](https://ifgeekthen.nttdata.com/es/intellij-idea-una-gran-alternativa-para-programar-en-java).

## Implementación del Hibernate

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

**Mapeo Objeto-Relacional. Hibernate**

- ¿Qué es el mapeo objeto-relacional?

> ![Figure 1](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura1.png)
Mapeo Objeto-Relacional (ORM)

Por ejemplo, si trabajamos directamente con JDBC tendremos que descomponer el objeto para construir la sentencia `INSERT` del siguiente ejemplo: 

> ![Figure 2](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura2.PNG)

Si contamos con un framework como Hibernate, esta misma operación se traduce en unas pocas líneas de código en las que podemos trabajar directamente con el objeto Java, puesto que el framework realiza el mapeo en función de las anotaciones que hemos implementado a la hora de definir la clase, que le indican a éste con que tabla y campos de la misma se corresponde la clase y sus atributos, respectivamente.

> ![Figure 3](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura3.PNG)

Así, podemos simplemente establecer una sesión con la Base de Datos y enviarle el objeto, en este caso invocando al método `save` que se encarga de registrarlo en la Base de Datos donde convenga según sus propias anotaciones.

> ![Figure 3](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura4.PNG)

Se ha creado una clase HibernateUtil con toda la configuracion y métodos estándar de Hibernate, además se ha creado una clase especificamente mapeada por cada tabla que queremos extrar de la base de datos utilizando Hibernate.

Guia completa: [Hibernate ORM](https://github.com/acarneirod/NoSePOP/blob/main/Hibernate.md)

## Código para las funcionalidades de nuestro proyecto y la comunicación con la Base de Datos

### Java Swing

- Se ha creado una interfaz especifica por cada opción disponible en el programa. Además se ha creado una a mayores para mensajes de informacion del programa.
- El programa termina unicamente cuando cierras la ventana de menú principal. Mientras el programa se ejecute está continuará abierta, permitiendo el uso de varias opciónes a la vez, como por ejemplo la visualizacion de la tabla empleados y la insercion de un empleado. Cada vez que se actualice la base de datos se deberán cerrar y volver a abrir las ventanas de visualizacion de cada tabla en uso, de no ser asi la tabla mostrará el contenido desactualizado.
- Al insertar o borrar un empleado o departamento de forma satisfactoria, el programa mostrará un mensaje al respecto y cerrará dicha ventana. Si algun dato es incorrecto está permanecerá abierta y saltara un mensaje indicando que campo no es correcto.

