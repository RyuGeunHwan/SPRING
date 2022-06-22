# <a href="https://devops.datenkollektiv.de/banner.txt/index.html">log banner</a>

```java
1. spring boot들어가서 resources패키지에 banner.txt파일 만들어서 사이트에 나오는 로그 실행 배너 그대로 복사 붙여넣기 하면됨.

    ex) banner.txt파일에 붙여넣기
    /|/ . /|/ _  /|/ _
    / | / / | /_|/ | /_/

    Title : ${application.title}    // yaml파일의 title => 류근환 짱!!!
    version : ${application.version}    // yaml파일의 version => v0.0.1
    Spring Boot version : ${spring-boot.version}    // 내가 현재 사용하고 있는 spring boot OR 이클립스 버전


2. yaml파일 들어가서 작성해주면 됨.
# 제목과 버전 설정
application:
   version: v0.0.1
   title: 류근환 짱!!!

```
