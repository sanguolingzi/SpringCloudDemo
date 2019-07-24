package demo.business.feign.impl;

import demo.business.feign.BankrollFeignService;
import demo.business.httpresponse.ResponseData;
import model.bankroll.BankRollBusiModel;
import model.bankroll.BankRollModel;
import org.springframework.stereotype.Component;
import utils.ResponseDataUtil;

@Component
public class BankRollFeignServiceFallBack implements BankrollFeignService{
    public ResponseData<String> updateBankroll(BankRollBusiModel bankRollBusiModel) {
        return ResponseDataUtil.toFail();
    }

    public ResponseData<BankRollModel> getBankRollInfo(String customerId) {
        return ResponseDataUtil.toFail();
    }
}
