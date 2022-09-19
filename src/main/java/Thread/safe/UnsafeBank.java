package Thread.safe;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(300,"总资产");
        new Thread(new Drawing(account,50),"你").start();
        new Thread(new Drawing(account,100),"你女朋友").start();
    }
}
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class  Drawing implements Runnable {
    //账号
    private Account account;
    //取了多少钱
    private int drawingMoney;
    //名字
    private String name;

    public Drawing(Account account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {  //public synchronized void run() 这样锁的是(this) drawing银行，但是我们操作改动的对象是account,所以锁住我们要curd的对象
        //使用同步块
        synchronized (account) {
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName() + "钱不够");
                return;
            }
            //放大线程不同步
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("账户余额:"+account.money);
            account.money=account.money-drawingMoney;
            System.out.println(Thread.currentThread().getName()+"取款了，当前余额为"+account.money);
        }
    }
}