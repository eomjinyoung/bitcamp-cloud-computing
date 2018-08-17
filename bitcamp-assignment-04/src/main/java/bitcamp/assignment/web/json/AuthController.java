package bitcamp.assignment.web.json;

import java.util.HashMap;

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
    public Object signUp(
            String email, String password, boolean saveEmail) {
        
        HashMap<String,Object> result = new HashMap<>();
        try {
            Member loginUser = memberService.getMember(
                    email, password);
            
            if (loginUser == null)
                throw new Exception("로그인 실패!");
            
            result.put("status", "success");
            
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
}







