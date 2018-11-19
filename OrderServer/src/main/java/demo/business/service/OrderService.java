package demo.business.service;

import pojo.order.OrderModel;
public interface OrderService {

    public String getMessage(String message);

    public String saveMessage(OrderModel orderModel);

    public String orderToCustomerMessage(String message);
}
