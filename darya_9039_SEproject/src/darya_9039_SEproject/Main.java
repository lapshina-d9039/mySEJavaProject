package darya_9039_SEproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inputRead = new Scanner(System.in);
		UserInput userIn = new UserInput();
		ArrayList<ScrabbleSymbol> validSymbols = new ArrayList<ScrabbleSymbol>();
		
		addListOfScrabbleTiles(validSymbols);
		Validator validator = new Validator(validSymbols);
		do {
			System.out.println("Input letters to get words that can be formed:");
			String userInput = inputRead.nextLine().toLowerCase();
			userIn.setInput(userInput);
			
			if (validator.validate(userIn)) {
				userIn.setValidation();
			}
			else {
				ErrorMessage error = new ErrorMessage(validator.getResult());
				error.display();
			}
		} while (!userIn.getValidation());

	}

	public static void addListOfScrabbleTiles(ArrayList<ScrabbleSymbol> validSymbols) {
		for (char i = 'a'; i <= 'z'; i++) {
			int pointValue = 1;
			if (i == 'd' || i == 'g')
				pointValue++;
			else if (i == 'b' || i == 'c' || i == 'm' || i == 'p')
				pointValue = 3;
			else if (i == 'f' || i == 'h' || i == 'v' || i == 'w' || i == 'y')
				pointValue = 4;
			else if (i == 'k')
				pointValue = 5;
			else if (i == 'j' || i == 'x')
				pointValue = 8;
			else if (i == 'q' || i == 'z')
				pointValue = 10;
			validSymbols.add(new ScrabbleSymbol(i, pointValue));
		}
		validSymbols.add(new ScrabbleSymbol('*', 0));
	}

}
