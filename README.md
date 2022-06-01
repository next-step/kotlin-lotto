# Nextstep 4기

## 1. 문자열 덧셈 계산기

### 기능 요구 사항

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과
  같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.

### 체크 리스트

* [x] 문자열을 입력 받아 `덧셈` 기능을 수행하는 계산기 구현
    * [x] 아래와 같은 문자열을 입력 받을 때, 0을 반환
        * [x] null
        * [x] 빈 문자열
    * [x] 숫자들을 구분자로 입력할 경우 입력 받은 숫자의 합을 반환
        * [x] 컴마(,) 구분자
        * [x] 콜론(:) 구분자
    * [x] `//`와 `\n` 문자 사이에 커스텀 구분자를 지정하여 합을 반환
    * [x] 음수가 전달되는 경우 RuntimeException 예외 발생

## 2. 로또 (자동)

### 기능 요구 사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 체크 리스트
* [x] 6개의 숫자를 포함하는 로또 티켓 구현
* [x] 로또 티켓 발급기 구현
* [x] 로또 판매점 구현
* [x] 로또 수익률 연산 구현
* [x] 로또 UI 구현
* [x] 로또 메인 구현

## 3. 로또 (2등)

### 기능 요구 사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 힌트
* 일급 컬렉션을 쓴다. 6개의 숫자 값을 가지는 컬렉션을 감싸는 객체를 추가해 구현해 본다.
* 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. Enum 클래스를 활용해 상수 값을 제거한다.
    * 즉, Enum 클래스를 활용해 일치하는 수를 로또 등수로 변경해 본다.

### 체크 리스트
* [x] 로또 보너스 당첨 번호 구현
* [x] 로또 보너스 당첨 번호 UI 구현