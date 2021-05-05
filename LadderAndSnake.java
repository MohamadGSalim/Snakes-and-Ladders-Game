
/** 
 * This program describes a Snakes and Ladders Game where different functions of the game are constructed in the code. 
 * Players take turns playing the game by flipping dice and the winner is the first to reach square 100 of the game. 
 */

/**
 * The LadderAndSnake class contains most methods, attributes and constructors used to implement and run the game.
 */
public class LadderAndSnake {
	/**
	 * A static variable which stores number of players
	 */
	public static int numberOfPlayers; 
	/**
	 * A variable which stores the the player number (order)
	 */
	public int playerNumber;
	/**
	 * A variable which stores the number rolled by the player dice
	 */
	public int playerRoll;
	/**
	 * A variable which keeps track of the player's position on the game board
	 */
	public int playerPosition; 

	/**
	 * The LadderAndSnake constructor is used to initialize an object (player) once created	
	 * @param playerNumber the player number (order) initialized according to order of objects creation 
	 * @param playerRoll the roll number initialized to 0
	 * @param playerPosition the roll number initialized to 0
	 */
	public LadderAndSnake (int playerNumber, int playerRoll, int playerPosition) {
		this.playerNumber = playerNumber;
		this.playerRoll = playerRoll;
		this.playerPosition = playerPosition;
	}

	/**
	 * The flipDice method is the method responsible to roll the dice	
	 * @return a random roll number between 1 and 6 is output 
	 */
	public static int flipDice() {
		int dice = (int) (Math.random() * 6) + 1;
		return dice;
	}

	/**
	 * The getPlayerNumber method is used to get the player number specific to an object (player)
	 * @return the player number is output
	 */
	public int getPlayerNumber() {
		return this.playerNumber; 
	}

	/**
	 * The getPlayerRoll method is used to get the player roll specific to an object (player)
	 * @return the player roll is output
	 */
	public int getPlayerRoll() {
		return this.playerRoll; 
	}

	/**
	 * The getPlayerPosition method is used to get the player position specific to an object (player)
	 * @return the player position is output
	 */
	public int getPlayerPosition() {
		return this.playerPosition; 
	}

	/**
	 * The setNumberOfPlayers is a static method used to set the number of players taken from user from main method in the driver program
	 * @param numberOfPlayers the number of players taken from user
	 */
	public static void setNumberOfPlayers(int numberOfPlayers) {
		LadderAndSnake.numberOfPlayers = numberOfPlayers;
	}


	/**
	 * The play method is a static method which initiates the core engine of the game where players start to play the game
	 */
	public static void play() {
		LadderAndSnake players [] = new LadderAndSnake [numberOfPlayers]; // Creating an Array of variable number of Objects of type LadderAndSnake
		for (int i = 0; i < players.length; i++) {
			players [i] = new LadderAndSnake((i + 1), 0, 0); // Initializing each object in the array with its appropriate parameters
		}
		System.out.println("Game is Played by " + numberOfPlayers + " players;");
		System.out.println("Now deciding which player will start playing;");


		for (int i = 0; i < players.length; i++) {
			players[i].playerRoll = flipDice(); // Rolling the dice for each player
			System.out.println("Player " + (i + 1) + " got a dice value of " + players[i].getPlayerRoll());
		}


		for (int i = 0; i < players.length; i++) { // Checking for ties between players
			for(int j = i + 1; j < players.length; j++) {


				while((i != j) && (players[i].getPlayerRoll() == players[j].getPlayerRoll())) {
					System.out.println("A tie was achieved between Player " + (i + 1) + " and Player " + (j + 1) + ". Attempting to break the tie");



					players[i].playerRoll = flipDice(); // Reroll if tie is found
					System.out.println("Player " + (i + 1) + " got a dice value of " + players[i].getPlayerRoll());

					players[j].playerRoll = LadderAndSnake.flipDice();
					System.out.println("Player " + (j + 1) + " got a dice value of " + players[j].getPlayerRoll());
				}
			}
		}

		for (int i = 0; i < players.length; i++) { // Rechecking for a tie between players to make sure no more ties are there
			for (int j = i + 1; j < players.length; j++) {
				if (i != j && (players[i].getPlayerRoll() == players[j].getPlayerRoll())) {
					for (int k = 0; k < players.length; k++) {
						for(int n = k + 1; n < players.length; n++) {


							while(k != n && (players[n].getPlayerRoll() == players[k].getPlayerRoll())) {
								System.out.println("A tie was achieved between Player " + (k + 1) + " and Player " + (n + 1) + ". Attempting to break the tie");



								players[k].playerRoll = flipDice(); // Reroll the dice if tie is found
								System.out.println("Player " + (k + 1) + " got a dice value of " + players[k].getPlayerRoll());

								players[n].playerRoll = flipDice();
								System.out.println("Player " + (n + 1) + " got a dice value of " + players[n].getPlayerRoll());
							}
						}
					}
				}
			}
		}	

		for (int i = 0; i < players.length; i++) { // Using bubble sort method to sort the array so that order of players is determined
			for (int j = i + 1; j < players.length; j++){

				if(players[j].getPlayerRoll() > players[i].getPlayerRoll()) {
					int tempPlayerNumber = players[i].getPlayerNumber();
					int tempPlayerRoll = players[i].getPlayerRoll();
					players[i].playerNumber = players[j].getPlayerNumber();
					players[i].playerRoll = players[j].getPlayerRoll();
					players[j].playerNumber = tempPlayerNumber;
					players[j].playerRoll = tempPlayerRoll;
				}
			}
		}

		System.out.print("Reached final decision on order of playing:");
		for (int i = 0; i < players.length; i++) {
			System.out.print(" Player " + players[i].getPlayerNumber());
			if (i < players.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();

		int laddersArray [] = new int [9]; // Declaring and filling an array with the set of ladders
		laddersArray [0] = 1;
		laddersArray [1] = 4;
		laddersArray [2] = 9;
		laddersArray [3] = 21;
		laddersArray [4] = 28;
		laddersArray [5] = 36;
		laddersArray [6] = 51;
		laddersArray [7] = 71;
		laddersArray [8] = 80;

		int positionAfterLadder [] = new int [9]; // Declaring and filling and array with set of positions attained after landing over a certain ladder
		positionAfterLadder [0] = 38;
		positionAfterLadder [1] = 14;
		positionAfterLadder [2] = 31;
		positionAfterLadder [3] = 42;
		positionAfterLadder [4] = 84;
		positionAfterLadder [5] = 44;
		positionAfterLadder [6] = 67;
		positionAfterLadder [7] = 91;
		positionAfterLadder [8] = 100;

		int snakesArray [] = new int [8]; // Declaring and filling an array with the set of snakes
		snakesArray [0] = 16;
		snakesArray [1] = 48;
		snakesArray [2] = 64;
		snakesArray [3] = 79;
		snakesArray [4] = 93;
		snakesArray [5] = 95;
		snakesArray [6] = 97;
		snakesArray [7] = 98;

		int positionAfterSnake [] = new int [8]; // Declaring and filling and array with set of positions attained after landing over a certain snake
		positionAfterSnake [0] = 6;
		positionAfterSnake [1] = 30;
		positionAfterSnake [2] = 60;
		positionAfterSnake [3] = 19;
		positionAfterSnake [4] = 68;
		positionAfterSnake [5] = 24;
		positionAfterSnake [6] = 76;
		positionAfterSnake [7] = 78;

		loop1:
			while (players[0].playerPosition != 100) { // A useless condition just used to get into the loop of the engine of the game

				loop2:
					for (int i = 0; i < numberOfPlayers; i++) {

						players[i].playerRoll = flipDice(); // For each player the dice is rolled
						players[i].playerPosition = players[i].getPlayerPosition() + players[i].getPlayerRoll(); // Position of each player is stored

						for (int j = 0; j < laddersArray.length; j++) { // Checking if player landed on a ladder
							if (players[i].getPlayerPosition() == laddersArray[j]) {
								System.out.print("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPlayerRoll() + "; gone to square " + players[i].getPlayerPosition());
								players[i].playerPosition = positionAfterLadder[j];
								System.out.println(" then up to square " + players[i].getPlayerPosition());
								if (players[i].getPlayerPosition() == 100) { // Checking if player has landed on square 100 and has won 
									System.out.println("Player " + players[i].getPlayerNumber() + " has won the game!");
									break loop1;  
								} else {
									continue loop2;
								}
							}
							if (players[i].getPlayerPosition() == 100) { // Checking if player has landed on square 100 and has won
								System.out.println("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPlayerRoll() + "; now in square " + players[i].getPlayerPosition());
								System.out.println("Player " + players[i].getPlayerNumber() + " has won the game!");
								break loop1;
							} else { 
								if (players[i].getPlayerPosition() > 100) { // Checking if player has exceeded the maximum number of possible moves when near square 100
									players[i].playerPosition = players[i].getPlayerPosition() - (2 * (players[i].getPlayerPosition() - 100));
									System.out.println("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPlayerRoll() + "; moved to square 100 then backwards to square " + players[i].getPlayerPosition());
								}
								for (int k = 0; k < snakesArray.length; k++) { // Checking if player has landed on a snake
									if (players[i].getPlayerPosition() == snakesArray[k]) {
										System.out.print("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPlayerRoll() + "; gone to square " + players[i].getPlayerPosition());
										players[i].playerPosition = positionAfterSnake[k];
										System.out.println(" then down to square " + players[i].getPlayerPosition());
										continue loop2;
									}
								}
							}
						}
						System.out.println("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPlayerRoll() + "; now in square " + players[i].getPlayerPosition());	
					}
		System.out.println("Game not over; flipping again");

			}
	}  
}