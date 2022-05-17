- # <a href="https://start.spring.io/">spring initializr</a>

<img src="./image/캡처.PNG" width= 1000px; alt="" />

```
1. 왼쪽 부분은 회사와 java버젼에 맞게 설정하면 된다.
2. 오른쪽 부분(ADD DEPENDENCIES...CTRL + B)은 클릭해서 원하는것 다운로드(추가).
3. GENERATE CTRL + Enter 클릭하면 .zip파일 다운로드 받아짐.
4. IDE 실행 파일(spring-workspace)에 넣은뒤 '여기에 압축풀기' 클릭!
5. IDE(스프링,이클립스) 들어가서 임포트 하기!
6. .propertis 파일을 .yaml로 파일로 바꾸고 파일 들어가서
     type-aliases-package : 데이터를 받을 패키지 경로)변경해주기!
7. banner파일과 logback파일(mapper위치 변경하기) resources패키지에 추가
8. resources패키지에 sqlmap패키지 생성 후 sqlmapper.xml 파일 생성
9. java패키지에 MVC(vo,mapper,service,controller) 생성
10. 클래스 파일 생성
11. "hello word!" 찍어 보기
```

- ## 다운로드 받은 목록 의미

```
1. Spring Boot DevTools : 저장하면 자동으로 reload(새로고침)됨.
2. Spring Web : Spring 웹 기본!
3. Lombok : getter, setter, 생성자 등등
4. MyBatis Framework : ORM(Object Relational Mapping)을 사용하기 위한 MyBatis 다운로드
5. MySQL Driver : MySQL에서 데이터를 연동하기 위해 다운로드
```

- # JSP 설정방법

### 1. jsp는 html 안에서 java코딩이 가능한 파일이다.

### 2. jsp파일과 html 파일의 차이점은 jsp는 language="java"라고 적혀있고 java 문법을 사용 할 수 있다.

```java
1. 프로젝트 오른쪽 마우스 클릭 후 Source Folder 클릭후 이름 src/main/webapp 로 설정
2. 패키지가 생기면 webapp패키지 오른쪽 마우스 클릭 후 제너럴 -> 폴더 -> webapp 폴더 클릭 후 이름 WEB-INF 로 설정
3. WEB-INF 오른쪽 마우스 클릭 후 폴더 만들기 이름은 views 로 설정
4. views 오른쪽 마우스 클릭 NEW ->  Other -> Web -> JSPfile -> index.jsp(이름 설정) -> finish 클릭
5. views폴더안에 index.jsp 파일이 생성됨.
6. jsp로 쓸거야라는 것을 설정 해주어야함. yaml파일 들어가서
    spring : 하위 관계로 설정하여야한다.
        # JSP 경로 설정
        mvc :
            prefix : /WEB_INF/views
            suffix : .jsp
7. .geadle 파일 들어가서 dependencies안에 JSP다운로드 후 refresh

    // JSP다운로드
    implementation "org.apache.tomcat.embed:tomcat-embed-jasper"
	implementation 'javax.servlet:jstl'

8. .geadle 파일 refresh하면 webapp 패키지 사라지는데 당황하지말고 scr폴더에 들어가면 있다!
9. resoueces폴더안에 static 폴더에 css , images, js 폴더 생성
10. js폴더에 index.js 파일 추가
11. .yaml파일 들어가서 css,js,image 폴더 위치 설정

    #css,js,image 폴더 위치 설정
      static-path-pattern: /resources/static/**

12. .jsp파일 들어가서 script태그 생성
    <script type="text/javascript" src="/resources/static/js/index.js"></script>
    // src에 경로 설정!
```

_yaml파일에 JSP 경로 설정 위치_

<img src="./image/JSP설정.PNG" width= 700px; alt="" />

_yaml파일에 css,js,image 폴더 위치 설정_

<img src="./image/css,js,image 폴더 위치 설정.PNG" width= 700px; alt="" />
