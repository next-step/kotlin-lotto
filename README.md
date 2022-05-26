# 2주차 : kotlin-lotto
## Step1 : 문자열 덧셈
### 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 커스텀 구분자를 지정할 수 있으며 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - (예: “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.)
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - (예: while문 안에 if문이 있으면 들여쓰기는 2이다.)
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - (함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.)

### 할일
- [x] 기본 구분자(,:)로 구분된 각 숫자의 합을 리턴한다.
- [x] 커스텀 구분자로 구분된 각 숫자의 합을 리턴한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] //와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.
- [x] 빈 문자열 또는 null값을 입력할 경우 0을 반환한다.
- [x] 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외가 발생한다.
- [x] 문자열 계산기에 정수가 아닌 값을 전달하는 경우 RuntimeException 예외가 발생한다.
- 코드리뷰 반영
  - [ ] 검증/연산을 수행하는 객체를 분리하기 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878018838))
  - [ ] 명시적으로 람다변수를 사용하도록 수정 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878019003))
  - [ ] inline함수의 리턴을 명확하게 수정 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878021037))
  - [ ] require 함수 활용 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878022149))
  - [ ] 정규식은 생성비용이 높아 미리 생성하는게 좋다👍 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878023153))
