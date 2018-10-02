package my.examples.guestbook.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/write")
public class GuestbookWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        // 이름과 내용을 읽어들인다.
        String name = req.getParameter("name");
        String content = req.getParameter("content");

        System.out.println(name);
        System.out.println(content);

        // 이름과 내용을 검사한다.

        // DB에 이름과 내용을 저장한다.

        // /guestbook/list 로 리다이렉트
        resp.sendRedirect("/guestbook/list");


    }
}
