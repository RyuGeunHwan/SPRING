# Spring의 MyBatis와 java의 interface와 비교하기

## interface인데 왜 implements가 없는지? 왜 @Override가 없는지에 대해서

```java
1. xml파일을 보게 되면 <mapper namespace="com.example.first_spring.mapper.EmpMapper">
    //namespace = xml에서 정의한 sql쿼리의 결과를 받을 Mapper(java의 interface)의 위치경로를 입력
    1-1) Interface인 EmpMapper클래스를 implements한것.
    1-2) Spring에서 Mapper위치경로를 입력해준 이 구문이 java에서는 implements(java에서 interface를 상속받는 단어)를 해준것.

2. interface는 무조건 사용 클래스에서 오버라이딩(재정의)를 해주어야 하는데 이것은 xml파일의 <select id="getEmpList" resultType="EmpVO">
    이 구문이 @Override 해준것이다.
    (java) 메소드 :
    @Override
    public 리턴타입 getEmpList(){}
        getEmpList()는 interface에서 정의한 추상메소드를 implements로 상속받아 @Override를 사용하여 메소드를 재정의!
    ==
    (Spring)
    xml :
    <select id="getEmpList" resultType="EmpVO">
        (id="getEmpList"는 Mapper에서 재정의할 메소드 명)

3. java interface의 @Override 메소드의 로직은 Spring에서는 xml파일의 sql쿼리와 같다.
```
