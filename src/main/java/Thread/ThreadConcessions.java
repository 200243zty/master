package Thread;
//线程让步

/**
 * 1.使用Thread.slepp() 使正在运行的线程进入阻塞状态，其他任何线程不考虑优先级都能有运行的机会
 * 2.Thread.yield() 使正在云的的线程进入就绪状态(随时可以投入运行，并放弃cpu)让步给同优先级或者更高优先级的线程
 */
public class ThreadConcessions implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"zdw qnm");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadConcessions  t1 =new ThreadConcessions();
        ThreadConcessions  t2 =new ThreadConcessions();
        Thread thread1 =new Thread(t1);
        Thread thread2 =new Thread(t2);
        thread1.start();
        thread2.start();
    }
/**
 *@author zhouyu
 *@date 2022/9/6 14:36
 */
}
