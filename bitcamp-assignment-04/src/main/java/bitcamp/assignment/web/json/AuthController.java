package bitcamp.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.assignment.domain.Member;
import bitcamp.assignment.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired MemberService memberService;
    
    @PostMapping("signIn")
    public Object signIn(
            String email, 
            String password, 
            boolean saveEmail,
            HttpSession session) {
        
        HashMap<String,Object> result = new HashMap<>();
        try {
            Member loginUser = memberService.getMember(
                    email, password);
            
            if (loginUser == null)
                throw new Exception("로그인 실패!");
            
            session.setAttribute("loginUser", loginUser);
            result.put("status", "success");
            
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
}







