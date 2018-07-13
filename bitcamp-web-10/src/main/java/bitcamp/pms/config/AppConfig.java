package bitcamp.pms.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }
    
    /*
    @Bean("sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        System.out.println("AppConfig.getSqlSessionFactory() 호출됨!");
        String resource = "bitcamp/pms/config/mybatis-config.xml";
        InputStream inputStream = 
                Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    */
}
