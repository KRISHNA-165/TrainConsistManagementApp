import java.util.*;

// Train class
class Train {
    private String trainName;
    private HashMap<String, Integer> bogieCapacityMap;

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieCapacityMap = new HashMap<>();
    }

    // Add or update bogie capacity
    public void addOrUpdateBogie(String bogieId, int capacity) {
        bogieCapacityMap.put(bogieId, capacity);
        System.out.println("✅ Bogie " + bogieId + " set with capacity " + capacity);
    }

    // Remove bogie
    public void removeBogie(String bogieId) {
        if (bogieCapacityMap.containsKey(bogieId)) {
            bogieCapacityMap.remove(bogieId);
            System.out.println("❌ Bogie " + bogieId + " removed.");
        } else {
            System.out.println("⚠️ Bogie not found!");
        }
    }

    // Display all bogie-capacity mappings
    public void displayBogies() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("----- Bogie Capacity Map -----");

        if (bogieCapacityMap.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie ID: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        System.out.println("------------------------------");
        System.out.println("Total Bogies: " + bogieCapacityMap.size());
    }

    // Get capacity of a specific bogie
    public void getCapacity(String bogieId) {
        if (bogieCapacityMap.containsKey(bogieId)) {
            System.out.println("🔍 Capacity of " + bogieId + ": " + bogieCapacityMap.get(bogieId));
        } else {
            System.out.println("⚠️ Bogie not found!");
        }
    }
}

// Main class
public class TrainConsistManagementApp{
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Adding bogies
        train.addOrUpdateBogie("B1", 72);
        train.addOrUpdateBogie("B2", 64);
        train.addOrUpdateBogie("B3", 48);

        // Update capacity
        train.addOrUpdateBogie("B2", 70);

        // Display
        train.displayBogies();

        // Get specific bogie capacity
        train.getCapacity("B2");

        // Remove bogie
        train.removeBogie("B3");

        // Display again
        train.displayBogies();
    }
}
