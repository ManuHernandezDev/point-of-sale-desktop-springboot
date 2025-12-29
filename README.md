# Sistema de Punto de Venta (POS) - Desktop

Aplicación de escritorio **Offline-first** para gestión comercial. Combina la potencia de **Spring Boot** (Backend logic) con la interfaz nativa de **JavaFX**, bajo una arquitectura totalmente desacoplada.

---

## Stack Tecnológico

- **Core:** Java 21 LTS + Spring Boot 3.4.0
- **UI:** JavaFX 21 (Modular)
- **Data:** H2 Database (File-based) + Spring Data JPA
- **Build:** Maven

---

## Ejecución Rápida

El proyecto utiliza un Launcher personalizado para gestionar la modularidad.

```bash
mvn clean javafx:run

```

_(Nota: El punto de entrada es `PointOfSaleLauncher.java`)_

---

## Funcionalidades Implementadas (Feature Log)

_Registro de características activas organizadas por módulo._

### Módulo: Core & Arquitectura

- **Integración Spring-JavaFX:** Gestión del ciclo de vida de la aplicación y contexto de Spring.
- **Inyección de Dependencias en UI:** `ControllerFactory` personalizado para inyectar Servicios/Repositorios en Controladores JavaFX.
- **Persistencia Multientorno:**
- Perfil `dev`: Base de datos local H2 y logs de depuración.
- Perfil `prod`: Configuración optimizada para despliegue.

### Módulo: Gestión de Inventario (Productos)

- **Visualización de Datos:** Tabla de productos (`TableView`) con diseño limpio en FXML.
- **Diseño Responsivo:** Lógica en Controlador para ajuste automático de columnas (Width Binding) según el tamaño de la ventana.
- **Data Binding:** Enlace unidireccional entre el modelo de datos (`Product`) y la vista, separando lógica de diseño.

---
