package bitcamp.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.assignment.domain.Member;
import bitcamp.assignment.repository.MemberRepository;
import bitcamp.assignment.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberRepository memberRepository;
    
    @Override
    public int add(Member member) {
        return memberRepository.insert(member);
    }

}
