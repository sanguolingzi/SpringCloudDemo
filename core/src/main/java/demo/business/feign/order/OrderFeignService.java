package demo.business.feign.order;


import demo.business.feign.order.impl.OrderFeignServiceFallBack;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.order.OrderModel;

@FeignClient(value="OrderServer",fallback= OrderFeignServiceFallBack.class)
public interface OrderFeignService {

    @GetMapping(value="/orderMessage")
    public String orderMessage(@RequestParam("message") String message);

    @PostMapping(value="/saveMessage")
    @Headers({"content-type:"+ MediaType.APPLICATION_JSON_VALUE})
    public String saveMessage(@RequestBody OrderModel orderModel);
}
