/* 
CS 1027B – Assignment 2 
Name: Mark Ziza 
Student Number: 251442316
Email: mziza@uwo.ca
Created: Feb 18, 2025 
*/
public class TrainCar {

	private int weight;
	private String freight;// what material stored in train car

	/**
	 * {@summary constructor for TrainCar class}
	 * 
	 * @param weight  weight of train car
	 * @param freight what is in train car
	 */
	public TrainCar(int weight, String freight) {
		this.weight = weight;
		this.freight = freight;
	}

	/**
	 * {@summary getter getting weigh of train car}
	 * 
	 * @return weight of train car
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * {@summary getter getting freight of train car}
	 * 
	 * @return freight of train car
	 */
	public String getFreight() {
		return freight;
	}

	/**
	 * {@summary setter setting weight of train car}
	 */
	public void setWeight(int newWeight) {
		this.weight = newWeight;
	}

	/**
	 * {@summary setter setting freight of train car}
	 */
	public void setFreight(String newFreight) {
		this.freight = newFreight;
	}

	/**
	 * {@summary method shows string representation of train car}
	 * 
	 * @return string showing freight and weight of train car
	 */
	public String toString() {
		return "<" + getFreight() + ", " + getWeight() + ">";
	}

	/**
	 * {@summary method sees if two train cars can connect}
	 * 
	 * @param other another train car
	 * @return true/false if train cars can connect
	 */
	public boolean canConnect(TrainCar other) {
		// can connect if weight or freight is same
		if (this.getWeight() == other.getWeight() || this.getFreight().equals(other.getFreight()))
			return true;
		return false;
	}

	/**
	 * {@summary method sees if two train cars are equal}
	 * 
	 * @param other another train car
	 * @return true/false if train cars are equal
	 */
	public boolean equals(TrainCar other) {
		// can't connect if other is a reefer and this is train car
		if (other instanceof Reefer) {
			return false;
		}
		// equal if weight and freight are same
		if (this.getWeight() == other.getWeight() && this.getFreight().equals(other.getFreight()))
			return true;
		return false;
	}
}// end of class
