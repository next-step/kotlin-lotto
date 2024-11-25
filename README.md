# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구 사항

- [x] 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - [x] 구분자는 쉼표(,) 또는 콜론(:)을 사용할 수 있다.
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.

## 2단계 - 로또(자동)

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급 받을 수 있다.
  - [x] 금액을 입력 받는다.
  - [x] 금액을 1000원으로 나눈 개수만큼 줄이 발급된다.
  - [x] 무작위로 생성한 로또를 발급한다.
  - [x] 자동 발급받은 로또는 1부터 45까지 숫자로 이루어져있다.
  - [x] 숫자들은 중복없이 정렬되어 있다.
  - [x] 구매한 로또를 화면에 출력한다.
- 당첨 통계를 구하고 화면에 출력한다.
  - [x] 지난 주 당첨 번호를 사용자에게서 입력 받는다.
  - [x] 당첨 통계를 구한다.
  - [x] 당첨 통계를 화면에 출력한다. 
  - [x] 수익률을 계산해서 화면에 출력한다.

## 3단계 - 로또(2등)

### 기능 요구 사항

- [x] 2등을 위한 추가 변호를 하나 더 추첨한다.
- [ ] 당첨 통계에 2등도 추가해야 한다.

## 로또 게임 규칙

미션 단계에서 구현하고 있는 로또 게임의 규칙

### 게임 방법

1. __숫자 선택__: 1부터 45까지의 숫자 중 자동으로 6개를 선택합니다.
2. __복권 구매__: 선택한 번호로 복권을 구매합니다.
3. __추첨 확인__: 추첨일에 발표되는 당첨 번호와 보너스 번호를 확인합니다.

### 당첨 기준

- 1등 (6개 번호 일치): 고정 상금 2,000,000,000원을 수령합니다.
- 2등 (5개 번호 일치, 보너스 볼 일치): 고정 상금 30,000,000원을 수령합니다.
- 3등 (5개 번호 일치): 고정 상금 1,500,000원을 수령합니다.
- 4등 (4개 번호 일치): 고정 상금 50,000원을 수령합니다.
- 5등 (3개 번호 일치): 고정 상금 5,000원을 수령합니다.
