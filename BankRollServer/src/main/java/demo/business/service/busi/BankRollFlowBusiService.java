package demo.business.service.busi;

import pojo.bankroll.BankRollFlowPojo;

public interface BankRollFlowBusiService
{
    int insertSelective(BankRollFlowPojo bankRollFlowPojo);

    int deleteByPrimaryKey(BankRollFlowPojo bankRollFlowPojo);
}