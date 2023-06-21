package com.featuresaccrossprojects.featuresdata.util;

import java.math.BigInteger;
import java.util.UUID;

public class UniqueKeyGenerator {

	public static int generateUniqueInteger() {
		String generateUUIDNo = String.format("%010d",
				new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String unique_no = generateUUIDNo.substring(generateUUIDNo.length() - 9);
		int parsedString = Integer.parseInt(unique_no);
		return parsedString;
	}
}
