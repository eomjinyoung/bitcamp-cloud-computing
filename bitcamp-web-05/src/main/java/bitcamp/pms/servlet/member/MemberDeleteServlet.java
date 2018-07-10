package bitcamp.pms.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            MemberDao memberDao = 
                    (MemberDao) getServletContext().getAttribute("memberDao");
                 
            memberDao.delete(request.getParameter("id"));
            response.sendRedirect("list");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
    
}







