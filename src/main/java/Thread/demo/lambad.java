package Thread.demo;

interface AnimalRun {
    void run();
}

class Bear{
    public void setRunMethod(AnimalRun animalRun){
        animalRun.run();
    }
}
class Dog{

}
//1.使用一个实现类BearRun传入setRunMethod
//2，在SetRunMethod中直接重写
public class lambad {
    public static void main(String[] args) {
        Bear bear =new Bear();
        bear.setRunMethod(new AnimalRun() {
            @Override
            public void run() {
                System.out.println("bear run");
            }
        });
        Bear dogBear =new Bear();
        dogBear.setRunMethod(() -> System.out.println("dog run"));

        //前体接口只有一个方法，即函数式接口
        AnimalRun animalRun=()-> {System.out.println("run");};

        animalRun.run();
    }
}
//lambda 可以简化不写参数类型和花括号
//后面将使用lambda简化Thread