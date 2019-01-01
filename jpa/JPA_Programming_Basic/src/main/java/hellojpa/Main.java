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
            team.setName("TeamA");
            em.persist(team);
            // 회원 저장
            Member member = new Member();
            member.setName("member1");
//            member.setTeam(team);
            em.persist(member);
//            team.getMembers().add(member);
            member.setTeam(team);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 엔티티 매니저는 끝나고 항상 닫아줘야 한다.
        }
        emf.close();
    }
}