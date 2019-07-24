package demo.business.service.info.impl;

import demo.business.service.info.BankRollInfoService;
import model.bankroll.BankRollModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.info.BankRollInfoMapper;
import org.springframework.util.Assert;
import pojo.bankroll.BankRollPojo;

@Service
public class BankRollInfoServiceImpl implements BankRollInfoService
{
    @Autowired
    private BankRollInfoMapper mapper;

    @Override
    public BankRollModel selectByCustomerId(String customerId) {
        Assert.notNull(customerId,"customerId 为空");
        BankRollPojo bankRollPojo = new BankRollPojo();
        bankRollPojo.setCustomerId(Integer.parseInt(customerId));
        BankRollModel bankRollModel = new BankRollModel();
        bankRollPojo = mapper.selectOne(bankRollPojo);
        Assert.notNull(bankRollPojo,"未查询到账户信息!");
        BeanUtils.copyProperties(bankRollPojo,bankRollModel);
        return bankRollModel;
    }
}