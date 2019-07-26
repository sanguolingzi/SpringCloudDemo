package demo.business.service.busi.impl;

import demo.business.mapper.busi.BankRollBusiMapper;
import demo.business.service.busi.BankRollBusiService;
import demo.business.service.busi.BankRollFlowBusiService;
import model.bankroll.BankRollBusiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bankroll.BankRollFlowPojo;
import util.BankrollInfoEnum;

import javax.transaction.Transactional;

@Service
public class BankRollBusiServiceImpl implements BankRollBusiService
{
    @Autowired
    private BankRollBusiMapper bankRollBusiMapper;

    @Autowired
    private BankRollFlowBusiService bankRollFlowBusiServiceImpl;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String updateBankrollForOrder(BankRollBusiModel bankRollBusiModel) throws Exception{

        int bankRollResult = bankRollBusiMapper.updateBankrollAmount(bankRollBusiModel.getBankRollId()
                ,bankRollBusiModel.getNewAmount(),
                bankRollBusiModel.getOldAmount(),
                bankRollBusiModel.getFlowType());

        BankRollFlowPojo bankRollFlowPojo = new BankRollFlowPojo();
        bankRollFlowPojo.setBankrollId(bankRollBusiModel.getBankRollId());
        bankRollFlowPojo.setAmount(bankRollBusiModel.getNewAmount().movePointRight(2));
        bankRollFlowPojo.setFlowType(bankRollBusiModel.getFlowType());
        bankRollFlowPojo.setFlowDescription(BankrollInfoEnum.AMOUNTPAY.getValue());
        bankRollFlowPojo.setFlowCategory(BankrollInfoEnum.AMOUNT.getValue());
        int bankRollFlowResult = bankRollFlowBusiServiceImpl.insertSelective(bankRollFlowPojo);

        if((bankRollResult==1 && bankRollFlowResult >= 1))
            return "success";
        throw new Exception("updateBankrollForOrder failed");
    }

    @Override
    public int minusBankrollAmount(BankRollBusiModel bankRollBusiModel) {
        return bankRollBusiMapper.minusBankrollAmount(bankRollBusiModel.getBankRollId(),bankRollBusiModel.getNewAmount());
    }

    @Override
    public int addBankrollAmount(BankRollBusiModel bankRollBusiModel) {
        return bankRollBusiMapper.addBankrollAmount(bankRollBusiModel.getBankRollId(),bankRollBusiModel.getNewAmount());
    }
}