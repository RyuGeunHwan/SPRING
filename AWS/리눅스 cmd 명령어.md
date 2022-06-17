### Xshell 명령어

```
1. ubuntu는 apt라는 명령어를 이용해서 프로그램을 다운로드 받는다.
    1-1) 업데이트 명령어 : sudo apt update
    1-2) 자바 설치 명령어 : sudo apt install openjdk-11-jdk
            ( 자바 버전 확인 명령어 : javac -version )
```

## 사용자 ROOT 계정 만들기 명령어

```
1. sudo passwd root (ROOT 비밀번호 초기 설정)
    sudo passwd root 이 창이 뜨면 비밀번호 입력하면 됨.(타자가 쳐지지는 않음.)
2. su - (ROOT 로그인 명령어) -> 설정한 비밀번호 입력
```

## 리눅스 명령어

```
1. tomcat 설치명령어 :
        wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz

2. apache-tomcat-9.0.64 파일 압축풀기 명령어 :
        tar xf apache-tomcat-9.0.64.tar.gz

3. 파일명 변경 혹은 파일 폴더 이동 :
        mv

        현재 디렉토리(폴더)에 있는 test.txt 파일을 디렉토리 내부의 new_folder 디렉토리로 이동
        ex) mv test.txt new_folder

        현재 디렉토리(폴더)에 있는 test.txt 파일을 new_test.txt라는 파일로 이름 바꾸기
        ex) mv test.txt new_test.txt

        /user/jtaewu 경로의 test.txt 파일을 /user/jtaewu 디렉토리(폴더)로 이동
        ex) mv test.txt /user/jtaewu/new_folder

        /user/jtaewu 경로 test.txt 파일을 /user/guest 디렉토리(폴더)에 new.txt로 바꾸어 이동
        ex) mv /user/jtaewu/test.txt /user/guest/new.txt

4. tomcat실행 명령어 :
        sh startup.sh (톰캣 실행 bin폴더 들어가야 함)

5. tomcat 켜져있는지 확인하는 명령어 :
        netstat -tnlp

6. 현재 경로 확인 명령어 :
        pwd

7. 현재 위치한 폴더에 모든 파일 확인 명령어 :
        ls

8. 강제 삭제 명령어 :
        rm -rf

9. logs폴더 들어가서 log확인 하는 명령어 :
        tail -f catalina.out
        (최종 경로 => /home/tomcat/logs# tail -f catalina.out)
        (log확인 하는 파일 나가기 명령어 : ctrl + c)

```

### 번외

```
1. 압축푸는 명령어 : tar xf (압축 파일명)
2. 파일명 변경 명령어 : mv (파일명) (변경할파일명)
3. 파일 접근 명령어 : cd
    3-1) 폴더 접근하기 : cd => cd /폴더명
    3-2) 파일 접근 : cd => cd 파일명
    3-3) 뒤로가기 : cd => cd ..
```
