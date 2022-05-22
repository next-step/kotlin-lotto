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
- Issuable: 로또 생성기 (interface)
    - test 에서 해당 인터페이스 구현한 stub 사용
    - main 에서 랜덤한 로또를 생성하는 `Issuer` 사용
- Store: 로또 생성기와 금액을 받아 Lotto 목록을 반환
- WinPolicy: 당첨 조건을 의미, 맞아야 하는 숫자 개수와 당첨 금액을 가짐
- WinNumbers: 당첨 번호 목록을 의미하는 값 객체
- Matcher: 당첨 번호와 로또 리스트를 받아서 당첨 조건에 따른 결과를 반환
- MatchResult: 당첨 결과, 숫자 일치 개수, 금액, 당첨 회수를 가지는 객체

### 작업 사항

- Money
    - [x] 금액을 받아 Money 인스턴스를 생성한다
    - [x] 금액에 음수를 제공하면 에러가 발생한다
- Lotto
    - [x] 숫자 리스트를 받아 Lotto 인스턴스를 생성한다
    - [x] 입력받은 리스트의 크기가 6이 아니면 에러가 발생한다
    - [x] 입력받은 숫자에 동일한 값이 존재하면 에러가 발생한다
- Issuer
    - [x] 로또를 생성할 수 있다
    - [x] 생성한 로또는 1에서 45 사이의 숫자를 가진다
    - [x] 생성한 로또 숫자는 오름차순으로 정렬된다
- Store
    - [x] 0원으로 구매를 시도하면 로또를 얻지 못한다
    - [x] 금액에 따라 올바른 로또 목록을 받는다
    - [x] 제공한 발급자를 통해서 로또를 생성한다
- WinPolicy
    - [x] 숫자 일치 개수와 당첨 금액을 받아서 정책을 생성한다
    - [x] 숫자 일치 개수에 음수를 제공하면 에러가 발생한다
    - [x] 숫자 일치 개수에 0을 제공하면 에러가 발생한다
    - [x] 숫자 일치 개수가 로또의 숫자 개수보다 크면 에러가 발생한다
    - [x] 주어진 로또가 조건에 일치하는지 확인한다
- WinNumbers
    - [x] 숫자 목록을 받아 인스턴스를 생성한다
    - [x] 주어진 로또와 일치하는 숫자의 개수를 반환한다
- Matcher
    - [x] 당첨 조건 목록과 당첨 번호를 통해 인스턴스틑 생성한다
    - [ ] 주어진 로또 목록을 통해 당첨 결과를 반환한다
