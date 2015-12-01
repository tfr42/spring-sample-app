package net.gfu.seminar.spring.lab.student;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        String firstname = args.length > 0 && args[0] != null ? args[0] : "Hans";
        String lastname = args.length > 1 && args[1] != null ? args[1] : "Dampf";
        GreetingService greetingService = new MockGreetingService();
        String message = greetingService.sayHelloTo(new Guest(firstname, lastname));
        System.out.println(message);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GreetingService service = context.getBean("greeting", GreetingService.class);
        String springMessage = service.sayHello();
        System.out.println(springMessage);
        context.close();
}
}
