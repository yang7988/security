package com.rayvision.security;

import com.rayvision.SecurityAdminApplication;
import com.rayvision.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityAdminApplication.class)
public class SecurityAdminApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private HomeController homeController;

	@Test
	public void testDataSource() throws Exception{
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testController() throws Exception{
		System.out.println(homeController.foos());
	}

}
