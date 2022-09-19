package stream.serialization;
import java.io.*;

public class ByteToCat {
/**D:/JavaIOSerialization
 *@author zhouyu
 *@date 2022/6/22 11:42
 */
public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file =new File("D:/JavaIOSerialization");
    if(!file.exists()){
        file.createNewFile();
    }
    byte []content =new byte[(int) file.length()];
    InputStream fis=new FileInputStream(file);
    fis.read(content);
    fis.close();
    ByteArrayInputStream bis=new ByteArrayInputStream(content);
    ObjectInputStream ois=new ObjectInputStream(bis);//从bis字节输入流中读取
    CatToByte cat = (CatToByte) ois.readObject();
    ois.close();
    bis.close();
    System.out.println(cat.getName()+" "+cat.getAge());
}
}
