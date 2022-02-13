<h1 align="center"> Base de Datos </h1>

## Contenido. 
- [Diferencia entre MySQL y PostgreSQL](#diferencia-entre-mysql-y-postgresql)
- [Motivos de elección de PostgreSQL](#motivos-de-elecci%C3%B3n-de-postgresql)
    - [Alta concurrencia.](#alta-concurrencia)
    - [Soporte para múltiples tipos de datos de manera nativa.](#soporte-para-multiples-tipos-de-datos-de-manera-nativa)
    - [Soporte a triggers.](#soporte-a-triggers)
    - [Trabajo con vistas.](#trabajo-con-vistas)
    - [Objeto-relacional.](#objeto-relacional)
    - [Soporte para bases de datos distribuidas.](#soporte-para-bases-de-datos-distribuidas)
    - [Soporte para gran cantidad de lenguajes.](#soporte-para-gran-cantidad-de-lenguajes) 
- [Estrutura da base de datos](#estructura-de-base-de-datos)
    - [Tabla Departamentos.](#tabla-departamentos)
    - [Tabla Empleados.](#tabla-empleados)

## Diferencia entre MySQL y PostgreSQL

Gráfica comparativa:

| **Bases para la comparación**  | **MySQL** | **PostgreSQL**| 
| ------------- | ------------- | ------------- |
| BASIC  |  MySQL es un sistema de gestión de bases de datos relacionales.  | PostgreSQL es un sistema de gestión de base de datos relacional de objetos.|
| Producto  | MySQL es el producto de Oracle Corporation.  | PostgreSQL es el producto de Global Development Group. |
| Sistema operativo  | MySQL es compatible con Windows, Mac OS X, Linux, BSD, UNIX, z/OS, Symbian, AmigaOS. | Postgre es compatible con Windows, Mac OS X, Linux y BSD, pero no con UNIX, z/OS, Symbian, AmigaOS.|
| Extensible  | MySQL no es extensible.  | PostgreSQL es altamente extensible.|
| Interfaz  | En MySQL, la herramienta phpMyAdmin proporciona GUI.  | En PostgreSQL, la herramienta pgAdmin proporciona GUI. |
| Apoyo  | Mysqldump, y XtraBackup proporciona copia de seguridad en MySQL.  | PostgresSQL proporciona copia de seguridad en línea. |
| Vista materializada  | MySQL proporciona una tabla temporal, pero no proporciona una vista materializada.  | PostgreSQL proporciona una tabla temporal así como una vista materializada. |
| Objeto de dominio de datos  | MySQL no proporciona el objeto de dominio de datos.  | PostgreSQL proporciona el objeto de dominio de datos. |

## Motivos de elección de PostgreSQL.

PostgreSQL es un sistema de base de datos relacional de alta disponibilidad. Es capaz de funcionar de manera estable en el servidor y, por lo tanto, resulta robusto, una de las principales características que buscan las empresas. Además, es consistente y tolerante a fallos. Es compatible con el modelo relacional, ya que asegura siempre su integridad referencial.

#### Alta concurrencia.
- Es capaz de atender a muchos clientes al mismo tiempo y entregar la misma información de sus tablas, sin bloqueos.

#### Soporte para múltiples tipos de datos de manera nativa.
- Ofrece los tipos de datos habituales en los sistemas gestores, pero además muchos otros que no están disponibles en otros competidores, como direcciones IP, direcciones MAC, Arrays, números decimales con precisión configurable, figuras geométricas, etc.

#### Soporte a triggers.
- Permite definir eventos y generar acciones cuando estos se disparan.

#### Trabajo con vistas.
- Esto quiere decir que pueden consultar los datos de manera diferente al modo en el que se almacenan.

#### Objeto-relacional.
- Otra de sus principales características, que permite trabajar con sus datos como si fueran objetos y ofrece mecanismos de la orientación a objetos, como herencia de tablas.

#### Soporte para bases de datos distribuidas.
- Donde el trabajo con transacciones asegura que estas tendrán éxito cuando han podido realizarse en todos los sistemas involucrados.

#### Soporte para gran cantidad de lenguajes. 
- PostgreSQL es capaz de trabajar con funciones internas, que se ejecutan en el servidor, escritas en diversos lenguajes como C, C++, Java, PHP o Python. Además, ofrece interfaces para ODBC y JDBC, así como interfaces de programación para infinidad de lenguajes de programación.

### Conclusión
- Todas las anteriores características y muchas otras convierten a PostgreSQL en una elección ideal para la mayoría de proyectos ya que obtenemos seguridad, confiabilidad, estabilidad y la oportunidad de mejorar y aportar desarrollos funcionales para hacer un manejador de base de datos aún más óptimo. Estas sencillas razones son más que suficiente para colocar a Postgres entre las principales opciones a tener en cuenta a la hora de trabajar con bases de datos

## Estrutura da base de datos

- La estructura de la base de datos consta de 2 tablas: 
  - Tabla Departamentos.
  - Tabla Empleados.
- El modelo Entidad-Relación de estás tablas se muestra en la siguiente imagen: [Modelo ER NoSePOP](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/M_E-R.PNG).

### Tabla Departamentos.

- Representa los _departamentos_ que hay en la empresa **_NoSePOP_**. 
- Contiene numero de departamento(`deptno`), nombre de departamento(`dname`) y localización(`loc`).
- Teniendo como primary_key a _deptno_.

> ![Tabla Departamentos](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura13.PNG)

### Tabla Empleados.

- Representa los _empleados_ que hay en la empresa **_NoSePOP_**.
- Contiene número de empleado(`empno`), nombre de empleado(`ename`), trabajo(`job`), jefe(`mgr`), fecha de contratación(`hiredate`), salario(`sal`), `comm` y número de departamento(`deptno`).
- Teniendo como `primary_key` a `empno` y como `foreign_key` a `deptno`.

> ![Tabla Empleados](https://raw.githubusercontent.com/JGuilmar/fp/main/NoSePOP/figura14.PNG)





 
