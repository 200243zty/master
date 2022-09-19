package Thread;

public class ThreadState implements  Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("zzc&zdw are sb");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return ;
            }
        }
    }

    public static void main(String[] args) {
        ThreadState thread =new ThreadState();
        Thread t =new Thread(thread);
        t.start();
        try {
            Thread.sleep(5000); //主线程睡眠5s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
/**
 *@author zhouyu
 *@date 2022/9/6 14:04
 */
}
