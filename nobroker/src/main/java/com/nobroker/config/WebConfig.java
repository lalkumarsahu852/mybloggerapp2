package com.nobroker.config;

import com.nobroker.filters.PropertyApprovalFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class WebConfig {

    @Bean
    public FilterRegistrationBean<PropertyApprovalFilter> propertyApprovalFilter(){
        FilterRegistrationBean<PropertyApprovalFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new PropertyApprovalFilter());
        registrationBean.addUrlPatterns("/properties/*");
        return registrationBean;
    }
}
