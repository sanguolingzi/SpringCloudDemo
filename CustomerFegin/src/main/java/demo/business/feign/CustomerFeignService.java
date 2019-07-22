package demo.business.feign;

import demo.business.feign.impl.CustomerFeignServiceFallBack;
import demo.business.httpresponse.ResponseData;
import demo.config.FeignClientConfig;
import model.custoemr.CustomerModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="CustomerServer",fallback = CustomerFeignServiceFallBack.class
,path="customer",configuration = {FeignClientConfig.class})
public interface CustomerFeignService {
    @GetMapping(value="/getCustomerInfo")
    ResponseData<CustomerModel> getCustomerInfo(@RequestParam("customerId") String customerId);
}
