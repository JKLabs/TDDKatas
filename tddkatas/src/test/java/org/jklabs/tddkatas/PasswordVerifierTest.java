package org.jklabs.tddkatas;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordVerifierTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void nullPasswordShouldThrowExceptionStatingNullPassword() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NULL_NOT_ALLOWED);

		PasswordVerifier.verify(null);
	}

	@Test
	public void emptyPasswordShouldThrowExceptionStatingMinimumCharRequirement() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NEED_MIN_CHARS);

		PasswordVerifier.verify("");
	}

	@Test
	public void passwordLessThan8CharactersShouldThrowExceptionStatingIt() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NEED_MIN_CHARS);

		PasswordVerifier.verify("yu32s");
	}

	@Test
	public void passwordWithotUpperCaseCharacterShouldThrowExceptionStatingIt() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NEED_UPPER_CASE);

		PasswordVerifier.verify("yu32sufods");
	}

	@Test
	public void passwordWithoutLowerCaseCharacterShouldThrowExceptionStatingIt() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NEED_LOWER_CASE);

		PasswordVerifier.verify("93YHDSOI0");
	}

	@Test
	public void passwordWithoutNumericShouldThrowExceptionStatingIt() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(PasswordErrorMessage.NEED_NUMERIC);

		PasswordVerifier.verify("asdasqOIS");
	}

	@Test
	public void validPasswordShouldBeAccepted() {
		PasswordVerifier.verify("Eldo123Joseph");
	}
}
