package demo.business.service.busi.impl;

import demo.business.service.busi.BankRollFlowBusiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.busi.BankRollFlowBusiMapper;
import pojo.bankroll.BankRollFlowPojo;

@Service
public class BankRollFlowBusiServiceImpl implements BankRollFlowBusiService
{
    @Autowired
    private BankRollFlowBusiMapper bankRollFlowBusiMapper;

    @Override
    public int insertSelective(BankRollFlowPojo bankRollFlowPojo) {
        return bankRollFlowBusiMapper.insertSelective(bankRollFlowPojo);
    }

    @Override
    public int deleteByPrimaryKey(BankRollFlowPojo bankRollFlowPojo) {
        return bankRollFlowBusiMapper.deleteByPrimaryKey(bankRollFlowPojo);
    }
}