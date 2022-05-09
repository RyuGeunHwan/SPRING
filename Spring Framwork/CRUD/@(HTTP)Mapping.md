## SQL 핵심개념

```sql
CREATE, DROP, ALTER(DDL)

SELECT, INSERT, DELETE, UPDATE(DML)

1. DDL과 DML의 *핵심 차이점?
 => AUTO COMMIT 여부!
    (DDL = AUTO COMMIT(O) , DML = AUTO COMMIT(X))

2. MyBatis INSERT, DELETE, UPDATE는 auto commit;
    2-1) DML을 짤때는 쿼리를 한번더 신경을 써야한다
        why? 쿼리가 오류가 나도 DML은 AUTO COMMIT이기 때문에 에러가 난 상태로 commit이 되기 때문에!

3. MyBatis INSERT, DELETE, UPDATE return은 int로 처리된 행의 수를 return해준다.

4. INSERT, DELETE, UPDATE 의 명칭 => DML or ***트랜잭션
    (트랜잭션 : 변하고, 삭제되고, 생성되는 것을 트랜잭션이라고 한다.)

```

# CRUD

```
C : CREATE(INSERT)
R : READ(SELECT)
U : UPDATE
D : DELETE
```

# @PostMapping : 데이터 insert

```
1. 주소는 같으면 안되지만 URL이 같아도 가능할 경우
    HTTP메소드가 다르면 오버로딩처럼 사용 가능
    ex) UR:주소가 같아도 사용가능 할때
    @GetMapping("/emp/naver")
    @PostMapping("/emp/naver")

2. PostMapping :
    2-1) 중요한 정보를 보내거나, 데이터를 많이 보낼 때 post를 사용한다.
    2-2) PostMapping은 웹에서 Body로 넘어간다 <-> GetMapping은 웹에서 header(주소 입력창)로 넘어간다.
    ex) 대표적인 예 : 회원가입 => GetMapping으로 넘겨주게 되면 회원정보가 header(주소 입력창)에 나타나기 때문에 PostMapping으로 넘겨주어야한다.

```

# @PostMapping문법

```java
// emp테이블에 insert해보기
	// @RequestBody가 파라미터로 넘어오는 VO클래스를 대신 new해줌.
	@PostMapping("/emp")
	public int callEepSet(@RequestBody EmpVO empVO) {
		System.out.println("사원 hiredate : "+empVO.getHiredate());
		System.out.println("사원 job : "+empVO.getJob());
		return 0;
	}
```

# @DeleteMapping : 데이터 delete

```

```

# @PatchMapping : 데이터 update

```

```
