package ventanaConMemoria.View;

import javax.swing.plaf.SliderUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VMview extends GridPane {
	
	private Slider Red;
	private Slider Green;
	private Slider Blue;
	
	public VMview() {
		super();
		
		Red = new Slider();
		Green = new Slider();
		Blue = new Slider();
		
		Red.setValue(100);
		Green.setValue(100);
		Blue.setValue(100);
		
		setAlignment(Pos.CENTER);
		setHgap(5);
		setVgap(5);
		addRow(0,new Label("Red"),Red);
		addRow(1,new Label("Green"),Green);
		addRow(2,new Label("Blue"),Blue);
	}

	public Slider getRed() {
		return Red;
	}

	public void setRed(Slider red) {
		Red = red;
	}

	public Slider getGreen() {
		return Green;
	}

	public void setGreen(Slider green) {
		Green = green;
	}

	public Slider getBlue() {
		return Blue;
	}

	public void setBlue(Slider blue) {
		Blue = blue;
	}
	
}
