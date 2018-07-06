package bitcamp.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
        out.println("<title>게시물 삭제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 삭제 결과</h1>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://13.125.81.120:3306/studydb",
                        "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "delete from pms2_member where mid=?");) {
                
                stmt.setString(1, request.getParameter("id"));
                
                if (stmt.executeUpdate() == 0) {
                    out.println("<p>해당 회원이 없습니다.</p>");
                } else {
                    out.println("<p>삭제하였습니다.</p>");
                }
            } 
    
        } catch (Exception e) {
            out.println("<p>삭제 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}







