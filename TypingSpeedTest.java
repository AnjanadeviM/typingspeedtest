import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sentences = {
            "Java is a versatile programming language.",
            "Typing speed is measured in words per minute.",
            "Accuracy is important in typing tests.",
            "Practice improves performance.",
            "Simple projects help improve coding skills."
        };

        boolean continueTest = true;

        while (continueTest) {
            // Select a random sentence
            String sentence = getRandomSentence(sentences);
            System.out.println("\nType the following sentence:");
            System.out.println("\"" + sentence + "\"");
            System.out.println("\nPress Enter when ready...");
            scanner.nextLine();

            // Start timer
            long startTime = System.currentTimeMillis();

            // Get user input
            System.out.println("Start typing:");
            String userInput = scanner.nextLine();

            // End timer
            long endTime = System.currentTimeMillis();
            long timeTakenMillis = endTime - startTime;
            double timeTakenSeconds = timeTakenMillis / 1000.0;

            // Calculate WPM
            int wordCount = userInput.trim().isEmpty() ? 0 : userInput.trim().split("\\s+").length;
            double wpm = (wordCount / timeTakenSeconds) * 60;

            // Calculate Accuracy
            double accuracy = calculateAccuracy(sentence, userInput);

            // Show results
            System.out.println("\n--- Test Result ---");
            System.out.printf("Time Taken: %.2f seconds\n", timeTakenSeconds);
            System.out.printf("Words Per Minute (WPM): %.2f\n", wpm);
            System.out.printf("Accuracy: %.2f%%\n", accuracy);

            // Option to restart
            System.out.print("\nDo you want to try again? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueTest = false;
                System.out.println("Thanks for using the Typing Speed Test!");
            }
        }

        scanner.close();
    }

    // Method to select a random sentence
    public static String getRandomSentence(String[] sentences) {
        Random random = new Random();
        return sentences[random.nextInt(sentences.length)];
    }

    // Method to calculate typing accuracy
    public static double calculateAccuracy(String original, String typed) {
        int correctChars = 0;
        int minLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correctChars++;
            }
        }

        return ((double) correctChars / original.length()) * 100;
    }
}
