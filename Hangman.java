//Game: Hangman
//Program By: Chris Huynh

import java.util.Scanner;
import java.util.Random;

public class Hangman {

	public static void main (String[] args) {
		
		boolean finished = false;									//flag determines whether or not to continue the game
		
		while (finished == false) {									//if game is being played...
		
			Scanner input = new Scanner(System.in);
			String[] words = {"animal", "house", "dolphin", "cupcake", "flags", "parrot"};
			Random rand = new Random();
			int randomNumber = rand.nextInt(words.length) + 1;		
			String chosenWord = words[randomNumber - 1];			//choose a random word for the list of words
			
			char[] charArray = chosenWord.toCharArray();			//splits the chosen word into an array of characters
			char[] astArray = chosenWord.toCharArray();				//creates a copy of the characters array to be converted to '*'
			
			for (int i = 0; i < astArray.length; i++) {				//converts characters of chosen word into ****
				astArray[i] = '*';
			}
			
			boolean guessed = false;								//flag determines if word is guessed or not
			int mistakes = 0;										//counter keeps track of how many incorrect letter guesses occur
			
			while (guessed == false) {								//while word has not been solved...					
									
				boolean mistakeMade = true;
				
				System.out.print("(Guess) Enter a letter in word ");
				
				for (int i = 0; i < astArray.length; i++) {			//outputs hidden word
					System.out.print(astArray[i]);
				}
				
				System.out.print(" > ");
				char guess = input.next().charAt(0);				//user inputs a character to guess
				
				for (int i = 0; i < charArray.length; i++) {		//checks if any characters in word matches guess
					
					if (guess == charArray[i]) {					//if a match is found, that letter is unhidden
						astArray[i] = guess;						
						mistakeMade = false;	
					}
				}
				
				if (mistakeMade == true) {							//if a guess is incorrect, add a mistake
					mistakes++;
				}
				
				if (java.util.Arrays.equals(charArray, astArray)) {	//if the word is solved, show results
					guessed = true;
				}	
			}
			
			System.out.println("The word is " + chosenWord + ". You missed " + mistakes + " time(s)");	//outputs solved word and number of mistakes
			System.out.print("Do you want to guess another word? Enter y or n > ");						//asks user to play again
			if (input.next().charAt(0) == 'n'){															//if no, end program
				finished = true	;
				System.exit(0);
			} 
		}	
	}
}
