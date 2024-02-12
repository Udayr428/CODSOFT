package Codsoft_Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    public static void main(String[] args) {
        // Step 1: Prompt the user for input
        System.out.println("Enter text or provide a file path:");

        // Step 2: Read input text or file
        String input = getUserInput();

        // Step 3: Split the string into an array of words
        String[] words = input.split("\\s+");

        // Step 4: Initialize a counter variable
        int wordCount = words.length;

        // Step 5: Display the total count of words
        System.out.println("Total number of words: " + wordCount);

        // Step 6: Display the number of unique words
        displayUniqueWords(words);
    }

    private static String getUserInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            StringBuilder inputBuilder = new StringBuilder();

            System.out.println("1. Enter text\n2. Provide a file path");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.println("Enter your text:");
                inputBuilder.append(scanner.nextLine());
            } else if (choice == 2) {
                System.out.println("Enter the file name (including extension, e.g., demo1.txt):");
                String fileName = scanner.nextLine();

                Path filePath = Path.of(fileName);

                inputBuilder.append(Files.readString(Path.of("src/Codsoft_Task2/" + filePath)));
            } else {
                System.err.println("Invalid choice. Exiting.");
                System.exit(1);
            }

            return inputBuilder.toString();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private static void displayUniqueWords(String[] words) {
        Set<String> uniqueWords = Arrays.stream(words)
                .collect(Collectors.toSet());

        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
