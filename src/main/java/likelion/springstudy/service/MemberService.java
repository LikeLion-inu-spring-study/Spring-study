package likelion.springstudy.service;

import likelion.springstudy.domain.Member;
import likelion.springstudy.repository.MemberRepository;
import likelion.springstudy.repository.MemoryMemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
