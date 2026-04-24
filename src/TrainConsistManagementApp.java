import java.util.*;

public class TrainConsistApp {

    // 🔹 Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found → stop early
            }
        }

        return false; // No match found
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Input: Unsorted bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key (can modify for testing)
        String searchKey = "BG309";

        // Perform search
        boolean found = linearSearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND in the train.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND.");
        }
    }
}