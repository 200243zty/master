package Thread;
class Share{
    private int a;
    public Share(){a=0;}
    public Share(int b){ a=b;}
    public synchronized void add(){
        a+=1;
        System.out.println("ADD"+a);
    }
    public synchronized void dec(){
        a-=1;
        System.out.println("Dec:"+a);
    }
    public int getValue(){
        return a;
    }
}
class AddThread implements Runnable{

    private Share share1;
    public AddThread(Share share){
        share1=share;
    }
    public Share getShare(){
        return share1;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            share1.add();
        }
    }
}
class DecThread implements Runnable{

    private Share share2;
    public DecThread(Share share){
        share2=share;
    }
    public Share getShare(){
        return share2;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            share2.dec();
        }
    }
}
public class Mutex {
    public static void main(String[] args) throws InterruptedException {
        Share share =new Share();
        AddThread addThread =new AddThread(share);
        Thread thread1 =new Thread(addThread);
        thread1.start();
        thread1.join();
        DecThread decThread=new DecThread(share);
        Thread thread2 =new Thread(decThread);
        thread2.start();
        thread2.join();
        DecThread decThread2=new DecThread(share);
        Thread thread3 =new Thread(decThread2);
        thread3.start();
        thread3.join();
        System.out.println(addThread.getShare().getValue());
        System.out.println(decThread.getShare().getValue());
        System.out.println(decThread2.getShare().getValue());
    }
}
