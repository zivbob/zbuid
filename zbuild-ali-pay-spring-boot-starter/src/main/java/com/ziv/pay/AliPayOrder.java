package com.ziv.pay;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 支付宝支付订单类
 *
 * @author ziv
 * @date 2020-10-14
 */
public class AliPayOrder {

    /**
     * 销售产品码
     */
    private static final String PRODUCT_CODE = "FAST_INSTANT_TRADE_PAY";

    /**
     * 交易单号
     */
    private String outTradeNo;

    /**
     * 交易金额
     */
    private BigDecimal totalAmount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 订单描述
     */
    private String body;

    /**
     * 绝对超时时间-yyyy-MM-dd HH:mm:ss
     */
    private Date timeExpire;

    private List<AliPayGoods> goodsList;

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    public Map<String, Object> getInfo() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> info = new HashMap<>(16);

        info.put("out_trade_no", outTradeNo);
        info.put("product_code", PRODUCT_CODE);
        info.put("total_amount", totalAmount.setScale(2, RoundingMode.HALF_UP).doubleValue());
        info.put("subject", subject);
        info.put("body", body);
        info.put("time_expire", dateTimeFormatter.format(timeExpire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));

        if (goodsList != null && goodsList.size() > 0) {
            LinkedList<Map<String, Object>> goodsDetail = new LinkedList<>();
            goodsList.forEach(goods -> goodsDetail.addLast(goods.toMap()));
            info.put("goods_detail", goodsDetail);
        }

        return info;
    }

}
