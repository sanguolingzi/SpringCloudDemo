package demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan(basePackages = {
        "demo.compoment"
})
public class ZuulServerApplication {

    public static void main(String[] args) {
                 SpringApplication.run(ZuulServerApplication.class, args);
            }
}
