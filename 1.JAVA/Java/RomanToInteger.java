import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase(); // Convert to uppercase for case insensitivity

        int result = romanToInt(romanNumeral);

        if (result == -1) {
            System.out.println("Invalid Roman numeral.");
        } else {
            System.out.println("Integer value: " + result);
        }

        scanner.close();
    }

    public static int romanToInt(String s) {
        int result = 0;
        String romanChars = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);

            // Check if the character is a valid Roman numeral character
            if (romanChars.indexOf(currentChar) == -1) {
                return -1; // Invalid Roman numeral
            }

            int currentValue = values[romanChars.indexOf(currentChar)];

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
