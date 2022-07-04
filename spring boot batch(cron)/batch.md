- ## Build.gradle 의존성 추가

```java
Spring Boot starter 에 기본적으로 의존 org.springframework.scheduling 이 내장 되어있다.

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter'
	testImplementation 'org.awaitility:awaitility:3.1.2'
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}
```

- ## main class
- ### @EnableScheduling

```java
@EnableScheduling
@SpringBootApplication
public class SpringBootTestApplication {
    // main 실행 함수
    public static void main(String[] args) {
         SpringApplication.run(SpringBootTestApplication.class, args);
    }
}

```

- ## scheduler를 사용할 클래스 && scheduler를 사용할 메소드

- ### @Component && @Scheduled(cron = "\* \* \* \* \* \* \*")

```java
@Component
public class SchedulerTest {

 // cron 스케줄러 설정(일괄처리 되는 시간 설정)
  @Scheduled(cron = "0/10 * * * * *")  public void test() {
    // 콘솔 출력
    System.out.println(new Date());
    // 콘솔 출력
    System.out.println(userdao.selectById("nowonbun").getName());  }

}
```

- ## 번외 : @Component VS @Configuration

```java
@Componenet

1. 개발자가 직접 작성한 클래스를 Bean으로 등록하고자 할 경우 사용
2. @Controller, @Service, @Repository 등의 어노테이션에서 상속
ex)
    // 다른 클래스에서 Bean으로 불러 사용이 가능함
    @Component
    public class MyComponent{ // 개발자가 직접 작성한 클래스
        // do something
    }


@Configuration

1. 외부라이브러리 또는 내장 클래스를 Bean으로 등록하고자 할 경우 사용(개발자가 직접 제어가 불가능한 클래스)
2. 1개 이상의 @Bean을 제공하는 클래스의 경우 반드시 @Configuration을 사용. 즉, 해당 클래스에서 한 개 이상의 Bean을 생성하고 있을때 선언 해주어야 함
ex)
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {//외부 라이브러리를 상속 받는 SecurityConfig클래스

        // config...

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
```

- # cron 표현식
<img src="img/spring boot cron1.PNG" width= 600px; height= 800px; alt="" />
<img src="img/spring boot cron2.PNG" width= 600px; height= 800px; alt="" />
<img src="img/spring boot cron3.PNG" width= 600px; height= 600px; alt="" />
