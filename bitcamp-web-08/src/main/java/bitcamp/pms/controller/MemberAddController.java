package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberAddController {
    
    MemberDao memberDao;
    
    public MemberAddController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String add(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            return "/member/form.jsp";
        }
        
        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        
        memberDao.insert(member);
        return "redirect:list";
    }
    
    
}









