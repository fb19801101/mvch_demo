package com.mvc.bean;

import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.*;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 16:36
 */
public class UploadFileBean {
    private String driverPath = null;
    private String tempFileName = null;
    private String saveFileName = null;
    private InputStream fileSource = null;
    private String uploadFileName = null;
    private String backMessage = null;
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public String getTempFileName() {
        return tempFileName;
    }

    public void setTempFileName(String tempFileName) {
        this.tempFileName = tempFileName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public void setFileSource(InputStream fileSource) {
        this.fileSource = fileSource;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getBackMessage() {
        if (fileSource != null){
            uploadFileMethod();
        }
        else{
            backMessage = "未选择文件！";
        }
        return backMessage;
    }

    public boolean uploadFileMethod() {
        try{//上传文件保存到临时文件中
            File f1 = new File(driverPath,tempFileName);
            FileOutputStream fos = new FileOutputStream(f1);
            byte b[] = new byte[10000];
            int n;
            while((n = fileSource.read(b)) != -1) {
                fos.write(b, 0, n);
            }
            fos.close();
            fileSource.close();
            //读取临时文件中第二行的内容
            RandomAccessFile random = new RandomAccessFile(f1,"r");
            int second = 1;
            String secondLine = null;
            while(second <= 2) {
                secondLine = random.readLine();
                second++;
            }
            //得到上传文件的文件名
            int position = secondLine.lastIndexOf('=');
            uploadFileName = secondLine.substring(position+2, secondLine.length()-1);
            //转换编码，识别汉字文件名
            byte cc[] = uploadFileName.getBytes("iso-8859-1");
            uploadFileName = new String(cc);
            //得到上传文件的扩展名
            int extposition = uploadFileName.lastIndexOf('.');
            String extName = uploadFileName.substring(extposition+1, uploadFileName.length());
            //获取上传临时文件第四行回车符的位置
            random.seek(0);
            long forthEndPosition = 0;
            int forth=1;
            while((n=random.readByte()) != -1 && forth <= 4){
                if(n == '\n') {
                    forthEndPosition=random.getFilePointer();
                    forth++;
                }
            }
            //删除重名的文件
            saveFileName = saveFileName.concat("."+extName);
            File dir = new File(driverPath);
            dir.mkdir();
            File file[] = dir.listFiles();
            for(int k = 0; k < file.length; k++){
                if(file[k].getName().equals(saveFileName)) {
                    file[k].delete();
                }
            }
            //按新文件名保存文件
            File savingFile = new File(driverPath,saveFileName);
            RandomAccessFile random2 = new RandomAccessFile(savingFile,"rw");
            //在临时文件中获得上传文件结束位置
            random.seek(random.length());
            long endPosition = random.getFilePointer();
            long mark = endPosition;
            int j = 1;
            while((mark >= 0) && (j <= 6)) {
                mark--;
                random.seek(mark);
                n=random.readByte();
                if(n == '\n') {
                    endPosition = random.getFilePointer();
                    j++;
                }
            }
            random.seek(forthEndPosition);
            long startPoint = random.getFilePointer();
            while(startPoint < endPosition-1){
                n=random.readByte();
                random2.write(n);
                startPoint = random.getFilePointer();
            }
            random2.close();
            random.close();
            f1.delete();
            flag = true;
            backMessage = "成功上传！";
        }
        catch(Exception exp)
        {
            System.out.println("uploadFileMethod"+exp.toString());
            backMessage = "上传失败";
            flag = false;
        }
        return flag;
    }
}
