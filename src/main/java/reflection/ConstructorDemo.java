package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * getConstructor - 返回类的特定 public 构造方法。参数为方法参数对应 Class 的对象。
 * getDeclaredConstructor - 返回类的特定构造方法。参数为方法参数对应 Class 的对象。
 * getConstructors - 返回类的所有 public 构造方法。
 * getDeclaredConstructors - 返回类的所有构造方法。
 *
 */
public class ConstructorDemo{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取所有构造方法
//        Constructor<?>[] declaredConstructors = String.class.getDeclaredConstructors();
//        for (Constructor declaredConstructor : declaredConstructors) {
//            System.out.println(declaredConstructor);
//        }

        Constructor<String> constructor = String.class.getConstructor(String.class);
        System.out.println(constructor);
        String s = constructor.newInstance("I love java");
        System.out.println(s);
    }
}
