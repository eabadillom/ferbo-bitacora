#Changelog

Todos los cambios relevantes de este proyecto serán documentados en este archivo.

El formato está basado en Keep a Changelog y este proyecto utiliza Versionado Semántico (SemVer).

---

##[1.0.0] - 2026-08-07

### Agregado 

* Creación inicial de la librería ferbo-bitacora.
* Implementación del modelo de dominio para el registro de eventos operativos.
* Definición de la entidad Bitacora para la persistencia de eventos mediante JPA.
* Implementación del patrón Builder para la construcción estandarizada de registros de bitácora.
* Incorporación del modelo ContextoBitacora para representar la información común asociada a los eventos.
* Incorporación de filtros para la consulta de eventos registrados.
* Definición de interfaces DAO con métodos default para encapsular la lógica de persistencia y consulta.
* Definición de interfaces Business con métodos default para encapsular la lógica de negocio del registro y consulta de eventos.
* Inclusión de objetos de transferencia de datos (DTO) para la comunicación entre componentes.
* Incorporación de excepciones personalizadas para el manejo uniforme de errores.
* Compatibilidad con JPA 2.2 (javax.persistence).
* Compatibilidad con Java 8 y Spring Boot 2.x.
* Documentación inicial del proyecto (README.md, CHANGELOG.md y LICENSE).