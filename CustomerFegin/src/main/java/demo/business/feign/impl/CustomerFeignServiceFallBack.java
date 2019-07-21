package demo.business.feign.impl;

import demo.business.feign.CustomerFeignService;
import model.custoemr.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignServiceFallBack implements CustomerFeignService {
    public CustomerModel getCustomerInfo(String customerId) {
        System.out.println("is not work");
        return null;
    }
}
