package darya_9039_SEproject;

public class ValidationResult {
	private String invalidCharacters;
	private String validCharacters;

	public ValidationResult(String invalid, String valid) {
		invalidCharacters = invalid;
		validCharacters = valid;
	}

	public String getInvalid() {
		return invalidCharacters;
	}

	public String getValid() {
		return validCharacters;
	}
}
