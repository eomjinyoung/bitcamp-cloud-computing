import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;

public class Test {

    static ArrayList<Object> objPool = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        ClassLoader defaultClassLoader = 
                ClassLoader.getSystemClassLoader();
        
        URL url = defaultClassLoader.getResource(
                "bitcamp/pms");
        File file = new File(url.toURI());
        
        findClass(file, "bitcamp.pms");
        
        for (Object obj : objPool) {
            System.out.println(obj.getClass().getName());
        }
    }
    
    static void findClass(File path, String packageName) {
        
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

    private static void createObject(String className) {
        try {
            // 클래스 이름(패키지명 + 클래스명)으로 .class 파일을 찾아 로딩한다.
            Class clazz = Class.forName(className);
            
            // 클래스 정보를 보고 기본 생성자를 알아낸다.
            Constructor constructor = clazz.getConstructor();
            
            // 기본 생성자를 호출하여 객체를 생성한 후 객체 보관소에 저장한다.
            objPool.add(constructor.newInstance());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}






