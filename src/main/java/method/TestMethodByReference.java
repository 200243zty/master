package method;
class Share{
    private int a=1;
    public Share(int b){
        a=b;
    }
    public int getValue(){
        return a;
    }
    public void add(){
        for (int i = 0; i < 10; i++) {
            a+=1;
        }
    }
}
class TestDemo{
    private Share share1;
    public TestDemo(Share share){
        this.share1=share;
    }
    public void run(){
        share1.add();
    }
    public Share getShare(){
        return share1;
    }
}

public class TestMethodByReference {
    public static void main(String[] args) {
        Share share =new Share(10);
        TestDemo testDemo = new TestDemo(share);
        testDemo.run();
        System.out.println(share.getValue());
        System.out.println(testDemo.getShare().getValue());
        System.out.println(share==testDemo.getShare());
    }

/**
 *@author zhouyu
 *@date 2022/9/8 11:38
 */
}
