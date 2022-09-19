package Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        BuyTicket buyTicket =new BuyTicket();
        new Thread(buyTicket,"小王").start();
        new Thread(buyTicket,"小李").start();
        new Thread(buyTicket,"小周").start();
    }
}

class BuyTicket implements Runnable{
    int tickNums =10;

    private Lock lock =new ReentrantLock();
    //try,finally+lock和syn一样，他是显式声明
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(tickNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNums--);
                }
                else {
                    break;
                }

            }finally {
                lock.unlock();
            }

        }
    }
}