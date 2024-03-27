package likelion.springstudy.repository;

import likelion.springstudy.domain.Address;
import likelion.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(String name, Address address);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
