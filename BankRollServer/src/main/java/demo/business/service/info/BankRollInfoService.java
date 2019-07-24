package demo.business.service.info;

import model.bankroll.BankRollModel;

public interface BankRollInfoService
{
    public BankRollModel selectByCustomerId(String customerId);
}