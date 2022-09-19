package stream.char_;
import java.io.*;
//一般二进制文件
//f1:File-->FileInputStream-->Reader(inputStreamReader)-->BufferReader
//f2 其实上面FileInputStream是没有意义的,File-->Reader(FileReader)-->BufferReader
public class ReadFileByChar {
/**
 *@author zhouyu
 *@date 2022/6/22 10:13
 */
public static void print() throws IOException {
    File file =new File("D:/javaIOTest");
    Reader reader=new FileReader(file);
    BufferedReader bufferedReader=new BufferedReader(reader);
    String line ;
    while((line=bufferedReader.readLine())!=null){
        System.out.println(line);
    }
    reader.close();
    bufferedReader.close();
}
public static void main(String[] args) throws IOException {
    //InputStream字节流读入,通过InputStreamReader字符流读取
    File file =new File("D:/javaIOTest");
    InputStream inputStream =new java.io.FileInputStream(file);
    Reader fileInputStreamReader= new InputStreamReader(inputStream);
    //让fileInputStreamReader增加缓冲功能
    BufferedReader bufferedReader=new BufferedReader(fileInputStreamReader);
    String line;
    while((line=bufferedReader.readLine())!=null){
        System.out.println(line);
    }
    bufferedReader.close();
    fileInputStreamReader.close();
    inputStream.close();
    System.out.println("写法上的不同");
    print();
}
}
