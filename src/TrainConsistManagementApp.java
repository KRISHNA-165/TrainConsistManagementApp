import java.util.*;
import java.util.stream.*;

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Create dataset (large dataset for meaningful comparison)
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new PassengerBogie("Sleeper", (i % 100) + 1));
        }

        // -------------------------------
        // Loop-Based Filtering
        // -------------------------------
        long loopStart = System.nanoTime();

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopResult.add(bogie);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // Stream-Based Filtering
        // -------------------------------
        long streamStart = System.nanoTime();

        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // -------------------------------
        // Output Results
        // -------------------------------
        System.out.println("Loop Result Count   : " + loopResult.size());
        System.out.println("Stream Result Count : " + streamResult.size());

        System.out.println("Loop Execution Time   : " + loopTime + " ns");
        System.out.println("Stream Execution Time : " + streamTime + " ns");

        // Consistency Check
        if (loopResult.size() == streamResult.size()) {
            System.out.println("✅ Results Match");
        } else {
            System.out.println("❌ Results Do NOT Match");
        }
    }
}