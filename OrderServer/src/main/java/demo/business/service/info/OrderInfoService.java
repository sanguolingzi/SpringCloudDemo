package demo.business.service.info;

import model.order.OrderModel;

public interface OrderInfoService
{
    OrderModel getOrderInfo(String orderId);
}