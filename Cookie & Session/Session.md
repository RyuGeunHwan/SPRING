# Session

```
1. 서버가 다운되거나 혹은 만료시간이 지나기 전까지 데이터를 보관하는 기술
    1-1) 데이터베이스 X
    1-2) 서버(웹서버)에 임시적 보관 / 반대로 서버거 죽거나 꺼지면 저장 되어있던 Session은 날라감.
2. 대표적인 Session
    2-1) 회원 정보(PK, 이름)
3. Session은 Interceptor에서 데이터가 넘어오기 전에 확인을 거친다.
    ex) 데이터를 넘기기 전에 Interceptor에서 로그인 여부를 확인 후 데이터를 넘겨준다.
```