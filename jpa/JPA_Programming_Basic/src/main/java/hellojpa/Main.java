package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // hello 라는 이름을 가지고 EntityManagerFactory를 띄운다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // jpa의 모든 활동은 트랜잭션 안에서 이뤄진다.
        tx.begin();// 트랜잭션 시작

        try {
            // 팀 저장
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);
            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            // 조회시 쿼리문을 보기 위함
//            em.flush();
//            em.clear();       // 지워줘야 수정이 작동됨

            // 조회
            Member findMember = em.find(Member.class, member.getId());
            // 참조를 사용해서 연관관계 조회
            Team findTeam = findMember.getTeam();

            // 새로운 팀B
            Team teamB = new Team();
            teamB.setName("TeamB");
            em.persist(teamB);
            // 회원1에 새로운 팀B 설정
            member.setTeam(teamB);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 엔티티 매니저는 끝나고 항상 닫아줘야 한다.
        }
        emf.close();
    }
}