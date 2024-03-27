package likelion.springstudy.service;

import likelion.springstudy.domain.Member;
import likelion.springstudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입(){
        //given
        Member member = new Member();
        member.setName("spring");
        member.setCity("Incheon");
        member.setStreet("17");
        member.setZipcode("123-456");
        //when
        Long saveId = memberService.join(member);
        //then
        Member find = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), find.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member = new Member();
        member.setName("spring");
        member.setCity("Incheon");
        member.setStreet("17");
        member.setZipcode("123-456");

        Member member2 = new Member();
        member2.setName("spring");
        member2.setCity("Incheon");
        member2.setStreet("17");
        member2.setZipcode("123-456");

        //when
        memberService.join(member);
        IllegalStateException e= assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


}
