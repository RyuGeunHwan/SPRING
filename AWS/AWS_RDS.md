# RDS : 데이터베이스 전용 서버(관계형 DB만 설치 가능)

### <a href="https://velog.io/@ehddnr7355/AWS-RDS-%EA%B5%AC%EC%B6%95%ED%95%98%EA%B8%B0-%ED%9B%84-DataGrip%EC%9C%BC%EB%A1%9C-%EC%99%B8%EB%B6%80%EC%97%90%EC%84%9C-%EC%A0%91%EC%86%8D%ED%95%98%EA%B8%B0">AWS-RDS 구축 참고 사이트</a>

## RDS 개념

```
1. RDS는 AWS에서 제공하는 관계형데이터베이스 서비스
2. AWS에 설치된 DB를 구매하는 것.
3. 데이터베이스 설정,패치,백업 등 시간 소모적인 관리 작업을 자동화해주는 특징
4. 애플리케이션에 필요한 빠른 성능, 고가용성, 보안 및 호환성을 제공할 수 있도록 지원해주는 서비스
```

## RDS 데이터베이스 엔진

```
1. MySql
2. PostgreSql
3. MariaDB
4. ORACLE
5. SQLServer
6. Amazone Aurora
```

# RDS

- DB전용 AWS

## 1. 데이터베이스 생성

![001](/AWS/img/RDS/001.JPG)

## 2. 본인이 사용하는 DB선택 (MySQL 버전 낮춰서 선택)

![002](/AWS/img/RDS/002.JPG)

## 3. DB인스턴스 식별자 : 원하는 이름database / 마스터 암호 : DB접속 암호

![003](/AWS/img/RDS/003.JPG)

## 4. 캡쳐와 동일하게 선택

- 스토리지 : 최종데이터가 쌓이는 장소

![004](/AWS/img/RDS/004.JPG)

## 5. 퍼블릭 액세스 '예' 선택

- 디비는 민감하니까 퍼블릭 액세스는 아니오임 우리는 편의상 예

![005](/AWS/img/RDS/005.JPG)

## 6. 데이터베이스 생성

![006](/AWS/img/RDS/006.JPG)

## 7. 오른쪽 하단 VPC보안그룹 클릭

![007](/AWS/img/RDS/007.JPG)

## 8. 인바운드&아웃바운드 규칙 수정 -> mysql추가

- 0.0.0.0/0 : 모든 ip허용

![008](/AWS/img/RDS/008.JPG)

## 9. 사용자 sql실행

![009](/AWS/img/RDS/009.JPG)

## 10. create -> connection

![010](/AWS/img/RDS/010.JPG)

## 11. 사용하는 DB선택

![011](/AWS/img/RDS/011.JPG)

## 12. serverHost : 7번의 엔드포인트 / userName&password : 3번에서 설정한 이름&암호

![012](/AWS/img/RDS/012.JPG)

## 13. AWSDB생성 됐는지 확인

![013](/AWS/img/RDS/013.JPG)

## 14. DB이름 수정

![014](/AWS/img/RDS/014.JPG)

## 15. AWS SQL편집기 실행

![015](/AWS/img/RDS/015.JPG)

## 16. create DB & TABLE 실행

- DB만 생성하면 autoincrement가 체크 안됨(체크 해주어야 함.)

![016](/AWS/img/RDS/016.JPG)

## 17. create한 table 체크

![017](/AWS/img/RDS/017.JPG)

## 18. 데이터 내보내기

![018](/AWS/img/RDS/018.JPG)

## 19. 테이블선택 Cxported에 내가 선택한 테이블이 있는지 확인

![019](/AWS/img/RDS/019.JPG)

## 20. target container에 내가 생성한 AWS로 선택해야함 (choose)

![020](/AWS/img/RDS/020.JPG)

## 21. target container확인

![021](/AWS/img/RDS/021.JPG)

## 22. target [Existing]확인 > 진행

![022](/AWS/img/RDS/022.JPG)

## 23. 테이블에 데이터 들어왔는지 확인

![023](/AWS/img/RDS/023.JPG)

## 24. edit connection으로 연결 SQL수정

![024](/AWS/img/RDS/024.JPG)

## 25. serverHost : 7번의 엔드포인트 / userName&password : 3번에서 설정한 이름&암호

![025](/AWS/img/RDS/025.JPG)

## 26. AWSDB사용할 yaml파일 실행

![026](/AWS/img/RDS/026.JPG)

## 27. url 및 username, password수정

![027](/AWS/img/RDS/027.JPG)
