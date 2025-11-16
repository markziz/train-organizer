/* 
CS 1027B – Assignment 2 
Name: Mark Ziza 
Student Number: 251442316
Email: mziza@uwo.ca
Created: Feb 18, 2025 
*/
public class Reefer extends TrainCar {

	private int temp;// temperature inside reefer car in celsius

	/**
	 * {@summary constructor for Reefer extending train car}
	 * 
	 * @param weight  weight of reefer car
	 * @param temp    temperature of reefer car
	 * @param freight freight (what's inside) of reefer car
	 */
	public Reefer(int weight, int temp, String freight) {
		super(weight, freight);
		this.temp = temp;
	}

	/**
	 * {@summary getter that gets temperature}
	 * 
	 * @return temperature of reefer car
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * {@summary setter that sets temperature}
	 * 
	 * @param newTemp new temperature for reefer car
	 */
	public void setTemp(int newTemp) {
		this.temp = newTemp;
	}

	/**
	 * {@summary String representation of reefer car}
	 * 
	 * @return a string containing reefer's freight, weight and temperature
	 */
	public String toString() {
		return "<" + getFreight() + ", " + getWeight() + ", " + getTemp() + "C>";
	}

	/**
	 * {@summary method that sees if two cars can connect}
	 * 
	 * @param other another car of reefer or train
	 * @return true/false if cars can connect
	 */
	public boolean canConnect(TrainCar other) {

		int difference;// difference in temperature between two reefer's

		// seeing if they can connect with connect method from train car
		if (super.canConnect(other)) {
			return true;
		}

		// if not see if temperature difference is 5 or less either way if both are
		// reefer's
		if (other instanceof Reefer) {
			difference = this.getTemp() - ((Reefer) other).getTemp();
			if (difference <= 5 && difference >= -5)
				return true;
		}
		return false;
	}

	/**
	 * {@summary method that sees if two cars are equal}
	 * 
	 * @param other another car of reefer or train
	 * @return true/false if cars are equal
	 */
	public boolean equals(TrainCar other) {
		// is other is not a reefer then both are different
		if (!(other instanceof Reefer))
			return false;

		// seeing if they are equal with equal method from train car
		if (super.equals(other)) {
			return true;
		}

		// if not see if temperature is the same if both are reefer's
		if (this instanceof Reefer && other instanceof Reefer) {
			if (this.getTemp() == ((Reefer) other).getTemp())
				return true;
		}
		return false;
	}
}// end of class
