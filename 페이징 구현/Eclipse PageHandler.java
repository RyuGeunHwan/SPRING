package 페이징;

public class PageHandler {

	public static void main(String[] args) {

		//네이버 웹툰 여신강림 페이징
		//야옹이 작가는 210화까지 연재함.
		
		// setp 1. ★페이지 수 알아내기★(총 카운트와 한페이지에 몇개를 보여줄지가 중요)
		int total = 219;  //sql에서 count를 의미한다, 쿼리로 알아낼 수 있다.
		//네이버 웹툰 기준으로 1페이지 10개에 게시물을 보여줄 수 있다.
		int pages = 0;
		int pageSize = 10;//1페이지에 보여줄 수 있는 게시물 수
		// 몇개의 페이지가 나올까?
		pages = total / pageSize;
		// remainder : 나머지 값
		int remainder = total % pageSize;
		if(remainder > 0) {// 만약에 나머지 값이 있다면
			pages++; //나머지 값이 있기 때문에 1페이지를 증가 시켜준다.
		}
		System.out.println();
		System.out.println("총 페이지 수 : "+pages+"페이지");
		
		
		// step 2. 블록 알아내기
		int navigatePages = 10; //한블록에 몇페이지를 보여줄지(네이버 기준 1블록에 1 ~ 10페이지)
		int blocks = 0;
		blocks = pages / navigatePages;
		if(pages % navigatePages > 0) {// pages % navigetePages == 2페이지가 남음.
			// 만약 나머지값인 페이지가 0보다 크다면 blocks을 증감
			blocks++;
		}
		System.out.println("총 블록 수 : "+blocks+"블록");
		
		
		//step 3. 현재 블록 알아내기
		int pageNum = 14; //현재 페이지
		System.out.println("현재 페이지 : "+pageNum);
		int nowBlock = 0;
		nowBlock = pageNum / navigatePages;
		if(pageNum % navigatePages > 0) {
			nowBlock++;
		}
		System.out.println("현재 블록 : "+nowBlock+"블록");
		
		// step 4. 마지막 블록 알아내기
		int lastBlock = 0;
		// hint : total(219), navigatePages(한블록에 몇페이지를 보여줄지), pageSize(1페이지에 보여줄 수 있는 게시물 수)
		lastBlock = total / (navigatePages * pageSize); 
		//lastBlock == 2 , 나머지값 == 19
		if(total % (navigatePages * pageSize) > 0) {
			lastBlock++;
		}
		System.out.println("마지막 블록 : "+lastBlock+"블록");
		
		// step 5. 현재 내가 위치한 블록의 처음 페이지와 마지막페이지 구하기
//		ex) 1블록에 있으면 1 ~ 10
//			2블록에 있으면 11 ~ 20
//			3블록에 있으면 21 ~ 22 (여신강림 기준)
		int startPage = 0;
		startPage = (nowBlock*navigatePages) - (navigatePages - 1);
		int endPage = 0;
		endPage = (nowBlock*navigatePages);
		if(endPage>pages) {
			endPage = pages;
		}
		// hint : startPage 먼저 구하기
		System.out.println("현재 블록의 첫 페이지 : "+startPage+"페이지");
		System.out.println("현재 블록의 마지막 페이지 : "+endPage+"페이지");

		
		//step 6. 이전버튼, 다음버튼 유무 판단
		boolean hasPreviousPage = true; //이전버튼
		boolean hasNextPage = true; //다음버튼
		
		if(lastBlock == 1) {//블록이 하나이므로 이전, 다음 버튼 존재 X
			hasPreviousPage = false;
			hasNextPage = false;
		}
		if(lastBlock > 1 && lastBlock == nowBlock) {//마지막 블록이라면 이전버튼만 존재
			hasPreviousPage = true;
			hasNextPage = false;
		}
		if(lastBlock > 1 && pageNum <= navigatePages) {//첫번 째 블록인데 블록이 1 이상일 경우 다음 버튼 존재
			hasPreviousPage = false;
			hasNextPage = true;
		}
		System.out.println("이전 버튼이 있습니까? "+hasPreviousPage);
		System.out.println("다음 버튼이 있습니까? "+hasNextPage);
		
	}

}
