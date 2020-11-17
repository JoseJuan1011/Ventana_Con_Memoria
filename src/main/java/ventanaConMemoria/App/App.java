package ventanaConMemoria.App;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanaConMemoria.Controller.VMController;
import ventanaConMemoria.Model.VMmodel;
import ventanaConMemoria.View.VMview;

public class App extends Application{

	private VMController controller;
	
	private VMmodel model;
	
	private static String RGB;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		model = new VMmodel();
		
		primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
			if (oldValue!=newValue) {
				model.getSizeWidth().set(primaryStage.getWidth());
			}
		});
		
		primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
			if (oldValue!=newValue) {
				model.getSizeHeight().set(primaryStage.getHeight());
			}
		});
		
		controller = new VMController();
		
		Scene scene = new Scene(controller.getView(), model.getSizeWidth().get(), model.getSizeHeight().get());
		
		primaryStage.setTitle("Cambio de Divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void init() {
		VMController.Load();
	}
	
	@Override
	public void stop() {
		controller.Write(model.getSizeWidth().get(),model.getSizeHeight().get());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
