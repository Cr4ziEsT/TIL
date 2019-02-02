package examples.spring;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter");
        // 중요! 메세지만 출력하면 요청 응답이 다음 필터로 전달이 되지 않는다. 따라서 반드시 `FilterChain`으로 연결해주어야 한다.
        // 맨 마지막 filter 일 경우 자동으로 servlet 으로 연결이 된다. 아래와 같이 해줬다면
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter Destroy");
    }
}
