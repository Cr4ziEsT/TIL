package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service        // Spring 에서 자동으로 Component 로 등록!
public class BoardServiceImpl implements BoardService {
    private BoardDao boardDao;      // BoardService 는 DAO를 사용해야 함. (의존성 주입 : 생성자 주입 방식 or 필드 주입 방식 사용)

    // 생성자 주입 방식 사용
    public BoardServiceImpl(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    @Override
    @Transactional      // 트랜잭션 처리를 위한 AOP 적용
    public Board addBoard(Board board) {
        // board 정보 저장, id 값은 저장시 자동으로 생성된다.
        Long id = boardDao.addBoard(board); //insert 한 id 값이 나옴
        board.setId(id);                    // 하지만 아직 생성자를 통해 받아온 board에는 id 값이 설정이 안되어 있으므로 setID를 통해 id 값을 설정해주고
        return board;                       // reture을 통해서 id 값을 추가해줌
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        // readCount 를 수정.
        // 1건 읽어오고
        return null;
    }
}
