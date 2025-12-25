# Sistema de Punto de Venta (POS) - Desktop

Aplicación de escritorio moderna para la gestión de ventas, inventario y facturación, desarrollada bajo una arquitectura híbrida y desacoplada utilizando **Spring Boot** y **JavaFX**.

Este proyecto está diseñado para funcionar de manera local (Offline-first), garantizando persistencia de datos y alta disponibilidad sin necesidad de servidores web externos.

## 🚀 Características Principales (Key Features)

- **Gestión de Inventario:** Operaciones CRUD completas para productos y control de stock en tiempo real.
- **Punto de Venta (POS):** Interfaz optimizada para cajeros con soporte para escaneo de códigos de barras.
- **Arquitectura Robusta:** Uso de Spring Framework para Inyección de Dependencias (DI), gestión de transacciones y JPA.
- **Persistencia Local:** Base de datos H2 embebida en modo archivo (File-based), sin necesidad de instalar motores SQL externos.
- **Entornos Aislados:** Configuración separada para Development y Production.

---

## 🛠️ Stack Tecnológico (Tech Stack)

- **Lenguaje:** Java 21 (LTS)
- **Framework:** Spring Boot 3.4.0 (Profile: Non-Web)
- **GUI:** JavaFX 21
- **Database:** H2 Database (File Mode) / MySQL Compatible
- **Build Tool:** Maven
- **Testing:** JUnit 5, Mockito

---

## 🏗️ Arquitectura y Configuración Técnica

### 1. Arquitectura Híbrida (Spring Boot + JavaFX)

El proyecto implementa una integración donde **Spring Boot** actúa como el núcleo de lógica y contenedor de beans, mientras que **JavaFX** maneja la capa de presentación.

Se utiliza `WebApplicationType.NONE` para deshabilitar servidores embebidos (Tomcat), optimizando el rendimiento para escritorio.

### 2. Estrategia de Inicio (Startup Lifecycle)

Para solucionar la incompatibilidad entre el **Java Module System (JPMS)** y el escaneo de Classpath de Spring, utilizamos una estrategia de inicialización dual:

| Clase (Class)                     | Rol                 | Descripción Técnica                                                                                                                                                                   |
| :-------------------------------- | :------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **`PointOfSaleLauncher.java`**    | **Entry Point**     | Clase "Wrapper" que no extiende `Application`. Su función es invocar la app principal evitando los chequeos estrictos de módulos al inicio. **Es el punto de ejecución obligatorio.** |
| **`PointOfSaleApplication.java`** | **Spring Host**     | Extiende `Application`. Inicializa el `ConfigurableApplicationContext` de Spring dentro del método `init()` nativo de JavaFX.                                                         |
| **`StageReadyEvent.java`**        | **Custom Event**    | Evento que transporta el `Stage` (Ventana) primario una vez que JavaFX está listo, permitiendo a Spring tomar el control de la UI.                                                    |
| **`StageInitializer.java`**       | **UI Bootstrapper** | Listener que recibe el evento. Configura el `FXMLLoader` para inyectar dependencias automáticamente en los Controladores.                                                             |

### 3. Inyección de Dependencias en UI

Se ha sobrescrito el `ControllerFactory` predeterminado de JavaFX.
Esto permite que los **JavaFX Controllers** (ej. `MainController`) sean gestionados como **Spring Beans**, habilitando el uso de:

- `@Autowired` para inyectar Servicios y Repositorios.
- `@Value` para inyectar configuraciones del `application.properties`.

### 4. Gestión de Datos y Entornos

La persistencia se gestiona mediante **Spring Data JPA**. Los entornos se controlan vía perfiles en `src/main/resources/`:

- **`application.properties`**: Define el perfil activo (default: `dev`).
- **`application-dev.properties`**:
  - **Database:** H2 en modo archivo local (`./data/point_of_sale_db`).
  - **Logging:** Nivel `DEBUG` para trazabilidad.
- **`application-prod.properties`**:
  - **Database:** Configuración lista para producción.
  - **Logging:** Nivel `ERROR` (Clean console).

---

## ⚙️ Configuración y Ejecución

### Requisitos Previos

1.  **Java JDK 21** instalado.
2.  **Maven** instalado y configurado en el PATH.
3.  **Visual Studio Code** con "Extension Pack for Java".

### ▶️ Cómo Ejecutar (IMPORTANTE)

Debido a la arquitectura modular, **NO** ejecutes la clase que extiende de `Application` directamente.

**Método Correcto:**
Ejecuta siempre la clase Launcher:
`src/main/java/com/michingon/point_of_sale/PointOfSaleLauncher.java`

**Desde Terminal:**

```bash
mvn clean javafx:run
```
