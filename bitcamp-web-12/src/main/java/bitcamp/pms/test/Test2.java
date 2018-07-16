package bitcamp.pms.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) throws Exception {
        // Spring IoC 컨테이너 객체 생성하기
        AnnotationConfigApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(
                        MySpringConfig.class);
        
        System.out.println(iocContainer.getBeanDefinitionCount());
        System.out.println("-----------------------------");
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s ==> %s\n", name,
               iocContainer.getBean(name).getClass().getName());
        }
        
    }
}






