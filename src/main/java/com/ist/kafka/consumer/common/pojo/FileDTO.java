package com.ist.kafka.consumer.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端文件交互用
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private String url;             // 预览用地址
    private String relativePath;    // 服务器的保存位置，相对路径？
    private String absolutePath;    // 实际存储位置
    private String filename;        // 描述信息
    private String originalFilename;   //原文件名
}
