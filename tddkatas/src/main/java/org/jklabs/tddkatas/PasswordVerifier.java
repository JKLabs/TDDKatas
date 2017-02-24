package org.jklabs.tddkatas;

public class PasswordVerifier {
	
	public static void verify(String password) {
		if (password == null)
			throw new IllegalArgumentException(PasswordErrorMessage.NULL_NOT_ALLOWED);
		
		if (password.length() < 8)
			throw new IllegalArgumentException(PasswordErrorMessage.NEED_MIN_CHARS);
		
		handleMandatoryCasesMissingScenario(password);
		
		handleMissingNumericScenario(password);
	}

	private static void handleMissingNumericScenario(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return;
			}
		}
		
		throw new IllegalArgumentException(PasswordErrorMessage.NEED_NUMERIC);
	}

	private static void handleMandatoryCasesMissingScenario(String password) {
		boolean upperCaseCharFound = false;
		boolean lowerCaseCharFound = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				upperCaseCharFound = true;
			}
			
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCaseCharFound = true;
			}
			
			if (upperCaseCharFound && lowerCaseCharFound)
				return;
		}
		
		if (!upperCaseCharFound) {
			throw new IllegalArgumentException(PasswordErrorMessage.NEED_UPPER_CASE);
		}
		
		if (!lowerCaseCharFound) {
			throw new IllegalArgumentException(PasswordErrorMessage.NEED_LOWER_CASE);
		}
	}
	
}

class PasswordErrorMessage {
	public static final String NULL_NOT_ALLOWED = "Null is not allowed";
	public static final String NEED_MIN_CHARS = "Password should have atleast eight characters";
	public static final String NEED_NUMERIC = "Password should have atleast one number";
	public static final String NEED_UPPER_CASE = "Password should have atleast one upper case character";
	public static final String NEED_LOWER_CASE = "Password should have atleast one lower case character";
}
