package demo.business.feign.customer.impll;

import demo.business.feign.customer.CustomerFeignService;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignServiceFallBack implements CustomerFeignService {

    @Override
    public String sayHello() {
        return "customerServer is not work please check ";
    }
}
