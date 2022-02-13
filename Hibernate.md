<h1 align="center"> Hibernate </h1>

En nuestro caso usaremos _Hibernate_ como librería ORM, concretamente Hibernate ORM 5.6.4.Final. 
Habrá que tenerlo en cuenta puesto que algunas clases/métodos pueden variar entre diferentes versiones de este framework, especialmente a la hora de configurar (`hibernate.cfg.xml`) e implementar el gestor de sesiones (`HibernateUtil.java`).

## Configuración

- El fichero de configuración de hibernate `hibernate.cfg.xml` se debe crear directamente dentro de la carpeta `src` del proyecto y el propio framework Hibernate será el encargado de leerlo para obtener las sesiones que permitan conectar con la Base de Datos con el código que se implementa en el fichero HibernateUtil.java que se muestra justo después del primero.
- En nuestro caso la configuración del `hibernate.cfg.xml` la hemos implementado en la clase `HibernateUtil.java`.

Creación de las factorias de sesiones. 

> ![Figura_5](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura5.PNG)

> ![Figura_6](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura6.PNG)

## Mapeo de entidades/relaciones con clases/atributos Java

- En el caso de las entidades, se deben anotar tanto la propia clase como cada uno de los atributos (se puede hacer en el atributo o en su getter/setter) para indicar con qué tabla mapearla y cómo mapear los atributos con los campos que corresponda, respectivamente.
- Las anotaciones que nos podemos encontrar para anotar una clase Java que debe ser mapeada con una tabla son:
  > - `@Entity` Indica que la clase es una tabla en la base de datos.
  > - `@Table(name = “nombre_tabla”, catalog = “nombre_base_datos”)` Indica el nombre de la tabla y la base de datos a la que pertenece (este último parámetro no es necesario ya que esa información viene en el fichero de configuración).

- En el caso de los atributos simples que deben ser mapeados con los campos de la tabla correspondiente: 
  > - `@Id` Indica que un atributo es la clave
  > - `@GeneratedValue(strategy = GenerationType.IDENTITY)` Indica que es un valor autonumérico (`PRIMARY KEY` en MySQL, por ejemplo)
  > - `@Column(name = “nombre_columna”)` Se utiliza para indicar el nombre de la columna en la tabla donde debe ser mapeado el atributo.

Mapeo objeto- relacional de nuestro proyecto NoSePOP.

### Tabla Departamentos

> ![Figura_7](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura7.PNG)

### Tabla Empleados

> ![Figura_8](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura8.PNG)
> ![Figura_9](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura9.PNG)

## Operaciones sobre la Base de Datos

### Registrar un objeto

Para registrar un nuevo objeto en la Base de Datos necesitamos haber creado previamente la clase y haberla mapeado correctamente con la tabla que le corresponda. Entonces, utilizando la clase HibernateUtil podremos obtener una sesión (conexión con la Base de Datos) para registrar ese objeto directamente en la Base de Datos de la siguiente forma.

> ![Figura_10](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura10.PNG)

Hay que tener en cuenta que entre el inicio y cierre de la transacción podemos realizar más de una operación y éstas se ejecutarán como tal. Es la forma correcta en el caso de que queramos registrar más de un objeto cuando éstos estén relacionados de alguna forma y dependan entre ellos. Un caso muy claro sería el del registro de un pedido junto con todas sus líneas de detalle puesto que no tendría sentido registrarlo sin los detalles, por lo que la forma más segura sería darlos de alta dentro de una misma transacción.


### Búsquedas

> ![Figura_12](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura12.PNG)

### Eliminar un objeto

> ![Figura_11](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura11.PNG)




