import java.util.*;

// Bogie class
class Bogie {
    private String name;
    private int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Display method
    public void display() {
        System.out.println("Bogie: " + name + " | Capacity: " + capacity);
    }
}

// Main class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Create list of bogies
        List<Bogie> bogieList = new ArrayList<>();

        // Add passenger bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        // Sort bogies by capacity (ascending)
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Bogies sorted by capacity (Ascending):");
        for (Bogie b : bogieList) {
            b.display();
        }

        // Optional: Sort in descending order
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nBogies sorted by capacity (Descending):");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}
