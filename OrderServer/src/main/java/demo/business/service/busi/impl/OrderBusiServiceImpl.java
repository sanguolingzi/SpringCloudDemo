package demo.business.service.busi.impl;

import demo.business.feign.BankrollFeignService;
import demo.business.feign.CustomerFeignService;
import demo.business.httpresponse.ResponseData;
import demo.business.mapper.busi.OrderBusiMapper;
import demo.business.service.busi.OrderBusiService;
import model.bankroll.BankRollBusiModel;
import model.bankroll.BankRollModel;
import model.custoemr.CustomerModel;
import model.order.AddOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
import pojo.order.OrderPojo;
import util.BankrollInfoEnum;

import javax.transaction.Transactional;

@Service
public class OrderBusiServiceImpl implements OrderBusiService
{
    @Autowired
    private OrderBusiMapper orderBusiMapper;

    @Autowired
    private BankrollFeignService bankrollFeignService;

    @Autowired
    private CustomerFeignService customerFeignService;


    @Override
    @Transactional(rollbackOn = Exception.class)
    public String addOrderInfo(AddOrderModel addOrderModel) throws Exception{
        ResponseData<BankRollModel> bankRollModelResponseData
                =  bankrollFeignService.getBankRollInfo(String.valueOf(addOrderModel.getCustomerId()));

        BankRollModel bankRollModel = null;
        if(bankRollModelResponseData.success())
            bankRollModel = bankRollModelResponseData.getData();


        //新增一个订单
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setCustomerId(addOrderModel.getCustomerId());
        orderPojo.setOrderSourse(addOrderModel.getOrderSourse().shortValue());
        orderBusiMapper.insertSelective(orderPojo);

        //修改账户金额
        BankRollBusiModel bankRollBusiModel = new BankRollBusiModel();
        bankRollBusiModel.setBankRollId(bankRollModel.getId());
        bankRollBusiModel.setFlowType(BankrollInfoEnum.EXPENSE.getValue());
        bankRollBusiModel.setOldAmount(bankRollModel.getAmount());
        bankRollBusiModel.setNewAmount(addOrderModel.getPayAmount());
        bankrollFeignService.updateBankroll(bankRollBusiModel);

        return "success";
    }
}