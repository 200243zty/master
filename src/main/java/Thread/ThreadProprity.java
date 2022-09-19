package Thread;

public class ThreadProprity implements Runnable{
    @Override
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName()+"zzc is sb");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ThreadProprity t1 =new ThreadProprity();
        ThreadProprity t2 =new ThreadProprity();
        Thread thread =new Thread(t1);// 用户线程1
        Thread thread2 =new Thread(t2); //用户线程2
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        thread.start();
    }
/**
 *@author zhouyu
 *@date 2022/9/6 14:15
 */
}
