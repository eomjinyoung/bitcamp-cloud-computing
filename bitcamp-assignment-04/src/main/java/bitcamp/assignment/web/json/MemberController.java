package bitcamp.assignment.web.json;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.assignment.domain.Member;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @PostMapping("signUp")
    public Object signUp(Member member) {
        System.out.println(member);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
}







