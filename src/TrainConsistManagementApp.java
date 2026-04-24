import java.util.*;

// Main Application
public class TrainConsistManagementApp
{

    // 🔹 Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // 🔹 Goods Bogie Class
    static class GoodsBogie {
        private String type;   // Rectangular / Cylindrical
        private String cargo;  // Assigned cargo

        public GoodsBogie(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        // 🔹 Cargo Assignment with try-catch-finally
        public void assignCargo(String cargo) {
            try {
                // Safety rule: Rectangular bogie cannot carry Petroleum
                if (type.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe assignment: Rectangular bogie cannot carry Petroleum"
                    );
                }

                // Safe assignment
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo + " to " + type + " bogie");

            } catch (CargoSafetyException e) {
                // Handle unsafe condition
                System.out.println("Error: " + e.getMessage());

            } finally {
                // Always executes
                System.out.println("Cargo assignment attempt completed for " + type + " bogie\n");
            }
        }

        @Override
        public String toString() {
            return type + " Bogie carrying " + (cargo == null ? "Nothing" : cargo);
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical"));
        bogies.add(new GoodsBogie("Rectangular"));

        // ✅ Safe assignment
        bogies.get(0).assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled gracefully)
        bogies.get(1).assignCargo("Petroleum");

        // ✅ Another safe assignment to prove program continues
        bogies.get(1).assignCargo("Coal");

        // Display final state
        System.out.println("Final Bogie Status:");
        for (GoodsBogie b : bogies) {
            System.out.println(b);
        }
    }
}