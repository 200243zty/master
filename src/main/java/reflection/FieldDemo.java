package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test2{
    public boolean[][] b = {{false, false}, {true, true}};
    public String name="zhouy";
    public List<Integer> list= new ArrayList<>(Arrays.asList(1,2,3));
    private String lover="???";
}

/**
 * getFiled - 根据名称获取公有的（public）类成员。
 * getDeclaredField - 根据名称获取已声明的类成员。但不能得到其父类的类成员。
 * getFields - 获取所有公有的（public）类成员。
 * getDeclaredFields - 获取所有已声明的类成员。
 */
public class FieldDemo {
    public static void main(String[] args) throws NoSuchFieldException {
//        Field b = Test2.class.getField("b");
//        System.out.println(b);
//        System.out.println(b.getType());
//
//        Field name = Test2.class.getField("name");
//        System.out.println(name.getType());

//        Field[] fields = Test2.class.getFields();
//        for (Field field : fields) {
//            System.out.println(field.getType());
//        }
        //无法获取private,只能获取public
//        System.out.println(Test2.class.getField("lover").getType());
        //可以获取全部
        System.out.println(Test2.class.getDeclaredField("lover").getType());
    }
}
