# yaml(야믈)을 다운로드 방법

```
1. 패키지명 resource에 있는 properties파일 -> yaml로 파일명 변경 ->
    상단 Help클릭 -> 이클립스 마켓플레이스 -> Find창에 yaml Editor -> Install ->
    쭉쭉 넘어가면 마지막에 이클립스 다시 시작 -> yaml파일 로고가 y로 바뀜! -> yaml파일 들어가서 MySQL 접속정보 설정 입력 && MyBatis 설정 입력!
```

## 데이터베이스 && MyBatis 설정!

```yaml
#MyBatis 설정
mybatis:
  mapper-locations: classpath:/sqlmap/sqlmapper_*.xml
  # locations == sql위치!
  # * == sql전체를 다 가져오겠다.
  type-aliases-package: com.example.first_spring.v

#MySQL 접속 정보 설정
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/dw?useUnicode=true&charaterEncoding=utf-8&serverTimezone=UTC #접속하고 싶은 데이터베이스 url작성
    username: root #데이터베이스 username 작성
    password: rmsghksdl1! #데이터베이스 password 작tjd


  #yaml 파일 안에 설정을 할 경우 계층표현(상,하위 구분)으로 Tab을 꼭 해주어야한다!
```

# SQL데이터를 받는 XML파일 만들기

```
1. 프로젝트명 .resource에 만들기!
    1-1) 프로젝트에 패키지(패키지명 : sqlmap) 만들기 -> 패키지(sqlmap) 마우스 오른쪽 클릭 -> new -> Other -> 아래에 XML클릭 -> XML File -> Next -> File name : sqlmapper_데이터베이스명.xml로 수정 -> Finish클릭

(XML(ML == 마크업랭귀지(태그로 둘러쌓인 언어)) : )
```

## xml파일에서 SQL경로 설정

```xml
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- MyBatis에게 Mapper 경로를 적어야한다. -->
<mapper namespace="com.example.first_spring.mapper.MainMapper">
<select id="getEmpList" resultType="EmpVO">
	SELECT
	empno,
	ename,
	job
	FROM emp
</select>
</mapper>
```
