package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// BoardRepository를 구현하고 있는 객체가 springdatajpa에 의해서 자동으로 생성된다.
public interface BoardRepository extends JpaRepository<Board, Long> {

}
