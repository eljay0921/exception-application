package hello.exception.servlet;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx() {
        throw new RuntimeException("경고! 에러 발생!");
    }

    @GetMapping("/error-404")
    public void error404(HttpServletResponse response) throws IOException {
        response.sendError(404, "404 오류입니다");
    }

    @GetMapping("/error-429")
    public void error429(HttpServletResponse response) throws IOException {
        response.sendError(429, "429 너무 많은 요청입니다.");
    }

    @GetMapping("/error-502")
    public void error502(HttpServletResponse response) throws IOException {
        response.sendError(502, "502 오류입니다");
    }

    @GetMapping("/error-503")
    public void error503(HttpServletResponse response) throws IOException {
        response.sendError(503, "503 오류입니다");
    }
}
