package model.bankroll;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankRollBusiModel implements Serializable {
    private Integer bankRollId;
    private BigDecimal oldAmount;
    private BigDecimal newAmount;
    private Short flowType;

    public Integer getBankRollId() {
        return bankRollId;
    }

    public void setBankRollId(Integer bankRollId) {
        this.bankRollId = bankRollId;
    }

    public BigDecimal getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(BigDecimal oldAmount) {
        this.oldAmount = oldAmount;
    }

    public BigDecimal getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(BigDecimal newAmount) {
        this.newAmount = newAmount;
    }

    public Short getFlowType() {
        return flowType;
    }

    public void setFlowType(Short flowType) {
        this.flowType = flowType;
    }
}