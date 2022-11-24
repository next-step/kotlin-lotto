# kotlin-lotto

## 🚀 1단계 - 문자열 덧셈 계산기

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과
  같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 기능 목록

- [X] 문자열 숫자
    - [X] 빈 문자열 또는 null을 입력할 경우 0을 반환한다.
    - [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
    - [X] 쉼표(,) 또는 콜론(:)을 구분자로 문자열을 분리한다.
    - [X] `//`와 `\n` 사이에 위치하는 문자를 커스텀 구분자로 문자열을 분리한다.
    - [X] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- [X] 문자열 덧셈 계산기
    - [X] 쉼표(,) 또는 콜론(:) 구분자를 가지는 문자열의 숫자를 합하여 반환한다.
    - [X] `//`와 `\n` 사이에 위치하는 문자를 커스텀 구분자를 가지는 문자열의 숫자를 합하여 반환한다.

## 🚀 2단계 - 로또(자동)

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 목록

- [X] 입력
    - [X] 구입 금액
    - [X] 지난 주 당첨 번호
        - [X] 입력 받은 값에서 정상적인 숫자 6개를 추출한다.
- [X] 출력
    - [X] 구입 금액에 따른 로또 리스트 값을 화면에 출력한다.
    - [X] 당첨 통계를 화면에 출력한다.
- [X] 로또
    - [X] 1~45 범위의 중복되지 않는 랜덤 숫자 6개를 생성한다.
- [X] 로또 생성자
    - [X] 구입 금액만큼 로또 번호 생성
- [X] 당첨 로또
    - [X] 당첨 로또와 비교하여 일치하는 번호의 갯수를 가져온다.
- [X] 로또 통계
    - [X] 각 등수에 당첨된 로또 수
    - [X] 총 수익률

## 🚀 3단계 - 로또(2등)

### 기능 요구사항

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.

### 기능 목록

- [X] 입력
    - [X] 2등 보너스 번호를 입력 받는다.
- [X] 출력
    - [X] 당첨 통계에 2등 추가
- [X] 로또 번호
    - [X] 로또에서 로또 번호 객체로 리팩토링
    - [X] 1~45 범위의 숫자를 가진다.
- [X] 로또
    - [X] 중복되지 않는 로또 번호 6개를 생성한다.
- [X] 당첨 로또
    - [X] 보너스 볼 번호가 당첨 번호와 같으면 예외가 발생한다.
- [X] 로또 통계
    - [X] 보너스 볼에 의한 2등 추가
