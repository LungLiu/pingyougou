import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQueue {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-jms.xml");
        Object o = applicationContext.getBean("queueSolrDestination");
        System.out.println(o);
    }
}
