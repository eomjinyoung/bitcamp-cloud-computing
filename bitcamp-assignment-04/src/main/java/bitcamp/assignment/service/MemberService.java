package bitcamp.assignment.service;

import bitcamp.assignment.domain.Member;

public interface MemberService {

    int add(Member member);

    Member getMember(String email, String password);

}
