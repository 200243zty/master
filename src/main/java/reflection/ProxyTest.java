package reflection;

/**
 * 静态代理模式(时间模式中)
 */
interface Marry{
    void doMarry();
}
class You implements Marry{
    @Override
    public void doMarry() {
        System.out.println("我要结婚了");
    }
}

class WeddingCompany implements Marry{ //作为代理中介
    private You you;

    public WeddingCompany(You you){
        this.you =you;
    }
    @Override
    public void doMarry() {
        if(you!=null){
            System.out.println("你要化妆");
            System.out.println("你要去接亲");
            you.doMarry();
            System.out.println("你结账");
        }
    }
}
//如上就是静态代理
public class ProxyTest {
    public static void main(String[] args) {
        You you =new You();
        Marry yourMarry =new WeddingCompany(you);
        yourMarry.doMarry();
    }
}
