### Xshell 명령어

```
1. ubuntu는 apt라는 명령어를 이용해서 프로그램을 다운로드 받는다.
    1-1) 업데이트 명령어 : sudo apt update
    1-2) 자바 설치 명령어 : sudo apt install openjdk-11-jdk
            ( 자바 버전 확인 명령어 : javac -version )
```

## Ubuntu ROOT 계정 만들기 명령어

```
1. sudo passwd root (ROOT 비밀번호 초기 설정)
    sudo passwd root 이 창이 뜨면 비밀번호 입력하면 됨.(타자가 쳐지지는 않음.)
2. su - (ROOT 로그인)
```

## 리눅스 명령어

```
1. tomcat 설치명령어 :
        wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz
2. apache-tomcat-9.0.64 파일 압축풀기 명령어 :
        tar xf apache-tomcat-9.0.64.tar.gz
3. apache-tomcat-9.0.64파일 => tomcat으로 파일명 변경 명령어 :
        mv apache-tomcat-9.0.64 tomcat
4. tomcat실행 명령어 :
        sh startup.sh (톰캣 실행 bin폴더 들어가야 함)
5. port 확인 명령어 :
        netstat -tnlp
```

### 번외

```
1. 압축푸는 명령어 : tar xf (압축 파일명)
2. 파일명 변경 : mv (파일명) (변경할파일명)
3. 파일 접근 명령어 :
    3-1) 파일 접근하기 : cd => cd 파일명
    3-2) 뒤로가기 : cd => cd ..
```
