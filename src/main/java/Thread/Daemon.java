package Thread;
// gc回收线程 后台线程
/**
 * 1。主线程 前台线程 由前台线程创建的线程也为前台线程
 * 2. 通过Thread.setDaemon(true)可以将一个前台线程变为后台线程 Thread.isDaemon()用于判断
 * 3.由主线程创建的前台线程，主线程会等待所有的前台线程全部执行完毕后才会结束，但是如果将创建的前台线程设置为后台线程，那么主线程执行完毕后，后台线程会一直存在
 */
public class Daemon implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("后台线程存活");
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
    public static void main(String[] args) {
        Daemon daemon =new Daemon();
        Thread thread =new Thread(daemon);
        thread.setDaemon(true); //设置为后台线程
        thread.start();
        System.out.println("main end");
    }
/**
 *@author zhouyu
 *@date 2022/9/6 15:01
 */
}
