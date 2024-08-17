package japbook.start;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //[엔티티 매니저 팩토리] - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        //[엔티티 매니저] - 생성
        EntityManager em = emf.createEntityManager();
        //[트랜잭션] - 획득
        EntityTransaction tx = em.getTransaction(); //트랜잭션 API

        try {

            tx.begin();     //[트랜잭션] - 시작
            logic(em);      //비지니스 로직 실행
            tx.commit();    //[트랜잭션] - 커밋
        } catch (Exception e) {
            tx.rollback(); //[트랜잭션] - 롤백
        } finally {
            em.close(); //[엔티티 매니저] - 종료
        }
        emf.close();    //[엔티티 매니저 팩토리] - 종료
    }

    //비지니스 로직
    private static void logic(EntityManager em) {

        String id = "id1";
        jpabook.start.Member member = new jpabook.start.Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        em.persist(member);

        //수정
        member.setAge(20);

        //한 건 조회
        jpabook.start.Member findMember = em.find(jpabook.start.Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        List<jpabook.start.Member> members = em.createQuery("select m from Member m", jpabook.start.Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);
    }
}