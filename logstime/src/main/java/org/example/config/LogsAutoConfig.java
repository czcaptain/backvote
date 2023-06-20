package org.example.config;


import org.example.aspect.LogsAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(A.class) // 存在目标类时才会初始化
public class LogsAutoConfig {

    /**
     * 自动生成切面类
     * @return
     */
    @Bean
    @ConditionalOnMissingBean //当你的bean被注册之后，如果而注册相同类型的bean，就不会成功，它会保证你的bean只有一个，即你的实例只有一个
    public LogsAspect getBean() {
        return new LogsAspect();
    }
}
