package method;
//这里入参的是一个基本数据类型
class Test{
    private int a;
    public Test(){a=0;}
    public Test(int b){
        a=b;
    }
    public int getValue(){
        return a;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            a+=1;
        }
    }
}
public class TestMethod {
    public static void main(String[] args) {
        int b=2;
        Test test =new Test(b);
        test.run();
        System.out.println(b);
        System.out.println(test.getValue());
    }


/**
 *@author zhouyu
 *@date 2022/9/7 20:28
 */
}
