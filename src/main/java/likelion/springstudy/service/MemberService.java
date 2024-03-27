package likelion.springstudy.service;

import likelion.springstudy.domain.Member;
import likelion.springstudy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 중복확인 보안 필요
    private void validateDuplicateMember(Member member) {
        if(memberRepository.findByName(member.getName()).isEmpty())
            return;

        if(memberRepository.findByName(member.getName()).equals(memberRepository.findByCity(member.getCity())))
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
