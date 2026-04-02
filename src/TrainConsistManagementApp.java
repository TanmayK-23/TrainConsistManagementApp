import java.util.*;
import java.util.stream.Collectors;

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
/**
 * ================================================================
 * MAIN CLASS - UseCase6TrainConsistMgmt
 * ================================================================
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This class associates each bogie with its seating or
 * load capacity using a key-value mapping structure.
 *
 * @version 6.0
 */
class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("======================================\n");

        // HashMap stores data in key -> value format
        Map<String, Integer> capacityMap = new HashMap<>();

        // ---- Insert bogie capacities ----
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");

        // Iterate through map
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase7TrainConsistMgmt
 * ================================================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 *
 * @version 7.0
 */
class UseCase7TrainConsistMgmt {

    // Inner Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("======================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Before sorting
        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Sort using Comparator (ascending capacity)
        bogies.sort((b1, b2) -> b1.capacity - b2.capacity);

        // After sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase8TrainConsistMgmt
 * ================================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * @version 8.0
 */
class UseCase8TrainConsistMgmt {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // 🔥 METHOD (IMPORTANT for test cases)
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("======================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Filter > 60
        List<Bogie> filtered = filterBogies(bogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 filtering completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase9TrainConsistMgmt
 * ================================================================
 *
 * Use Case 9: Group Bogies by Type
 *
 * @version 9.0
 */
class UseCase9TrainConsistMgmt {

    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }
    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("======================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        // Display all bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped result
        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * ================================================================
 *
 * Use Case 10: Count Total Seats in Train
 *
 * @version 10.0
 */
class UseCase10TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("======================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        //  REDUCE OPERATION
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + total);

        System.out.println("\nUC10 aggregation completed...");
    }

    //  METHOD FOR TESTING
    public static int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }
}