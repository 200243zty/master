package Thread.correspondence;

//测试生产者消费者-->利用缓冲区解决：管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer container =new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }

}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }
    //生产
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("生产力" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }
    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + container.pop().id + "只鸡");
        }
    }
}
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    //需要一个容器大小
    Chicken [] chickens =new Chicken[10];
    //容器计数器
    int count =0;
    //生成者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        if(count==chickens.length){
            //生产满了
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满,生产者丢入产品
        chickens[count]=chicken;
        count++;
        this.notifyAll();
    }
    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(count==0){//没有产品，等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //如果可以消费
        count--;
        Chicken chicken =chickens[count];
        this.notifyAll();
        //吃完了，通知生产者生产
        return chicken;
    }
}

