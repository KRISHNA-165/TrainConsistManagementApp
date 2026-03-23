import java.util.*;

// Train class
class Train {
    private String trainName;
    private LinkedHashSet<String> bogieIds; // Maintains insertion order

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieIds = new LinkedHashSet<>();
    }

    // Add bogie ID
    public void addBogieId(String bogieId) {
        if (bogieIds.add(bogieId)) {
            System.out.println("Bogie ID " + bogieId + " added.");
        } else {
            System.out.println("Duplicate Bogie ID! Cannot add: " + bogieId);
        }
    }

    // Display bogies in insertion order
    public void displayBogies() {
        System.out.println("\n Train: " + trainName);
        System.out.println("----- Bogie IDs (Insertion Order) -----");

        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}

// Main class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Adding bogie IDs
        train.addBogieId("B3");
        train.addBogieId("B1");
        train.addBogieId("B4");
        train.addBogieId("B2");
        train.addBogieId("B5");
        train.addBogieId("B3"); // Duplicate

        // Display bogies
        train.displayBogies();
    }
}


