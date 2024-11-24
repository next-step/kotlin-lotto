# kotlin-lotto

### 1단계 기능목록

[ v ] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.

[ v ] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.

[ v ] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.

[ v ] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.

[ v ] //와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.

[ v ] 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.

### 구성
[ StringAddCalculator ]
- InputParser : 입력 받은 문자열에서 연산을 위한 커스텀 구분자 및 연산에 사용될 숫자 목록을 추출한다.
  - InputValidator : 입력 받은 문자열의 검증을 담당
- Operator : 추후 덧셈, 뺄셈, 곱샘, 나눈셈 등 연산 식을 정의하기 위한 인터페이스 추출
  - fun apply (a: Int, b: Int): Int
- AddOperator : 전달받은 두값을 가지고 덧셈 연산 방식을 정의
  - num1, num2 => + 연산
- ExpressionEvaluator : 연산 대상 (숫자)목록을 속성으로 가지고 있고, operator 를 호출하여 **연산된 결과를 반환** 담당
  - 연산은 생성자로 전달받을 Operator 로 진행 
