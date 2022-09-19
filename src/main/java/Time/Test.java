package Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//DateTimeFormatter 优于SimpleDateFormat
//1.初始化DateTimeFormatter df
//2。localDateTime.format(df).var
public class Test {
/**
 *@author zhouyu
 *@date 2022/6/22 13:17
 */
public static void main(String[] args) {
    LocalDateTime localDateTime =LocalDateTime.now();
    DateTimeFormatter df=DateTimeFormatter.ofPattern("MM");
    String format = localDateTime.format(df);
    System.out.println(format);
}
}
