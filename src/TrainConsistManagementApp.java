import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔹 Input: Bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        // Before sorting
        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // 🔹 Sorting using built-in method
        Arrays.sort(bogieNames);

        // After sorting
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogieNames));
    }
}