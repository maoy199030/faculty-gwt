package com.hsn.web.gwt.server.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hsn.web.gwt.client.DemoService;

/**
 * @author Hasan
 *
 */
public class DemoServiceTest {

	private final Logger logger = LoggerFactory.getLogger(DemoServiceTest.class);
	
	private DemoService service;

	public DemoServiceTest() {
		service = new DemoServiceImpl();
	}
	
	@Before
	public void setup() {
	}
	
	@Test
	public void tumPersonelListesi() {
		logger.info("testing : tumPersonelListesi");
//		service.getTumPersonelListesi();
	}
}
