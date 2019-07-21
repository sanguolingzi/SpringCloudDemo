package demo.business.service.info.impl;

import demo.business.mapper.info.CustomerInfoMapper;
import demo.business.service.info.CustomerInfoService;
import model.custoemr.CustomerModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pojo.customer.CustomerPojo;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService
{
    @Autowired
    private CustomerInfoMapper customerInfoMapper;


    @Override
    public CustomerModel getCustomerInfo(String customerId) {
        CustomerPojo customerPojo = new CustomerPojo();
        Assert.notNull(customerId,"用户信息为空!");
        customerPojo.setId(Integer.parseInt(customerId));
        customerPojo = customerInfoMapper.selectOne(customerPojo);

        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customerPojo,customerModel);
        return customerModel;
    }
}