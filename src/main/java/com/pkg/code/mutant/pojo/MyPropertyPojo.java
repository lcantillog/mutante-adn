package com.pkg.code.mutant.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "my.url")
public class MyPropertyPojo {
    private String palatsi;
    private String dolphin;
    private String ellencce;
    private String pass_palatsi;
    private String pass_dolphin;
    private String pass_ellencce;
}
