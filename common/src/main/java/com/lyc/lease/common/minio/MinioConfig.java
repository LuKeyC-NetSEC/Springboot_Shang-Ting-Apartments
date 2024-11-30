package com.lyc.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LuKey_C
 * @Description: TODO Minio配置类
 * @Date: 2024/11/30 16:24
 * @Version: 1.0
 */

@Configuration
//@ConfigurationPropertiesScan("com.lyc.lease.common.minio")
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;
    @Bean
    public MinioClient minioClient(){

        return MinioClient.builder()
                .endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(),minioProperties.getSecretKey())
                .build();
    }
}
