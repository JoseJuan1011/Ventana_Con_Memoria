package ventanaConMemoria.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import ventanaConMemoria.Controller.VMController;

public class VMmodel {
	
	private DoubleProperty RedSliderValue;
	private DoubleProperty GreenSliderValue;
	private DoubleProperty BlueSliderValue;
	private DoubleProperty RedColorValue;
	private DoubleProperty GreenColorValue;
	private DoubleProperty BlueColorValue;
	private DoubleProperty SizeWidth;
	private DoubleProperty SizeHeight;
	
	public VMmodel() {
		RedSliderValue = new SimpleDoubleProperty();
		GreenSliderValue = new SimpleDoubleProperty();
		BlueSliderValue = new SimpleDoubleProperty();
		RedColorValue = new SimpleDoubleProperty();
		GreenColorValue = new SimpleDoubleProperty();
		BlueColorValue = new SimpleDoubleProperty();
		SizeWidth = new SimpleDoubleProperty();
		SizeWidth.set(Double.parseDouble(VMController.LoadMethod("size.width")));
		SizeHeight = new SimpleDoubleProperty();
		SizeHeight.set(Double.parseDouble(VMController.LoadMethod("size.height")));
	}

	public DoubleProperty getRedSliderValue() {
		return RedSliderValue;
	}

	public void setRedSliderValue(DoubleProperty redSliderValue) {
		RedSliderValue = redSliderValue;
	}

	public DoubleProperty getGreenSliderValue() {
		return GreenSliderValue;
	}

	public void setGreenSliderValue(DoubleProperty greenSliderValue) {
		GreenSliderValue = greenSliderValue;
	}

	public DoubleProperty getBlueSliderValue() {
		return BlueSliderValue;
	}

	public void setBlueSliderValue(DoubleProperty blueSliderValue) {
		BlueSliderValue = blueSliderValue;
	}

	public DoubleProperty getRedColorValue() {
		return RedColorValue;
	}

	public void setRedColorValue(DoubleProperty redColorValue) {
		RedColorValue = redColorValue;
	}

	public DoubleProperty getGreenColorValue() {
		return GreenColorValue;
	}

	public void setGreenColorValue(DoubleProperty greenColorValue) {
		GreenColorValue = greenColorValue;
	}

	public DoubleProperty getBlueColorValue() {
		return BlueColorValue;
	}

	public void setBlueColorValue(DoubleProperty blueColorValue) {
		BlueColorValue = blueColorValue;
	}

	public DoubleProperty getSizeWidth() {
		return SizeWidth;
	}

	public void setSizeWidth(DoubleProperty sizeWidth) {
		SizeWidth = sizeWidth;
	}

	public DoubleProperty getSizeHeight() {
		return SizeHeight;
	}

	public void setSizeHeight(DoubleProperty sizeHeight) {
		SizeHeight = sizeHeight;
	}
}
