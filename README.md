# kotlin-lotto

## Step1 - 문자열 덧셈 계산기

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
  - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달할 수 없다.
  - 만약 전달되었을 경우 RuntimeException 예외를 throw 한다.

### 요구 사항 쪼개기

- 문자열 파서는 문자열을 입력받으면 구분자를 기준으로 구분할 수 있다.
- 문자열 파서는 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
  - 커스텀 구분자와 기본 구분자를 함께 사용할 수도 있다. ex) "//;\n1;2,3" => 6
- 문자열 파서는 숫자 이외의 값 또는 음수를 전달하면 예외를 발생한다.

- 문자열 덧셈 계산기는 빈 문자열 또는 null을 입력받으면 0을 반환한다.
- 문자열 덧셈 계산기는 문자열을 구분한 결과값을 기준으로 더한 값을 반환한다.

