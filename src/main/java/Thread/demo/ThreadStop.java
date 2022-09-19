package Thread.demo;

//推荐使用标志位,让线程自己停止
class Test implements Runnable{

    private boolean flag =true;

    public void  stop(){
        this.flag=false;
    }

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run:"+ i++);
        }
    }
}


public class ThreadStop{
    public static void main(String[] args) {
        Test test =new Test();
        Thread thread=new Thread(test);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                test.stop();
                System.out.println("线程停止");
            }
        }
    }
}
