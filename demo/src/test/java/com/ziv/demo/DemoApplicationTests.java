package com.ziv.demo;

import com.alipay.api.AlipayApiException;
import com.ziv.pay.AliPayOrder;
import com.ziv.pay.AliPayService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private AliPayService aliPayService;

    @Test
    void contextLoads() throws AlipayApiException {
        AliPayOrder order = new AliPayOrder();
        order.setOutTradeNo("20201014162801");
        order.setTotalAmount(new BigDecimal(888.88));
        order.setSubject("手机");
        order.setBody("5G手机");
        order.setTimeExpire(new Date());
        String form = aliPayService.pageExecute(order);
        System.err.println(form);
    }

}
