# <a href="https://velog.io/@light/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8SpringBoot-3.-%EA%B9%83%ED%97%88%EB%B8%8CGitHub-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0">ID에서 깃허브 레파지토리 연동하기(참고사이트1)</a>

# <a href="https://jojelly.tistory.com/61">ID에서 깃허브 레파지토리 연동하기(참고사이트2)</a>

```
해당파일 git bash열어서
git init 후
github 에 레파지토리 생성

1. git add .
   (add에서 오류 뜨면 : git config --global core.autocrlf true 명령어 실행)
2. git commit -m "first commit"
3. git branch -M main
4. git remote add origin https://github.com/RyuGeunHwan/asd.git
5. git push -u origin main

명령어 순서대로 git bash에 실행!
하게되면 해당파일과 github 레파지토리와 연동됨.
```

=====================================================

```
이클립스 들어가서 import후 Restart!
오른쪽 상단 GIT들어가서 git추가 해주면 끄읏!!!
commit,push,pull... 은 GIT들어가서 하면 된다!!!
```
