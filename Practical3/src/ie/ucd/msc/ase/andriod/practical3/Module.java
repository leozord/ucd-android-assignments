package ie.ucd.msc.ase.andriod.practical3;

import java.io.Serializable;

public class Module implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int numberOfCredits;
	
	public Module(String name, int numberOfCredits) {
		super();
		this.name = name;
		this.numberOfCredits = numberOfCredits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public String toString() {
		return name;
	}
	
	
}
