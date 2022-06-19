# Spring security
### <a href="https://devuna.tistory.com/55">참고 사이트</a>
## 개념
```
1. 애플리케이션의 보안(인증 or 인가)을 담당하는 하나의 프레임워크이다.
2. 인증(== 사람,인물에 대한 보안)
   2-1) 보호된 리소스에 접근한 대상에 대해 *누구인지, 애플리케이션의 작업을 수행해도 되는 주체인지 확인하는 과정 => 즉, 누구인지,누가 리소스에 접근하는지 
3. 인가(== 행동,권한)
   3-1) 리소스에 접근 가능한 권한을 가지고 있는지 확인하는 과정 => 즉, 어떠한 권한을 가지고 있는지 확인하는 과정
4. Spring Security는 기본적으로 세션 & 쿠키방식으로 인증
```
## 특징 & 구조
```
1. Filter 기반으로 동작, MVC와 분리하여 관리 및 동작
2. 어노테이션을 통한 간단한 설정
   2-1) @EnableWebSecurity
   2-2) 
3. WebSecurityConfig extends WebSecurityConfigurerAdapter 상속을 통한 설정
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
