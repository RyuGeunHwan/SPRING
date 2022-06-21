# Spring security

### <a href="https://devuna.tistory.com/55">참고 사이트</a>

## 개념

```
1. 애플리케이션의 보안(인증 or 인가)을 담당하는 하나의 프레임워크이다.
2. 인증(== 사람,인물에 대한 보안)
   2-1) 보호된 리소스에 접근한 대상에 대해 *누구인지, 애플리케이션의 작업을 수행해도 되는 주체인지 확인하는 과정 => 즉, 누구인지,누가 리소스에 접근하는지
   2-2) 인증관리자는 UsenamePasswordAuthenticationFilter에서 누구인지 확인
   2-3) 접근 결정 관리자는 FilterSecurityInterceptor에서 어떤 권한이 있는지 확인
3. 인가(== 행동,권한)
   3-1) 리소스에 접근 가능한 권한을 가지고 있는지 확인하는 과정 => 즉, 어떠한 권한을 가지고 있는지 확인하는 과정
4. Spring Security는 기본적으로 세션 & 쿠키방식으로 인증
```

## 특징 & 구조

```
1. Filter 기반으로 동작, MVC와 분리하여 관리 및 동작
2. 어노테이션을 통한 간단한 설정
   2-1) @EnableWebSecurity : Spring Security 설정할 클래스라고 정의
   2-2) @Configuration
3. WebSecurityConfig extends WebSecurityConfigurerAdapter 상속을 통한 설정
```

### 표현식

### <a href="https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html">HttpSecurity 클래스 함수 참고 사이트</a>

```java

   // 비밀번호 암호화를 위한 객체 생성 후 Bean으로 등록
   // 로그인 시 해당 객체를 통해 암호화되어 진행
    @Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


   // WebSecurity filter
   // WebSecurity : 보안 예외 처리(정적 리소스, HTML 등)
   // 상속하는 WebSecurityConfigurerAdapter의 interface
    @Override
      public void configure(WebSecurity web) throws Exception {
         web.ignoring().antMatchers("/static/**");
         //.antMatchers 파라미터로 넘겨주는 경로의 파일들은 Spring Security Filter Chain을 거치지 않고 예외로 들어가기 때문에 Security서비스인 '인증','인가' 서비스가 적용되지 않는다.
      }

   // HttpSecurity :
   //    시큐리티 설정은 httpSecurity에서 설정해준다.
   // 상속하는 WebSecurityConfigurerAdapter의 interface
    @Override
    protected void configure(HttpSecurity http) throws Exception {
               //csrf(Cross site Request forgery) : 사이즈간의 위조요청, 특정 웹사이트에 요청하게 하는 공격(쉽게 말해 사용자가 자신의 의도와는 무관하게 공격자가 의도한 행위(수정,삭제,등록 등)) => @EnableWebSecurity은 csrf 공격을 방지하는 기능을 지원한다.
            http.csrf().disable() // 임의의 csrf 토큰을 지급한 후 이를 이용해 요청에 csrf 토큰이 없거나 불일치 하면 4XX 상태 코드를 리턴한다. 이를 비활성화하기 위하여 쓰는 메소드
                .formLogin().disable();
            .and()
            // .authorizeRequests() : 인가(특정 권한 접근 정책 지정)
                .authorizeRequests() // 특정 경로에 특정 권한을 가진 사람만 접근할 수 있도록 설정하는 메소드.
                .anyRequest().authenticated() //어떤 요청에도 보안검사를 진행하는 메소드.
               // .antMatchers() : 특정 경로 설정
                .antMatchers("/logs/**").hasRole("ROOT")
                // /logs경로의 모든 경로는 ROOT 권한 사용자만 접근 가능(특정 경로에 특정 권한자 설정)
                .antMatchers("/**").permitAll()
                //모든 경로에 권한없이 접근 가능.
            .and()
                .formLogin() // .formLogin() : 로그인 관련 인증 설정
                .loginPage("/login/form") // 사용자 정의 로그인 페이지 경로 지정
                .usernameParameter("userId") // 사용자이름 파라미터명 설정(로그인 폼에서 input태그의 name이 userId로 설정되어야 함
                .passwordParameter("password") // 사용자비밀번호 파라미터명 설정(로그인 폼에서 password태그의 name이 password로 설정되어야 함
                .loginProcessingUrl("/login/perform") //로그인 폼에서 아이디와 비밀번호를 받아 로그인 처리하는 경로, 이 경로는 직접 구현하는 것이 아니라 Spring security filter가 자동으로 처리해준다.
                .defaultSuccessUrl("/login/success") //로그인 인증 성공시 방문 페이지
                .failureUrl("/login?error=true") //로그인 실패시 방문 페이지
                .permitAll() // 모든 유저에게 접근을 허용.
                .denyAll() // 모든 유저에게 접근을 허용하지 않음.
            .and()
                .logout() // .logout() : 로그아웃 설정 진행 메소드(Spring security가 자동으로 처리)
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃 경로 지정.
                .logoutSuccessUrl("/login/logout") // 로그아웃 성공시 방문 페이지
                .invalidateHttpSession(true) // 로그아웃 성공 시 세션을 제거(세션 초기화)
                .deleteCookies("Session KEY명") //로그아웃 시, 특정 쿠기를 제거하고 싶을 때 사용하는 메서드
            .and()
                .exceptionHandling().accessDeniedPage("/login/denied"); // 권한이 없는 사용자(403에러)가 접근했을 경우 이동할 경로 지정.
            .and()
                .session-management() // session-fixation 공격을 방어하고, 세션 타임아웃을 감지하고, 인증된 사용자가 동시에 열 수 있는 세션 수를 제한하는 등에 사용
                ..maximumSessions() // 최대 허용 세션수를  제한하는 메소드(-1인 경우 무제한 세션)
                .maxSessionsPreventsLogin(true) // 동시 로그인 차단, false인 경우 기존 세션 만료(default)
                .expiredUrl("URL경로") // 세션이 만료되었을 경우 이동 할 페이지 URl
                .invalidSessionUrl("/login") //세션이 유효하지 않을 경우 이동 할 페이지
    }
```

### maven(pom.xml) 의존성 추가

```java
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
   <version>2.4.5</version>
</dependency>
```

### gradle(Build.gradle) 의존성 추가

```java
implementation group: 'org.springframework.boot', name: 'spring-boot-starter-security', version: '2.4.5'
// 버전은 명시하지 않으면 자동으로 최신버전이 적용 된다.
```
