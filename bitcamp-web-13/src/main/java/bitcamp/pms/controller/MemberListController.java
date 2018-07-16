package bitcamp.pms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
public class MemberListController {

    MemberDao memberDao;
    
    public MemberListController() {}
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/member/list")
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String,Object> params = new HashMap<>();
        if (request.getParameter("page") != null &&
            request.getParameter("size") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int size = Integer.parseInt(request.getParameter("size"));
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        
        List<Member> list = memberDao.selectList(params);
        request.setAttribute("list", list);
        
        return "/member/list.jsp";
            
    }
    

}










