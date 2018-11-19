package pojo.order;

import java.io.Serializable;

public class OrderModel implements Serializable{

    private Integer id;

    private String ordersNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }
}
