package examples.daoexam.controller;

import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

// boards에 대한 url 처리
@Controller     // 컨트롤러에 붙는 애노테이션
public class BoardController {
    private BoardService boardService;  // 실제 리스트를 보여주기 위해서는 Service에서 결과를 가져와야 한다. 따라서 boardcontroller는 service를 사용해야 한다.
                                        // 사용하려면 의존성 주입(생성자 주입 등)을 사용해야 한다.

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    @GetMapping("/boards")  // GetMapping 을 보면 RequestMapping 임을 알 수 있음!
    public String list(ModelMap modelMap){  // jsp 로 사용하기 위해서는 modelMap을 선언해 주어야함. 그럼 Dispatcher Servlet이 모델 맵을 넣어줌
        List<Board> boards = boardService.getBoards(0, 10);
        modelMap.addAttribute("boards", boards);        // 그러면 이와같이 해주면 서블릿에서 requestSetAttribute로 담아주는 것처럼 jsp에도 이것을 사용할 수 있게 된다.
        return "list";      // list.jsp를 보여준다.
    }

    @GetMapping("/boards/writeform")        // Get 방식의 요청
    public String writeform() { return "writeform"; }

    @PostMapping("/boards")                 // Post 방식의 요청
    public String write(@RequestParam(name = "name")String name,
                        @RequestParam(name = "title")String title,
                        @RequestParam(name = "content")String content){     // RequestParam 으로 값을 받아준다.
        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(new Date());
        board.setReadCount(0);

        boardService.addBoard(board);       // 저장

        return "redirect:/boards";          // redirect 하라는 뜻!
    }
}
