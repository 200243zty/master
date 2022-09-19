package Thread.safe;

public class Test1 {
    public static void main(String[] args) {
        buyTicket buyTicket =new buyTicket();
        new Thread(buyTicket,"小王").start();
        new Thread(buyTicket,"小李").start();
        new Thread(buyTicket,"小周").start();
    }

}

class buyTicket implements Runnable{

    private int ticketNum=20;

    private boolean flag=true;

    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用synchronized方法，线程必须持有对象锁才能执行，执行过程中独占该锁，直到结束返还该锁，后面被阻塞的线程获取该锁，继续执行。
     * 这里和synchronized默认锁住了this 即本身的buyTicket
     * @throws InterruptedException
     */
//    private synchronized void buy() throws InterruptedException {
//        //判断是否有票
//        if(ticketNum<=0){
//            flag=false;
//            return;
//        }
//        //放大线程不同步
//        //每个线程都有自己的工作内存
//        Thread.sleep(100);
//
//        System.out.println(Thread.currentThread().getName()+"买了"+ticketNum--);
//    }
    //等价于这种写法
    private void buy() throws InterruptedException {
        synchronized (this){
            //判断是否有票
            if(ticketNum<=0){
                flag=false;
                return;
            }
            //放大线程不同步
            //每个线程都有自己的工作内存
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+"买了"+ticketNum--);
        }
    }
}
