# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과
  같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 작업 사항

- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
- [x] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
- [x] //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.
- [x] 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.

## 로또(자동)

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 실행 결과

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

### 도메인 클래스

- Money: 금액을 이미하는 값 객체
- Lotto: 로또를 의미하는 값 객체
- LottoIssuable: 로또 생성기 (interface)
    - test 에서 해당 인터페이스 구현한 stub 사용
    - main 에서 랜덤한 로또를 생성하는 `RandomLottoIssuer` 사용
- LottoStore: 로또 생성기와 금액을 받아 Lotto 목록을 반환
- LottoPolicy: 당첨 조건을 의미, 맞아야 하는 숫자 개수와 당첨 금액을 가짐
- LottoWinningNumber: 당첨 번호를 의미하는 값 객체
- LottoMatcher: 당첨 번호와 로또 리스트를 받아서 당첨 조건에 따른 결과를 반환
- LottoMatchResult: 당첨 결과, `LottoPolicy` 와 당첨 개수를 쌍으로 가지는 값 객체

### 작업 사항

- Money
    - [x] 금액을 받아 Money 인스턴스를 생성한다
    - [x] 금액에 음수를 제공하면 에러가 발생한다
- Lotto
    - [ ] 숫자 리스트를 받아 Lotto 인스턴스를 생성한다