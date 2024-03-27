package likelion.springstudy.service;

import likelion.springstudy.domain.Address;
import likelion.springstudy.domain.Member;
import likelion.springstudy.repository.MemberRepository;
import likelion.springstudy.repository.MemoryMemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(String name, Address address) {
        Member member = memberRepository.save(name, address);
        return member.getId();
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
