package Thread;

/**
 * 创建主线程和用户线程交替运行
 */
public class MyThread implements Runnable {

    private static String tar []={"zzc","zdw","lyl","zy"};

    @Override
    public void run() {
        for (int i = 0; i < tar.length; i++) {
            System.out.println("用户线程"+tar[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        MyThread myThread =new MyThread();
        Thread t=new Thread(myThread);
        t.start();
        for (int i = 0; i < tar.length; i++) {
            System.out.println("主线程"+tar[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
/**
 *@author zhouyu
 *@date 2022/9/6 13:50
 */
}
