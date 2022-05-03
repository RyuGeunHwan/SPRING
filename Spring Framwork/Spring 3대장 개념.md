# Spring 3대장 개념

# 1대장 개념 : IoC(Inversion of Conrtol)

```java
객체의 생성부터 소명까지 Spring에서 관리함.
ex)
@Autowired
private MainService service;
	// 1. MainService클래스는 비즈니스로직을 구현하는 @Service 어노테이션이 있기 때문에
	// 2. 추가로 호출하는 곳에 @Autowired 어노테이션이 작성되어 있어야한다.
	// 두가지가 충족 된다면 Controller에서 따로 호출(new)하지 않고 필드변수로 선언 후 사용 가능!
	// (@Autowired Spring이 해당 객체(클래스)를 관리해줌. IoC(Inversion of Conrtol)
```

# 2대장 개념 : DI(Dependency Injection)

```
1. Spring이 객체(클래스)가 필요하다면 외부에서 가져다가 주입(대입)하는 방식.
	(객체(클래스)를 외부에서 가져다가 쓰기 때문에 new연산자가 사라짐.)
```

# 3대장 개념 : AOP(Aspect Oriented Programming)

```
1. 여러 메소드(함수)에서 중복되는 코드가 있다면, 따로 모아서 재활용 하는 것.
```
