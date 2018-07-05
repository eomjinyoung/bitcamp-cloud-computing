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
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
        
        out.println("<title>회원 등록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>회원 등록 결과</h1>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://13.125.81.120:3306/studydb",
                        "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
                
                stmt.setString(1, request.getParameter("id"));
                stmt.setString(2, request.getParameter("email"));
                stmt.setString(3, request.getParameter("password"));
            
                stmt.executeUpdate();
                
                out.println("<p>등록 성공!</p>");
            }
        } catch (Exception e) {
            out.println("<p>등록 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}









