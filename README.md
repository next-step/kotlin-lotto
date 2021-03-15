# kotlin-lotto


- [X] 로또 번호  
  - [X] validation: 1~45 사이의 값인가 ?  

- [X] 로또
  - [X] 로또 가격은 1000원이다
  - [X] validation: 번호 개수는 6개 인가 ?  
  - [X] validation: 중복된 로또번호는 없는가 ?  

- [X] 로또 생성기
  - 랜덤한 로또번호를 생성한다

- [X] 로또머신
  - [X] validation: 로또 금액은 0보다 큰가?
  - [X] 로또를 판매한다 (1장 당 천원)
    - [X] validation: 금액은 0보다 큰 금액인가?
    - [X] validation: 로또를 딱 맞게 구매할 수 있는 가격인가 ?  
  - [X] 당첨 결과 알려준다 
    - 입력: 로또, 지난주 당첨 번호
    - 출력: 당첨 결과

- [X] 로또 구매하기  
  - [X] 구입 금액 입력받기  
  - [X] 로또 구매하기
  - [X] 로또 번호 출력

- [X] 지난주 당첨 번호
  - [X] 지난주 당첨 번호 입력받기 (구분자는 콤마(,) 이며 입력 시 공백에 프로그램 영향 없음)  
    - [X] validation: 번호 개수는 6개 인가 ?  
    - [X] validation: 1~45 사이의 값인가 ?
    - [X] validation: 중복된 로또번호는 없는가 ?  
  - [ ] 보너스볼 입력받기
    - [ ] validation: 1~45 사이의 값인가 ?

- [X] 당첨 여부 확인하기  
  - [X] 당첨 번호와 숫자가 동일한 개수에 따른 금액 지급
    - [X] 1등: 6개 일치하는 경우 (20억원)
    - [X] 2등: 5개 일치, 보너스볼 일치하는 경우 (3천만원)
    - [X] 3등: 5개 일치, 보너스볼 미일치하는 경우 (150만원)
    - [X] 4등: 4개 일치하는 경우 (5만원)
    - [X] 5등: 3개 일치하는 경우 (5천원)

- [X] 사용자에게 결과 출력
  - [X] 일치한 갯수 통계정보 만들기  
  - [X] 수익률 계산하기 (구입한 금액이 기준)  
