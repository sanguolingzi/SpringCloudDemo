package demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
/**
 * 声明一个认证服务器，当用此注解后，应用启动后将自动生成几个Endpoint
 /oauth/authorize：验证

 /oauth/token：获取token

 /oauth/confirm_access：用户授权

 /oauth/error：认证失败

 /oauth/check_token：资源服务器用来校验token

 /oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥
 */
@EnableAuthorizationServer
@ComponentScan(basePackages = {
        "demo.config",
        "demo.service",
        "demo.controller"
})
@EnableResourceServer
public class SSOAuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSOAuthServerApplication.class, args);
    }
}

