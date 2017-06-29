package com.itlong.whatsmars.spring.boot;

import com.itlong.whatsmars.spring.boot.config.UserConfig;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
// 加上exclude=DataSource..后，不会连接数据库，同时@Mapper也不会起作用
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({UserConfig.class})
@ImportResource(locations={"classpath*:spring/*.xml"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        // motan
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("server start...");
    }

}