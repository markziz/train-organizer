import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Train myTrain = new Train();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Train Simulator!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a TrainCar");
            System.out.println("2. Add a Reefer");
            System.out.println("3. Remove a TrainCar/Reefer");
            System.out.println("4. Display Train");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter freight: ");
                        String freight = sc.nextLine();
                        System.out.print("Enter weight: ");
                        int weight = sc.nextInt();
                        sc.nextLine();
                        TrainCar car = new TrainCar(weight, freight);
                        if (myTrain.tryAddCar(car))
                            System.out.println("TrainCar added successfully!");
                        else
                            System.out.println("TrainCar could not be added.");
                        break;

                    case 2:
                        System.out.print("Enter freight: ");
                        String rFreight = sc.nextLine();
                        System.out.print("Enter weight: ");
                        int rWeight = sc.nextInt();
                        System.out.print("Enter temperature (C): ");
                        int temp = sc.nextInt();
                        sc.nextLine();
                        Reefer reefer = new Reefer(rWeight, temp, rFreight);
                        if (myTrain.tryAddCar(reefer))
                            System.out.println("Reefer added successfully!");
                        else
                            System.out.println("Reefer could not be added.");
                        break;

                    case 3:
                        System.out.print("Enter freight of car to remove: ");
                        String rFreightRemove = sc.nextLine();
                        System.out.print("Enter weight of car to remove: ");
                        int rWeightRemove = sc.nextInt();
                        sc.nextLine();
                        TrainCar removeCar = new TrainCar(rWeightRemove, rFreightRemove);
                        if (myTrain.tryRemoveCar(removeCar))
                            System.out.println("Car removed successfully!");
                        else
                            System.out.println("No matching car could be removed.");
                        break;

                    case 4:
                        System.out.println("\nCurrent Train:");
                        System.out.println(myTrain.toString());
                        break;

                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (TrainException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}