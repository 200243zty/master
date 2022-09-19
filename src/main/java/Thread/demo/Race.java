package Thread.demo;

public class Race implements Runnable{

    private static String Winner;

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            boolean flag =gameOver(i);
            if(Thread.currentThread().getName().equals("兔子")&&(i%10==0)){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps){
        if(Winner!=null){
            return true;
        }
        if(steps==100){
            Winner=Thread.currentThread().getName();
            System.out.println("Winner is" +Winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race =new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
