package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.在运行状态中，需要时Subject和RealSubject中动态的创建一个Proxy，用完即销毁
 * 使用InvocationHandler接口负责所有Proxy类方法的调用，Proxy类需实现该接口
 */
interface Subject{
    void hello(String str);
    String bye();
}
class RealSubject implements Subject{

    @Override
    public void hello(String str) {
        System.out.println("Hello"+str);
    }

    @Override
    public String bye() {
        System.out.println("Goodbye");
        return "over";
    }
}
//创建动态代理类
class ProxyDemo implements InvocationHandler{
    //要代理的对象
    private Subject subject;

    public ProxyDemo(Subject subject){
        this.subject=subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method");
        System.out.println("Call method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler(InvocatioinHandler的实例）对象的invoke方法来进行调用
        Object invoke = method.invoke(subject, args);
        System.out.println("After method");

        return invoke;
    }

}
public class DynamicProxyTest {
    public static void main(String[] args) {
        Subject subject =new RealSubject();
        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler =new ProxyDemo(subject);
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject proxySubject =(Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        System.out.println(proxySubject.getClass().getCanonicalName());
        proxySubject.hello("zhouy");
        String bye = proxySubject.bye();
        System.out.println("last:"+bye);
    }
}
