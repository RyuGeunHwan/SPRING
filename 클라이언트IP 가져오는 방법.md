# 클라이언트 or url요청하는 사람의 IP를 가져오는 방법

```java

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ooooo{

@GetMapping("/getIp")
    // 메소드의 매개변수 부터~
public static String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null) ip = request.getRemoteAddr();
    System.out.println("IP ====> "+ip);
    // 여기까지의 로직이 IP를 Controller에 요청하는 IP를 확인할 수 있는 로직이다!
    return 0;
    }
}

```
