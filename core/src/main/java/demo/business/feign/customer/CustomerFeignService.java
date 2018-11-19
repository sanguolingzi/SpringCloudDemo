package demo.business.feign.customer;

import demo.business.feign.customer.impll.CustomerFeignServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="CustomerServer",fallback = CustomerFeignServiceFallBack.class)
public interface CustomerFeignService {

    @GetMapping(value="/sayHello")
    public String sayHello();
}
