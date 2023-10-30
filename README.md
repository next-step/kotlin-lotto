# kotlin-lotto

## step1 문자열 덧셈 계산기

## step1 요구사항 정리

### 기능요구사항


- tokenizer
   콜론(:)은 구분자로 동작 해야 한다
  - 쉼표(,)는 구분자로 동작 해야 한다
  - 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있어야 한다
  - 커스텀 구분자는 문자열 앞 부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다
  - “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다
  - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 IllegalArgumentException throw
  - 구분자를 컴마(,) 이외에 콜론(:)을 동시에 사용할 수 있다. (예 : “1,2:3” => 6)
  - "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)

- Validator
  - 빈 문자열 을 입력하는 경우 0 을 반환해야한다
  - null을 입력할 경우 0을 반환해야 한다
  - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 해야 한다
  - 숫자 두개를 입력할 경우 두 숫자의 합을 반환 해야 한다
- Token
  - 음수를 전달할 경우 IllegalArgumentException throw

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 1까지만 허용한다
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다
