package com.pkg.code.mutant.config;

import com.pkg.code.mutant.pojo.MyPropertyPojo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableConfigurationProperties(MyPropertyPojo.class)
public class SpringConfig {

}
