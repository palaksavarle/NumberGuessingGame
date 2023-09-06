package com.first;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int minDigit = 1;
		int maxDigit = 100;
		int maxAttempts = 10;
		int score = 0;

		boolean playAgainGame = true;

		while (playAgainGame) {
			int targetNumber = random.nextInt(maxDigit - minDigit + 1) + minDigit;
			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("you have selected a number between " + minDigit + " and " + maxDigit + ".");
			System.out.println("You have " + maxAttempts + " attempts to guess the number.");

			int attempts = 0;
			boolean guessTrue = false;

			while (attempts < maxAttempts) {
				System.out.print("Enter your guess number: ");
				int userGuess = scanner.nextInt();
				attempts++;

				if (userGuess == targetNumber) {
					guessTrue = true;
					score++;
					System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly!");
					break;
				} else if (userGuess < targetNumber) {
					System.out.println("Your guess is too low. Try again.");
				} else {
					System.out.println("Your guess is too high. Try again.");
				}
			}

			if (!guessTrue) {
				System.out.println("Sorry, you've used all your attempts. The number was: " + targetNumber);
			}

			System.out.println("Your current score: " + score);

			System.out.print("Do you want to play again? (yes/no): ");
			String playAgainResponse = scanner.next();
			playAgainGame = playAgainResponse.equalsIgnoreCase("yes");
		}

		System.out.println("Thank you for playing!");
	}
}