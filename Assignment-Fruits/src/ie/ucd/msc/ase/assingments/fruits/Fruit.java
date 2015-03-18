package ie.ucd.msc.ase.assingments.fruits;

import java.io.Serializable;

public class Fruit implements Serializable {

	private static final long serialVersionUID = 1L;

	private int image;
	private String shortName;
	private String name;
	private int color;
	private int realImg;

	public Fruit(int image, String name, int color, int realImg) {
		super();
		this.image = image;
		this.name = name;
		this.realImg = realImg;
		this.shortName = name.substring(1);
		this.color = color;
	}

	public int getRealImg() {
		return realImg;
	}

	public int getColor() {
		return color;
	}

	public int getImage() {
		return image;
	}

	public String getShortName() {
		return shortName;
	}

	public String getName() {
		return name;
	}
}
