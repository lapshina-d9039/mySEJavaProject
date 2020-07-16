package darya_9039_SEproject;

public class ErrorMessage {
private ValidationResult resultOfVal;

public ErrorMessage(ValidationResult result) {
	resultOfVal = result;
}
public void display() {
	System.out.println("*****Error!*****");
	System.out.println("Invalid Symbols inputted: "+ resultOfVal.getInvalid());
	System.out.println("Valid Symbols inputted: " + resultOfVal.getValid());
}
}
