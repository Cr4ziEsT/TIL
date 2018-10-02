package my.examples.guestbook.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/list")
public class GuestbookListServlet extends HttpServlet {
    // list는 GET 방식
    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // db에서 목록을 읽어온다.

        // request scop - request에 값을 저장하여 jsp까지 값을 전달.
        // 읽어온 결과를 jsp에게 전달하기 위해 request에 값을 저장한다.

        // jsp에 포워딩(forwarding)한다. 포워딩은 url은 변경되지 않고 jsp에게 값을 전달.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(req, resp);
    }
}
