package com.example.demo;

import com.example.demo.restful.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//SpringBootApplication 表示是一个SpringBoot项目的主入口
//RestController 表示的是一个WEB的控制器，如果通过WEB浏览器访问则可以转发到特定的mapping
@SpringBootApplication
@Controller
@EnableAutoConfiguration
@EnableSwagger2
public class DemoApplication {

		@RequestMapping("/")
		public String index(ModelMap map) {
			// 加入一个属性，用来在模板中读取
			map.addAttribute("host", "http://blog.didispace.com");
			// return模板文件的名称，对应src/main/resources/templates/index.html
			return "index";
		}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
