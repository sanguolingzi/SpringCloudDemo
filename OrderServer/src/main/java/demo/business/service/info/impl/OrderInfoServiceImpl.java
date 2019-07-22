package demo.business.service.info.impl;

import demo.business.feign.CustomerFeignService;
import demo.business.httpresponse.ResponseData;
import demo.business.mapper.info.OrderInfoMapper;
import demo.business.service.info.OrderInfoService;
import model.custoemr.CustomerModel;
import model.order.OrderModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pojo.order.OrderPojo;

@Service
public class OrderInfoServiceImpl implements OrderInfoService
{
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private CustomerFeignService customerFeignService;

    @Override
    public OrderModel getOrderInfo(String orderId) {
        Assert.notNull(orderId,"订单信息为空!");
        OrderPojo orderPojo =  new OrderPojo();
        orderPojo.setId(Integer.parseInt(orderId));
        orderPojo = orderInfoMapper.selectOne(orderPojo);
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(orderPojo,orderModel);
        ResponseData<CustomerModel> responseData = customerFeignService.getCustomerInfo(String.valueOf(orderPojo.getCustomerId()));
        if(responseData.success()){
            orderModel.setCustomerName(responseData.getData().getNickName());
        }
        return orderModel;
    }
}