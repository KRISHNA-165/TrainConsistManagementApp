import java.util.*;

// Bogie class
class Bogie {
    private String bogieId;
    private String bogieType;
    private int capacity;

    public Bogie(String bogieId, String bogieType, int capacity) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Train class
class Train {
    private String trainName;
    private ArrayList<Bogie> bogies;
    private HashSet<String> bogieIds; // To track unique IDs

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
    }

    // Add bogie with uniqueness check
    public void addBogie(Bogie bogie) {
        if (bogieIds.contains(bogie.getBogieId())) {
            System.out.println("❌ Duplicate Bogie ID! Cannot add: " + bogie.getBogieId());
            return;
        }

        bogies.add(bogie);
        bogieIds.add(bogie.getBogieId());
        System.out.println("✅ Bogie " + bogie.getBogieId() + " added successfully.");
    }

    // Display bogies
    public void displayBogies() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("----- Bogie List -----");

        for (Bogie b : bogies) {
            System.out.println("ID: " + b.getBogieId() +
                    " | Type: " + b.getBogieType() +
                    " | Capacity: " + b.getCapacity());
        }

        System.out.println("----------------------");
        System.out.println("Total Bogies: " + bogies.size());
    }
}

// Main class
public class TrainConsistManagementApp
{
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Adding bogies
        train.addBogie(new Bogie("B1", "Sleeper", 72));
        train.addBogie(new Bogie("B2", "AC 3 Tier", 64));
        train.addBogie(new Bogie("B1", "General", 90)); // Duplicate

        // Display
        train.displayBogies();
    }
}

