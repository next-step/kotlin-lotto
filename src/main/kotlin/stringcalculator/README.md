# 1단계 - 문자열 덧셈 계산기

## 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
    - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
      예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 포로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.

## 명시된 테스트 케이스

- [x] "" 을 입력한 경우 0 이 반환된다
- [x] null 을 입력한 경우 0 이 반환된다
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
- [x] 구분자 문자로 콜론(:)을 사용할 수 있다.
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.

# domain 패키지 설명

## 계산 영역

### Calculator

- 숫자를 받고 총합 값을 내보낸다

## 문자에서 숫자, 커스텀 구분자를 추출하는 영역

### ParserSeparator

- 연산식에서 숫자를 추출할때 사용하는 구분자
- validation
    - 빈문자열이 들어오면 IllegalArgumentException 발생
    - 숫자가 들어가 있는 경우 IllegalArgumentException 발생
    - 중간에 숫자가 포함되어 있는 경우 IllegalArgumentException 발생

### ParserSeparators

- `ParserSeparator` 리스트로 관리한다
- 구분자 추가

### CustomNumbersStringParser

- `ParserSeparators`(구분자들) 받아서 문자열에서 숫자들을 추출한다. ex) "1,2:3"을 넣으면 1, 2, 3 을 추출한다
- validation
    - `ParserSeparators`(구분자들) 이 없는 경우 IllegalArgumentException 가 발생한다
    - 숫자, `ParserSeparators`(구분자들) 이외에 문자가 들어가 있는 경우 IllegalArgumentException 가 발생한다.
    - 추출한 숫자가 음수 인 경우 IllegalArgumentException 발생

### CustomSeparatorParser

- 커스텀 구분자를 선언하는 문자열에서 커스텀 구분자를 가져온다 ex) "//;\n" 을 넣으면 ";" 을 추출한다
- validation
    - 구분자가 -인 경우 IllegalArgumentException 이 발생한다
    - 커스텀 구분자 포맷만 있고 구분자 문자열은 없는 경우 IllegalArgumentException 발생 ex) "//\n"
    - 커스텀 구분자 시작 부분이 없는 경우 IllegalArgumentException 발생 ex) ";\n"
    - 커스텀 구분자 끝이 없는 경우 에러가 IllegalArgumentException 발생 "//;"

### CustomExpressionParser

- `CustomNumbersStringParser`, `CustomSeparatorParser` 협력으로 연산식에서 구분자, 숫자을 분리하고 보관한다
  ex1)  "1,2:3"을 넣으면 1, 2, 3 을 추출한다
  ex2)  "//;\n1;2;3"을 넣으면 1, 2, 3 을 추출한다

# service 패키지 설명

### CustomExpressionCalculator

- 외부에서 InputDto 로 값을 받고 연산식에서 `CustomExpressionParser`으로 숫자를 추출하고 `Calculator`로 종합 값 구해 OutputDto 로 내보내준다.

# view 패키지 설명

### CustomExpressionCalculatorView

- 입력과 출력을 위한 UI 용 String 을 만들어준다

## 작업 리스트

- [x] domain 구현
- [x] service 구현
- [x] view 구현
- [x] main 함수 구현