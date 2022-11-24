# kotlin-lotto

## 기능 목록

- [x] StringAddCalculator 객체 생성
    - [x] 객체에 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다.
    - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
    - [x] 숫자의 합 반환
        - [x] 문자열에서 ,를 기준으로 숫자들의 덧셈을 반환한다.
        - [x] 문자열에서 :를 기준으로 숫자들의 덧셈을 반환한다.
        - [x] 문자열에서 ,와:를 기준으로 숫자들의 덧셈을 반환한다.
- [x] 커스텀 구분자
    - [x] "//"와 "\n" 문자 사이에 있는 문자를 커스텀 구분자로 지정한다.
- [x] 음수 처리
    - [x] 음수 값 전달 시 , throw RuntimeException 

## 기능 요구 사항

-쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

-앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

-문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.