package stream.byte_;

import java.io.*;

public class WriteByteToFile {
/**
 *@author zhouyu
 *@date 2022/6/22 11:10
 */
public static void main(String[] args) throws IOException {
    File file =new File("D:/javaIOImgTest");
    if(!file.exists()){
        file.createNewFile();
    }
    OutputStream outputStream =new FileOutputStream(file);
    byte [] content ={1,2,3,4};
    outputStream.write(content);
    outputStream.close();
}
}
