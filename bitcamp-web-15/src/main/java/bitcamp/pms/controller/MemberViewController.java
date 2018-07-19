package bitcamp.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/member/view/{id}")
    public String view(
            @PathVariable String id,
            Model model) throws Exception {
        
        Member member = memberDao.selectOne(id);
        model.addAttribute("member", member);
        return "member/view";
    }
    
}








