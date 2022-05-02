## 회사가서 이클립스, sts 한글로 설정하는 방법!(맨 처음 확인 해야함)

```
회사 가서
이클립스 or sts(spring tools) => 'IDE'라고 한다.

첫번째. 한글 설정
두번째. 네비게이션바 Window클릭 -> Preferences -> 왼쪽 상단 검색창에 encoding 검색
	-> General(Workspace 클릭) -> 하단 Text file encoding에서 Other 클릭 후 'UTF-8'로 설정
```

## sts(spring tools) 설치방법

```
    번외 : https://start.spring.io -> 북마크해주기!

1. 구글에 'sts'검색
2. spring Tools 클릭
3. WINDOWS X86_64 다운로드(파일이 커서 오래걸림~!)
4. 압축 풀고 'spring-tool...'파일안에 'contents.zip' 압축풀고 contents파일 들어가서 'SpringToolSuite4.exe'실행
     -> C드라이브에 spring-workspace 파일 만들고 선택 후 Launch

5. 한글 설정 후 구글에서 https://start.spring.io 접속
    5-1) Gradle Project 선택-> Artifact 칸에 프로젝트명 설정 후 오른쪽 Dependencies에 원하는 프로그램 ADD(필수로 Spring Web은 선택!!!) 후 GENERATE 클릭!
        Tip) java버전은 cmd창 띄어서 'java --version'로 확인
            (현재 사용 버전보다 낮은 버전으로 선택)
    5-2) 다운받은 zip파일을 프로젝트 하는 공간 파일(spring-workspace)에 넣은 후 압축 풀기!

6. 이클립스 들어가서 상단 File클릭 -> Switch Workspace -> Other(프로젝트 하는 공간 파일(spring-workspace) 선택)


```
