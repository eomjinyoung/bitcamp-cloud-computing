package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberViewController implements PageController {

    MemberDao memberDao;
    
    public MemberViewController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        
        Member member = memberDao.selectOne(id);
        request.setAttribute("member", member);
        return "/member/view.jsp";
    }
    
}








