import java.io.File;
import java.io.IOException;

public class FileTest {
/**
 *@author zhouyu
 *@date 2022/6/22 9:59
 */
static File file =new File("D:/JavaIOTest");
static File file2=new File("D:/dirTest");
    public static void main(String[] args) throws IOException {
        file.createNewFile();
        file2.mkdir();
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getParent());
    }
}
