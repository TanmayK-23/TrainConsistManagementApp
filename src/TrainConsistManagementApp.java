import java.util.ArrayList;
import java.util.List;

/**
 * ================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ================================================================
 *
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Train Consist Management System.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message
 * - Confirms system startup
 *
 * @author Developer
 * @version 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Train Consist Management System");
        System.out.println("System initialized successfully.");
    }
}

/**
 * ================================================================
 * CLASS - Train
 * ================================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * Demonstrates CRUD operations using ArrayList.
 *
 * @version 2.0
 */
class Train {

    private List<String> bogies = new ArrayList<>();

    public void addBogie(String bogie) {
        bogies.add(bogie);
    }

    public void removeBogie(String bogie) {
        bogies.remove(bogie);
    }

    public boolean containsBogie(String bogie) {
        return bogies.contains(bogie);
    }

    public void displayConsist() {
        System.out.println(bogies);
    }

    @Override
    public String toString() {
        return bogies.toString();
    }
}

/**
 * ================================================================
 * MAIN CLASS - UseCase2TrainConsistMgmt
 * ================================================================
 *
 * @version 2.0
 */
class UseCase2TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("======================================\n");

        Train train = new Train();

        // CREATE
        train.addBogie("Sleeper");
        train.addBogie("AC Chair");
        train.addBogie("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + trainConsistToString(train));

        // DELETE
        train.removeBogie("AC Chair");
        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + trainConsistToString(train));

        // READ
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + train.containsBogie("Sleeper"));

        // FINAL STATE
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(trainConsistToString(train));

        System.out.println("\nUC2 operations completed successfully...");
    }

    private static String trainConsistToString(Train train) {
        return train.toString().replace("Train Consist: ", "");
    }
}
