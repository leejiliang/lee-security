package com.lee.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: lee-security
 * @description: SecurityConfig
 * @author: Jiliang.Lee
 * @create: 2018-10-19 20:34
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig {
}
