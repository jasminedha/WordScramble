import java.util.Scanner;
import java.util.Random;

public class WordScrambleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"iteration", "java", "computer", "algorithm", "conditionals", "operators", "methods", "bytecode", "identifier", "static", "boolean","exceptions", "encapsulation", "constructors","accessors","mutators", "instance", "inheritance", "polymorphism", "downcasting", "recursion"};

        String wordToGuess = pickRandomWord(words);
        String scrambledWord = scrambleWord(wordToGuess);

        System.out.println("Welcome to the Word Scramble Game!");
        System.out.println("Scrambled word: " + scrambledWord);

        int attempts = 3;
        boolean hasGuessedCorrectly = false;

        while (attempts > 0) {
            System.out.println("You have " + attempts + " attempts left.");
            System.out.print("Your guess: ");
            String userGuess = scanner.nextLine();

            if (userGuess.equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed it correctly.");
                hasGuessedCorrectly = true;
                break;
            } else {
                System.out.println("Incorrect guess. Try again.");
                attempts--;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
        }
    }

    public static String pickRandomWord(String[] words) {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }

    public static String scrambleWord(String word) {
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int j = randomIndex(i, characters.length);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

    public static int randomIndex(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static boolean checkGuess(String userGuess, String wordToGuess) {
       
        boolean correct = true;
        if (userGuess.length() != wordToGuess.length()) {
            correct = false;
        } else {
            for (int i = 0; i < userGuess.length(); i++) {
                char userChar = userGuess.charAt(i);
                char targetChar = wordToGuess.charAt(i);
                if (userChar != targetChar) {
                    correct = false;
                    break;
                }
            }
        }
        return correct;
    }
}

