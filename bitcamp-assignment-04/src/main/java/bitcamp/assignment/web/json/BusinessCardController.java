package bitcamp.assignment.web.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.assignment.domain.BusinessCard;
import bitcamp.assignment.domain.Member;
import bitcamp.assignment.service.BusinessCardService;

@RestController
@RequestMapping("/businesscard")
public class BusinessCardController {
    
    BusinessCardService bizcardService;
    
    public BusinessCardController(
            BusinessCardService bizcardService) {
        this.bizcardService = bizcardService;
    }
    
    @GetMapping("list")
    public Object list(HttpSession session) {
        
        Member loginUser = 
                (Member)session.getAttribute("loginUser");
        
        List<BusinessCard> list = 
                bizcardService.list(loginUser.getNo());
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("list", list);
        return result;
    }
}







