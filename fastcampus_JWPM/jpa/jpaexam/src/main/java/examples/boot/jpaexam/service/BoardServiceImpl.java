package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Override
    @Transactional
    public void test() {
        Board result = boardRepository.getOne(1L);
        Board result2 = boardRepository.getOne(1L);
        String str = result.getTitle();
        result.setTitle("hello java");
        result.setTitle(str);
    }
}