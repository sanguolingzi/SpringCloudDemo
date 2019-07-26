package demo.business.mapper.busi;

import mybaties.mapper.BusiMapper;
import org.apache.ibatis.annotations.Param;
import pojo.bankroll.BankRollPojo;

import java.math.BigDecimal;

public interface BankRollBusiMapper extends BusiMapper<BankRollPojo> {
    int updateBankrollAmount(@Param("id") Integer bankrollId, @Param("amount") BigDecimal amount, @Param("oldAmount") BigDecimal oldAmount, @Param("flowType") Short flowType);

    int minusBankrollAmount(@Param("id") Integer bankrollId, @Param("amount") BigDecimal amount);

    int addBankrollAmount(@Param("id") Integer bankrollId, @Param("amount") BigDecimal amount);
}