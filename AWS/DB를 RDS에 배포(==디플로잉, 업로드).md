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

## 쉽게 AWS에 DB배포하는 방법 = AWS_Beanstalk

```
1. AWS 빈스톡(Beanstalk)을 이용한다.
2. 단, war파일 압축까지는 하여야한다.
```

## 코드에만 집중 할 수 있는 AWS 서비스 = AWS_Lamda

```
1. 배포,war파일 압축도 쉽게 할 수 있다.
```
