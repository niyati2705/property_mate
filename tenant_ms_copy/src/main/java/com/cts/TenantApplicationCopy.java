package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class TenantApplicationCopy {

	public static void main(String[] args) {
		SpringApplication.run(TenantApplicationCopy.class, args);
	}

}
