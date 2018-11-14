package com.mmall.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author WangCH
 * @create 2018-02-09 21:30
 */
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);
    private static String ftpIp =  PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser =  PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass =  PropertiesUtil.getProperty("ftp.pass");

    public FTPUtil(String ip,int port,String user,String pwd){
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    //上传文件到FTP
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp,21,ftpUser,ftpPass);
        logger.info("开始连接tfp服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器，结束上传，上传结果{}",result);
        return result;
    }

    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                ftpClient.changeWorkingDirectory(remotePath);// 设置上传目录
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); //二进制
                ftpClient.enterLocalPassiveMode();
                //上传文件
                for(File item :fileList){
                    fis = new FileInputStream(item);
                    ftpClient.storeFile(item.getName(), fis);
                }
            } catch (IOException e) {
                logger.error("上传文件异常",e);
                uploaded = false;
                //e.printStackTrace();
            }finally {
                fis.close();
                ftpClient.disconnect();
            }
        }else{//连接失败
            return false;
        }
        return uploaded;
    }
    //连接FTP服务器
    private boolean connectServer(String ip,int port,String user,String pwd){
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);

        } catch (IOException e) {
            logger.error("连接FTP服务器异常",e);
        }
        return isSuccess;
    }



}
