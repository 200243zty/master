//package methodreferences;
//
//public class PrintableDemo {
///**
// *@author zhouyu
// *@date 2022/8/10 22:23
// */
//public static void main(String[] args) {
////    usePrintable((String s)->{
////        System.out.println(s);
////    });
//    usePrintable(System.out::println);
//
//}
//    private  static  void usePrintable(Printable p)
//    {
//        p.printString("爱生活，爱java");
//    }
//
//    private static int  Print(String s){
//        return
//    }
//
//
//
//}
//
////一个接口,待实现的方法
////一个把这个接口当作参数的方法,使用这个方法时，要么传入上面接口指向的实例的引用，要不使用匿名内部类（该接口只用于实现一个方法，lambda简化）
//
////方法引用，有点变态
////1.调用类的静态方法
////lambda:(args)->Class.staticMethod(args)