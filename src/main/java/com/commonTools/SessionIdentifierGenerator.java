package com.commonTools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class SessionIdentifierGenerator {

	private static final Logger logger = LoggerFactory.getLogger(SessionIdentifierGenerator.class);

	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}
}