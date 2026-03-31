import java.util.*;

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

class UseCase3TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("======================================\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase4TrainConsistMgmt
 * ================================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 *
 * @version 4.0
 */
class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("======================================\n");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase5TrainConsistMgmt
 * ================================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while also preventing duplicate entries using LinkedHashSet.
 *
 * @version 5.0
 */
class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("======================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Adding bogies (with duplicates)
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper"); // duplicate
        formation.add("Cargo");   // duplicate

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}