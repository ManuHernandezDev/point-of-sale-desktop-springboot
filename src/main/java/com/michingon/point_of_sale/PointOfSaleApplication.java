package com.michingon.point_of_sale;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

@SpringBootApplication
public class PointOfSaleApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		Application.launch(PointOfSaleApplication.class, args);
	}

	@Override
	public void init() {
		applicationContext = new SpringApplicationBuilder(PointOfSaleApplication.class)
				.web(WebApplicationType.NONE)
				.run();
	}

	@Override
	public void start(Stage stage) {
		applicationContext.publishEvent(new StageReadyEvent(stage));
	}

	@Override
	public void stop() {
		applicationContext.close();
		Platform.exit();
	}

}
