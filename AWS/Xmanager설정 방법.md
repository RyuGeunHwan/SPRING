# 가장 먼저 위치설정 확인

![00](/AWS/img/00.JPG)

# Xmanager

내가 방금 만든 클라우드 컴퓨터와 연결할 수 있는 프로그램(원격프로그램) 설치 중  
명령어로 프로그램 설치  
ubuntu : apt명령어를 이용 프로그램을 다운받음

## 1. Xme4.exe -> userName, companyName : 원하는대로

keygen.exe -> 생성한 productKey 입력

![001](/AWS/img/Xmanager/001.JPG)

## 2. Xshell 4 실행

![002](/AWS/img/Xmanager/002.JPG)

## 3. 새로만들기

![003](/AWS/img/Xmanager/003.JPG)

## 4. 호스트(H): EC2 퍼블릭 IPv4 주소 붙여넣기

![004](/AWS/img/Xmanager/004.JPG)

## 5. 터미널 -> 인코딩(E) : 유니코드로 변경

![005](/AWS/img/Xmanager/005.JPG)

## 6. 사용자 이름 : ubuntu

사용자 키 -> 찾아보기

![006](/AWS/img/Xmanager/006.JPG)

## 7. 가져오기 -> 바탕화면에 있는 .pem key가져오기 -> 확인

![007](/AWS/img/Xmanager/007.JPG)

---

## java JDK install 명령어

1. sudo apt update
2. sudo apt install openjdk-11-jdk
3. Y
4. javac -version

## Ubuntu ROOT 계정 생성 명령어

1. sudo passwd root (ROOT 초기 비밀번호 설정)

![008](/AWS/img/Xmanager/008.JPG)

2. su - (ROOT 로그인)
3. cd /home (바탕화면 home폴더 접속)

## 톰캣 설치

1. wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz

2. tar xf apache-tomcat-9.0.64.tar.gz  
   tar xf(압축푸는 명령어)

3. 같은 경로의 폴더이름을 변경시킬 수 있음  
   mv 기존폴더이름 변경할이름

4. sh startup.sh > 8080port가 열림 (tomcat > bin접속)

![009](/AWS/img/Xmanager/009.JPG)

5. netstat -tnlp (현재 실행중인 파일들)

![010](/AWS/img/Xmanager/010.JPG)
window : .exe  
ubuntu : .sh

6. EC2 인바운드 규칙 편집 -> 사용자 지정 TCP추가  
   아웃바운드 규칙도 동일하게 편집

![011](/AWS/img/Xmanager/011.JPG)

7. EC2 퍼블릭 IPv4 주소+포트번호 8080 -> tomcat설치 확인

![012](/AWS/img/Xmanager/012.JPG)

---
