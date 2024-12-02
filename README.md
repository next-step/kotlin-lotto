# kotlin-lotto

---
### Step1. 문자열 덧셈 계산기

##### 기능 요구 사항
1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 
   구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
   예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 
   커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

##### 요구 사항 정리
 - [x] 빈 문자열 또는 null 을 입력하면 0을 반환한다
 - [x] 숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다
 - [x] 숫자 사이에 입력된 문자열은 구분자
 - [x] 구분자는 , 또는 : 을 사용 할 수 있다
 - [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
 - [x] 음수를 입력하면 RuntimeException 발생한다
 - [x] 입력된 문자열의 덧셈 결과를 얻을 수 있다

---

### Step2. 로또(자동)

##### `기능 요구사항`
1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.

##### `실행결과`
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

##### `요구사항 정리`

- controller
  - [ ] 구입 금액을 입력 받으면 로또 티켓을 자동 발급 한다
  - [ ] 입력한 당첨 티켓과 비교하여 일치하는 숫자의 개수와 기대 수익률을 표시한다  
- domain
  - [ ] 로또 번호(Lotto Number) : 1부터 45까지, 양수
  - [ ] 로또 티켓(Lotto Ticket) : 1장당 1000원, 중복 없는 6개의 로또 번호
  - [ ] 로또 번호 발급기(Lotto Generator) : 1장당 중복 없는 6개의 로또 번호를 구입금액에 맞게 복수 발급
  - [ ] 로또 티켓들(Lotto Tickets) : 구입 금액/1,000원 만큼 로또들 티켓 발급 
  - [ ] 당첨 티켓(Winning Ticket) : 사용자가 입력한 중복 없는 6개의 번호
  - [ ] 당첨 랭크(Winning Rank) : 3개~6개 각각 일치하는 개수마다 당첨 금액이 다르다
- view
  - [ ] 구입 금액 입력(숫자)
  - [ ] 당첨 티켓 6개의 번호 입력(콤마 구분자)
  - [ ] 구매된 티켓 수량 출력 
  - [ ] 발급된 로또 티켓들 번호 출력
  - [ ] 당첨 랭크별 일치 개수 표시(3개~6개)
  - [ ] 당첨 통계 수익률 표시

