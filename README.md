# Ferbo - Bitacora

## Descripción

**ferbo-bitacora** es una librería diseñada para centralizar el registro de eventos operativos generados por las aplicaciones que la integran. Su propósito es proporcionar un mecanismo estandarizado para registrar las acciones realizadas por los usuarios, permitiendo mantener un historial de operaciones que facilite la auditoría, la trazabilidad y el monitoreo de los procesos del negocio.

La librería proporciona un conjunto de modelos, contratos e implementaciones reutilizables que simplifican la incorporación de funcionalidades de bitácora en distintos sistemas, promoviendo la consistencia en el registro de eventos y reduciendo la duplicidad de código entre proyectos.

## Objetivo

Proporcionar una solución reutilizable y estandarizada para el registro de eventos operativos, permitiendo que las aplicaciones consumidoras integren funcionalidades de bitácora de manera sencilla, consistente y desacoplada.

## Características

* Registro centralizado de eventos operativos.
* Seguimiento de las acciones realizadas por los usuarios.
* Contratos reutilizables mediante interfaces con métodos predeterminados (default) de Java.
* Modelos comunes para el registro y consulta de eventos.
* Integración sencilla con aplicaciones consumidoras.
* Extensible para incorporar nuevos tipos de eventos o mecanismos de persistencia.
* Orientada a la auditoría, trazabilidad y monitoreo de procesos.

## Organización de la libreria

La librería está organizada en módulos funcionales que encapsulan el modelo de dominio, los contratos de acceso a datos, la lógica de negocio y las excepciones necesarias para el registro de eventos operativos.

* **Modelo**: Contiene las entidades y objetos de negocio de la librería. Incluye el *Contexto de la Bitácora*, que define la información común que debe registrarse en cualquier sistema; los *Filtros de Bitácora*, utilizados para consultar eventos; y la entidad *Bitácora*, implementada con JPA para la persistencia de los registros y construida mediante el patrón *Builder*, garantizando una creación consistente y estandarizada de los eventos.
* **DAO**: Define el contrato para el acceso a los datos mediante una interfaz que proporciona métodos predeterminados (default methods) de Java para las operaciones de persistencia y consulta de la bitácora. Esto permite reutilizar la lógica común sin necesidad de implementarla en cada proyecto consumidor.
* **DTO**: Contiene los objetos de transferencia de datos utilizados para el intercambio de información entre las distintas capas y las aplicaciones que integran la librería.
* **Exception**: Agrupa las excepciones personalizadas utilizadas por la librería para representar y gestionar errores de forma uniforme.
* **Business**: Define el contrato de la lógica de negocio mediante una interfaz con métodos predeterminados (default methods) de Java. Estos métodos encapsulan el flujo de registro y consulta de eventos, proporcionando una implementación reutilizable que puede ser utilizada o extendida por las aplicaciones consumidoras.

## Compatibilidad

La librería está desarrollada utilizando la especificación JPA 2.2 (javax.persistence) y está orientada a aplicaciones basadas en Java 8+ y Spring Boot 2.x.

## Tecnologías soportadas

|Componente	| Versión |
| --------- | ------- |
Java        | 8 o superior |
JPA	        | 2.2 (javax.persistence)|
Hibernate   |	5.6.x (como proveedor JPA)|
Spring Boot |	2.7.x|

> Nota:
> La librería depende únicamente de la especificación JPA para la definición de las entidades. Hibernate actúa como proveedor de persistencia en la mayoría de las aplicaciones consumidoras, pero no es un requisito exclusivo de la librería.

## Compatibilidad con Spring Boot 3.x

Actualmente la librería **no es compatible de forma nativa** con Spring Boot 3.x, debido a la migración del ecosistema Java EE (javax.*) hacia Jakarta EE (jakarta.*).

Para utilizar la librería en proyectos basados en Spring Boot 3.x será necesario realizar, entre otros, los siguientes cambios:

* Migrar las importaciones de javax.persistence.* a jakarta.persistence.*.
* Actualizar la dependencia de JPA a Jakarta Persistence.
* Actualizar Hibernate a la versión 6.x o superior.
* Validar la compatibilidad de las dependencias utilizadas por la librería.

Estas modificaciones podrán incorporarse en una futura versión mayor de la librería para mantener la compatibilidad con las versiones más recientes del ecosistema Spring.

## Evolución

La librería ha sido diseñada para facilitar su evolución y mantener compatibilidad con nuevas versiones de Java, Spring Boot y los proveedores de persistencia, procurando minimizar el impacto sobre las aplicaciones consumidoras.

## Instalación

Agregar la dependencia Maven correspondiente.

```xml
<dependency>
    <groupId>com.ferbo.bitacora</groupId>
  	<artifactId>ferbo-bitacora</artifactId>
    <version>Version-RELEASE</version>
</dependency>
```

## Versionado

El proyecto sigue Semantic Versioning (SemVer).

- 1.x.x → Compatible con Spring Boot 2.x
- 2.x.x → Compatible con Spring Boot 3.x (planeado)

## Licencia

Este proyecto se distribuye bajo la licencia definida en el archivo `LICENSE`.