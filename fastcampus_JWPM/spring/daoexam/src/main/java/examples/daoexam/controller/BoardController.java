package examples.daoexam.controller;

import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// boards에 대한 url 처리
@Controller     // 컨트롤러에 붙는 애노테이션
public class BoardController {
    // /boards->list.jsp 작성 이후 list를 보여주기 위해 필요한 것을 생각하고 아래 필드 작성
    private BoardService boardService;  // 실제 리스트를 보여주기 위해서는 Service에서 결과를 가져와야 한다. 따라서 boardcontroller는 service를 사용해야 한다.
                                        // 사용하려면 의존성 주입(생성자 주입 등)을 사용해야 한다.

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    @GetMapping("/boards")  // GetMapping 에 들어가보면 RequestMapping 임을 알 수 있음!, /boards 요청이 오면 return "list" list.jsp를 보여준다는 것
    public String list(ModelMap modelMap){
        List<Board> boards = boardService.getBoards(0, 10); // 이 객체가 출력하기 위해 jsp 에서 사용하기 위해서는
                                                                        // modelMap을 선언해 주어야함. 그럼 DispatcherServlet이 모델 맵을 넣어줌
        modelMap.addAttribute("boards", boards);        // 그러면 이와같이 해주면 서블릿에서 requestSetAttribute로 값을 설정하는 것처럼 ModelMap에 담아주면 jsp에도 이것을 사용할 수 있게 된다.
        return "list";      // list.jsp를 보여준다.
    }

    @GetMapping("/boards/download/{id}")
    @ResponseBody
    public void download(@PathVariable("id") Long id,
                         HttpServletResponse response){
        // id에 해당하는 파일정보를 읽는다.
        String contentType = "image/gif";
        long size = 13898L;
        String originalFileName = "github.gif";
        String savePath = "/tmp/2018/10/31/90b51b95-4d5a-4cb0-829e-c29947a9dab5";
        response.setContentLength((int)size);
//        response.setContentType("application/x-msdownload");
        response.setContentType(contentType);
        try {
            originalFileName = URLDecoder.decode(originalFileName, "ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        response.setHeader("Content-disposition", "attachment; filename="+ originalFileName);
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(savePath);
            out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(in != null){
                try{ in.close(); } catch(Exception e){}
            }
            if(out != null){
                try{ out.close(); } catch(Exception e){}
            }
        }
    }


    @GetMapping("/boards/writeform")        // 글 쓰기 위해 Get 방식의 요청, viewname으로 writeform을 리턴, writeform.jsp를 보여주게 된다.
    public String writeform() { return "writeform"; }

    @PostMapping("/boards")                 // Post 방식의 요청
    public String write(@RequestParam(name = "name")String name,
                        @RequestParam(name = "title")String title,
                        @RequestParam(name = "content")String content,     // RequestParam 으로 값을 받아준다.
                        @RequestParam("file") MultipartFile file){
        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(new Date());
        board.setReadCount(0);

        System.out.println("------file info start ----");
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getSize());
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(uuidStr);
        System.out.println(dateStr);
        String baseDir = "/tmp"; // 이미 있어야 한다.
        String saveDir = baseDir + "/" + dateStr;
        String saveFile = saveDir + "/" + uuidStr;
        File fileObj = new File(saveDir);
        fileObj.mkdirs();
        InputStream in = null;
        OutputStream out = null;
        try{
            in = file.getInputStream();
            out = new FileOutputStream(saveFile);
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(in != null){
                try{ in.close(); } catch(Exception e){}
            }
            if(out != null){
                try{ out.close(); } catch(Exception e){}
            }
        }
        System.out.println("------file info end ----");

        boardService.addBoard(board);       // 저장

        return "redirect:/boards";          // redirect 하라는 뜻!
    }
}
