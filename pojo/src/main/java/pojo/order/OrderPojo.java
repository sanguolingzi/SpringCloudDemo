package pojo.order;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "busi_order")
public class OrderPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 0 线上  1 线下
     */
    @Column(name = "order_type")
    private Short orderType;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 商品总价
     */
    @Column(name = "pro_amount")
    private BigDecimal proAmount;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 总价
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 抵扣积分
     */
    @Column(name = "pay_integral")
    private BigDecimal payIntegral;

    /**
     * 消费券抵扣金额
     */
    @Column(name = "integral_amount")
    private BigDecimal integralAmount;

    /**
     * 付款价格
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 1 支付宝 2 微信 3纯星币 4余额 5 快捷  
     */
    @Column(name = "pay_type")
    private Short payType;

    /**
     * 赠送的消费券
     */
    @Column(name = "give_integral")
    private BigDecimal giveIntegral;

    /**
     * 0 已取消 1 未付款 2 已付款 3已发货  4已签收 5已评价  6已追评 7退款中 8交易关闭 
     */
    @Column(name = "order_status")
    private Short orderStatus;

    /**
     * 1 PC 2WAP 3 APP  4 微信
     */
    @Column(name = "order_sourse")
    private Short orderSourse;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收货地址ID
     */
    @Column(name = "receive_address_id")
    private Integer receiveAddressId;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 是否为默认收货地址（0默认，1不默认）
     */
    @Column(name = "address_default")
    private Short addressDefault;

    /**
     * 0 审核通过 1 审核不通过  2待审核
     */
    @Column(name = "audit_status")
    private Short auditStatus;

    /**
     * 总订单号
     */
    @Column(name = "total_order_no")
    private String totalOrderNo;

    /**
     * 所属店铺
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 所属用户
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 0 正常 1 已删除
     */
    @Column(name = "del_flag")
    private Short delFlag;

    /**
     * 订单号
     */
    @Column(name = "orders_no")
    private String ordersNo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单付款时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Date deliveryTime;

    /**
     * 订单收货时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 评论时间
     */
    @Column(name = "evaluate_time")
    private Date evaluateTime;

    /**
     * 取消时间
     */
    @Column(name = "cancel_time")
    private Date cancelTime;

    /**
     * 是否自动取消(0不是 1是)
     */
    @Column(name = "is_auto_cancel")
    private Short isAutoCancel;

    /**
     * 订单是否赠送积分(0未赠送，1已赠送)
     */
    @Column(name = "is_give_integral")
    private Short isGiveIntegral;

    /**
     * 快递单号
     */
    @Column(name = "express_no")
    private String expressNo;

    /**
     * 快递公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 是否送消费券 0.否 1.是
     */
    @Column(name = "is_rebate")
    private Short isRebate;

    /**
     * 订单结算状态(1未申请 2待审核 3审核通过 4审核拒绝 5已打款）
     */
    @Column(name = "settlement_status")
    private Short settlementStatus;

    /**
     * 结算金额
     */
    @Column(name = "settlement_amount")
    private BigDecimal settlementAmount;

    /**
     * 结算单ID
     */
    @Column(name = "settlement_id")
    private Integer settlementId;

    /**
     * 是否为游戏订单（0普通订单 1游戏订单 2礼包订单 3一元购订单）
     */
    @Column(name = "is_game_order")
    private Short isGameOrder;

    /**
     * 游戏用户ID
     */
    @Column(name = "game_id")
    private Integer gameId;

    /**
     * 游戏订单通知状态（0失败 1成功）
     */
    @Column(name = "game_notify_result")
    private Short gameNotifyResult;

    /**
     * 开发票类型（0没有发票 1个人 2公司）
     */
    @Column(name = "tax_type")
    private Short taxType;

    /**
     * 公司开票的税号
     */
    @Column(name = "tax_no")
    private String taxNo;

    /**
     * 开票公司
     */
    @Column(name = "tax_company")
    private String taxCompany;

    /**
     * 发票类型（1纸质 2电子）
     */
    @Column(name = "receipt_type")
    private Short receiptType;

    /**
     * 推广优惠价
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 推荐人ID
     */
    @Column(name = "promotion_user")
    private Integer promotionUser;

    /**
     * 抵扣的游戏币金额
     */
    @Column(name = "reward_amount")
    private BigDecimal rewardAmount;

    /**
     * 推广返利 0.未返 1.已返
     */
    @Column(name = "promotion_rebate")
    private Short promotionRebate;

    /**
     * 合伙人ID
     */
    @Column(name = "partner_id")
    private Integer partnerId;

    /**
     * 返还给合伙人的金额
     */
    @Column(name = "partner_amount")
    private BigDecimal partnerAmount;

    /**
     * 返还直接推荐的会员获得金额
     */
    @Column(name = "member_amount")
    private BigDecimal memberAmount;

    /**
     * 推荐人的推荐人ID
     */
    @Column(name = "upgrade_promotion_user")
    private Integer upgradePromotionUser;

    /**
     * 推荐人的推荐人获得的推荐奖励
     */
    @Column(name = "upgrade_promotion_price")
    private BigDecimal upgradePromotionPrice;

    /**
     * 代发店铺ID
     */
    @Column(name = "proxy_shop_id")
    private Integer proxyShopId;

    /**
     * 游戏订单房卡数量
     */
    @Column(name = "room_card_num")
    private BigDecimal roomCardNum;

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
     * 获取0 线上  1 线下
     *
     * @return order_type - 0 线上  1 线下
     */
    public Short getOrderType() {
        return orderType;
    }

    /**
     * 设置0 线上  1 线下
     *
     * @param orderType 0 线上  1 线下
     */
    public void setOrderType(Short orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取商品总价
     *
     * @return pro_amount - 商品总价
     */
    public BigDecimal getProAmount() {
        return proAmount;
    }

    /**
     * 设置商品总价
     *
     * @param proAmount 商品总价
     */
    public void setProAmount(BigDecimal proAmount) {
        this.proAmount = proAmount;
    }

    /**
     * 获取运费
     *
     * @return freight - 运费
     */
    public BigDecimal getFreight() {
        return freight;
    }

    /**
     * 设置运费
     *
     * @param freight 运费
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * 获取折扣
     *
     * @return discount - 折扣
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置折扣
     *
     * @param discount 折扣
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取总价
     *
     * @return total_amount - 总价
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置总价
     *
     * @param totalAmount 总价
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取抵扣积分
     *
     * @return pay_integral - 抵扣积分
     */
    public BigDecimal getPayIntegral() {
        return payIntegral;
    }

    /**
     * 设置抵扣积分
     *
     * @param payIntegral 抵扣积分
     */
    public void setPayIntegral(BigDecimal payIntegral) {
        this.payIntegral = payIntegral;
    }

    /**
     * 获取消费券抵扣金额
     *
     * @return integral_amount - 消费券抵扣金额
     */
    public BigDecimal getIntegralAmount() {
        return integralAmount;
    }

    /**
     * 设置消费券抵扣金额
     *
     * @param integralAmount 消费券抵扣金额
     */
    public void setIntegralAmount(BigDecimal integralAmount) {
        this.integralAmount = integralAmount;
    }

    /**
     * 获取付款价格
     *
     * @return pay_amount - 付款价格
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置付款价格
     *
     * @param payAmount 付款价格
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取1 支付宝 2 微信 3纯星币 4余额 5 快捷  
     *
     * @return pay_type - 1 支付宝 2 微信 3纯星币 4余额 5 快捷  
     */
    public Short getPayType() {
        return payType;
    }

    /**
     * 设置1 支付宝 2 微信 3纯星币 4余额 5 快捷  
     *
     * @param payType 1 支付宝 2 微信 3纯星币 4余额 5 快捷  
     */
    public void setPayType(Short payType) {
        this.payType = payType;
    }

    /**
     * 获取赠送的消费券
     *
     * @return give_integral - 赠送的消费券
     */
    public BigDecimal getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * 设置赠送的消费券
     *
     * @param giveIntegral 赠送的消费券
     */
    public void setGiveIntegral(BigDecimal giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * 获取0 已取消 1 未付款 2 已付款 3已发货  4已签收 5已评价  6已追评 7退款中 8交易关闭 
     *
     * @return order_status - 0 已取消 1 未付款 2 已付款 3已发货  4已签收 5已评价  6已追评 7退款中 8交易关闭 
     */
    public Short getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置0 已取消 1 未付款 2 已付款 3已发货  4已签收 5已评价  6已追评 7退款中 8交易关闭 
     *
     * @param orderStatus 0 已取消 1 未付款 2 已付款 3已发货  4已签收 5已评价  6已追评 7退款中 8交易关闭 
     */
    public void setOrderStatus(Short orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取1 PC 2WAP 3 APP  4 微信
     *
     * @return order_sourse - 1 PC 2WAP 3 APP  4 微信
     */
    public Short getOrderSourse() {
        return orderSourse;
    }

    /**
     * 设置1 PC 2WAP 3 APP  4 微信
     *
     * @param orderSourse 1 PC 2WAP 3 APP  4 微信
     */
    public void setOrderSourse(Short orderSourse) {
        this.orderSourse = orderSourse;
    }

    /**
     * 获取收货人
     *
     * @return receiver - 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货人
     *
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取收货地址ID
     *
     * @return receive_address_id - 收货地址ID
     */
    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    /**
     * 设置收货地址ID
     *
     * @param receiveAddressId 收货地址ID
     */
    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    /**
     * 获取收货地址
     *
     * @return address - 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取是否为默认收货地址（0默认，1不默认）
     *
     * @return address_default - 是否为默认收货地址（0默认，1不默认）
     */
    public Short getAddressDefault() {
        return addressDefault;
    }

    /**
     * 设置是否为默认收货地址（0默认，1不默认）
     *
     * @param addressDefault 是否为默认收货地址（0默认，1不默认）
     */
    public void setAddressDefault(Short addressDefault) {
        this.addressDefault = addressDefault;
    }

    /**
     * 获取0 审核通过 1 审核不通过  2待审核
     *
     * @return audit_status - 0 审核通过 1 审核不通过  2待审核
     */
    public Short getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置0 审核通过 1 审核不通过  2待审核
     *
     * @param auditStatus 0 审核通过 1 审核不通过  2待审核
     */
    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取总订单号
     *
     * @return total_order_no - 总订单号
     */
    public String getTotalOrderNo() {
        return totalOrderNo;
    }

    /**
     * 设置总订单号
     *
     * @param totalOrderNo 总订单号
     */
    public void setTotalOrderNo(String totalOrderNo) {
        this.totalOrderNo = totalOrderNo;
    }

    /**
     * 获取所属店铺
     *
     * @return shop_id - 所属店铺
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置所属店铺
     *
     * @param shopId 所属店铺
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取所属用户
     *
     * @return customer_id - 所属用户
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置所属用户
     *
     * @param customerId 所属用户
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
     * 获取订单号
     *
     * @return orders_no - 订单号
     */
    public String getOrdersNo() {
        return ordersNo;
    }

    /**
     * 设置订单号
     *
     * @param ordersNo 订单号
     */
    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
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
     * 获取订单付款时间
     *
     * @return pay_time - 订单付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置订单付款时间
     *
     * @param payTime 订单付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return delivery_time - 发货时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliveryTime 发货时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取订单收货时间
     *
     * @return complete_time - 订单收货时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置订单收货时间
     *
     * @param completeTime 订单收货时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取评论时间
     *
     * @return evaluate_time - 评论时间
     */
    public Date getEvaluateTime() {
        return evaluateTime;
    }

    /**
     * 设置评论时间
     *
     * @param evaluateTime 评论时间
     */
    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    /**
     * 获取取消时间
     *
     * @return cancel_time - 取消时间
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置取消时间
     *
     * @param cancelTime 取消时间
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取是否自动取消(0不是 1是)
     *
     * @return is_auto_cancel - 是否自动取消(0不是 1是)
     */
    public Short getIsAutoCancel() {
        return isAutoCancel;
    }

    /**
     * 设置是否自动取消(0不是 1是)
     *
     * @param isAutoCancel 是否自动取消(0不是 1是)
     */
    public void setIsAutoCancel(Short isAutoCancel) {
        this.isAutoCancel = isAutoCancel;
    }

    /**
     * 获取订单是否赠送积分(0未赠送，1已赠送)
     *
     * @return is_give_integral - 订单是否赠送积分(0未赠送，1已赠送)
     */
    public Short getIsGiveIntegral() {
        return isGiveIntegral;
    }

    /**
     * 设置订单是否赠送积分(0未赠送，1已赠送)
     *
     * @param isGiveIntegral 订单是否赠送积分(0未赠送，1已赠送)
     */
    public void setIsGiveIntegral(Short isGiveIntegral) {
        this.isGiveIntegral = isGiveIntegral;
    }

    /**
     * 获取快递单号
     *
     * @return express_no - 快递单号
     */
    public String getExpressNo() {
        return expressNo;
    }

    /**
     * 设置快递单号
     *
     * @param expressNo 快递单号
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    /**
     * 获取快递公司名称
     *
     * @return company_name - 快递公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置快递公司名称
     *
     * @param companyName 快递公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取是否送消费券 0.否 1.是
     *
     * @return is_rebate - 是否送消费券 0.否 1.是
     */
    public Short getIsRebate() {
        return isRebate;
    }

    /**
     * 设置是否送消费券 0.否 1.是
     *
     * @param isRebate 是否送消费券 0.否 1.是
     */
    public void setIsRebate(Short isRebate) {
        this.isRebate = isRebate;
    }

    /**
     * 获取订单结算状态(1未申请 2待审核 3审核通过 4审核拒绝 5已打款）
     *
     * @return settlement_status - 订单结算状态(1未申请 2待审核 3审核通过 4审核拒绝 5已打款）
     */
    public Short getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * 设置订单结算状态(1未申请 2待审核 3审核通过 4审核拒绝 5已打款）
     *
     * @param settlementStatus 订单结算状态(1未申请 2待审核 3审核通过 4审核拒绝 5已打款）
     */
    public void setSettlementStatus(Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /**
     * 获取结算金额
     *
     * @return settlement_amount - 结算金额
     */
    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    /**
     * 设置结算金额
     *
     * @param settlementAmount 结算金额
     */
    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    /**
     * 获取结算单ID
     *
     * @return settlement_id - 结算单ID
     */
    public Integer getSettlementId() {
        return settlementId;
    }

    /**
     * 设置结算单ID
     *
     * @param settlementId 结算单ID
     */
    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
    }

    /**
     * 获取是否为游戏订单（0普通订单 1游戏订单 2礼包订单 3一元购订单）
     *
     * @return is_game_order - 是否为游戏订单（0普通订单 1游戏订单 2礼包订单 3一元购订单）
     */
    public Short getIsGameOrder() {
        return isGameOrder;
    }

    /**
     * 设置是否为游戏订单（0普通订单 1游戏订单 2礼包订单 3一元购订单）
     *
     * @param isGameOrder 是否为游戏订单（0普通订单 1游戏订单 2礼包订单 3一元购订单）
     */
    public void setIsGameOrder(Short isGameOrder) {
        this.isGameOrder = isGameOrder;
    }

    /**
     * 获取游戏用户ID
     *
     * @return game_id - 游戏用户ID
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * 设置游戏用户ID
     *
     * @param gameId 游戏用户ID
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     * 获取游戏订单通知状态（0失败 1成功）
     *
     * @return game_notify_result - 游戏订单通知状态（0失败 1成功）
     */
    public Short getGameNotifyResult() {
        return gameNotifyResult;
    }

    /**
     * 设置游戏订单通知状态（0失败 1成功）
     *
     * @param gameNotifyResult 游戏订单通知状态（0失败 1成功）
     */
    public void setGameNotifyResult(Short gameNotifyResult) {
        this.gameNotifyResult = gameNotifyResult;
    }

    /**
     * 获取开发票类型（0没有发票 1个人 2公司）
     *
     * @return tax_type - 开发票类型（0没有发票 1个人 2公司）
     */
    public Short getTaxType() {
        return taxType;
    }

    /**
     * 设置开发票类型（0没有发票 1个人 2公司）
     *
     * @param taxType 开发票类型（0没有发票 1个人 2公司）
     */
    public void setTaxType(Short taxType) {
        this.taxType = taxType;
    }

    /**
     * 获取公司开票的税号
     *
     * @return tax_no - 公司开票的税号
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * 设置公司开票的税号
     *
     * @param taxNo 公司开票的税号
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    /**
     * 获取开票公司
     *
     * @return tax_company - 开票公司
     */
    public String getTaxCompany() {
        return taxCompany;
    }

    /**
     * 设置开票公司
     *
     * @param taxCompany 开票公司
     */
    public void setTaxCompany(String taxCompany) {
        this.taxCompany = taxCompany;
    }

    /**
     * 获取发票类型（1纸质 2电子）
     *
     * @return receipt_type - 发票类型（1纸质 2电子）
     */
    public Short getReceiptType() {
        return receiptType;
    }

    /**
     * 设置发票类型（1纸质 2电子）
     *
     * @param receiptType 发票类型（1纸质 2电子）
     */
    public void setReceiptType(Short receiptType) {
        this.receiptType = receiptType;
    }

    /**
     * 获取推广优惠价
     *
     * @return promotion_price - 推广优惠价
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置推广优惠价
     *
     * @param promotionPrice 推广优惠价
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取推荐人ID
     *
     * @return promotion_user - 推荐人ID
     */
    public Integer getPromotionUser() {
        return promotionUser;
    }

    /**
     * 设置推荐人ID
     *
     * @param promotionUser 推荐人ID
     */
    public void setPromotionUser(Integer promotionUser) {
        this.promotionUser = promotionUser;
    }

    /**
     * 获取抵扣的游戏币金额
     *
     * @return reward_amount - 抵扣的游戏币金额
     */
    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    /**
     * 设置抵扣的游戏币金额
     *
     * @param rewardAmount 抵扣的游戏币金额
     */
    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    /**
     * 获取推广返利 0.未返 1.已返
     *
     * @return promotion_rebate - 推广返利 0.未返 1.已返
     */
    public Short getPromotionRebate() {
        return promotionRebate;
    }

    /**
     * 设置推广返利 0.未返 1.已返
     *
     * @param promotionRebate 推广返利 0.未返 1.已返
     */
    public void setPromotionRebate(Short promotionRebate) {
        this.promotionRebate = promotionRebate;
    }

    /**
     * 获取合伙人ID
     *
     * @return partner_id - 合伙人ID
     */
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     * 设置合伙人ID
     *
     * @param partnerId 合伙人ID
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 获取返还给合伙人的金额
     *
     * @return partner_amount - 返还给合伙人的金额
     */
    public BigDecimal getPartnerAmount() {
        return partnerAmount;
    }

    /**
     * 设置返还给合伙人的金额
     *
     * @param partnerAmount 返还给合伙人的金额
     */
    public void setPartnerAmount(BigDecimal partnerAmount) {
        this.partnerAmount = partnerAmount;
    }

    /**
     * 获取返还直接推荐的会员获得金额
     *
     * @return member_amount - 返还直接推荐的会员获得金额
     */
    public BigDecimal getMemberAmount() {
        return memberAmount;
    }

    /**
     * 设置返还直接推荐的会员获得金额
     *
     * @param memberAmount 返还直接推荐的会员获得金额
     */
    public void setMemberAmount(BigDecimal memberAmount) {
        this.memberAmount = memberAmount;
    }

    /**
     * 获取推荐人的推荐人ID
     *
     * @return upgrade_promotion_user - 推荐人的推荐人ID
     */
    public Integer getUpgradePromotionUser() {
        return upgradePromotionUser;
    }

    /**
     * 设置推荐人的推荐人ID
     *
     * @param upgradePromotionUser 推荐人的推荐人ID
     */
    public void setUpgradePromotionUser(Integer upgradePromotionUser) {
        this.upgradePromotionUser = upgradePromotionUser;
    }

    /**
     * 获取推荐人的推荐人获得的推荐奖励
     *
     * @return upgrade_promotion_price - 推荐人的推荐人获得的推荐奖励
     */
    public BigDecimal getUpgradePromotionPrice() {
        return upgradePromotionPrice;
    }

    /**
     * 设置推荐人的推荐人获得的推荐奖励
     *
     * @param upgradePromotionPrice 推荐人的推荐人获得的推荐奖励
     */
    public void setUpgradePromotionPrice(BigDecimal upgradePromotionPrice) {
        this.upgradePromotionPrice = upgradePromotionPrice;
    }

    /**
     * 获取代发店铺ID
     *
     * @return proxy_shop_id - 代发店铺ID
     */
    public Integer getProxyShopId() {
        return proxyShopId;
    }

    /**
     * 设置代发店铺ID
     *
     * @param proxyShopId 代发店铺ID
     */
    public void setProxyShopId(Integer proxyShopId) {
        this.proxyShopId = proxyShopId;
    }

    /**
     * 获取游戏订单房卡数量
     *
     * @return room_card_num - 游戏订单房卡数量
     */
    public BigDecimal getRoomCardNum() {
        return roomCardNum;
    }

    /**
     * 设置游戏订单房卡数量
     *
     * @param roomCardNum 游戏订单房卡数量
     */
    public void setRoomCardNum(BigDecimal roomCardNum) {
        this.roomCardNum = roomCardNum;
    }
}