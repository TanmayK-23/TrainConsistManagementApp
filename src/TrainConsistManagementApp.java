import java.util.*;
import java.util.regex.Pattern;
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
/**
 * ================================================================
 * MAIN CLASS - UseCase11TrainConsistMgmt
 * ================================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * @version 11.0
 */
class UseCase11TrainConsistMgmt {

    // Regex patterns
    private static final String TRAIN_REGEX = "TRN-\\d{4}";
    private static final String CARGO_REGEX = "[A-Z]{3}-[A-Z]{2}";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("======================================\n");

        // Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validation
        boolean isTrainValid = validateTrainId(trainId);
        boolean isCargoValid = validateCargoCode(cargoCode);

        // Output
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");
    }

    //  Methods for testing
    public static boolean validateTrainId(String trainId) {
        return Pattern.matches(TRAIN_REGEX, trainId);
    }

    public static boolean validateCargoCode(String cargoCode) {
        return Pattern.matches(CARGO_REGEX, cargoCode);
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase12TrainConsistMgmt
 * ================================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * @version 12.0
 */
class UseCase12TrainConsistMgmt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("======================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // ❌ violation

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g.type + " -> " + g.cargo);
        }

        //  SAFETY RULE USING allMatch
        boolean isSafe = goodsBogies.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }

    //  Method for testing
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase13TrainConsistMgmt
 * ================================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * @version 13.0
 */
class UseCase13TrainConsistMgmt {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("======================================\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Type" + i, i % 100));
        }

        //  Loop filtering
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = filterUsingLoop(bogies);

        long endLoop = System.nanoTime();

        //  Stream filtering
        long startStream = System.nanoTime();

        List<Bogie> streamResult = filterUsingStream(bogies);

        long endStream = System.nanoTime();

        // Results
        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));

        System.out.println("\nUC13 performance benchmarking completed...");
    }

    //  Loop logic
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    //  Stream logic
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase14TrainConsistMgmt
 * ================================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * @version 14.0
 */
class UseCase14TrainConsistMgmt {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("======================================\n");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.type + " -> " + b1.capacity);

            // Invalid case
            PassengerBogie b2 = new PassengerBogie("AC Chair", -10);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase15TrainConsistMgmt
 * ================================================================
 *
 * Use Case 15: Safe Cargo Assignment using try-catch-finally
 *
 * @version 15.0
 */
class UseCase15TrainConsistMgmt {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with validation
        void assignCargo(String cargo) {

            try {
                // Rule: Rectangular cannot carry Petroleum
                if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("======================================\n");

        // Safe case
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe case
        GoodsBogie g2 = new GoodsBogie("Rectangular");
        g2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase16TrainConsistMgmt
 * ================================================================
 *
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 *
 * @version 16.0
 */
class UseCase16TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("======================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        // Display original
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // Bubble Sort
        bubbleSort(capacities);

        // Display sorted
        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase17TrainConsistMgmt
 * ================================================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * @version 17.0
 */
class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("======================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting
        Arrays.sort(bogieNames);

        // Display sorted
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }

    public static void sortNames(String[] arr) {
        Arrays.sort(arr);
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase18TrainConsistMgmt
 * ================================================================
 *
 * Use Case 18: Linear Search for Bogie ID
 *
 * @version 18.0
 */
class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("======================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Linear Search
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        // Display result
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found.");
        }

        System.out.println("\nUC18 search completed...");
    }

    // Method for testing
    public static boolean search(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase19TrainConsistMgmt
 * ================================================================
 *
 * Use Case 19: Binary Search for Bogie ID
 *
 * @version 19.0
 */
class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("======================================\n");

        // Create sorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure sorted (precondition)
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Binary Search
        int left = 0;
        int right = bogieIds.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                found = true;
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Result
        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }

    // Method for testing
    public static boolean binarySearch(String[] arr, String key) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
/**
 * ================================================================
 * MAIN CLASS - UseCase20TrainConsistMgmt
 * ================================================================
 *
 * Use Case 20: Exception Handling During Search Operations
 *
 * @version 20.0
 */
class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("======================================\n");

        // Empty bogie list (fail-fast scenario)
        String[] bogieIds = {};

        String searchId = "BG101";

        // FAIL-FAST VALIDATION
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // Search logic
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        // Result
        if (found) {
            System.out.println("Bogie found.");
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nUC20 execution completed...");
    }

    // Method for testing
    public static boolean searchWithValidation(String[] arr, String key) {

        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }
}