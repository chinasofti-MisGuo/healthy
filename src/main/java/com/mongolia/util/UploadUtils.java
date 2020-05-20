package com.mongolia.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件上传工具类
 *
 * @author Dong.wen
 */
public class UploadUtils {

    /**
     * 保存文件
     *
     * @param filePath 文件路径
     * @param multipartFile 文件
     * @return 文件路径
     * @throws Exception 文件保存异常
     */
    public static String save(String filePath, MultipartFile multipartFile) throws Exception {

        String path = getFilePath(multipartFile.getOriginalFilename(), filePath);
        OutputStream outputStream = new FileOutputStream(path);

        InputStream input = multipartFile.getInputStream();

        int length = 0;
        byte[] bytes = new byte[1024];
        while ((length = input.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
        }
        input.close();
        outputStream.close();
        return pathEdit(path);
    }

    /**
     * 路径处理
     *
     * @param path 需要处理的路径
     * @return 相对路径
     */
    private static String pathEdit(String path) {
        return StringUtils.isEmpty(path) ? "" : StringUtils.substring(path, path.lastIndexOf("/upload") + 7);
    }

    /**
     * 获取文件保存全路径
     *
     * @param fileName 文件名     eg:photo.jpg
     * @param filePath 文件路径  eg: /var/file/image
     * @return 全路径  eg:/var/file/image/2020-01-10/photo.jpg
     */
    private static String getFilePath(String fileName, String filePath) {
        filePath = filePath.replaceAll("\\\\", "/");
        String name = getFileName(fileName, getFileSuffix(fileName));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(new Date()) + "/";
        StringBuilder stringBuilder = new StringBuilder(filePath);
        stringBuilder.append("/" + dateStr);
        String savePath = stringBuilder.substring(0, stringBuilder.lastIndexOf("/") + 1);
        File folder = new File(savePath);
        if (!folder.exists() || !folder.isDirectory()) {
            folder.mkdirs();
        }
        return savePath + name;
    }

    /**
     * 通过文件名的哈希值与uuid生成唯一文件名
     *
     * @param fileName 文件名
     * @param suffix   文件后缀
     * @return uuid与文件名组合的新文件名
     */
    private static String getFileName(String fileName, String suffix) {
        fileName = fileName.replaceAll(".", "");
        String uuid = UUID.randomUUID().toString();
        int hashcode = fileName.hashCode();
        return uuid + hashcode + suffix;
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName 文件全名    eg:photo.jpg
     * @return 后缀名  eg:.jpg
     */
    private static String getFileSuffix(String fileName) {
        return (StringUtils.isEmpty(fileName) ? "" : fileName.substring(fileName.lastIndexOf(".")));
    }
}
