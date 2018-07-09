package bitcamp.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>멤버 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>멤버 보기</h1>");
        
        try {
            MemberDao memberDao = 
                    (MemberDao) getServletContext().getAttribute("memberDao");
                 
            Member member = memberDao.selectOne(id);
                
            if (member == null) {
                out.println("<p>유효하지 않은 멤버 아이디입니다.</p>");
            } else {
                out.println("<form action='update' method='post'>");
                out.println("<table border='1'>");
                out.println("<tr><th>아이디</th><td>");
                out.printf("    <input type='text' name='id' value='%s' readonly></td></tr>\n", 
                        member.getId());
                out.println("<tr><th>이메일</th>");
                out.printf("    <td><input type='email' name='email' value='%s'></td></tr>\n",
                        member.getEmail());
                out.println("<tr><th>암호</th>");
                out.println("    <td><input type='password' name='password'></td></tr>\n");
                out.println("</table>");
                out.println("<p>");
                out.println("<a href='list'>목록</a>");
                out.println("<button>변경</button>");
                out.printf("<a href='delete?id=%s'>삭제</a>\n", id);
                out.println("</p>");
                out.println("</form>");
                }
               
        } catch (Exception e) {
            out.printf("<p>%s</p>\n", e.getMessage());
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
    
}








