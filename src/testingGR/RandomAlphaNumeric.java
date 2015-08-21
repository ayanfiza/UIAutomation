package testingGR;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphaNumeric {

	public String randomAlphanumeric() {
		String string = RandomStringUtils.random(64, false, true);
		string = RandomStringUtils.random(7, 0, 36, true, true, "abcdefchijklmnopqrstuvwxyz1234567890".toCharArray());
		return string;
	}

}
