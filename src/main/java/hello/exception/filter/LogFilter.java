package hello.exception.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("[LogFilter] init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        try {
            log.info("[LogFilter] do: DispatcherType-{} URI-{}", request.getDispatcherType(), requestURI);

            // (중요) chain -> 다음 단계(Filter or Servlet)로 넘어가도록 반드시 작성해줘야 한다
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("[LogFilter] do: OK");
        }
    }

    @Override
    public void destroy() {
        log.info("[LogFilter] destroy");
        Filter.super.destroy();
    }
}

