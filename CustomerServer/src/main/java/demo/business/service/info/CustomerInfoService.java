package demo.business.service.info;

import model.custoemr.CustomerModel;

public interface CustomerInfoService
{
    CustomerModel getCustomerInfo(String customerId);
}