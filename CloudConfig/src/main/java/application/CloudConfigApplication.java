package application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Spring Cloud官方文档提供了几个可选URL可以是如下几个：
 * /{application}/{profile}[/{label}]
 /{application}-{profile}.yml
 /{label}/{application}-{profile}.yml
 /{application}-{profile}.properties
 /{label}/{application}-{profile}.properties
 */
@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class CloudConfigApplication {

    public static void main(String[] args) {
                 SpringApplication.run(CloudConfigApplication.class, args);
    }
}
