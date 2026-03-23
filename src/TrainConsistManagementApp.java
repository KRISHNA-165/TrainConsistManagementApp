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

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    // Add bogie
    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
        System.out.println("Bogie " + bogie.getBogieId() + " added.");
    }

    // Remove bogie by ID
    public void removeBogie(String bogieId) {
        Iterator<Bogie> iterator = bogies.iterator();

        while (iterator.hasNext()) {
            Bogie b = iterator.next();
            if (b.getBogieId().equalsIgnoreCase(bogieId)) {
                iterator.remove();
                System.out.println("Bogie " + bogieId + " removed.");
                return;
            }
        }
        System.out.println("Bogie not found!");
    }

    // Display all bogies
    public void displayBogies() {
        System.out.println("\nTrain: " + trainName);
        System.out.println("----- Bogie List -----");

        if (bogies.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

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
public class TrainBogieApp {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Adding bogies
        train.addBogie(new Bogie("B1", "Sleeper", 72));
        train.addBogie(new Bogie("B2", "AC 3 Tier", 64));
        train.addBogie(new Bogie("B3", "AC 2 Tier", 48));

        // Display bogies
        train.displayBogies();

        // Remove a bogie
        train.removeBogie("B2");

        // Display after removal
        train.displayBogies();
    }
}
