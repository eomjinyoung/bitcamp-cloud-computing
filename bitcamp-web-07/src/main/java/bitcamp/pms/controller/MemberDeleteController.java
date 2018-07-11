package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;

public class MemberDeleteController implements PageController {
    
    MemberDao memberDao;
    
    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        memberDao.delete(request.getParameter("id"));
        return "redirect:list";
       
    }
    
    
}







