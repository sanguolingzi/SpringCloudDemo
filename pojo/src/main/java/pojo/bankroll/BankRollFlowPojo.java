package pojo.bankroll;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "busi_customer_bankroll_flow")
public class BankRollFlowPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 1 余额 2 积分 3消费券 4微信 5支付宝 6游戏币
     */
    @Column(name = "flow_category")
    private Short flowCategory;

    /**
     * 0 收入 1 支出
     */
    @Column(name = "flow_type")
    private Short flowType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 流水号
     */
    @Column(name = "flow_number")
    private String flowNumber;

    /**
     * 流水类别描述(1提现 2 推荐奖励 3余额支付 4获取星币 5消费券支付 6赠送积分 7摘星消耗积分 8订单消费券退回 9订单余额退回 10微信支付 11支付宝支付 12微信退回 13支付宝退回 14游戏商品反消费券 15推荐消费者消费奖励到余额 16提现退回 17游戏订单合伙人返余额 18游戏订单会员返余额 19 游戏任务奖励游戏币 20订单支付游戏币 21订单退回游戏币 22推荐会员反余额)
     */
    @Column(name = "flow_description")
    private Short flowDescription;

    /**
     * 0 正常 1 未删除
     */
    @Column(name = "del_flag")
    private Short delFlag;

    /**
     * 所属账户id
     */
    @Column(name = "bankroll_id")
    private Integer bankrollId;

    /**
     * 根据流水类型 关联数据Id
     */
    @Column(name = "relation_id")
    private Integer relationId;

    /**
     * 游戏用户绑定已有帐号 修改流水的操作时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取1 余额 2 积分 3消费券 4微信 5支付宝 6游戏币
     *
     * @return flow_category - 1 余额 2 积分 3消费券 4微信 5支付宝 6游戏币
     */
    public Short getFlowCategory() {
        return flowCategory;
    }

    /**
     * 设置1 余额 2 积分 3消费券 4微信 5支付宝 6游戏币
     *
     * @param flowCategory 1 余额 2 积分 3消费券 4微信 5支付宝 6游戏币
     */
    public void setFlowCategory(Short flowCategory) {
        this.flowCategory = flowCategory;
    }

    /**
     * 获取0 收入 1 支出
     *
     * @return flow_type - 0 收入 1 支出
     */
    public Short getFlowType() {
        return flowType;
    }

    /**
     * 设置0 收入 1 支出
     *
     * @param flowType 0 收入 1 支出
     */
    public void setFlowType(Short flowType) {
        this.flowType = flowType;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取金额
     *
     * @return amount - 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取流水号
     *
     * @return flow_number - 流水号
     */
    public String getFlowNumber() {
        return flowNumber;
    }

    /**
     * 设置流水号
     *
     * @param flowNumber 流水号
     */
    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }

    /**
     * 获取流水类别描述(1提现 2 推荐奖励 3余额支付 4获取星币 5消费券支付 6赠送积分 7摘星消耗积分 8订单消费券退回 9订单余额退回 10微信支付 11支付宝支付 12微信退回 13支付宝退回 14游戏商品反消费券 15推荐消费者消费奖励到余额 16提现退回 17游戏订单合伙人返余额 18游戏订单会员返余额 19 游戏任务奖励游戏币 20订单支付游戏币 21订单退回游戏币 22推荐会员反余额)
     *
     * @return flow_description - 流水类别描述(1提现 2 推荐奖励 3余额支付 4获取星币 5消费券支付 6赠送积分 7摘星消耗积分 8订单消费券退回 9订单余额退回 10微信支付 11支付宝支付 12微信退回 13支付宝退回 14游戏商品反消费券 15推荐消费者消费奖励到余额 16提现退回 17游戏订单合伙人返余额 18游戏订单会员返余额 19 游戏任务奖励游戏币 20订单支付游戏币 21订单退回游戏币 22推荐会员反余额)
     */
    public Short getFlowDescription() {
        return flowDescription;
    }

    /**
     * 设置流水类别描述(1提现 2 推荐奖励 3余额支付 4获取星币 5消费券支付 6赠送积分 7摘星消耗积分 8订单消费券退回 9订单余额退回 10微信支付 11支付宝支付 12微信退回 13支付宝退回 14游戏商品反消费券 15推荐消费者消费奖励到余额 16提现退回 17游戏订单合伙人返余额 18游戏订单会员返余额 19 游戏任务奖励游戏币 20订单支付游戏币 21订单退回游戏币 22推荐会员反余额)
     *
     * @param flowDescription 流水类别描述(1提现 2 推荐奖励 3余额支付 4获取星币 5消费券支付 6赠送积分 7摘星消耗积分 8订单消费券退回 9订单余额退回 10微信支付 11支付宝支付 12微信退回 13支付宝退回 14游戏商品反消费券 15推荐消费者消费奖励到余额 16提现退回 17游戏订单合伙人返余额 18游戏订单会员返余额 19 游戏任务奖励游戏币 20订单支付游戏币 21订单退回游戏币 22推荐会员反余额)
     */
    public void setFlowDescription(Short flowDescription) {
        this.flowDescription = flowDescription;
    }

    /**
     * 获取0 正常 1 未删除
     *
     * @return del_flag - 0 正常 1 未删除
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * 设置0 正常 1 未删除
     *
     * @param delFlag 0 正常 1 未删除
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取所属账户id
     *
     * @return bankroll_id - 所属账户id
     */
    public Integer getBankrollId() {
        return bankrollId;
    }

    /**
     * 设置所属账户id
     *
     * @param bankrollId 所属账户id
     */
    public void setBankrollId(Integer bankrollId) {
        this.bankrollId = bankrollId;
    }

    /**
     * 获取根据流水类型 关联数据Id
     *
     * @return relation_id - 根据流水类型 关联数据Id
     */
    public Integer getRelationId() {
        return relationId;
    }

    /**
     * 设置根据流水类型 关联数据Id
     *
     * @param relationId 根据流水类型 关联数据Id
     */
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取游戏用户绑定已有帐号 修改流水的操作时间
     *
     * @return update_time - 游戏用户绑定已有帐号 修改流水的操作时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置游戏用户绑定已有帐号 修改流水的操作时间
     *
     * @param updateTime 游戏用户绑定已有帐号 修改流水的操作时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}