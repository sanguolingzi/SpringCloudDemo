package demo.business.service.busi;

import model.bankroll.BankRollBusiModel;

public interface BankRollBusiService
{
    String updateBankrollForOrder(BankRollBusiModel bankRollBusiModel)throws Exception;

    int minusBankrollAmount(BankRollBusiModel bankRollBusiModel);

    int addBankrollAmount(BankRollBusiModel bankRollBusiModel);

}