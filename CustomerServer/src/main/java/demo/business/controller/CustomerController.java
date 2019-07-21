package demo.business.controller;

import demo.business.service.info.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerInfoService customerInfoServiceImpl;

    @GetMapping(value="getCustomerInfo")
    public Object getCustomerInfoExecutor(@RequestParam("customerId") String customerId){
        return customerInfoServiceImpl.getCustomerInfo(customerId);
    }
}
