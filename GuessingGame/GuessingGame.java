// CS210 Assignment #5 "GuessingGame"
// ANdy Vargas Noesi
/* Guessing game: it will provide user opportunities to guess a random number from 1-100.
Once a user guesses the number, it will ask if user wants to play. If yes user get opportunity to guess a new number and
when the user decides not to play again, a result with be printed out containing total number of guesses,
total games and the best game (fewer guesses)*/

import java.util.*;

public class GuessingGame {

    public static int RAND_ORIGIN = 1;
    public static int RAND_BOUND = 101;
    public static boolean PLAY = true;
    public static int NUMBER_OF_GUESSES;
    public static int TOTAL_GAMES;
    public static int BEST_GAME;


    public static void main(String[] args) {
        double bestGame = Double.POSITIVE_INFINITY;
        while (PLAY){
            TOTAL_GAMES ++;
            int numOfGuesses = guess();
            bestGame = Math.min(bestGame, numOfGuesses);
            BEST_GAME = (int) bestGame;
            NUMBER_OF_GUESSES += numOfGuesses;
        }
        result(NUMBER_OF_GUESSES, TOTAL_GAMES, BEST_GAME);
    }
    //Creates random number that will be used until the user guesses the number
    public static int randNumber(){
        Random rand = new Random();
		return rand.nextInt(RAND_ORIGIN, RAND_BOUND);
    }
    // The brain of the game providing the guess question taking the input of the user and analyzing it.
    public static int guess(){
        int numGuess;
        int countGuesses = 0;

        Scanner console = new Scanner(System.in);
        int number = randNumber();

        System.out.printf("I'm thinking of a number between %s and %s...\n", RAND_ORIGIN, RAND_BOUND - 1);
        boolean guess = false;
            while (!guess){
                System.out.print("Your guess? ");
                numGuess = console.nextInt();

                if (numGuess < number) {
                    countGuesses++;
                    System.out.println("It's higher.");
                } else if (numGuess > number) {
                    countGuesses++;
                    System.out.println("It's lower.");
                } else {
                    countGuesses++;
                    System.out.printf("You guessed it in %s guesses!\n", countGuesses);
                    System.out.print("Play again? ");
                    String response = console.next();
                    System.out.println();
                    PLAY = playAgain(response);
                    guess = true;
                }
            }
        return countGuesses;
    }
    //Boolean will pass a response indicating if user wants to continue playing or not.
    public static boolean playAgain(String response){
        char firstCharacter = response.toLowerCase().charAt(0);
		return firstCharacter == 'y';
    }
    // Display the results, and it would be used at the end of the loop in main.
    public static void result(int numberOfGuesses, int totalGame, int bestGame){
        double averageGuessPerGame = numberOfGuesses / (double) totalGame;
        System.out.println("Your overall results:");
        System.out.printf("Total games = %s\n", totalGame);
        System.out.printf("Total guesses = %s\n", numberOfGuesses);
        System.out.printf("Guesses/game = %.1f\n", averageGuessPerGame);
        System.out.printf("Best game = %s\n", bestGame);
    }
}

