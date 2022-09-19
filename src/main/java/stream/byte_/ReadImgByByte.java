package stream.byte_;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadImgByByte {
/**
 *@author zhouyu
 *@date 2022/6/22 10:56
 */
public static void main(String[] args) throws IOException {
    File file =new File("D:/R.png");
    if(!file.exists()){
        file.createNewFile();
    }
    InputStream inputStream =new FileInputStream(file);
    //二进制文件reader读不了,要用byte[]存储
    byte[] content= new byte[(int) file.length()];
    inputStream.read(content);//读取file内容并存入content中
    inputStream.close();
    for (byte b : content) {
        System.out.print(b+" ");
    }
}
}
