package demo.business.service.impl;

import demo.business.feign.order.OrderFeignService;
import demo.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.order.OrderModel;

import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private OrderFeignService orderFeignService;

    @Override
    public String OrderMessage(String message) {
        return "this is customer ...."+ orderFeignService.orderMessage(message);
    }

    @Override
    public String saveOrderMessage(Map<String, Object> map) {
        OrderModel orderModel = new OrderModel();
        orderModel.setId(Integer.parseInt(map.get("id").toString()));
        orderModel.setOrdersNo(map.get("ordersNo").toString());
        return orderFeignService.saveMessage(orderModel);
    }
}
