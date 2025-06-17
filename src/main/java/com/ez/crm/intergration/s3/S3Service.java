package com.ez.crm.intergration.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;

@Service
public class S3Service {

//    @Value("${cloud.aws.bucket}")
//    private String bucketName;
//
//    private final S3Client s3Client;
//
//    public S3Service(S3Client s3Client) {
//        this.s3Client = s3Client;
//    }
//
//    public void uploadFile(String key, InputStream inputStream, long contentLength, String contentType) {
//        PutObjectRequest putRequest = PutObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .contentType(contentType)
//                .build();
//
//        s3Client.putObject(putRequest, RequestBody.fromInputStream(inputStream, contentLength));
//    }
//
//    public byte[] downloadFile(String key) {
//        GetObjectRequest getRequest = GetObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//
//        ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObjectAsBytes(getRequest);
//        return objectBytes.asByteArray();
//    }
//
//    public void deleteFile(String key) {
//        DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//
//        s3Client.deleteObject(deleteRequest);
//    }
}

