package darya_9039_SEproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		Scanner inputRead = new Scanner(System.in);
		UserInput userIn = new UserInput();
		
		ArrayList<ScrabbleSymbol> validSymbols = new ArrayList<ScrabbleSymbol>();
		addListOfScrabbleTiles(validSymbols);
		Validator validator = new Validator(validSymbols);
		
		HashMap<String,ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();
		createAnagrams("C:\\Users\\lapsh\\Desktop\\mySEJavaProject\\darya_9039_SEproject\\src\\darya_9039_SEproject\\dictionary.txt", dictionary);
		
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
	
	private static String sortString(String word) {
		char[] wordCharacters = word.toCharArray();
		Arrays.sort(wordCharacters);
		return new String(wordCharacters);
	}
	private static void createAnagrams(String fileName, HashMap<String, ArrayList<String>> anagramsMap)
			throws IOException {
		// reference to a file
		File f = new File(fileName);
		// set scanner to read the file
		Scanner fileRead = new Scanner(f);

		// while file has next lines
		while (fileRead.hasNext()) {
			// assign the line to the original word
			String originalWord = fileRead.next();
			// sort it to the get the sortedWord (future key)
			String sortedWord = sortString(originalWord);

			// if the hashDictionary already has the key
			if (anagramsMap.containsKey(sortedWord)) {
				// add the word to the value list of the found key
				anagramsMap.get(sortedWord).add(originalWord);

			}
			// if the key is not in the dictionary
			else {
				// create a new list
				ArrayList<String> listOfAnagrams = new ArrayList<String>();
				// add the original read word to it
				listOfAnagrams.add(originalWord);
				// and add the entry of the key and value
				anagramsMap.put(sortedWord, listOfAnagrams);
			}
		}
		// close the file
		fileRead.close();

	}

}
