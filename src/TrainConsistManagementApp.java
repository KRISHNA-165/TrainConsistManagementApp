import java.util.*;

// Train class
class Train {
    private String trainName;
    private SortedSet<String> bogieIds; // Sorted & unique

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieIds = new TreeSet<>();
    }

    // Add bogie ID
    public void addBogieId(String bogieId) {
        if (bogieIds.add(bogieId)) {
            System.out.println("✅ Bogie ID " + bogieId + " added.");
        } else {
            System.out.println("❌ Duplicate Bogie ID! Cannot add: " + bogieId);
        }
    }

    // Display sorted bogie IDs
    public void displayBogieIds() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("----- Sorted Bogie IDs -----");

        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println("----------------------------");
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }

    // Show first and last bogie (extra feature)
    public void showFirstAndLast() {
        if (bogieIds.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        System.out.println("🔹 First Bogie: " + bogieIds.first());
        System.out.println("🔹 Last Bogie: " + bogieIds.last());
    }
}

// Main class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Adding bogie IDs (unordered input)
        train.addBogieId("B3");
        train.addBogieId("B1");
        train.addBogieId("B2");
        train.addBogieId("B5");
        train.addBogieId("B4");
        train.addBogieId("B2"); // Duplicate

        // Display sorted order
        train.displayBogieIds();

        // Show first & last
        train.showFirstAndLast();
    }
}


