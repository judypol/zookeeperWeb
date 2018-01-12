package com.guanyi.zkweb.configuration;

import com.guanyi.zkweb.utils.ZkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ZkwebConfig {
    @Autowired
    Environment env;
    @Bean
    public ZkUtils getZkUtils(){
        return new ZkUtils(env.getProperty("zkhost"));
    }
}
