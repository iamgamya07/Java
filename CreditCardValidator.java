import java.util.Scanner;

public class CreditCardValidator {
    private String ccNumber;

    // Constructor to read the credit card number
    public CreditCardValidator(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    // Method to validate the credit card
    public void validateCard() {
        switch (validateLength()) {
            case 1:
                processCard();
                break;
            case -1:
                System.out.println("Invalid credit card number.");
                break;
            default:
                System.out.println("Error processing the card.");
                break;
        }
    }

    // Method to check if the length of the card is valid
    private int validateLength() {
        if (ccNumber.length() >= 8 && ccNumber.length() <= 9) {
            return 1;  // Valid length
        }
        return -1;  // Invalid length
    }

    // Method to process the card number (following steps a-f)
    private void processCard() {
        // Step a: Remove the last digit
        char lastDigit = ccNumber.charAt(ccNumber.length() - 1);
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);

        // Step b: Reverse the remaining digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();

        // Step c: Double the digits in odd-numbered positions and sum the digits
        int sum = 0;
        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedNumber.charAt(i));

            // Double the digits in odd positions (1st, 3rd, 5th, etc.)
            if (i % 2 == 0) {  // 0-based index: 0, 2, 4 are odd positions
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;  // Add digits of a double-digit number
                }
            }
            sum += digit;
        }

        // Step d: Subtract the last digit of the sum from 10
        int checkDigit = (10 - (sum % 10)) % 10;

        // Step f: Compare the result with the last digit from step a
        if (checkDigit == Character.getNumericValue(lastDigit)) {
            System.out.println("The credit card is valid.");
        } else {
            System.out.println("The credit card is invalid.");
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the credit card number:");
        String ccNumber = sc.nextLine();

        CreditCardValidator validator = new CreditCardValidator(ccNumber);
        validator.validateCard();
    }
}
