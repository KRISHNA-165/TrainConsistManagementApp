
import java.util.*;

    // Coach class
    class Coach {
        private String coachType;
        private int capacity;

        public Coach(String coachType, int capacity) {
            this.coachType = coachType;
            this.capacity = capacity;
        }

        public String getCoachType() {
            return coachType;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Train class
    class Train {
        private String trainName;
        private List<Coach> coaches;

        public Train(String trainName) {
            this.trainName = trainName;
            this.coaches = new ArrayList<>();
        }

        // Add coach to train
        public void addCoach(Coach coach) {
            coaches.add(coach);
        }

        // Display train consist summary
        public void displaySummary() {
            System.out.println("🚆 Train Name: " + trainName);
            System.out.println("----- Coach Details -----");

            int totalCapacity = 0;

            for (int i = 0; i < coaches.size(); i++) {
                Coach c = coaches.get(i);
                System.out.println("Coach " + (i + 1) + ": " + c.getCoachType() +
                        " | Capacity: " + c.getCapacity());
                totalCapacity += c.getCapacity();
            }

            System.out.println("--------------------------");
            System.out.println("Total Coaches: " + coaches.size());
            System.out.println("Total Capacity: " + totalCapacity);
        }
    }

    // Main class (Entry point)
    public class TrainConsistManagementApp {
        public static void main(String[] args) {

            // Initialize Train
            Train train = new Train("Chennai Express");

            // Add Coaches
            train.addCoach(new Coach("Sleeper", 72));
            train.addCoach(new Coach("AC 3 Tier", 64));
            train.addCoach(new Coach("AC 2 Tier", 48));
            train.addCoach(new Coach("General", 90));

            // Display Summary
            train.displaySummary();
        }
    }


