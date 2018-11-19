package demo.business.controller;

import demo.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.order.OrderModel;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderServiceImpl;

    @GetMapping(value="orderMessage")
    public String getOrderMessage(@RequestParam("message") String message){
        try{
            Thread.sleep(Long.valueOf(message));
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderServiceImpl.getMessage(message);
    }

    @PostMapping(value="/saveMessage")
    public String saveMessage(@RequestBody  OrderModel orderModel){
        return orderServiceImpl.saveMessage(orderModel);
    }

    @GetMapping(value="orderToCustomerMessage")
    public String orderToCustomerMessage(@RequestParam("message") String message){
        return orderServiceImpl.orderToCustomerMessage(message);
    }


}
