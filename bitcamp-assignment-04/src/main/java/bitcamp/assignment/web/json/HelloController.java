package bitcamp.assignment.web.json;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object hello() {
        HashMap<String,Object> result = new HashMap<>();
        result.put("name", "홍길동");
        return result;
    }
}








