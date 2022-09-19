package Thread.safe;

//多个线程持有对方需要的资源，等待对方先释放，形成僵局
public class DeadLock {
    public static void main(String[] args) {
        new Thread(new Makeup(0,"周**")).start();
        new Thread(new Makeup(1,"鹿瑶")).start();
    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
//化妆类
class Makeup implements Runnable{
    //需要的资源只有一份
    private static Lipstick lipstick =new Lipstick();
    private static Mirror mirror =new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆
    private void makeup() throws InterruptedException {
//        if(choice==0){
//            //当一个同步块持有两个及以上的对象锁时可能发生下面这样的死锁
//            synchronized (lipstick){ //获得口红的锁
//                System.out.println(girlName+"获得口红的锁");
//                Thread.sleep(1000);
//                //1s 后想获得镜子
//                synchronized (mirror){
//                    System.out.println(girlName+"获得镜子的锁");
//                }
//            }
//        }
//        else{
//            synchronized (mirror){ //获得口红的锁
//                System.out.println(girlName+"获得镜子的锁");
//                Thread.sleep(1000);
//                //1s 后想获得镜子
//                synchronized (lipstick){
//                    System.out.println(girlName+"获得口红的锁");
//                }
//            }
//        }

        if(choice==0){
            //当一个同步块持有两个及以上的对象锁时可能发生下面这样的死锁
            synchronized (lipstick){ //获得口红的锁
                System.out.println(girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(girlName+"获得镜子的锁");
            }
        }
        else{
            synchronized (mirror){ //获得口红的锁
                System.out.println(girlName+"获得镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick){
                System.out.println(girlName+"获得口红的锁");
            }
        }

    }
}
