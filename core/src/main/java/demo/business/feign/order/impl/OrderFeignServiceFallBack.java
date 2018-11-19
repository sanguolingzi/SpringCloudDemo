package demo.business.feign.order.impl;

import demo.business.feign.order.OrderFeignService;
import org.springframework.stereotype.Component;
import pojo.order.OrderModel;

@Component
public class OrderFeignServiceFallBack implements OrderFeignService {

    @Override
    public String orderMessage(String message) {
        return "orderMessage is not work  please check OrderServer ";
    }

    @Override
    public String saveMessage(OrderModel orderModel) {
        return "saveMessage is not work  please check OrderServer ";
    }
}
