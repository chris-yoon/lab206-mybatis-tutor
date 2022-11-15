package org.egovframe.lab.ex;

import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.egovframe.rte.fdl.cryptography.impl.EgovEnvCryptoServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EgovCryptoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovCryptoTest.class);
	public String algorithm = "SHA-256";
	public String algorithmKey = "egovframe";
	
	@Test
	public void testCreateAlgorithmKeyHash() {
		EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
		egovPasswordEncoder.setAlgorithm(this.algorithm);
		
		LOGGER.info("algorithmKeyHash : " + egovPasswordEncoder.encryptPassword(this.algorithmKey) );
	}

	@Test
	public void testEncryptData() {
		String driver = "net.sf.log4jdbc.DriverSpy";
		String dburl = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com?useSSL=false";
		String username = "com";
		String password = "com01";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:/context-crypto.xml"});
		EgovEnvCryptoService cryptoService = context.getBean(EgovEnvCryptoServiceImpl.class);
		
		LOGGER.info("driver="+ cryptoService.encrypt(driver));
		LOGGER.info("dburl="+ cryptoService.encrypt(dburl));
		LOGGER.info("username="+ cryptoService.encrypt(username));
		LOGGER.info("password="+ cryptoService.encrypt(password));
	}
}
