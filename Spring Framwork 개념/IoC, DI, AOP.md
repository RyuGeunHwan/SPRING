# Spring 3대장 개념

# 1대장 개념 : IoC(Inversion of Control) == ★제어의 역전★

```java
1. 객체의 생성부터 소멸까지 Spring에서 관리함. => Spring이 제어해서 관리하는 class를 'Bean' class 라고 한다!
2. IoC 컨테이너는 spring에서 쓰이는 여러 객체들을 Spring이 생성, 관리하는 객체
3. IoC가 없다면 @Autowired를 통한 의존성 주입(대입)을 할 수 없을 것
(feat.의존성 주입 : @Autowired를 통해 new 사용하지 않고 의존 객체 생성 == java에서는 new를 통해 의존 객체를 직접 생성)
ex)
@Autowired
private MainService service; //메소드
	// 1. MainService클래스는 비즈니스로직을 구현하는 @Service 어노테이션이 있기 때문에
	// 2. 추가로 호출하는 곳에 @Autowired 어노테이션이 작성되어 있어야한다.
	// 두가지가 충족 된다면 Controller에서 따로 호출(new)하지 않고 @Autowired를 통하여 의존성 객체를 생성한다.
	// (@Autowired Spring이 해당 객체(클래스)를 관리해줌. IoC(Inversion of Conrtol)
	public List<ServiceVO> callSelectAllList(){
		return service.getSelectAllList(); //이런식으로 MainService에 있는 메소드를 사용할 수 있다.
	}
```

# 2대장 개념 : DI(Dependency Injection) == 의존성 주입(대입)

```java
1. Spring이 객체(클래스)가 필요하다면 외부에서 가져다가 주입(대입)하는 방식.
	(객체(클래스)를 외부에서 가져다가 쓰기 때문에 new연산자가 사라짐.)
2. 의존 관계 주입이라 하고, 어떤 객체가 사용하는 의존 객체를 직접 생성하는 것(new)이 아니라
	의존 객체를 *주입(대입)하는 방법( @Autowired )(객체간의 의존성을 자신이 아닌 외부에서 주입)
3. 의존성 주입(DI) 종류 3가지
	3-1) 필드 주입(Field Dependency Injection)
		3-1-1) 필드 주입 방식 사용법 :
		- 필드변수에 의존 객체를 생성하는것.
		- @Autowired을 통해 의존성을 주입(대입)하는 방식

		public class FieldInjection{
			*@Autowired
			private Field field; //필드변수
		}

	3-2) 수정자 주입(Setter Dependency Injection)
		3-3-1) 수정자 주입 방식 사용법 :
		- 수정자(setter)를 통해 의존성을 주입하는 방식
		public class SetInjection{
			private Set set; //필드변수

			@Autowired
			// 함수이름이 set일 필요는 없지만 일관성을위해(쉽게 알아보기 위해) set을 사용하는 것이 좋다.
			public void setSet(Set set){
				this.set = set;
			}
		}

	★★★3-3) 생성자 주입(Constructor Dependency Injection)
		3-3-1) 수정자 주입 방식 사용법 :
		- 생성자를 통해 의존성을 주입(대입)하는 방식
		- 3가지 주입 방식 중 가장 권장하는 방식이다.
		public class ConstructorInjection{
			private final Constructor constructor; //필드변수

			@Autowired
			public ConstructorInjection(Constructor constructor){ //생성자
				this.constructor = constructor;
			}
		}
```

# 3대장 개념 : AOP(Aspect Oriented Programming)

```
1. 여러 메소드(함수)에서 중복되는 코드가 있다면, 따로 모아서 재활용 하는 것.
```
