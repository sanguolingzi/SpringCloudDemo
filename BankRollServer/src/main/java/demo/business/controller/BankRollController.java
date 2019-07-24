package demo.business.controller;


import demo.business.httpresponse.ResponseData;
import demo.business.service.busi.BankRollBusiService;
import demo.business.service.info.BankRollInfoService;
import model.bankroll.BankRollBusiModel;
import model.bankroll.BankRollModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseDataUtil;

@RestController
@RequestMapping("bankroll")
public class BankRollController {

    //---------------------------------------GET------------------------------------------
    @Autowired
    private BankRollInfoService bankRollInfoService;
    @GetMapping(value = "/getBankRollInfo")
    public ResponseData<BankRollModel> getBankRollInfo(@RequestParam("customerId") String customerId)
            throws Exception
    {
        return ResponseDataUtil.toSuccess(bankRollInfoService.selectByCustomerId(customerId));
    }

    //---------------------------------------POST-----------------------------------------
    @Autowired
    private BankRollBusiService bankRollBusiService;

    @PostMapping(value = "/updateBankroll")
    public ResponseData<String> updateBankroll(@RequestBody BankRollBusiModel bankRollBusiModel)
            throws Exception
    {
        return ResponseDataUtil.toSuccess(bankRollBusiService.updateBankrollForOrder(bankRollBusiModel));
    }
}
