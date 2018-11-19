package demo.business.controller;

import demo.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private CustomerService customerServiceImpl;

    @Value("${customer.message}")
    private String port;

    @RequestMapping(value="sayHello",method= RequestMethod.GET)
    public String sayHello(){
        return "hello "+port;
    }


    @GetMapping(value="customerToOrderMessage")
    public String orderMessage(@RequestParam("message") String message)
    {
        return customerServiceImpl.OrderMessage(message);
    }


    @GetMapping(value="customerSaveOrder")
    public String customerSaveOrder(@RequestParam("id") Integer id,@RequestParam("ordersNo") String ordersNo)
    {
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("id",id);
        paraMap.put("ordersNo",ordersNo);
        return customerServiceImpl.saveOrderMessage(paraMap);
    }
}
