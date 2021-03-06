## Spring을 배우는 이유?

```
1. spring은 검증된 툴
2. 검증 되었으니 회사에서 spring을 사용
3. 회사에서도 spring을 사용하는 개발자를 원함
4. 교육기관에서도 spring을 베이스로 교육
결론 : 수요가 많음.
```

# Spring이란?

```
1. Java로 다양한 어플리케이션(웹 or 앱)을 만들기 위한 *틀( == Framwork)
    1-1) 프레임워크 : 이미 기본이 완성되어 있는 상태에서 내가 가져다가 쓰기만 하면 되는 플랫폼
2. Spring이란 자바를 기반으로 하는 어플리케이션(웹 && 앱) 만드는것을 도와주는 프레임워크(플랫폼)
3. Spring을 이용하려면 tomcat을 설치해야 실행 됨.
4. Spring Boot는 tomcat을 설치할 필요 없이 내장되어 있음.

번외 : port번호 :8080이란 서버를 개방(오픈)되었다라는 의미
```

## Spring 종류

```
1. spring 레거시(일반 spring)
2. spring boot(경량(가벼운) spring) (O)
3. spring 전자정부프레임워크(egov)
```

## ★ Spring 하고 같이 사용하는 친구들(프레임워크) ★

```
문제점 : spring만으로 어플리케이션을 개발하는데 한계가 있고 데이터베이스, 고객에게 보여줄 화면 필요 등등...

1번~5번은 must!!!

1. 데이터베이스 연결과 데이터 생성, 호출, 삭제, 수정을 도와주는 ★ORM★
    1-1) ORM종류 : MyBatis(O) , JPA

2. 필요한 기능을 쉽게 다운로드 받을 수 있고, 서버에 업로드(배포)를 도와주는 ***빌드관리도구(Build Tool)
    2-1) 빌드관리도구 종류 : Gradle(O) , Maven

3. 화면을 도와주는 템플릿 엔진(View)
    3-1) 템플릿 엔진 도구 : JSP , Thymeleaf(O)

4. 속성(데이터베이스 주소,아이디,비밀번호) 정의를 담당하는 속성 파일(DB경로 설정, DB 연결 등)
    4-1) yaml(야믈)(O) , properties

5. 서버를 담당하는 Tomcat(O)

6. (optional) 그 외 Docker(도커) , GraphQL(그래프큐엘) 등등...
```

# ★ spring 규칙 ★

```
● 규칙 1 : spring package 이름 설정 방법
    1. 패키지는 3개부터 시작한다.(default)
        1-1) 첫번째 패키지 : com, io, kr 등등
        1-2) 두번째 패키지 : 회사이름
        1-3) 세번째 패키지 : 프로젝트 명
        ex) 패키지 명 : com.dw.board
    2. 패키지를 생성하기 위해서는 3개의 패키지 뒤에 '.패키지명'을 만들자.
        ex) com.example.first_spring.vo -> vo(value object) 에 관련된 클래스만 생성
    3. 프로젝트명이 java인 프로젝트는 java관련된 패키지,클래스(Controller,service,vo 등),인터페이스(mapper) 등 것만 온다.
        3-1) 프로젝트명이 resources인 프로젝트는 java관련되지 않은 것들만 온다.
            ex) HTML, CSS, 이미지, properties, .yaml, .xml 등이 온다.

1. controller 패키지 생성
    1-1) controller : url 요청을 받는 곳

***2. http 메소드
    2-1) GET : 요청, 조회
    2-2) POST : insert, 생성
    2-3) PATCH : update, 삭제 후 생성
    2-4) DELETE : 삭제
```

### 서블릿 컨테이너

```
1. 컨테이너 === 담다라는 의미
2. 서블릿 컨테이너 === 내가 만든 java 어플리케이션을 컨테이너에 담다.
    2-1) 서블릿 컨테이너는 tomcat(톰캣)에 있음.
    2-2) 서블릿 컨테이너 == tomcat(톰캣) 핵심 기능
```

## <a href="https://velog.io/@courage331/Spring-%EA%B3%BC-Spring-Boot-%EC%B0%A8%EC%9D%B4">Spring 과 Spring Boot 차이</a>
