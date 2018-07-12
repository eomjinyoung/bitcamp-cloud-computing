import bitcamp.pms.context.ApplicationContext;

public class Test {

    
    
    public static void main(String[] args) throws Exception {
        
        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.pms");
        
        Object obj = iocContainer.getBean("/member/ohora");
        System.out.println(obj.getClass().getName());
        
    }
}






