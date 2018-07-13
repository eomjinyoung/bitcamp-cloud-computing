package bitcamp.pms.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        // Spring IoC 컨테이너 객체 생성하기
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/pms/test/application-context.xml");
        
        System.out.println(iocContainer.getBeanDefinitionCount());
        System.out.println("-----------------------------");
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(
               iocContainer.getBean(name).getClass().getName());
        }
        
    }
}






