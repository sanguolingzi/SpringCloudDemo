package demo.business.feign.impl;

import demo.business.feign.CustomerFeignService;
import demo.business.httpresponse.ResponseConstant;
import demo.business.httpresponse.ResponseData;
import model.custoemr.CustomerModel;
import org.springframework.stereotype.Component;
import utils.ResponseDataUtil;

@Component
public class CustomerFeignServiceFallBack implements CustomerFeignService {
    public ResponseData<CustomerModel> getCustomerInfo(String customerId) {
        return ResponseDataUtil.toFail(ResponseConstant.RESULT_DESCRIPTION_EXCEPTION);
    }
}
