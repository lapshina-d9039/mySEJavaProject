package darya_9039_SEproject;

import java.util.ArrayList;

public class Validator implements IValidator {
	private ArrayList<ScrabbleSymbol> validSymbols;
	private ValidationResult result;

	public Validator( ArrayList<ScrabbleSymbol> alphabet) {
		validSymbols = alphabet;
	}

	public ValidationResult getResult() {
		return result;
	}

	public boolean validate(UserInput userIn) {

		String invalid = "";
		String valid = "";
		boolean[] validFlag = new boolean[userIn.getUserIn().length()];
		for (int i = 0; i < userIn.getUserIn().length(); i++) {
			for (ScrabbleSymbol obj : validSymbols) {
				if (obj.getLetter() == userIn.getUserIn().charAt(i)) {
					validFlag[i] = true;
					break;
				}
			}
		}
		for (int i = 0; i < validFlag.length; i++) {
			if (validFlag[i] == false)
				invalid = invalid + " " + userIn.getUserIn().charAt(i);
			else
				valid = valid + " " + userIn.getUserIn().charAt(i);
		}
		result = new ValidationResult(invalid, valid);
		for (int i = 0; i < validFlag.length; i++) {
			if (validFlag[i] == false)
				return false;
		}
		return true;

	}
}
