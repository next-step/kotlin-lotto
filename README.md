# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기

**요구 사항 정리**

- [x] 입력받은 숫자의 합을 반환 - Calculator
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다. - Splitter
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. - Splitter
    - [x] 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. - Splitter
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다. - CalculatorNumber
- 구성한 class 조합


