package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        response.setContentType("text/html;charset=UTF-8");
        
        // 다른 서블릿(페이지 컨트롤러)으로 위임한다.
        RequestDispatcher rd = 
                request.getRequestDispatcher(pathInfo);
        rd.include(request, response);
        
        // 페이지 컨트롤러가 실행을 끝낸 후 view 이름을 저장한 JSP를 실행한다.
        String view = (String) request.getAttribute("view");
        if (view != null && view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else if (view != null) {
            rd = request.getRequestDispatcher(view);
            rd.include(request, response);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

}









