package org.egovframe.lab.ex;

import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EgovCryptoGeneration {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovCryptoGeneration.class);

	public String algorithmKey = "egovframe";

	//algorithm (MD5, SHA-1, SHA-256)
	public String algorithm = "SHA-256";

	//block size
	public int algorithmBlockSize = 1024;

	public static void main(String[] args) {
		EgovCryptoGeneration cryptoGeneration = new EgovCryptoGeneration();

		EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
		egovPasswordEncoder.setAlgorithm(cryptoGeneration.algorithm);

		LOGGER.info("------------------------------------------------------");
		LOGGER.info("algorithm : "+cryptoGeneration.algorithm);
		LOGGER.info("algorithmKey : "+cryptoGeneration.algorithmKey);
		LOGGER.info("algorithmKeyHash : "+egovPasswordEncoder.encryptPassword(cryptoGeneration.algorithmKey));
		LOGGER.info("algorithmBlockSize  :"+cryptoGeneration.algorithmBlockSize);

	}
}
