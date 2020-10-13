package com.ziv.pay;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝支付自动配置
 *
 * @author ziv
 * @date 2020-10-13
 */
@Configuration
@EnableConfigurationProperties(PayProperties.class)
@ConditionalOnClass(value = HelloService.class)
public class AliPayAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "pay.ali.enable", havingValue = "true")
    public HelloService helloService() {
        return new HelloService();
    }
}
