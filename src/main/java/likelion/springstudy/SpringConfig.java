package likelion.springstudy;

import likelion.springstudy.domain.Member;
import likelion.springstudy.repository.MemberRepository;
import likelion.springstudy.repository.MemoryMemberRepository;
import likelion.springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
