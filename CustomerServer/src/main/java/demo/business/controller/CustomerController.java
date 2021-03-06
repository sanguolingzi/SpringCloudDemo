package demo.business.controller;

import demo.business.httpresponse.ResponseData;
import demo.business.service.info.CustomerInfoService;
import model.custoemr.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseDataUtil;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerInfoService customerInfoServiceImpl;

    @GetMapping(value="getCustomerInfo")
    public ResponseData<CustomerModel> getCustomerInfoExecutor(@RequestParam("customerId") String customerId){
        return ResponseDataUtil.toSuccess(customerInfoServiceImpl.getCustomerInfo(customerId));
    }

}
