package com.ziv.pay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * 支付宝支付自动配置
 *
 * @author ziv
 * @date 2020-10-13
 */
@Configuration
@EnableConfigurationProperties(AliPayProperties.class)
@ConditionalOnClass(value = AlipayClient.class)
public class AliPayAutoConfiguration {
    Log log = LogFactory.getLog(AliPayAutoConfiguration.class);

    @Resource
    private AliPayProperties aliPayProperties;

    @Bean
    @ConditionalOnMissingBean
    public AliPayService alipayClient() {
        if (aliPayProperties != null) {
            AlipayClient alipayClient = new DefaultAlipayClient(
                    aliPayProperties.getGatewayUrl(),
                    aliPayProperties.getAppId(),
                    aliPayProperties.getMerchantPrivateKey(),
                    aliPayProperties.getFormat(),
                    aliPayProperties.getCharset(),
                    aliPayProperties.getAlipayPublicKey(),
                    aliPayProperties.getSignType());
            return new AliPayService(aliPayProperties, alipayClient);
        } else {
            log.error("未配置支付宝支付相关参数");
            return null;
        }
    }
}
