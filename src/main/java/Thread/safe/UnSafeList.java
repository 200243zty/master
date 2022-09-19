package Thread.safe;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnSafeList {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
                new Thread(()->{
                    synchronized (list){ //再每个用户线程中锁
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
        } //可能再一瞬间两个线程添加到了同一个位置，后者覆盖率前者,所以最后list.size()<1000;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
