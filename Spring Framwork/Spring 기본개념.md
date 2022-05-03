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
```

## Spring 종류

```
1. spring 레거시(일반 spring)
2. spring boot(경량(가벼운) spring)
3. spring 전자정부프레임워크(egov)
```

## ★ Spring 하고 같이 사용하는 친구들 ★

```
문제점 : spring만으로 어플리케이션을 개발하는데 한계가 있고 데이터베이스, 고객에게 보여줄 화면 필요 등등...

1번~5번은 must!!!

1. 데이터베이스 연결과 데이터 생성, 호출, 삭제, 수정을 도와주는 ***ORM
    1-1) ORM종류 : MyBatis(O) , JPA

2. 필요한 기능을 쉽게 다운로드 받을 수 있고, 서버에 업로드(배포)를 도와주는 ***빌드관리도구(Build Tool)
    2-1) 빌드관리도구 종류 : Gradle(O) , Maven

3. 화면을 도와주는 템플릿 엔진
    3-1) 템플릿 엔진 도구 : JSP , Thymeleaf(O)

4. 속성(데이터베이스 주소,아이디,비밀번호) 정의를 담당하는 속성 파일
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

1. controller 패키지 생성
    1-1) controller : url 요청을 받는 곳

***2. http?
    2-1) GET : 요청, 조회

```

## Spring 자동 리로드(재시작) 방법

```
1. 구글 'devtools gradle' search!
2. 첫번째 피드 들어가서 'Gradle'안에 있는

compileOnly("org.springframework.boot:spring-boot-devtools")

복사

3. Spring(이클립스)에 들어가서 파일이름(코끼리 모양) : 'build.gradle' 들어가
4. dependencies{ (중괄호 안에 붙여넣기)
 compileOnly("org.springframework.boot:spring-boot-devtools") // 서버 자동으로 리로드(재시작)
 }
 5. 파일 'build.gradle' 오른쪽 마우스 클릭 후 Gradle -> Refresh... 클릭해서 새로고침 해준다.
```
