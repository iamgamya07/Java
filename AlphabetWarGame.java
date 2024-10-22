import java.util.HashMap;
import java.util.Map;

public class AlphabetWarGame {

    // Strength mappings for left and right letters
    private Map<Character, Integer> leftSide;
    private Map<Character, Integer> rightSide;

    // Constructor with default strengths
    public AlphabetWarGame() {
        leftSide = new HashMap<>();
        rightSide = new HashMap<>();

        // Default left-side strengths
        leftSide.put('w', 4);
        leftSide.put('p', 3);
        leftSide.put('b', 2);
        leftSide.put('s', 1);

        // Default right-side strengths
        rightSide.put('m', 4);
        rightSide.put('q', 3);
        rightSide.put('d', 2);
        rightSide.put('z', 1);
    }

    // Constructor where strengths can be customized
    public AlphabetWarGame(Map<Character, Integer> customLeft, Map<Character, Integer> customRight) {
        this.leftSide = customLeft;
        this.rightSide = customRight;
    }

    // Method to determine the winner (single word input)
    public String determineWinner(String battle) {
        int leftScore = 0;
        int rightScore = 0;

        // Loop through the word and calculate the score
        for (char letter : battle.toCharArray()) {
            if (leftSide.containsKey(letter)) {
                leftScore += leftSide.get(letter); // Add strength for left-side letters
            } else if (rightSide.containsKey(letter)) {
                rightScore += rightSide.get(letter); // Add strength for right-side letters
            }
        }

        return determineResult(leftScore, rightScore);
    }

    // Method to determine the winner (separate left and right words)
    public String determineWinner(String leftBattle, String rightBattle) {
        int leftScore = 0;
        int rightScore = 0;

        // Calculate the score for the left word
        for (char letter : leftBattle.toCharArray()) {
            if (leftSide.containsKey(letter)) {
                leftScore += leftSide.get(letter);
            }
        }

        // Calculate the score for the right word
        for (char letter : rightBattle.toCharArray()) {
            if (rightSide.containsKey(letter)) {
                rightScore += rightSide.get(letter);
            }
        }

        return determineResult(leftScore, rightScore);
    }

    // Helper method to determine the result based on scores
    private String determineResult(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Main method for testing the game
    public static void main(String[] args) {
        // Test with default strengths
        AlphabetWarGame game = new AlphabetWarGame();

        System.out.println(game.determineWinner("z"));          // Right side wins!
        System.out.println(game.determineWinner("zdqmwpbs"));   // Let's fight again!
        System.out.println(game.determineWinner("wwwwwwz"));    // Left side wins!
    }
}
