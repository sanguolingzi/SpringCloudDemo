package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {
        "demo.business.service"
})
@ComponentScan(basePackages = {
        "demo.business.controller"
})
public class FeginServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginServerApplication.class, args);
    }
}

