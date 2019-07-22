package demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

//@Configuration
public class FeignClientConfig {

    @PostConstruct
    public void te(){
        System.out.println("----------------");
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
