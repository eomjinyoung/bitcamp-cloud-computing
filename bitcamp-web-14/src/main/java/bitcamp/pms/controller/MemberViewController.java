package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
public class MemberViewController {

    MemberDao memberDao;
    
    public MemberViewController() {}
    
    public MemberViewController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/member/view")
    public String view(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        
        Member member = memberDao.selectOne(id);
        request.setAttribute("member", member);
        return "member/view";
    }
    
}








