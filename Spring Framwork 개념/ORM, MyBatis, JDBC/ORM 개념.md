# ORM(Object Relational Mapping)(==객체지향언어) 개념

```
1. 데이터베이스 연결과 데이터 생성, 호출, 삭제, 수정을 도와주는 ★ORM★
2. 객체와 관계형 데이터베이스의 데이터를 *자동*으로 매핑(연결)해주는 것
3. 객체 지향 프로그래밍은 '클래스'를 사용하고, 관계형 데이터베이스는 '테이블'을 사용한다.
4. 객체(Object)와 관계형 데이터베이스(RDBMS)을 매핑하여 데이터베이스 테이블을 객체지향적으로 사용하기 위한 기술이다.
5. ORM을 사용하기 위해서는 DB 설계가 잘되어있어야 한다.
4. 종류 : MyBatis , JPA
```

## ORM dependencies

```java
dependencies {

	//ORM
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0'// Mapper->interface

}
```
