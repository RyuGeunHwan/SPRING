# Mybatis의 쿼리 결과를 Map과 VO로 받았을 때의 차이점

### Map과 VO 사용여부

```
1. SELECT나 JOIN의 쿼리 결과가 많아질 경우에는 **Map으로
	이유 : 조인이 많아지면 필드변수가 늘어남..(노가다)
	장점 : 컬럼이름이 맞게 알아서 매핑!

2. DELETE,UPDATE,INSERT의 쿼리 결과는 **VO or List<VO>로
	장점 : VO클래스에 미리 필드변수를 정의해서 문서화,유지보수 가능!
```

```
1. XML쿼리의 결과값이 여러개가 나오면 Mapper에서 List로 받는다. <-> 쿼리의 결과가 1개가 나올때는 VO로 받는것이 효과적이다.

2. 쿼리의 결과를 Map(key와 value로 이루어짐)으로 받게 될 경우 자동으로 key에는 컬럼명이 들어가고 value에는 쿼리의 결과 값이 들어가게 된다.

3. VO로 결과를 받을 경우 DB에 있는 컬럼명과 VO클래스에 있는 필드변수의 명이 같아야 한다.
    하지만 Map으로 받을 경우 앨리어스(==as)를 사용하여 컬럼의 별명으로 결과를 출력하여도 DB의 출력된 컬럼명과 상관없이
    값을 받을 수 있다.
    ex)
    1. VO클래스로 결과를 받을경우
        1-1) VO클래스 필드변수, XML쿼리 컬럼명, DB의 출력된 컬럼명 이 세개가 동일하여야한다.
        1-2) 쿼리의 결과가 많아지면 많아질 수록 VO에 필드변수(쿼리결과의 컬럼명)를 하나하나 다 만들어주어야한다는 단점이 있다.

    2. Map으로 결과를 받을 경우
        2-1) SELECT의 경우 VO클래스를 만들어 줄 필요 없다.
        2-2) XML쿼리에서 앨리어스를 사용한 컬럼명과 DB의 출력된 컬럼명이 동일할 필요는 없다.
```

```java
XML

<select id="selectEmpMapList" resultType="map">
SELECT
empno as 이엠피엔오,
ename as 이네임,
job as 잡,
sal as 샐,
e.deptno as 디쩜디이피티엔오,
d.dname as 디쩜디네임,
d.loc as 디쩜엘오씨
FROM emp AS e
INNER JOIN dept AS d
ON e.deptno = d.deptno
</select>

```

```java
@Mapper
    public List<Map<String, Object>> selectEmpMapList();

```

```java
@Service
    public List<Map<String, Object>> getEmpMapList(){
            return empMapper.selectEmpMapList();
        }
```

```java
@RestController
	@GetMapping("/emp/map/list")
	public List<Map<String, Object>> callEmpMapList(){
		return empService.getEmpMapList();
	}

```

```java
//결과 출력
// 컬렉션즈(List)로 여러개의 결과값을 받아서 Map으로 key와 value로 결과를 받아온다.

[
    {
        "샐": 2450.00,
        "잡": "MANAGER",
        "디쩜디이피티엔오": 10,
        "이엠피엔오": 7782,
        "이네임": "BABO",
        "디쩜디네임": "ACCOUNTING"
    },
    {
        "샐": 5000.00,
        "잡": "PRESIDENT",
        "디쩜디이피티엔오": 10,
        "이엠피엔오": 7839,
        "이네임": "KING",
        "디쩜디네임": "ACCOUNTING"
    },
    {
        "샐": 1300.00,
        "잡": "CLERK",
        "디쩜디이피티엔오": 10,
        "이엠피엔오": 7934,
        "이네임": "MILLER",
        "디쩜디네임": "ACCOUNTING"
    },
    {
        "샐": 800.00,
        "잡": "CLERK",
        "디쩜디이피티엔오": 20,
        "이엠피엔오": 7369,
        "이네임": "BRIAN",
        "디쩜디네임": "RESEARCH"
    },
    {
        "샐": 2975.00,
        "잡": "MANAGER",
        "디쩜디이피티엔오": 20,
        "이엠피엔오": 7566,
        "이네임": "JONES",
        "디쩜디네임": "RESEARCH"
    },
    {
        "샐": 3000.00,
        "잡": "ANALYST",
        "디쩜디이피티엔오": 20,
        "이엠피엔오": 7788,
        "이네임": "SCOTT",
        "디쩜디네임": "RESEARCH"
    },
    {
        "샐": 1100.00,
        "잡": "CLERK",
        "디쩜디이피티엔오": 20,
        "이엠피엔오": 7876,
        "이네임": "ADAMS",
        "디쩜디네임": "RESEARCH"
    },
    {
        "샐": 3500.00,
        "잡": "SALESMAN",
        "디쩜디이피티엔오": 20,
        "이엠피엔오": 7902,
        "이네임": "QEEN",
        "디쩜디네임": "RESEARCH"
    },
    {
        "샐": 1600.00,
        "잡": "SALESMAN",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7499,
        "이네임": "ALLEN",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 1250.00,
        "잡": "SALESMAN",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7521,
        "이네임": "WARD",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 1250.00,
        "잡": "SALESMAN",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7654,
        "이네임": "MARTIN",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 2850.00,
        "잡": "MANAGER",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7698,
        "이네임": "BLAKE",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 1500.00,
        "잡": "SALESMAN",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7844,
        "이네임": "TURNER",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 950.00,
        "잡": "CLERK",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 7900,
        "이네임": "JAMES",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 5000.00,
        "잡": "MANAGER",
        "디쩜디이피티엔오": 30,
        "이엠피엔오": 8000,
        "이네임": "류근환",
        "디쩜디네임": "SALES"
    },
    {
        "샐": 3250.00,
        "디쩜디이피티엔오": 40,
        "이엠피엔오": 9007,
        "이네임": "바르세로나",
        "디쩜디네임": "운영"
    }
]
```
