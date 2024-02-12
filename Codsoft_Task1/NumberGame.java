package Codsoft_Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int rounds = 0;
        int wins = 0;
        int losses = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange);
            System.out.println("You have a total of " + attemptsLimit + " attempts for each round!");

            while (attempts < attemptsLimit) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                int difference = Math.abs(targetNumber - userGuess);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    wins++;
                    break;
                } else if (difference <= 5) {
                    if (userGuess < targetNumber) {
                        System.out.println("Very close! Try to guess a little higher. Remaining attempts: " + (attemptsLimit - attempts));
                    } else {
                        System.out.println("Very close! Try to guess a little lower. Remaining attempts: " + (attemptsLimit - attempts));
                    }
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again. Remaining attempts: " + (attemptsLimit - attempts));
                } else {
                    System.out.println("Too high! Try again. Remaining attempts: " + (attemptsLimit - attempts));
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                    losses++;
                }
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        scanner.close();
    }
}


