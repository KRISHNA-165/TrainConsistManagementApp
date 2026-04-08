import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp{

    // UC11: Validate Train ID
    public static boolean isValidTrainID(String trainID) {
        // Pattern: TRN- followed by exactly 4 digits
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // UC11: Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        // Pattern: PET- followed by exactly 2 uppercase letters
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainID = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        if (isValidTrainID(trainID)) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Train ID is INVALID.");
        }

        if (isValidCargoCode(cargoCode)) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Cargo Code is INVALID.");
        }
    }
}