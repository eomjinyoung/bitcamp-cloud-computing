package bitcamp.assignment.repository;

import java.util.Map;

import bitcamp.assignment.domain.Member;

public interface MemberRepository {

    int insert(Member member);
    Member findByEmailAndPassword(Map<String,Object> params);

}
