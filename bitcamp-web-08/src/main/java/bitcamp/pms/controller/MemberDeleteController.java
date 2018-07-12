package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;

public class MemberDeleteController {
    
    MemberDao memberDao;
    
    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        memberDao.delete(request.getParameter("id"));
        return "redirect:list";
       
    }
    
    
}







