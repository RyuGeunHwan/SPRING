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
	// localhost:8080/tier?region=kr&name=geunhwan
	@GetMapping("/tier")
	public String calltier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region + ","+name;
	}
    //postman 출력 결과 => kr,geunhwan

    ex) 게시판
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
