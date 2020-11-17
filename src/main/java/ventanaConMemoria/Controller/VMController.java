package ventanaConMemoria.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import ventanaConMemoria.App.App;
import ventanaConMemoria.Model.VMmodel;
import ventanaConMemoria.View.VMview;

public class VMController {

	private final static String ruta = "src/main/resources/Datos_Usuario.properties";

	// view Done
	private static VMview view = new VMview();

	// model Done
	private static VMmodel model = new VMmodel();
	
	private String ColourRGB;

	public VMController() {
		Bindings.bindBidirectional(view.getRed().valueProperty(), model.getRedSliderValue());
		
		Bindings.bindBidirectional(view.getGreen().valueProperty(), model.getGreenSliderValue());
		
		Bindings.bindBidirectional(view.getBlue().valueProperty(), model.getBlueSliderValue());

		model.getRedColorValue().bind(model.getRedSliderValue().divide(100).multiply(255));
		model.getGreenColorValue().bind(model.getGreenSliderValue().divide(100).multiply(255));
		model.getBlueColorValue().bind(model.getBlueSliderValue().divide(100).multiply(255));
		
		model.getRedColorValue().get();
		model.getGreenColorValue().get();
		model.getBlueColorValue().get();
		
		model.getRedColorValue().addListener((observable, oldValue, newValue) -> {
			ColourRGB="rgb("+newValue.doubleValue()+","+model.getGreenColorValue().get()+","+model.getBlueColorValue().get()+")";
			view.setStyle("-fx-background-color:"+ColourRGB+";");
		});
		
		model.getBlueColorValue().addListener((observable, oldValue, newValue) -> {
			ColourRGB="rgb("+model.getRedColorValue().get()+","+model.getGreenColorValue().get()+","+newValue.doubleValue()+")";
			view.setStyle("-fx-background-color:"+ColourRGB+";");
		});

		model.getGreenColorValue().addListener((observable, oldValue, newValue) -> {
			ColourRGB="rgb("+model.getRedColorValue().get()+","+newValue.doubleValue()+","+model.getBlueColorValue().get()+")";
			view.setStyle("-fx-background-color:"+ColourRGB+";");
		});
	}

	public void Write(Double Width, Double Height) {
		try (OutputStream output = new FileOutputStream(ruta)) {

			Properties prop = new Properties();

			prop.setProperty("background.red", "" + model.getRedColorValue().doubleValue());
			prop.setProperty("background.blue", "" + model.getBlueColorValue().doubleValue());
			prop.setProperty("background.green", "" + model.getGreenColorValue().doubleValue());
			prop.setProperty("size.width", "" + Width);
			prop.setProperty("size.height", "" + Height);
			prop.setProperty("slider.red",""+model.getRedSliderValue().get());
			prop.setProperty("slider.green",""+model.getGreenSliderValue().get());
			prop.setProperty("slider.blue",""+model.getGreenSliderValue().get());

			prop.store(output, null);

			System.out.println(prop);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static String LoadMethod(String Property) {
		String aux = "";
		try (InputStream input = new FileInputStream(ruta)) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			aux = prop.getProperty(Property);

		} catch (IOException ex) {
			ex.printStackTrace();
			aux = "No se ha podido cargar los datos";
		}
		return aux;
	}
	
	public static void Load() {
		try {
			double Red = Double.parseDouble(LoadMethod("background.red")); //Double.parseDouble(LoadMethod("background.red"));
			double Green = Double.parseDouble(LoadMethod("background.green")); //Double.parseDouble(LoadMethod("background.green"));
			double Blue = Double.parseDouble(LoadMethod("background.blue")); //Double.parseDouble(LoadMethod("background.blue"));
			
			double RedSlider = Double.parseDouble(LoadMethod("slider.red"));
			double GreenSlider = Double.parseDouble(LoadMethod("slider.green"));
			double BlueSlider = Double.parseDouble(LoadMethod("slider.blue"));
			
			String RGB = "rgb("+Red+","+Green+","+Blue+")";
			
			view.setStyle("-fx-background-color:"+RGB+";");
			
			model.getRedSliderValue().set(RedSlider);
			model.getBlueSliderValue().set(BlueSlider);
			model.getGreenSliderValue().set(GreenSlider);
		}
		catch (NumberFormatException e) {
			System.out.println("Uno de los valores el archivo .properties no coincide con el tipo requerido");
		}
	}
	
	
	public VMview getView() {
		return view;
	}
	
	public VMmodel getModel() {
		return model;
	}
}
