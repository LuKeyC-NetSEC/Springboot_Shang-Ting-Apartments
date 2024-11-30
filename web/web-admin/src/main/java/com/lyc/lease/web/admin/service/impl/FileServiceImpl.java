package com.lyc.lease.web.admin.service.impl;

import com.lyc.lease.common.minio.MinioProperties;
import com.lyc.lease.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: LuKey_C
 * @Description: TODO FileService接口的实现类，用于使用Minio进行文件上传。
 * @Date: 2024/11/30 17:16
 * @Version: 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties properties;

    /**
     * 将文件上传到Minio服务器。
     *
     * @param file 要上传的文件
     * @return 上传文件的URL，如果上传失败则返回null
     */
    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        boolean bucketExists = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(properties.getBucketName())
                        .build());
        if (!bucketExists) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(properties.getBucketName())
                            .build());
            minioClient.setBucketPolicy(
                    SetBucketPolicyArgs.builder()
                            .bucket(properties.getBucketName())
                            .config(createBucketPolicyConfig(properties.getBucketName()))
                            .build());
        }
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date()) +
                "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(properties.getBucketName())
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());
        return String.join("/", properties.getEndpoint(), properties.getBucketName(), fileName);
    }

    /**
     * 创建允许公共读取访问的桶策略配置。
     *
     * @param bucketName 桶的名称
     * @return 桶策略配置的JSON字符串
     */
    private String createBucketPolicyConfig(String bucketName) {

        return """
                {
                  "Statement" : [ {
                    "Action" : "s3:GetObject",
                    "Effect" : "Allow",
                    "Principal" : "*",
                    "Resource" : "arn:aws:s3:::%s/*"
                  } ],
                  "Version" : "2012-10-17"
                }
                """.formatted(bucketName);
    }
}
