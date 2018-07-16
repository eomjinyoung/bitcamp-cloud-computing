package bitcamp.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import bitcamp.pms.annotation.RequestMapping;

@SuppressWarnings("serial")
@WebServlet(value="/app/*",loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;

    @Override
    public void init() throws ServletException {
        // DispatcherServlet이 본격적으로 클라이언트 요청을 처리하기 전에 
        // Spring의 ContextLoaderListener가 준비한 IoC 컨테이너를 꺼내자.
        // 다음과 같이 다른 클래스의 도움을 받아서 IoC 컨테이너를 꺼내야 한다. 
        iocContainer = WebApplicationContextUtils
                            .getWebApplicationContext(
                                    this.getServletContext());
        
        // IoC 컨테이너에 들어있는 객체를 한 번 출력해보자!
        System.out.println("----------------------------------");
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s ===> %s\n", name, 
                iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("----------------------------------");
    }
    
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 요청한 서비스 URL을 알아낸다.
        // 즉 /app/* 에서 *에  해당하는 값을 추출한다.
        // 예) /app/member/list => /member/list를 추출한다.
        String pathInfo = request.getPathInfo();
        
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            // IoC 컨테이너에 저장된 페이지 컨트롤러를 찾는다.
            Object pageController = 
                    iocContainer.getBean(pathInfo);

            // 페이지 컨트롤러를 못 찾았으면 오류를 내보낸다.
            if (pageController == null) 
                throw new Exception("해당 URL에 대해 서비스를 처리할 수 없습니다.");
            
            // 페이지 컨트롤러에 있는 메서드 중에서 @RequestMapping이라는
            // 애노테이션이 붙은 메서드를 찾아 호출한다.
            Method requestHandler = getRequestHandler(pageController.getClass());
            
            if (requestHandler == null) 
                throw new Exception("요청 핸들러를 찾지 못했습니다.");
            
            // 페이지 컨트롤러의 메서드를 호출한다.
            String view = (String) requestHandler.invoke(
                    pageController, request, response);
            
            if (view.startsWith("redirect:")) {
                response.sendRedirect(view.substring(9));
            } else {
                RequestDispatcher rd = 
                        request.getRequestDispatcher(view);
                rd.include(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    private Method getRequestHandler(Class<?> clazz) {
        
        // 클래스 정보에서 메서드 정보를 추출한다.
        Method[] methods = clazz.getMethods();
        
        // 메서드 중에서 @RequestMapping 애노테이션이 붙은 메서드를 찾아낸다.
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null)
                return m;
        }
        
        return null;
    }

}









