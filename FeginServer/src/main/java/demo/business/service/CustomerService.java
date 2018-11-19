package demo.business.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CustomerServer")
public interface CustomerService {
    @GetMapping(value = "/sayHello")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
