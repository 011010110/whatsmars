package com.itlong.whatsmars.spring.boot.config;

import com.itlong.whatsmars.spring.boot.interceptor.ApiAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;

/**
 * Created by javahongxi on 2017/11/16.
 */
@Configuration
public class AppConfig {

    @Autowired
    private UserConfig userConfig;

    @ConditionalOnProperty(value = "api.auth.enable")
    @Profile({"test", "prod"})
    @Configuration
    public static class WebMvcConf extends WebMvcConfigurerAdapter {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(apiAuthInterceptor())
                    .addPathPatterns("/api/mars/**")
                    .addPathPatterns("/api/toutiao/**")
                    .pathMatcher(new AntPathMatcher());
        }

        @Bean
        public HandlerInterceptor apiAuthInterceptor() {
            return new ApiAuthInterceptor();
        }

        @Bean
        public FilterRegistrationBean commonsRequestLoggingFilter() {
            FilterRegistrationBean registration = new FilterRegistrationBean();
            registration.setName("requestLoggingFilter");
            registration.setDispatcherTypes(DispatcherType.REQUEST);
            registration.setFilter(new CommonsRequestLoggingFilter());
            registration.addUrlPatterns("/**");
            registration.setOrder(Integer.MAX_VALUE);
            return registration;
        }

    }
}
