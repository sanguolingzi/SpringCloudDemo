package demo.business.feign;

import demo.business.feign.impl.BankRollFeignServiceFallBack;
import demo.business.httpresponse.ResponseData;
import demo.config.FeignClientConfig;
import model.bankroll.BankRollBusiModel;
import model.bankroll.BankRollModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="BankRollServer",fallback = BankRollFeignServiceFallBack.class
        ,path="bankroll",configuration = {FeignClientConfig.class})
public interface BankrollFeignService {
    @PostMapping(value = "/updateBankroll")
    public ResponseData<String> updateBankroll(@RequestBody BankRollBusiModel bankRollBusiModel);

    @GetMapping(value = "getBankRollInfo")
    public ResponseData<BankRollModel> getBankRollInfo(@RequestParam("customerId") String customerId);
}
