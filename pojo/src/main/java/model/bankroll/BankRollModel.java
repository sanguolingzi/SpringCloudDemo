package model.bankroll;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BankRollModel implements Serializable {
    private Integer id;

    /**
     * 积分
     */
    private BigDecimal integral;

    /**
     * 奖励金
     */
    private BigDecimal amount;

    /**
     * 消费券总补贴
     */
    private BigDecimal expenseSubsidy;

    /**
     * 已领消费券
     */
    private BigDecimal yokaAmount;

    /**
     * 未领消费券
     */
    private BigDecimal notYokaAmount;

    /**
     * 可用消费券(友旗币)
     */
    private BigDecimal starCoin;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 消费者id
     */
    private Integer customerId;

    /**
     * 0 正常 1 已删除
     */
    private Short delFlag;

    /**
     * U币账户(根据U币流水表累加)
     */
    private BigDecimal rewardAmount;

    /**
     * 游戏用户id 用于游戏用户未在商城注册时 记录的U币信息
     */
    private Integer gameId;

    /**
     * 累计 U币 消费金额
     */
    private BigDecimal usedRewardAmount;

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
     * 获取积分
     *
     * @return integral - 积分
     */
    public BigDecimal getIntegral() {
        return integral;
    }

    /**
     * 设置积分
     *
     * @param integral 积分
     */
    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    /**
     * 获取奖励金
     *
     * @return amount - 奖励金
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置奖励金
     *
     * @param amount 奖励金
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取消费券总补贴
     *
     * @return expense_subsidy - 消费券总补贴
     */
    public BigDecimal getExpenseSubsidy() {
        return expenseSubsidy;
    }

    /**
     * 设置消费券总补贴
     *
     * @param expenseSubsidy 消费券总补贴
     */
    public void setExpenseSubsidy(BigDecimal expenseSubsidy) {
        this.expenseSubsidy = expenseSubsidy;
    }

    /**
     * 获取已领消费券
     *
     * @return yoka_amount - 已领消费券
     */
    public BigDecimal getYokaAmount() {
        return yokaAmount;
    }

    /**
     * 设置已领消费券
     *
     * @param yokaAmount 已领消费券
     */
    public void setYokaAmount(BigDecimal yokaAmount) {
        this.yokaAmount = yokaAmount;
    }

    /**
     * 获取未领消费券
     *
     * @return not_yoka_amount - 未领消费券
     */
    public BigDecimal getNotYokaAmount() {
        return notYokaAmount;
    }

    /**
     * 设置未领消费券
     *
     * @param notYokaAmount 未领消费券
     */
    public void setNotYokaAmount(BigDecimal notYokaAmount) {
        this.notYokaAmount = notYokaAmount;
    }

    /**
     * 获取可用消费券(友旗币)
     *
     * @return star_coin - 可用消费券(友旗币)
     */
    public BigDecimal getStarCoin() {
        return starCoin;
    }

    /**
     * 设置可用消费券(友旗币)
     *
     * @param starCoin 可用消费券(友旗币)
     */
    public void setStarCoin(BigDecimal starCoin) {
        this.starCoin = starCoin;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取消费者id
     *
     * @return customer_id - 消费者id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置消费者id
     *
     * @param customerId 消费者id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取0 正常 1 已删除
     *
     * @return del_flag - 0 正常 1 已删除
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * 设置0 正常 1 已删除
     *
     * @param delFlag 0 正常 1 已删除
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取U币账户(根据U币流水表累加)
     *
     * @return reward_amount - U币账户(根据U币流水表累加)
     */
    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    /**
     * 设置U币账户(根据U币流水表累加)
     *
     * @param rewardAmount U币账户(根据U币流水表累加)
     */
    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    /**
     * 获取游戏用户id 用于游戏用户未在商城注册时 记录的U币信息
     *
     * @return game_id - 游戏用户id 用于游戏用户未在商城注册时 记录的U币信息
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * 设置游戏用户id 用于游戏用户未在商城注册时 记录的U币信息
     *
     * @param gameId 游戏用户id 用于游戏用户未在商城注册时 记录的U币信息
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     * 获取累计 U币 消费金额
     *
     * @return used_reward_amount - 累计 U币 消费金额
     */
    public BigDecimal getUsedRewardAmount() {
        return usedRewardAmount;
    }

    /**
     * 设置累计 U币 消费金额
     *
     * @param usedRewardAmount 累计 U币 消费金额
     */
    public void setUsedRewardAmount(BigDecimal usedRewardAmount) {
        this.usedRewardAmount = usedRewardAmount;
    }
}