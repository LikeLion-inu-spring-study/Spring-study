package likelion.springstudy.repository;

import likelion.springstudy.domain.Member;
import likelion.springstudy.dto.MemberForm;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    List<Member> findAll();
    Optional<Member> findByName(String name);

}
