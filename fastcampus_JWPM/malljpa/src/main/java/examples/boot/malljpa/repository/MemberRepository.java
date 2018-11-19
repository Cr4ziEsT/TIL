package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findMemberByEmail(String email);

    public Member findByNickname

    /*
    로그인
    회원가입
    회원정보보기
    구매리스트
    배송정보
    관심상품보기
    장바구니보기
    상품을 카트에 담다
    관심 상품으로 등록하다.
     */
}
