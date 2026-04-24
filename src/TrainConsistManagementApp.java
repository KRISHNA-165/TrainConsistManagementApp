import java.util.*;

public class TrainConsistManagementApp {

    // 🔹 Search Method with Fail-Fast Validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ✅ Defensive check (Fail-Fast)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train.");
        }

        // 🔍 Linear Search (can be replaced with binary if sorted)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // 🔸 Case 1: Empty dataset (will throw exception)
        String[] emptyBogies = {};

        try {
            System.out.println("Attempting search on empty dataset...");
            searchBogie(emptyBogies, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 🔸 Case 2: Valid dataset
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        try {
            System.out.println("\nSearching in valid dataset...");
            boolean found = searchBogie(bogieIds, "BG205");

            if (found) {
                System.out.println("Bogie FOUND.");
            } else {
                System.out.println("Bogie NOT FOUND.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 🔸 Case 3: Not found scenario
        try {
            boolean found = searchBogie(bogieIds, "BG999");

            if (found) {
                System.out.println("Bogie FOUND.");
            } else {
                System.out.println("Bogie NOT FOUND.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}