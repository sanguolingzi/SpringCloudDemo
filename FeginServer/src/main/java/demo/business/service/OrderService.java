package demo.business.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="OrderServer")
public interface OrderService {
    @GetMapping(value="orderMessage")
    public String getOrderMessage(@RequestParam(value = "message") String message);
}
