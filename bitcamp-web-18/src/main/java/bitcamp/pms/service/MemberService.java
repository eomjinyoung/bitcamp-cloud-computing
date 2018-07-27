package bitcamp.pms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Service
public class MemberService {
    
    @Autowired MemberDao memberDao;

    public List<Member> list(int page, int size) {
        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (page - 1) * size);
        params.put("pageSize", size);
        
        return memberDao.selectList(params);
    }

    public Member get(String id) {
        return memberDao.selectOne(id);
    }

    // 메서드에 @Transactional 애노테이션을 붙이면,
    // 메서드에서 수행하는 작업들을 한 단위로 묶어서 다루겠다는 의미다.
    // 따라서 작성들 중에 한 개의 작업이라도 실패하면,
    // 이전에 성공했던 모든 작업들이 취소된다.
    // 메서드 호출이 예외 없이 정상적으로 끝나면, 
    // DBMS에 commit을 요청하여 지금까지 한 작업을 실제 테이블에 적용시킨다.
    //@Transactional() // => 애노테이션 대신 xml 태그로 지정할 수 있다.
    public int update(Member member) {
        int count = memberDao.update(member);
        
        if (count != 100)
            throw new RuntimeException("일부로 예외 발생!");
        
        return count;
    }

    public int delete(String id) {
        return memberDao.delete(id);
    }

    public void add(Member member) {
        memberDao.insert(member);
    }
    
    public int getTotalPage(int size) {
        int count = memberDao.countAll();
        int totalPage = count / size;
        if (count % size > 0)
            totalPage++;
        return totalPage;
    }
}








