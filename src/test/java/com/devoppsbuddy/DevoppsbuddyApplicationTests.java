package com.devoppsbuddy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devoppsbuddy.web.i18n.I18NService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DevoppsbuddyApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private I18NService i18NService;
	
	public void testMessageByLocaleService(){
		String expectedResult = "A Warm Welcome i18n !";
		String messgeId = "index.main.callout";
		String actual = i18NService.getMessage(messgeId);
		org.junit.Assert.assertEquals("A Warm Welcome i18n !", expectedResult,actual);
	}

}
