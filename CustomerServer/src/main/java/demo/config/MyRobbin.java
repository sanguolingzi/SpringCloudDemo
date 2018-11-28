package demo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRobbin {

    @Bean
    public IRule myRule(){
        System.out.println("init myRule");
        return new RandomRule();
    }
}
