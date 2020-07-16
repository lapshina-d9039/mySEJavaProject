package darya_9039_SEproject;

public class UserInput {
	private String userIn;
	private boolean isValid;

	public UserInput(String in) {
		userIn = in;
	}

	public UserInput() {
	}

	public void setInput(String input) {
		userIn = input;
	}

	public String getUserIn() {
		return userIn;
	}

	public boolean getValidation() {
		return isValid;
	}

	public void setValidation() {
		isValid = true;
	}
}
