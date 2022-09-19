package reflection;
//关于反射
import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class Test {
    //reflect包下核心接口和类
    /**
     * Member 接口 - 反映关于单个成员(字段或方法)或构造函数的标识信息。
     * Field 类 - 提供一个类的域的信息以及访问类的域的接口。
     * Method 类 - 提供一个类的方法的信息以及访问类的方法的接口。
     * Constructor 类 - 提供一个类的构造函数的信息以及访问类的构造函数的接口。
     * Array 类 - 该类提供动态地生成和访问 JAVA 数组的方法。
     * Modifier 类 - 提供了 static 方法和常量，对类和成员访问修饰符进行解码。
     * Proxy 类 - 提供动态地生成代理类和类实例的静态方法。
     */

    //获取class的三种方式
    //1.Class.forName(),使用类的全限定名
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//        try {
//            Class c1= Class.forName("[D");
//            System.out.println(c1.getName()); //虚拟机中的class的表示
//            System.out.println(c1.getCanonicalName());//更具体的表示，对于array和内部类来说
//            Class c2 =Class.forName("[Ljava.lang.String;");
//            System.out.println(c2.getCanonicalName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        testClass();
        System.out.println("");
        testGetClass();
        System.out.println("");
        testInstanceOf();
        System.out.println("");
        testNewInstance();
    }
    //.class()
    public static void testClass(){
        Class c1 =int.class;
        System.out.println(c1.getCanonicalName());
        Class c2=Test.class;
        System.out.println(c2.getCanonicalName());
    }
    //使用Object.getClass
    public static void testGetClass(){
        Class c1="zhouy".getClass();
        System.out.println(c1.getCanonicalName());
        Set<String> set =new HashSet<>();
        Class c2 =set.getClass();
        System.out.println(c2.getCanonicalName());
    }
    //判断某个对象是否位某个类的实例
    public static void testInstanceOf(){
        ArrayList arrayList =new ArrayList();
        System.out.println(arrayList instanceof List);
    }
    //创建实例

    /**
     * 1.用Class对象的newInstance
     * 2.用Constructor对象的newInstance
     */
    public static void testNewInstance() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.
        Class<StringBuffer> c1 = StringBuffer.class;
        StringBuffer stringBuffer = c1.newInstance();
        System.out.println(stringBuffer.append("aaa"));
        //2.
        Class<String> c2 = String.class;
        Constructor<String> constructor = c2.getConstructor(c2);
        String s = constructor.newInstance("bbb");
        System.out.println(s);
    }
}
