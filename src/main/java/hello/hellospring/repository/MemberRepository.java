package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 기능 만들기
 */
public interface MemberRepository {
    Member save(Member member); //저장
    Optional<Member> findById(Long id);//Id 찾기
    Optional<Member> findByName(String name);//Name 찾기
    List<Member> findAll();//모든 회원 조회
}
