import java.util.*;

public class TrainConsistManagementApp {

    // 🔹 Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Optimization: track if any swap happens
            boolean swapped = false;

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // 🔁 Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // 🔹 Utility to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Example dataset (can modify for testing)
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        printArray(capacities);

        // Apply Bubble Sort
        bubbleSort(capacities);

        System.out.println("After Sorting:");
        printArray(capacities);
    }
}