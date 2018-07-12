package bitcamp.pms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.Repository;

public class ApplicationContext {
    
    HashMap<String,Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception {
        String filePath = packageName.replace('.', '/');
        
        ClassLoader defaultClassLoader = 
                ClassLoader.getSystemClassLoader();
        
        URL url = defaultClassLoader.getResource(filePath);
        
        File dir = new File(url.toURI());
        
        findClass(dir, packageName);
    }
    
    public Object getBean(String name) {
        Object obj = objPool.get(name);
        if (obj == null) 
            throw new RuntimeException("객체가 존재하지 않습니다.");
        return obj;
    }
    
    private void findClass(File path, String packageName) {
        
        File[] subFiles = path.listFiles((File pathname) -> {
            if (pathname.isDirectory())
                return true;
            if (pathname.isFile() && 
                    pathname.getName().endsWith(".class")) 
                return true;
            return false;
        });
        
        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                String className = packageName + "." + 
                        subFile.getName().replace(".class", "");
                createObject(className);
            } else {
                findClass(subFile, 
                        packageName + "." + subFile.getName());
            }
        }
    }

    private void createObject(String className) {
        try {
            // 클래스 이름(패키지명 + 클래스명)으로 .class 파일을 찾아 로딩한다.
            Class<?> clazz = Class.forName(className);
            
            //@Component, @Controller, @Repository 애노테이션이 
            //붙은 클래스가 아니라면 객체를 생성하지 않는다.
            if (clazz.getAnnotation(Component.class) == null &&
                    clazz.getAnnotation(Controller.class) == null &&
                    clazz.getAnnotation(Repository.class) == null)
                return;
            
            
            // 객체를 저장할 때 사용할 이름을 알아낸다.
            String objName = getObjectName(clazz);
            
            // 클래스 정보를 보고 기본 생성자를 알아낸다.
            Constructor<?> constructor = clazz.getConstructor();

            // 기본 생성자를 호출하여 객체를 생성한 후 객체 보관소에 저장한다.
            objPool.put(objName, constructor.newInstance());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getObjectName(Class<?> clazz) throws Exception {
        String objName = null;
        
        Component compAnno = clazz.getAnnotation(Component.class);
        if (compAnno != null) 
            objName = compAnno.value();
        
        Controller ctrlAnno = clazz.getAnnotation(Controller.class);
        if (ctrlAnno != null)
            objName = ctrlAnno.value();
        
        Repository repoAnno = clazz.getAnnotation(Repository.class);
        if (repoAnno != null)
            objName = repoAnno.value();
        
        if (objName.length() == 0) {
            return clazz.getCanonicalName();
        } else {
            return objName;
        }
    }
}
