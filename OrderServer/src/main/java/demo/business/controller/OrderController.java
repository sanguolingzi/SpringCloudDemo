package demo.business.controller;

import demo.business.service.info.OrderInfoService;
import model.order.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoServiceImpl;

    @GetMapping(value="getOrderInfo")
    public OrderModel getOrderInfo(@RequestParam("orderId") String orderId){
        return orderInfoServiceImpl.getOrderInfo(orderId);
    }

}
