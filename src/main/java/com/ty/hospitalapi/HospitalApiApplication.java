package com.ty.hospitalapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class HospitalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApiApplication.class, args);
	}
	
	List<VendorExtension> vendorExtenstions=new ArrayList<VendorExtension>();
	Contact contact=new Contact("prashanta","https://testyantra.com","pph@gmail.com");
	ApiInfo apiInfo=new ApiInfo("TestYantra Hospital App", 
			"API's to person all action related to Hospital App",
			"Snapchrat-0.01",
			"https://testyantragloble.com",
			contact,
			"www.ty.com",
			"teasers and cnditions",
			vendorExtenstions);
	
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo);
	}

}
