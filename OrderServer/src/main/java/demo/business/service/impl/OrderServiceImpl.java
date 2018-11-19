package demo.business.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.business.feign.customer.CustomerFeignService;
import demo.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.order.OrderModel;


@Service
public class OrderServiceImpl implements OrderService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CustomerFeignService customerFeignService;

    @Override
    public String getMessage(String message) {
        return "this is :"+port +"  message:"+message;
    }

    @Override
    public String saveMessage(OrderModel orderModel) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return "the port is :"+this.port+"          "+objectMapper.writeValueAsString(orderModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    @Override
    public String orderToCustomerMessage(String message) {
        return customerFeignService.sayHello();
    }
}
