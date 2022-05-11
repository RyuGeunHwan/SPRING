# Controller에서 URL을 요청받는 2가지 방법

## 1. RESTful

```
1. RESTful :  주소(URL)를 의미있게 네이밍(이름 정하기)을 하는 방법
    1-1) 주소만 보고도 이것이 무엇인지 짐작이 가게끔 네이밍을 하는것.
    ex)
    localhost:8080/emp/empno/7000 : emp테이블에 empno가 7000인 사람

    1-2) /job/{job}/sal/{sal}
        @PathVariable로 {} 값을 파라미터에 대입

2. RESTful 규칙
    2-1) 주소 이름은 동사X -> 명사로 작성
        ex) /member/ insert (X)
            /member/no/123 (O)

    2-2) 주소 이름은 대문자 X -> 소문자 사용
    2-3) 복수(그룹 등)를 의미할 경우에는 복수명사 사용
        ex) /members (O)
            /member (X)
    2-4) 주소 설정 : 리소스명/리소스아이디/관계가 있는 다른 리소스
        핸드폰을 소유하고 있는 학생(복수)조회
            /students/phone
        특정 학생의 핸드폰을 조회
            /students/1/phone
    2-5) 마지막 주소에는 '/' 를 포함하지 않는다.
        www.naver.com/news/ (X)
        www.naver.com/news (O)
    2-6) 주소에는 '_' 를 사용하지 않는다.


ex) 130번 번호를 가진 고객 주문 리스트 조회
    방법1. /customers/130/orderList
    방법2. /customers/130/order/list
     방법3. /customers/130/order-list

ex) 20번 번호를 가진 유저의 핸드폰 고유번호는 AA123
     /users/20/phone/AA123

ex) 사원번호가 7000 사원의 사수번호는 3000
    방법1. /emp/7000/mgr/3000
    방법2. /emp/empno/7000/mgr/mgrno/3000

```

## 2. QUERY String : URL주소 중에 ? or &

```java
1. **검색(필터링)할 때 많이 사용.
    ex) 게시판에서 많이 사용

2.  // 쿼리스트링으로 @GetMapping
	// 쿼리스트링은 @RequestParam("url주소의 변수명")으로 값을 받음.
	// region=kr kr을 region에 대입하겠다라는 의미.
	주소 => localhost:8080/tier?region=kr&name=geunhwan
	@GetMapping("/tier")
	public String calltier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region + ","+name;
	}
    //출력 결과 => kr,geunhwan

    ex) 게시판에서 많이 사용
    주소 => localhost:8080/board?page=1&pageSize=10&writer=geunhwan
	// 게시판의 현재 페이지는 1페이지 한 페이지에 보여주는 행의 수는 10개이고 작성자는 geunhwan이다.
	@GetMapping("/board")
	public int callBoard(
			@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize,
			@RequestParam("writer") String writer
			) {
		System.out.println("현재 페이지 : "+page);
		System.out.println("한 페이지에 보여주는 row수 : "+pageSize);
		System.out.println("작성자는 : "+writer);
		return 0;
	}
    // 출력 결과 =>
    // 현재 페이지 : 1
    // 한 페이지에 보여주는 row수 : 10
    // 작성자는 : geunhwan

```

### RESTful(REpresentational State Transfer)

    RESTful은 쉽게 생각해서 클라이언트와 서버간의 URL 규칙 스타일 중 하나.
    REST에는 기본 원칙이 있고, 이 가이드를 준수한 API는 RESTful하다고 표현.

### RESTful 규칙

1. 슬래시(/) 구분자는 계층 관계를 나타내는 데 사용
   ex) /whales/animals/mammals (x) 고래 -> 동물 -> 포유류
   ex) /animals/mammals/whales (o) 동물 -> 포유류 -> 고래

2. URL 마지막 문자로 슬래시(/)를 포함하지 않는다.
   ex) /houses/apartments/ (X)
   ex) /houses/apartments (0)

3. 밑줄(\_)은 URL에 사용하지 않는다. 대신 하이픈(-)을 사용하여 URL 가독성을 높이자!
   ex) /users/game_list (X)
   ex) /users/game-list (0)

4. URL 경로에는 소문자가 적합하다.
   ex) /users/FOOD (x)
   ex) /users/food (o)

5. 행위(method)는 URL에 포함하지 않는다.
   ex) /users/update/info (X)
   ex) /users/info (0)

6. 동사보다는 명사를 사용한다.
   ex) /users/delete (x)
   ex) /users (o) (\*http method를 delete로)

7. 단수(Singular) 보다는 복수(Plural)형 명사를 사용한다.
   ex) /sports/soccer/player/13 (x)
   ex) /sports/soccer/players/13 (o)
