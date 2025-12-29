package com.michingon.point_of_sale.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component // Es un Bean de Spring, así que podemos inyectar cosas
@RequiredArgsConstructor // Inyección por constructor (Lombok)
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    // 1. Necesitamos la ruta del FXML.
    // @Value inyecta el archivo desde resources. classpath:/view/Product.fxml
    @Value("classpath:/view/Product.fxml")
    private Resource chartResource;

    // 2. Necesitamos el título de la ventana (opcional, desde
    // application.properties)
    @Value("${spring.application.ui.title:Punto de Venta}")
    private String applicationTitle;

    // 3. ¡LA CLAVE! Necesitamos el contexto para conectar FXML con Spring
    private final ApplicationContext applicationContext;

    // public StageInitializer(ApplicationContext applicationContext) {
    // this.applicationContext = applicationContext;
    // }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            // Recuperamos la 'caja' vacía (Stage) que nos mandó la clase principal
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());

            // -----------------------------------------------------------
            // EL SECRETO DE LA INTEGRACIÓN SPRING + JAVAFX
            // -----------------------------------------------------------
            // Por defecto, FXMLLoader intenta hacer "new ProductFxController()".
            // Pero si hace eso, no se inyecta el Service.
            // Con esta línea le decimos: "No crees tú el controlador.
            // Pídeselo a Spring (applicationContext::getBean)".
            // Así Spring le entrega un controlador con el Service ya inyectado.
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            // -----------------------------------------------------------

            // Carga la vista visual (VBox, TableView, etc.)
            Parent parent = fxmlLoader.load();

            // Configura la escena
            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600)); // Ancho y alto inicial
            stage.setTitle(applicationTitle);
            stage.show(); // Muestra la ventana

        } catch (IOException e) {
            // Si no encuentra el FXML o falla la carga, explota con error runtime
            throw new RuntimeException(e);
        }
    }
}