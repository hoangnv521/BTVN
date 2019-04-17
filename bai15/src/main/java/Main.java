import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Customer.xml");
        Sum sumObj = (Sum) context.getBean("sum");

        Scanner scanner =new Scanner(System.in);

        System.out.println("Nhập số thứ nhất: ");
        String str1 = scanner.nextLine();

        System.out.println("Nhập số thứ hai: ");
        String str2 =scanner.nextLine();

        String result= sumObj.sum(str1, str2);
        System.out.println("Tổng 2 số = "+result);
    }
}
