package com.ziv.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝支付业务逻辑封装
 *
 * @author ziv
 * @date 2020-10-13
 */
public class AliPayService {

    private AlipayClient alipayClient;

    private AliPayProperties aliPayProperties;

    public AliPayService(AliPayProperties aliPayProperties, AlipayClient alipayClient) {
        this.aliPayProperties = aliPayProperties;
        this.alipayClient = alipayClient;
    }

    /**
     * 发起支付
     * @param order 订单信息
     * @return String 支付form表单
     * @throws AlipayApiException
     */
    public String pageExecute(AliPayOrder order) throws AlipayApiException {
        Map data = order.getInfo();

        AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
        payRequest.setBizContent(JSON.toJSONString(data));
        payRequest.setNotifyUrl(aliPayProperties.getNotifyUrl());
        payRequest.setReturnUrl(aliPayProperties.getReturnUrl());

        return alipayClient.pageExecute(payRequest).getBody();
    }

    /**
     * 支付宝验签
     * @param params 请求参数
     * @return boolean
     */
    public boolean verify(Map<String, String> params) {
        boolean flag = false;
        try {
            flag = AlipaySignature.rsaCheckV1(params,
                    aliPayProperties.getAlipayPublicKey(),
                    aliPayProperties.getCharset(),
                    aliPayProperties.getSignType());
        } catch (AlipayApiException e) {
            System.err.println("验签失败");
            e.printStackTrace();
            flag = false;
        } finally {
            return flag;
        }
    }

}