package stream.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
public class CatToByte implements Serializable {
/**
 *@author zhouyu
 *@date 2022/6/22 11:20
 */
private int age;
private String name;

    public static void main(String[] args) throws IOException {
        File file =new File("D:/JavaIOSerialization");
        if(!file.exists()){
            file.createNewFile();
        }
        CatToByte cat =new CatToByte();
        cat.setName("大橘");
        cat.setAge(2);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream  oos =new ObjectOutputStream(bos);
        //ObjectOutputStream接受一个OutputStream out
        oos.writeObject(cat);//序列化cat,并保存到字节序列输出流中(bos)
        //存储至文件
        OutputStream outputStream =new FileOutputStream(file);
        outputStream.write(bos.toByteArray());
        outputStream.close();
        oos.close();
        bos.close();
    }
}
