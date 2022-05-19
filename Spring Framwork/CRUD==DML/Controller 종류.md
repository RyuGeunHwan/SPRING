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

# Controller에서의 @Mapping종류

```
1. Post (insert) *Create
2. Get (select) *Read
3. Patch (update) *Update
4. Delete(delete) *Delete

5. Get을 제외한 트랜잭션의 리턴타입은 int형으로 온다.
6. 트랜잭션의 쿼리는 서브쿼리로 짜면 안됨!
	why? 추가해야할 사항이 늘어나면 쿼리가 1개씩 추가 됨.
	해결방법 : MyBatis쿼리에 IF문을 사용해서 우선 다 업데이트 해줌.(test(조건문)을 이용해서 막아두는거 필수)
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

3. ***중요한 데이터를 서버에 전송할 때 POST를 사용해서 데이터를 Body에 숨긴다.

```

# @PostMapping문법

```java
	// @RequestBody가 파라미터로 넘어오는 VO클래스를 대신 new해줌.
    // @PostMapping(insert)일 경우 데이터를 객체로 받고 JSON으로 넘어온다.
    // @PostMapping의 return타입은 int형이다. 뿐만아니라 트랜잭션(DML)은 return타입이 int형이다.(@GetMapping제외)
    // @PostMapping : 데이터 insert
	@PostMapping("/emp")
	public int callEepSet(@RequestBody EmpVO empVO) {
		System.out.println("사원 hiredate : "+empVO.getHiredate());
		System.out.println("사원 job : "+empVO.getJob());
		return 0;
	}
```

# @DeleteMapping : 데이터 delete

## delete할 경우 꼭 PK로 받자! PK로 받지 않을 경우 연관된 데이터 모두 삭제 되니까 주의 하긔~~!!!

```java
//@DeleteMapping : 데이터 delete
// 트랜잭션의 return타입은 int형이다.
	@DeleteMapping("/emp/empno/{empno}")
	public int callEmpRemove(@PathVariable("empno") int empNo) {
		return empService.getEmpRemoveCount(empNo);
	}
// delete같은 경우 왜 데이터를 객체로 받지 않는지?
// 1. 쿼리에서 delete를 할 경우 PK를 삭제하는 쿼리가 오게 되면
//  PK에 포함된 데이터는 다 같이 삭제 되기떄문에 다른 조건문을 사용할 필요없음.
// 그리하여 객체가 아닌 empno만 받을 수 있게 파라미터에 int형이 온것이다.
```

# @PatchMapping : 데이터 update

```java
// @PatchMapping : 데이터 update
// (DB에서 UPDATE == DELETE 후 INSERT이다.)
// 트랜잭션의 return타입은 int형이다.
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return empService.getEmpUpdateCount(empVO);
	}
```
