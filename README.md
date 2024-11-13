
# Ejercicio: Gestión de Seguros y Asistencias Médicas en Spring Boot con Java

En este ejercicio, desarrollarás una API REST completa en **Spring Boot** para la gestión de seguros médicos (**Seguro**) y asistencias médicas asociadas (**AsistenciaMedica**). Implementarás validaciones, relaciones entre entidades, manejo de excepciones personalizadas y retorno de códigos de estado HTTP adecuados.

---

## **Enunciado del Ejercicio**

La aplicación debe cumplir los siguientes objetivos:

### **1. Entidades a Gestionar**

1. **Entidad Seguro:**
    - Representa un seguro médico.
    - Propiedades:
        - `idSeguro`: Identificador único del seguro.
        - `nif`: Número de identificación fiscal (validar formato).
        - `nombre`: Nombre del asegurado (no vacío).
        - `ape1`: Primer apellido del asegurado (no vacío).
        - `ape2`: Segundo apellido del asegurado (opcional).
        - `edad`: Edad del asegurado (mayor que 0; no menor de edad).
        - `numHijos`: Número de hijos (mayor o igual que 0; debe ser 0 si el asegurado no está casado).
        - `fechaCreacion`: Fecha de creación del seguro.
        - `sexo`: Sexo del asegurado (no puede ser nulo).
        - `casado`: Estado civil del asegurado.
        - `embarazada`: Indica si el asegurado está embarazado (no permitido para hombres).

2. **Entidad AsistenciaMedica:**
    - Representa una asistencia médica asociada a un seguro.
    - Propiedades:
        - `idAsistenciaMedica`: Identificador único de la asistencia.
        - `seguro`: Referencia al seguro asociado.
        - `breveDescripcion`: Breve descripción de la asistencia (no vacío).
        - `lugar`: Lugar de la asistencia (no vacío).
        - `explicacion`: Explicación detallada de la asistencia (no vacío).
        - `tipoAsistencia`: Tipo de asistencia (no nulo).
        - `fecha`: Fecha de la asistencia (no nula).
        - `hora`: Hora de la asistencia (no nula).
        - `importe`: Importe asociado (double; mayor que 0, con 2 decimales).

---

### **2. Requisitos Funcionales**

1. **Operaciones CRUD:**
    - **Seguro:**
        - Crear un seguro.
        - Consultar un seguro por su identificador.
        - Listar todos los seguros.
        - Actualizar un seguro existente.
        - Eliminar un seguro (debe eliminar también las asistencias asociadas).

    - **AsistenciaMedica:**
        - Crear una asistencia médica asociada a un seguro.
        - Consultar una asistencia médica por su identificador.
        - Listar todas las asistencias médicas.
        - Actualizar una asistencia médica existente.
        - Eliminar una asistencia médica.

2. **Validaciones:**
    - Implementa las siguientes validaciones para cada entidad (ver tabla de validaciones más abajo).
    - Retorna un código de estado **400 Bad Request** y un mensaje descriptivo cuando no se cumplan las reglas.

3. **Manejo de Excepciones:**
    - Crea excepciones personalizadas para validaciones específicas (**ValidationException**) y recursos no encontrados (**ResourceNotFoundException**).
    - Centraliza el manejo de excepciones con una clase anotada con `@ControllerAdvice`.
    - Responde con códigos de estado y mensajes adecuados:
        - **400 Bad Request**: Para errores de validación.
        - **404 Not Found**: Para recursos inexistentes.
        - **500 Internal Server Error**: Para errores inesperados.

4. **Códigos de Respuesta:**
    - Operaciones exitosas:
        - **201 Created**: Para creación de recursos.
        - **200 OK**: Para consultas y actualizaciones exitosas.
        - **204 No Content**: Para eliminaciones exitosas.
    - Operaciones fallidas:
        - **400 Bad Request**: Para errores de validación.
        - **404 Not Found**: Para recursos inexistentes.

---

### **3. Requisitos Técnicos**

1. **Relación entre Entidades:**
    - Relación **1 a N** entre `Seguro` y `AsistenciaMedica`. Cada seguro puede tener múltiples asistencias médicas.

2. **Base de Datos:**
    - Modelo relacional:
        - Tabla `Seguro` con las columnas correspondientes a sus propiedades.
        - Tabla `AsistenciaMedica` con una columna `idSeguro` como clave foránea.

3. **Configuración:**
    - Configura el proyecto con las siguientes dependencias:
        - **Spring Web**
        - **Spring Data JPA**
        - **MySQL Database** (o un sistema de base de datos a elección).

4. **Documentación y Pruebas:**
    - Documenta la API utilizando **Swagger** o similar.
    - Proporciona pruebas funcionales que incluyan casos de éxito y error, utilizando herramientas como **Postman**.

---

### **4. Validaciones**

| Campo                   | Regla de Validación                                                       | Código HTTP  | Mensaje de Error                                     |
|-------------------------|---------------------------------------------------------------------------|--------------|-----------------------------------------------------|
| `nif`                  | Formato válido (regex).                                                   | 400          | "El campo NIF no tiene un formato válido."          |
| `nombre`, `ape1`       | No puede estar vacío.                                                     | 400          | "El campo {nombre/ape1} no puede estar vacío."      |
| `edad`                 | Mayor que 0. No menor de edad (<18).                                      | 400          | "No es posible ser menor de edad para hacer un seguro." |
| `numHijos`             | Mayor o igual que 0. Si `casado = false`, debe ser 0.                    | 400          | "Un seguro no puede registrar hijos si no está casado." |
| `embarazada`           | No puede ser `true` si `sexo = Hombre`.                                  | 400          | "El campo embarazada no puede ser true si el asegurado es hombre." |
| `breveDescripcion`     | No puede estar vacío.                                                     | 400          | "El campo breveDescripcion no puede estar vacío."   |
| `lugar`                | No puede estar vacío.                                                     | 400          | "El campo lugar no puede estar vacío."              |
| `explicacion`          | No puede estar vacío.                                                     | 400          | "El campo explicacion no puede estar vacío."        |
| `tipoAsistencia`       | No puede ser null.                                                        | 400          | "El campo tipoAsistencia no puede ser nulo."        |
| `fecha`, `hora`        | No pueden ser null.                                                       | 400          | "El campo {fecha/hora} no puede ser nulo."          |
| `importe`              | Mayor que 0.                                                             | 400          | "El campo importe debe ser mayor que 0."            |

---

### **5. Entregables**

1. **Código Fuente:**
    - Incluye todas las entidades, controladores, servicios, repositorios y excepciones.

2. **SQL de Prueba:**
    - Proporciona un script para poblar la base de datos con datos de prueba.

3. **Pruebas Funcionales:**
    - Evidencia de pruebas realizadas con Postman o Swagger:
        - Casos exitosos para cada operación.
        - Casos de validación fallida.

4. **Documentación:**
    - Esquema de la base de datos.
    - Descripción de los endpoints disponibles.

---

Con este ejercicio, aplicarás tus conocimientos en el diseño y desarrollo de APIs REST, validaciones, manejo de excepciones y buenas prácticas en Spring Boot.
