package Thread;

//在A线程中执行B.join 那么A线程将会被暂时挂起，直到B线程执行完毕
public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("客户线程");
        }
    }

    public static void main(String[] args) {
        ThreadJoin t1 =new ThreadJoin();
        Thread thread =new Thread(t1);
        thread.start();
        try {
            thread.join(); //主线程暂时挂起，知道客户线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程");
        }
    }
/**
 *@author zhouyu
 *@date 2022/9/6 14:55
 */
}
