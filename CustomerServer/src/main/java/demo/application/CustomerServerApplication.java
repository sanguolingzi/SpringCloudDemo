package demo.application;

import demo.config.MyRobbin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {
        "demo.business.feign"
})
@ComponentScan(basePackages = {
        "demo.business",
        "demo.config"
})
@RibbonClients(defaultConfiguration = MyRobbin.class)
public class CustomerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServerApplication.class, args);
    }
}

