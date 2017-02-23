package org.jklabs.tddkatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInvereter {

	public static String invert(String name) {

		List<String> nameParts = breakIntoNamePartsIgnoringSpaces(name);

		Honorifics.removeHonorifics(nameParts);

		// First Name only
		if (nameParts.size() < 2) {
			return nameParts.get(0);
		}

		return invert(nameParts);
	}

	private static String invert(List<String> nameParts) {
		String firstName = nameParts.get(0);
		String lastName = nameParts.get(1);
		String postNominal = findAndExtractPostNominals(nameParts);

		return String.format("%s, %s %s", lastName, firstName, postNominal).trim();
	}

	private static String findAndExtractPostNominals(List<String> nameParts) {
		String postNominal = "";
		for (String namePart : nameParts.subList(2, nameParts.size())) {
			postNominal += namePart + " ";
		}
		
		return postNominal;
	}

	private static List<String> breakIntoNamePartsIgnoringSpaces(String name) {
		return new ArrayList<String>(Arrays.asList(
				name.trim().split(RegulasrExpressions.ANY_NUMBER_OF_SPACES)));
	}

}

class RegulasrExpressions {
	public static final String ANY_NUMBER_OF_SPACES = "\\s+";
}

class Honorifics {
	private static List<String> knownHonorifics = Arrays.asList(
			"Mr.", "Mrs.", "Dr.");
	
	public static void removeHonorifics(List<String> nameParts) {
		if (knownHonorifics.contains(nameParts.get(0))) {
			nameParts.remove(0);
		}
	}
}