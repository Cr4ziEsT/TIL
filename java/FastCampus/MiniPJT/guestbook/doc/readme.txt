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

----------------

http://sinpk.tistory.com/entry/JSP-EL-%ED%91%9C%EA%B8%B0%EB%B2%95

${guestbook.name}
이거는 guestbook.getName(); //위의 el표기법은 객체의 field를 사용하는 것이 아니라 객체의 property를 사용하는것.

예를 들어
${data.name}
class Data{
    private String n; // field
    public String getName(){ // getter메소드, name property
        return n;
    }
    public void setName(String name){ // setter메소드, name property
        this.n = name;
    }
}