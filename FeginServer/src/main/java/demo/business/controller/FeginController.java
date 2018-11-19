package demo.business.controller;

import demo.business.service.CustomerService;
import demo.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeginController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "sayCustomerHello",method = RequestMethod.GET)
    public String sayCustomerHello(){
        return customerService.sayHiFromClientOne("asd");
    }

    @RequestMapping(value = "orderMessage",method = RequestMethod.GET)
    public String OrderMessage(@RequestParam("message") String message){
        return orderService.getOrderMessage(message);
    }

}
