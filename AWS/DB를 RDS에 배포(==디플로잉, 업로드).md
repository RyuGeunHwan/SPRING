# DB 배포(== 업로드, == 디플로잉)

```
1. 언어마다 배포하는 방법이 다름
2. 배포Tool : gradle, maven(grdle, maven은 java에만 있음(Spring,Android))
3. 데이터를 배로할 때에는 파일을 압축하여 배포하여야 하는데 그것은 java에서 .war or .jar 파일이다.
    (우리가 아는 .zip파일과 같은 개념이지만 java에서는 .war or .jar이다.)
    3-1) .war : 바로 실행 *불가능한 어플리케이션(==프로그램)
        ( .war파일은 Spring, eGov만 가능 .jar파일은 불가능)
    3-2) .jar(default) : 바로 실행 *가능한 어플리케이션(==프로그램)
    3-3) Spring Boot는 .jar / .war파일 둘다 가능() 내장 톰캣이 있기때문에

```

## 배포 순서 : 빌드 -> 컴파일(컴퓨터가 알아들을 수 있게 바꿔주는것) ->

## 쉽게 AWS에 DB배포하는 방법 = AWS_Beanstalk

```
1. AWS 빈스톡(Beanstalk)을 이용한다.
2. 단, war파일 압축까지는 하여야한다.
```

## 코드에만 집중 할 수 있는 AWS 서비스 = AWS_Lamda

```
1. 배포,war파일 압축도 쉽게 할 수 있다.
```

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
<img src="./war압축 설정 image/DB배포2.PNG" width= 500px; alt="" />
<img src="./war압축 설정 image/DB배포3.PNG" width= 800px; alt="" />

```
1. log창에 Gradle Tasks에서 .war압축파일로 만들고 싶은 프로젝트 선택
2. build 폴더 열기 (gradle파일에 추가를 해주고 gradle refresh를 하였다면 bootwar라는 파일이 생성 되었을 것이다.)
3. clean 실행(선택사항)
4. bootwar 실행 -> 한번 더 bootwar 실행
5. .war 압축파일 다운로드 성공 (오류가 뜨지 않는다면)
6. 확인 방법 : 선택한 프로젝트 폴더 들어가면 build라는 폴더가 생성되어있다.
7. build폴더 -> libs폴더 -> 프로젝트명으로 되어있는 .war압축 파일 -> ROOT.war압축파일로 파일명 변경
```
