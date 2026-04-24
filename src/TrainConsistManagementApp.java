import java.util.*;

public class TrainConsistManagementApp {

    // 🔹 Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                return true; // Found
            }
            else if (result < 0) {
                high = mid - 1; // Search left half
            }
            else {
                low = mid + 1; // Search right half
            }
        }

        return false; // Not found
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Input (can be unsorted)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Search key
        String searchKey = "BG205";

        // 🔹 Ensure sorting before binary search
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        // Handle empty array safely
        if (bogieIds.length == 0) {
            System.out.println("No bogies available.");
            return;
        }

        // Perform binary search
        boolean found = binarySearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND in the train.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND.");
        }
    }
}