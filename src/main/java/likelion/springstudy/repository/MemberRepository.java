package likelion.springstudy.repository;

import likelion.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByCity(String city);
    Optional<Member> findByName(String name);

    /**
     * 모든 회원 정보를 다 list로 내보낸다.
     * @return 모든 Member들을 List로 return
     */
    List<Member> findAll();
}
