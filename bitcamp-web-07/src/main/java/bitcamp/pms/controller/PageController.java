package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 프론트 컨트롤러(caller)와 페이지 컨트롤러(callee) 사이의 호출 규칙!
public interface PageController {
    String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception;
}
