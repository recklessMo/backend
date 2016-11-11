package com.recklessmo.service.ftp;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * 用于进行FTP上传,这样可以发布之后直接上传静态页面到网站服务器.
 * 也可以用于上传图片等文件
 *
 * Created by hpf on 11/10/16.
 */
@Service
public class FtpUploadService {

    public void updatFileByFtp(String directory, String content, String fileName)throws Exception{
        FTPClient ftpClient = new FTPClient();
        InputStream fis = null;
        try{
            //WFWZ005300
            //x8b5e4X9
            ftpClient.connect("119.10.40.62");
            ftpClient.login("WFWZ005300", "x8b5e4X9");
            fis = new ByteArrayInputStream(content.getBytes("UTF-8"));
            //设置上传目录
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");
            //设置文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile(fileName, fis);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            IOUtils.closeQuietly(fis);
            try{
                ftpClient.disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FtpUploadService ftpUploadService = new FtpUploadService();
        try {
            ftpUploadService.updatFileByFtp("/www", "aaa你好", "测试.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
