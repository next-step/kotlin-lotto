# kotlin-lotto

## step-1

### 요구 사항
- 문자열 덧셈 계산기 구현
  1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
  2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
  3. 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
  4. 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
  5. //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.
  6. 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.

### 프로그래밍 요구 사항
1. indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다
2. 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.

### Feedback
1. DelimiterExtractor - extractDelimiterAndText Data class 사용
2. extractDelimiterAndText - 상수 선언
3. StringSplitter - 네이밍 수정
4. 커스텀 구분자에 대한 테스트 케이스 추가


## step-2

### 요구사항