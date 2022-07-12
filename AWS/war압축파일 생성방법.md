## ROOT.war 압축하는 방법

### build.gradle파일

```
plugins {
    // 추가
	// default가 jar파일이기 때문에 war파일로 변경
	id 'war'
}

// 압축할 압축파일 이름 설정 추가
bootWar{
	archiveBaseName= 'board'
	archiveFileName= 'board.war'
	archiveVersion= '0.0.1'
}

dependencies {
    // 다운로드
	//deploy
	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
}

build.gradle파일 gradle refresh
```

### yaml파일

```
1. 개발 버전 설정이 ***env(운영환경 즉, AWS RDS로 연결)로 되어있는지 확인.
```

<img src="./war압축 설정 image/DB배포1.PNG" width= 500px; alt="" />
<img src="./war압축 설정 image/DB배포2.PNG" width= 600px; alt="" />
<img src="./war압축 설정 image/DB배포3.PNG" width= 800px; alt="" />

```
1. log창에 Gradle Tasks에서 .war압축파일로 만들고 싶은 프로젝트 선택
2. build 폴더 열기 (gradle파일에 추가를 해주고 gradle refresh를 하였다면 bootwar라는 파일이 생성 되었을 것이다.)
3. clean 실행(선택사항)
4. bootwar 실행 -> 한번 더 bootwar 실행
5. .war 압축파일 다운로드 성공 (오류가 뜨지 않는다면)
6. 확인 방법 : 선택한 프로젝트 폴더 들어가면 build라는 폴더가 생성되어있다.
7. build폴더 -> libs폴더 -> 프로젝트명으로 되어있는 .war압축 파일 -> ROOT.war로 파일명 변경
```
