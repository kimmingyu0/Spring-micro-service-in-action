package com.optimagrowth.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* Spring Cloud Version 2022.0~ @EnableEurekaClient 사용 불가
* pom.xml에 spring-cloud-starter-netflix-eureka-client 종속성 추가 후
* 설정 파일에 애플리케이션 이름이 있으면 Eureka에 등록되는 형식으로 바뀜
* */
public class ApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServerApplication.class, args);
	}

}
