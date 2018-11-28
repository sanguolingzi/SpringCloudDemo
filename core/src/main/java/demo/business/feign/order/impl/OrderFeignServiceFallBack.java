package demo.business.feign.order.impl;

import demo.business.feign.order.OrderFeignService;
import org.springframework.stereotype.Component;
import pojo.order.OrderModel;

@Component
public class OrderFeignServiceFallBack implements OrderFeignService {

    public String orderMessage(String message) {
        return "orderMessage is not work  please check OrderServer ";
    }

    public String saveMessage(OrderModel orderModel) {
        return "saveMessage is not work  please check OrderServer ";
    }
}
