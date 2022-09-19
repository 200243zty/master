package stream.char_;

import java.io.*;

public class WriteFileByChar {
/**
 *@author zhouyu
 *@date 2022/6/22 10:38
 */
public static void print() throws IOException {
    File file =new File("D:/javaIOTest");
    if(!file.exists()){
        file.createNewFile();
    }
    Writer writer=new FileWriter(file);
    BufferedWriter bufferedWriter =new BufferedWriter(writer);
    bufferedWriter.write("It takes time");
    bufferedWriter.newLine();
    bufferedWriter.write("Now just free yourself");
    bufferedWriter.close();
    writer.close();
}
public static void main(String[] args) throws IOException {
    File file =new File("D:/javaIOTest");
    if(!file.exists()){
        file.createNewFile();
    }
    OutputStream outputStream=new FileOutputStream(file);
    Writer writer=new OutputStreamWriter(outputStream);
    BufferedWriter bufferedWriter=new BufferedWriter(writer);
    bufferedWriter.write("I am zhouy and I love xy");
    bufferedWriter.newLine();
    bufferedWriter.write("But I don't know how to say");
    bufferedWriter.close();
    writer.close();
    outputStream.close();
    print();//write默认清空之前内容，再执行本次写入
}
}
