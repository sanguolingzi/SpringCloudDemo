package demo.business.feign.customer.impl;

import demo.business.feign.customer.CustomerFeignService;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignServiceFallBack implements CustomerFeignService {
    public String sayHello() {
         return "customerServer is not work please check ";
    }
}
