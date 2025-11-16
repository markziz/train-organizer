/* 
CS 1027B – Assignment 2 
Name: Mark Ziza 
Student Number: 251442316
Email: mziza@uwo.ca
Created: Feb 18, 2025 
*/
public class Train {

	private DoubleNode<TrainCar> locomotive;// front node of train
	private DoubleNode<TrainCar> caboose;// back node of train

	/**
	 * {@summary constructor for Train class initializing the nodes}
	 */
	public Train() {
		this.locomotive = null;
		this.caboose = null;
	}

	/**
	 * {@summary getter gets locomotive node}
	 * 
	 * @return locomotive node
	 */
	public DoubleNode<TrainCar> getLocomotive() {
		return locomotive;
	}

	/**
	 * {@summary getter gets caboose node}
	 * 
	 * @return caboose node
	 */
	public DoubleNode<TrainCar> getCaboose() {
		return caboose;
	}

	/**
	 * {@summary adds a car to the train, throws TrainException if it can't because of conditions}
	 * 
	 * @param car reefer or train car being added
	 */
	public void addCar(TrainCar car) throws TrainException {

		DoubleNode<TrainCar> lNode, fNode;// last and first node in train

		lNode = getCaboose();
		fNode = getLocomotive();
		boolean carPlaced = false;// updates to true if a car was added

		// if train is empty
		if (lNode == null && fNode == null) {
			DoubleNode<TrainCar> addNode = new DoubleNode<TrainCar>(car);// addNode is node that will be added
			locomotive = addNode;
			caboose = addNode;
			carPlaced = true;
			// if not empty
		} else {
			// if it can connect to end of train
			if (car.canConnect(lNode.getElement())) {
				DoubleNode<TrainCar> addNode = new DoubleNode<TrainCar>(car);
				lNode.setNext(addNode);
				addNode.setPrevious(lNode);
				caboose = addNode;
				carPlaced = true;
				// looking to connect in middle of train
			} else {
				DoubleNode<TrainCar> node = lNode;// last node
				DoubleNode<TrainCar> pnode = lNode.getPrevious();// second last node
				// looking from back to front of train to connect in middle
				while (pnode != null) {
					if (car.canConnect(node.getElement()) && car.canConnect(pnode.getElement())) {
						DoubleNode<TrainCar> addNode = new DoubleNode<>(car);
						addNode.setPrevious(pnode);
						addNode.setNext(node);
						pnode.setNext(addNode);
						node.setPrevious(addNode);
						carPlaced = true;
						// break out of loop if a car is placed
						break;
					}
					// moving nodes one back
					node = pnode;
					pnode = pnode.getPrevious();
				} // end of while loop
			}

		} // end of if not empty else

		// if a car was not placed throw TrainException
		if (carPlaced == false) {
			throw new TrainException("Can't add car to train");
		}

	}// end of Method addCar

	/**
	 * {@summary method tries to add a car to train and catches TrainException if it can't}
	 * 
	 * @param car a reefer or train car
	 * @return true/false if car can be added
	 */
	public boolean tryAddCar(TrainCar car) {
		try {
			addCar(car);
		} catch (TrainException e) {
			return false;
		}
		return true;
	}

	/**
	 * {@summary removes a car from the train, throws TrainException if it can't because of conditions}
	 * 
	 * @param car reefer or train car being removed
	 */
	public void removeCar(TrainCar car) throws TrainException {
		DoubleNode<TrainCar> node = getLocomotive();// first node
		boolean carRemoved = false;// updates if a car is removed

		// going through whole train (if at least 1 node) to see if we can remove
		// matching node
		while (node != null && carRemoved == false) {
			// if the node given matches a node in train
			if (car.equals(node.getElement())) {
				DoubleNode<TrainCar> pNode = node.getPrevious();// previous node from one in current position
				DoubleNode<TrainCar> nNode = node.getNext();// next node from one in current position
				// if the node is in the front
				if (pNode == null) {
					if (nNode != null) {
						nNode.setPrevious(null);
						locomotive = nNode;
						carRemoved = true;
						// if the node is the only node
					} else {
						locomotive = null;
						caboose = null;
						carRemoved = true;
					}
					// if the node is at the end
				} else if (nNode == null) {
					pNode.setNext(null);
					caboose = pNode;
					carRemoved = true;
					// if the node is in the middle and node before/after can connect
				} else if (pNode.getElement().canConnect(nNode.getElement())) {
					pNode.setNext(nNode);
					nNode.setPrevious(pNode);
					carRemoved = true;
				}
			} // end of if for node given matches a node in train
				// moving to the next node in train
			node = node.getNext();
		} // end of while loop

		// if a car was not removed throw TrainException
		if (carRemoved == false) {
			throw new TrainException("No train car fit the conditions to be removed");
		}

	}// end of Method removeCar

	/**
	 * {@summary method tries to remove a car from train and catches TrainException if it can't}
	 * 
	 * @param car a reefer or train car
	 * @return true/false if car can be removed
	 */
	public boolean tryRemoveCar(TrainCar car) {
		try {
			removeCar(car);
		} catch (TrainException e) {
			return false;
		}
		return true;
	}

	/**
	 * {@summary method outputs string representation of train}
	 * 
	 * @return String containing all train/reefer cars in train and what they
	 *         contain in order of how they were added
	 */
	public String toString() {
		DoubleNode<TrainCar> node = getLocomotive();// front node
		String trainString = "";

		// if train empty
		if (node == null)
			return "The train is empty.";

		// go through train get cars info, add to string
		while (node != null) {
			// if not last car
			if (node.getNext() != null) {
				trainString = trainString + node.getElement() + ", ";
				// if last car
			} else {
				trainString = trainString + node.getElement();
			}
			// move to next node
			node = node.getNext();
		} // end of while loop
		return trainString;
	}
}// end of class
