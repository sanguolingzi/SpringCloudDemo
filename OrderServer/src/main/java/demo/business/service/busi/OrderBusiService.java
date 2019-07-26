package demo.business.service.busi;

import model.order.AddOrderModel;
import pojo.order.OrderPojo;

public interface OrderBusiService
{
    public String addOrderInfo(AddOrderModel addOrderModel) throws Exception ;

    public int insertSelective(OrderPojo orderPojo);
}