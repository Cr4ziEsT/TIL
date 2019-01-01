package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
            member.setName("hello");
            member.setTeam(team);
            em.persist(member);
            team.getMembers().add(member);
//            member.setTeam(team);

            // 검색(7강 실습)
            String jpql = "select m From Member m join fetch m.team where m.name like '%hello%'";
            List<Member> resultList = em.createQuery(jpql, Member.class)
                    .setFirstResult(10)
                    .setMaxResults(20)
                    .getResultList();

//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            em.close();
//
//            Team findTeam = findMember.getTeam();
//            findTeam.getName();
//            System.out.println("findteam = " + findTeam);

//            findMember.setName("t아카데미");
// LazyInitializationException 예외 = 준영속 상태의
//            em.detach(findMember);
//            em.clear();

            // 처음 저장하는 것이 아니면 em.persist 를 할 필요가 없다.

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 엔티티 매니저는 끝나고 항상 닫아줘야 한다.
        }
        emf.close();
    }
}