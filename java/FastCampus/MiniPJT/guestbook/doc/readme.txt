forward , request scope
                                                    WAS
http://localhost:8080/guestbook/list      -------------------------------------
브라우저 ---- GET /guestbook/list ----------> GuestbookListServlet 의 doGet
                                                  forward -----> list.jsp
            <--------------------------------------------------------

-------

redirect

브라우저 값을 입력 확인
   ----- POST /guestbook/write        -----> GuestbookWriteServlet의 doPost()
   <---------------------------------------- redirect guestbook/list
   302 응답
   ------ GET /guestbook/list --------------->
   <-------------------------------------------