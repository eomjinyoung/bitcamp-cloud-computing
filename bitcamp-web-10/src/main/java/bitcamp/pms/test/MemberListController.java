package bitcamp.pms.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListController {
    
    MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String toString() {
        return "MemberListController [memberDao=" + memberDao + "]";
    }
    
    
}
