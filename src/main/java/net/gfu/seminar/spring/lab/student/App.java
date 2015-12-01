package net.gfu.seminar.spring.lab.student;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello, world! application.
 * Run with:
 * <code>
 * java cp ./target/classes/ net.gfu.seminar.spring.lab.student.App Anna Gramm
 * </code>
 * or with maven:
 * <code>
 * mvn exec:java -Dexec.mainClass=net.gfu.seminar.spring.lab.student.App -Dexec.args="Anna Gramm"
 * </code>
 */
public class App {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GreetingService service = context.getBean("greeting", GreetingService.class);
        String springMessage = service.sayHello();
        System.out.println(springMessage);
        context.close();
}
}
