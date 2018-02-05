package com.kent.datasource.spring.boot.autoconfigure;

import com.kent.datasource.aspect.DynamicDataSourceAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kongtong.ouyang on 2018/2/5.
 */
@Configuration
@ConditionalOnClass(DynamicDataSourceAspect.class)
public class DynamicDataSourceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DynamicDataSourceAspect dynamicDataSourceAspect() throws Exception {
        return new DynamicDataSourceAspect();
    }
}
