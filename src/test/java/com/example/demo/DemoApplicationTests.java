package com.example.demo;

import com.example.demo.dao.UserService;
import com.example.demo.restful.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setUp(){
		userService.deleteAllUsers();
	}

	@Test
	public void test() throws Exception{
		userService.create("a",1);
		userService.create("b",1);
		userService.create("c",1);
		userService.create("d",1);
		userService.create("e",1);
		Assert.assertEquals(5,userService.getUserCount().intValue());

		userService.deleteByName("a");
		userService.deleteByName("b");
		Assert.assertEquals(3,userService.getUserCount().intValue());

		System.out.println(userService.getAllUsers());
	}
}
