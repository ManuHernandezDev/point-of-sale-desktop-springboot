package com.michingon.point_of_sale;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();

        VBox root = new VBox();
        Label saludo = new Label("Welcome");
        root.getChildren().add(saludo);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Point of Sale");
        stage.show();

    }

}
