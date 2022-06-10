# JSP 기본 문법

## JSTL 추가

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 JSP 지시자에 JSTL을 추가해야 if,else,for-each를 사용할 수 있다.
```

## if,else,for-each(jsp는 기본for문 X)

```jsp
1. if
    ===
    <c:if test="조건문">

    </c:if>

2. if,else
    ===
    **c:choose로 감싸 주어야한다.
        <c:choose>
        <c:when test="조건문"> if문 </c:when>
        <c:otherwise> else문 </c:otherwise>
        </c:choose>

3. JSP for문(for_each문)
    ===
    <c:forEach items="${controller에서 받아오는 값}" var="변수명">

    </c:forEach>

4. JSP for-each문을 일반for문으로 변환
    ===
    <!-- 일반 for문처럼 사용할 수 있는 for-each문 -->
	<!-- begin부터 end까지 반복 (시작과 끝을 지정해준 뒤 변수에 대입하여 반복) -->
	<c:forEach begin="1" end="5" var="i">
		<h4>${i}</h4>
	</c:forEach>


5. fn(function)사용
    지시자 부분에 이 문구가 있어야한다.
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    JSP태그
        <c:choose>
            <c:when test="${fn:(함수내용)}">
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    ex)

```

### HomeController.java

```java
package com.study.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.jsp.vo.ActorVO;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String loadHomePage(ModelMap map) {

		// 왼쪽 : key , 오른쪽 : value
		map.addAttribute("name" , "손흥민");// name은 key, 손흥민은 value
		map.addAttribute("backNumber" , 7);// backNumber은 key, 7은 value
		map.addAttribute("size", 150);

		List<String> list = new ArrayList<String>();
		list.add("씨야");
		list.add("쏠");
		list.add("윤은혜");
		map.addAttribute("wsgList", list);


		List<ActorVO> actorList = new ArrayList<ActorVO>();
		ActorVO a1 = new ActorVO();
		a1.name = "이병헌";
		a1.age = 51;

		ActorVO a2 = new ActorVO();
		a2.name = "차승원";
		a2.age = 52;

		actorList.add(a1);
		actorList.add(a2);

		map.addAttribute("actorList", actorList);


		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("no", 300);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("no", 100);

		mapList.add(map1);
		mapList.add(map2);

		map.addAttribute("mapList", mapList);


		return "index";// jsp파일명 리턴
	}


	@GetMapping("/board")
	public String loadBoardPage(ModelMap map) {

		Map<String, Object> data = new HashMap<String, Object>();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Company", "Alfreds Futterkiste");
		map1.put("Contact", "Maria Anders");
		map1.put("Country", "Germany");

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Company", "Centro comercial Moctezuma");
		map2.put("Contact", "Francisco Chang");
		map2.put("Country", "Mexico");

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Company", "Ernst Handel");
		map3.put("Contact", "Roland Mendel");
		map3.put("Country", "Austria");

		list.add(map1);
		list.add(map2);
		list.add(map3);
		data.put("list", list);
		System.out.println(map1.get("Company"));
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		map.addAttribute("data", data);

		return "board";
	}

}


```

### ActorVO.java

```java
package com.study.jsp.vo;

public class ActorVO {

	public String name;
	public int age;

    // Map이 아닌 클래스로 값을 받아와야하는 경우 getter를 사용하여야 한다.
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

}
```

### board.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<!-- 문제. 테이블에 데이터 넣기  -->
	<table>
		<thead>
			<tr>
			    <th>Company</th>
			    <th>Contact</th>
			    <th>Country</th>
	 		</tr>
		</thead>
	 	<tbody>
	 		<c:forEach items="${data.list}" var="CCC">
		 		<tr>
				    <td>${CCC.get("Company")}</td>
				    <td>${CCC.get("Contact")}</td>
				    <td>${CCC.get("Country")}</td>
  				</tr>
			</c:forEach>
	 	</tbody>
	</table>

</body>
</html>

```

### index.jsp

```jsp
<!-- jsp 기본 설정 start -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- jsp 기본 설정 end -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
</head>
<body>
	<h1>Hello World!</h1>
	<h3>${backNumber}</h3><!-- value가져오기 -->
	<h3>${name}</h3><!-- value가져오기 -->

	<!-- JSP IF문 -->
	<!-- c:if : JSP문법(jstl문법)
		if는 있고 else는 없음
		test : 조건식 -->
	<!-- 숫자 비교 -->
	<c:if test="${backNumber == 7}">
	<h4>대한민국 만세!</h4>
	</c:if>
	<!-- 문자 비교 -->
	<c:if test="${name.equals('손흥민')}">
	<h4>코리아 만세!</h4>
	</c:if>


	<!-- JSP if else를 구현하고 싶을 때 -->
		<!-- c:choose = if,else를 담기위한 컨테이너 -->
		<!-- c:when = if -->
		<!-- c:otherwise = else -->
		<h1 style="color:red">if, else 문</h1>
		<p style="font-size:25px">c:choose = if,else를 담기위한 컨테이너</p>
		<p style="font-size:25px">c:when = if</p>
		<p style="font-size:25px">c:otherwise = else</p>
	<c:choose>
		<c:when test="${size < 100}">
			<h4 style="color:red;">사이즈는 100 미만입니다.</h4>
		</c:when>
		<c:when test="${size >= 100 && size < 200}">
			<h4>사이즈는 200 미만입니다.</h4>
		</c:when>
		<c:otherwise>
			<h4>사이즈는 200 이상입니다.</h4>
		</c:otherwise>
	</c:choose>


	<!-- JSP 반복문(for문) -->
	<!--
	for(String str : wsgList){

	 *items="${wsgList}" === wsgList
	 *var="str" === str

	} -->
	    <h1 style="color:red">c:forEach문</h1>
		<h5>items="${wsgList}"을 변수 "str"에 담아서 출력</h5>
	<c:forEach items="${wsgList}" var="str">
		<h4>str : ${str}</h4>
	</c:forEach>

	<c:forEach items="${actorList}" var="actor">
	 	<h4>배우이름 : ${actor.name},</br> 배우나이 : ${actor.age}</h4>
	</c:forEach>
		<h2>이병헌만 출력 ==> ${actorList[0].name}, ${actorList[0].age}</h2>
		<h2>차승원만 출력 ==> ${actorList[1].name}, ${actorList[1].age}</h2>
		<h3>연동 완료</h3>

	<c:forEach items="${mapList}" var="map">
		<h4>mapList의 no : ${map.no}번</h4>
	</c:forEach>


</body>
</html>
```
