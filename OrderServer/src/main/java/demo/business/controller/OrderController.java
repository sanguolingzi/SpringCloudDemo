package demo.business.controller;

import demo.business.httpresponse.ResponseData;
import demo.business.service.busi.OrderBusiService;
import demo.business.service.info.OrderInfoService;
import model.order.AddOrderModel;
import model.order.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseDataUtil;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoServiceImpl;

    @GetMapping(value="getOrderInfo")
    public ResponseData<OrderModel> getOrderInfo(@RequestParam("orderId") String orderId){
        return ResponseDataUtil.toSuccess(orderInfoServiceImpl.getOrderInfo(orderId));
    }

    //-------------------------------------------POST------------------------------------
    @Autowired
    private OrderBusiService orderBusiServiceImpl;

    @PostMapping(value="addOrderInfo")
    public ResponseData<OrderModel> addOrderInfo(@RequestBody AddOrderModel addOrderModel)
    throws Exception{
        return ResponseDataUtil.toSuccess(orderBusiServiceImpl.addOrderInfo(addOrderModel));
    }
}
