package likelion.springstudy.repository;

import likelion.springstudy.domain.Member;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long, Member> storage = new HashMap<>();
    private static long sequence = 100L;

    /**
     * 각 회원들에게 id를 부여하고 저장소에 저장
     * @param member 사용자가 입력한 정보가 담긴 member객체
     * @return member
     */
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        storage.put(member.getId(), member);
        return member;
    }

    /**
     * 저장소인 storage에서 id로 회원정보를 찾는다.
     * @param id 찾으려는 회원의 id
     * @return id에 맞는 회원 객체를 반환. optional --> null값 방지
     */
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    /**
     * storage에서 이름으로 회원정보를 찾는다.
     * @param name 찾으려는 회원의 이름
     * @return 이름과 일치하는 회원 객체. findAny() --> stream은 병렬처리이므로 순서무시.
     */
    @Override
    public Optional<Member> findByName(String name) {
        return storage.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
    }

    public Optional<Member> findByCity(String city){
        return storage.values().stream()
                .filter(member -> member.getCity().equals(city)).findAny();
    }

    /**
     * storage에 있는 모든 member들을 리스트로 반환.
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(storage.values());
    }

    /**
     * 실행할 때마다 저장소 정리느낌???? 맞나요?
     */
    public void clearStore(){
        storage.clear();
    }
}
