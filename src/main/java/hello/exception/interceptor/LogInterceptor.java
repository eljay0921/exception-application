package hello.exception.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("preHandle(req) :: [{}] [{}] [{}]", requestURI, request.getDispatcherType(), handler);

        // false로 리턴하면, 요청이 종료된다. (preHandle()에서 끝나면 핸들러 어댑터까지 넘어가지도 않음)
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle :: [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("afterCompletion(res) :: [{}] [{}] [{}]", requestURI, request.getDispatcherType(), handler);

        if (ex != null) {
            log.error("afterCompletion ERROR ! - ", ex);
        }
    }
}
