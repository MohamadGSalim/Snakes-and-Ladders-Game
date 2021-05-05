
/** 
 * This program describes a Snakes and Ladders Game where different functions of the game are constructed in the code. 
 * Players take turns playing the game by flipping dice and the winner is the first to reach square 100 of the game. 
 */

/**
 * The Scanner class is imported to allow user input
 */
import java.util.Scanner;
/**
 * The PlayLadderAndSnake class is a driver class which contains the main method where the game program is supposed to be launched from
 */
public class PlayLadderAndSnake {
	/**
	 * This is the "main" method which drives the program
	 */
	public static void main(String [] args) {

		System.out.println("-------------------------------------------Snakes and Ladders Game-------------------------------------------");
		System.out.println("Welcome to Snakes and Ladders Game !!\n");
		System.out.println("Enter the # of players for your game – Number must be between 2 and 4 inclusively:");


		Scanner input = new Scanner(System.in); // Created an object of class Scanner to allow user input


		int numberOfPlayers = input.nextInt();
		int numberOfAttempts = 1;
		while((numberOfPlayers < 2 || numberOfPlayers > 4) && numberOfAttempts < 4) { // Checking for number of attempts and if user has input a valid number of players
			System.out.println("Bad Attempt " + numberOfAttempts + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
			numberOfPlayers = input.nextInt();
			numberOfAttempts++;
		}
		if((numberOfAttempts == 4) && (numberOfPlayers < 2 || numberOfPlayers > 4)) { // Terminating the program if the user has exceeded 4 attempts of incorrect number of players entry
			System.out.println("Bad Attempt 4! You have exhausted all your chances. Program will terminate!");
			System.exit(0);
		}

		LadderAndSnake.setNumberOfPlayers(numberOfPlayers); // Setting the number of players attribute in the class LadderAndSnake
		LadderAndSnake.play(); // Calling the play method to start the core engine of the game
		System.out.println("\nGame Over. Thank you for playing Snakes and Ladders Game. Have a wonderful day!");
		input.close(); // Closing the Scanner object
	}

}
