package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameInverterTest {
	
	@Test(expected = NullPointerException.class)
	public void invert_null_shouldThrowNullPointerException() {
		NameInvereter.invert(null);
	}
	
	@Test
	public void invert_emptyString_shouldReturnEmptyString() {
		assertEquals(NameInvereter.invert(""), "");
	}
	
	@Test
	public void invert_emptyStringWithSpaces_shouldReturnEmptyString() {
		assertEquals(NameInvereter.invert("   "), "");
	}
	
	@Test
	public void invert_FirstNameOnly_shouldReturnFirstName() {
		assertEquals(NameInvereter.invert("John"), "John");
	}
	
	@Test
	public void invert_FirstNameOnlyWithSpaces_shouldReturnFirstName() {
		assertEquals(NameInvereter.invert("   John  "), "John");
	}
	
	@Test
	public void invert_FirstNameLastName_shouldReturnLastNameCommaFirstName() {
		assertEquals(NameInvereter.invert("John Smith"), "Smith, John");
	}
	
	@Test
	public void invert_FirstNameLastNameWithMultiSpace_shouldReturnLastNameCommaFirstName() {
		assertEquals(NameInvereter.invert("John    Smith"), "Smith, John");
	}
	
	@Test
	public void invert_NameWithKnownHonorifics_shouldReturnLastNameCommaFirstName() {
		assertEquals(NameInvereter.invert("Mr. John Smith"), "Smith, John");
		assertEquals(NameInvereter.invert("Mrs. Jane Smith"), "Smith, Jane");
		assertEquals(NameInvereter.invert("Dr. John Smith"), "Smith, John");
	}
	
	@Test
	public void invert_NameWithHonorificsWithWhiteSpaces_shouldReturnLastNameCommaFirstName() {
		assertEquals(NameInvereter.invert("Mr.   John  Smith"), "Smith, John");
	}
	
	@Test
	public void invert_NameWithPostNominal_shouldReturnLastNameCommaFirstNamePostnominal() {
		assertEquals(NameInvereter.invert("John Smith Sr."), "Smith, John Sr.");
	}
	
	@Test
	public void invert_NameWithMultiplePostNominals_shouldReturnLastNameCommaFirstNamePostnominals() {
		assertEquals(NameInvereter.invert("John Smith Sr. PhD."), "Smith, John Sr. PhD.");
	}
	
	@Test
	public void nameInverterAcceptanceTest() {
		assertEquals(NameInvereter.invert(" John    Smith  Sr.   PhD.  "), "Smith, John Sr. PhD.");
	}
}
