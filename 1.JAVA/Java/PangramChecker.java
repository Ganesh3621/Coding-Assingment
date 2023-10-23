import java.util.Scanner;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        boolean isPangram = isPangram(input);

        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }

        scanner.close();
    }

    public static boolean isPangram(String input) {
        boolean[] alphabetPresent = new boolean[26];
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                alphabetPresent[currentChar - 'a'] = true;
            }
        }

        for (boolean isPresent : alphabetPresent) {
            if (!isPresent) {
                return false;
            }
        }

        return true;
    }
}
