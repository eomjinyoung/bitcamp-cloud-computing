package bitcamp.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        // 서블릿을 실행하기 전에 수행할 작업
        request.setCharacterEncoding("UTF-8");
        
        // 다음 필터 또는 서블릿 실행
        chain.doFilter(request, response);
        
    }

}







