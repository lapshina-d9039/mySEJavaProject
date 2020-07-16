package darya_9039_SEproject;

public class ScrabbleSymbol {
	private char scrabbleLetter;
	private int scrabbleValue;
	private boolean isWildcard;

	public ScrabbleSymbol(char ch, int val) {
		scrabbleLetter = ch;
		scrabbleValue = val;
		if (ch == '*') {
			isWildcard = true;
		} else
			isWildcard = false;
	}
	
	public int getValue() {
		return scrabbleValue;
	}
	public char getLetter() {
		return scrabbleLetter;
	}
	public boolean getWild() {
		return isWildcard;
	}

}
