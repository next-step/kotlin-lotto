# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기
### 요구사항 정리
- [x] 입력 방식: 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 전달
  - 샘플: ```"" => 0``` ```"1,2" => 3``` ```"1,2,3" => 6``` ```"1,2:3" => 6```
- [x] 커스텀 구분자를 지정: 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
  - 샘플: ```"//;\n1;2;3" => 6```
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 2단계 - 로또(자동)
### 요구사항 정리
- 로또 구입 금액을 입력 하면
- 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 당첨 번호 6개를 입력하면
- 당첨 통계 출력 & 수익률 출력

### 기능 단위 정리
#### 로또 번호
- [x] 1 ~ 45 사이의 숫자로 객체 생성
- [x] 1 ~ 45 이외의 범위는 예외 발생
#### 로또 티켓
- [x] 6개의 번호로 티켓 발행 
- [x] 유효성 체크하여 예외 발생
#### 판매 및 당첨
- [x] 구입 금액 만큼 티켓 발행
- [x] n개의 임의 번호 생성
- [x] 당첨 번호와 비교하여 당첨여부 판단 
#### 상금
- [x] 맞는 개수에 따른 상금 계산
#### 입력 & 출력
- [x] 구입 금액 입력
- [x] 당첨 번호 입력
- [x] 당첨 통계 출력
- [x] 수익률 출력

## 3단계 - 로또(2등)
### 요구사항 변경
- [x] 당첨 번호 외 1개의 번호를 추가로 입력 받음
- [x] 당첨 통계에 2등도 추가

## 4단계 - 로또(수동)
### 요구사항 변경
- [ ] 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- [ ] 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

```text
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
...
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```