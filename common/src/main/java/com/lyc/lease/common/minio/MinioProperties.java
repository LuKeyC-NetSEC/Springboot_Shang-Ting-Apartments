package com.lyc.lease.common.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LuKey_C
 * @Description: TODO 加载minio开头的属性
 * @Date: 2024/11/30 16:32
 * @Version: 1.0
 */

@Data
@ConfigurationProperties(prefix = "minio") // 读取 web-admin 模块中配置文件中minio开头的属性
public class MinioProperties {
    private String endpoint; // 对应配置文件中的 minio.endpoint
    private String accessKey; // 对应配置文件中的 minio.access-key
    private String secretKey; // 对应配置文件中的 minio.secret-Key
    private String bucketName; // 对应配置文件中的 minio.bucket-name
}
