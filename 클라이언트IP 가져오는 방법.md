# 클라이언트 or url요청하는 사람의 IP를 가져오는 방법

```java

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ooooo{

@GetMapping("/getIp")
public static String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null) ip = request.getRemoteAddr();
    System.out.println("IP ====> "+ip);
    return 0;
    }
}

```
