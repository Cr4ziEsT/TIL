package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return board;                       // reture을 통해서 비어있는 id 값을 추가해줌
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {    // id 에 해당하는 보드를 조회한다.
        // readCount 를 수정하고
        boardDao.updateCount(id);
        // 1건 읽어온다.
        Board board = boardDao.getBoard(id);
        return board;
    }

    // 읽기 전용 메소드
    // start : 시작 id
    // limit : 읽어올 수
    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int start, int limit) {
        return null;
    }
}
