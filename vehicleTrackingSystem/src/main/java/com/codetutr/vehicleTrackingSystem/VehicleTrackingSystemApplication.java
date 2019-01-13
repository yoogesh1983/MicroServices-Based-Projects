package com.codetutr.vehicleTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.codetutr.vehicleTrackingSystem.Utility.AuthenticationStateBeanHandlerInterceptor;

//@ComponentScan("com.codetutr.springboot")
//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.codetutr.vehicleTrackingSystem"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class VehicleTrackingSystemApplication  extends WebMvcConfigurerAdapter {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(VehicleTrackingSystemApplication.class, args);
		
/*		JmsTemplate template = ctx.getBean(JmsTemplate.class);
		template.convertAndSend("PositionQueue", "Hello yoogesh welcome!");*/
	}
	
	
	
	public void addInterceptors(InterceptorRegistry registry)
	{
		// Register a handler intercepter to add the authenticate state bean to each request before passing control to the view
		AuthenticationStateBeanHandlerInterceptor authenticationStateBeanHandlerInterceptor = new AuthenticationStateBeanHandlerInterceptor();
		registry.addInterceptor(authenticationStateBeanHandlerInterceptor);
	}
}
