import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;   // Rectangular, Cylindrical, etc.
    private String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " Bogie carrying " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Sample data (can be modified for testing)
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );

        // Safety validation using Streams
        boolean isSafe = bogies.stream()
                .allMatch(bogie ->
                        // Rule: Cylindrical bogies must carry only Petroleum
                        !bogie.getType().equalsIgnoreCase("Cylindrical") ||
                                bogie.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Display result
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("Train is NOT SAFE!");
        }
    }
}