# 2주차 : kotlin-lotto
## Step3 : 로또(2등)
### 요구사항
- 2등을 위해 추가번호를 하나 더 추첨한다.
- 당첨통계에 2등을 추가한다.
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급컬렉션을 쓴다

### 할일
- [x] 보너스 번호를 입력받는다.
- [x] 입력된 보너스번호를 추가해 당첨결과를 조회한다.
- [x] 2등의 당첨금액을 추가해 통계에 포함하여 출력한다.
- [x] 2등 당첨이 포함된 테스트코드를 추가한다.

## Step2 : 로또(자동)
### 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 할일
- 로또숫자
  - [x] 1~45 사이의 숫자를 가진다
- 로또티켓
  - [x] 번호는 중복되지 않는다.
  - [x] 랜덤한 6개의 숫자를 가진다.
- 로또머신
  - [x] 입력된 금액만큼 로또를 발행한다.
    - [x] 입력된 금액이 1000원 미만이면 에러
- 당첨조회
  - [x] 지난주 당첨 번호와 출력된 로또의 번호가 3개 이상 일치하면 당첨으로 계산한다.
  - [x] 당첨 순위별 금액 및 구매개수를 이용해 통계와 수익률을 계산한다.
- 입력
  - [x] 구매금액을 입력한다.
    - [x] 입력된 값이 숫자가 아니면 에러
  - [x] 지난주 당첨번호를 입력한다.
    - [x] 입력된 번호는 총 6개의 숫자이며 콤마로 구분된다.
    - [x] 입력된 번호가 숫자가 아니거나, 6개가 아닐경우 에러
- [x] 출력
  - 구매 금액만큼 발행된 티켓을 출력한다.
  - 당첨 여부를 판단해 당첨 금액과 수익률을 출력한다.
- [x] 로또 앱 구현
- 코드리뷰 반영
  - 테스트 코드 정리
    - [x] 좋은 단위테스트는 결과가 올바른지 알 수 있어야 하고 경계조건이 설정되어 있어야 한다 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882665191))
    - [x] 테스트명을 명확하게 작성하기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882693619))
    - [ ] 꽝인 경우 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882750160))
    - [ ] 자주 사용하는 변수를 test fixture 로 생성하기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882701463))
  - 객체의 역할에 맞게 기능 구현 
    - [x] 정렬 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882666093))
    - [ ] 맞는 개수 비교 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882746666))
    - [x] 수익률 표시 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882754116))
    - [ ] LottoResult 객체 생성해서 테스트해보기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882799343))
    - [x] Money 객체 분리하기
  - [ ] [Operator overloading](https://kotlinlang.org/docs/operator-overloading.html) 적용해보기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882728105))
  - [ ] List Builder 사용해보기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882735688))
  - [ ] Map과 관련된 코드 개선 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882799343))
  - [x] 상수는 선언해서 사용하기 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882736373))
  - [ ] BigDecimal 적용 (Double은 소수점 정밀도에 있어 한계가 있어 값이 유실될 수 있다.) ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882767934))
  - [x] 익셉션 정리 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882770530))
  - [x] 패키지 분리 ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882810460))
  - [ ] 수익률 계산시 잔돈도 계산하기
  - [ ] 출력 시 요구사항에 맞게 출력하기(toString으로 동일하게 표현되고 있지만, 의도해서 표현하는 방식으로 개선해보자) ([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882791720))
  - [x] 당첨이 되지 않은 등수도 표시되어야 한다.([review](https://github.com/next-step/kotlin-lotto/pull/324#discussion_r882797294))


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
  - [x] 검증/연산을 수행하는 객체를 분리하기 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878018838))
  - [x] 명시적으로 람다변수를 사용하도록 수정 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878019003))
    - [destructured](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/-destructured/)
    - destructuring declaration : 여러 식별자를 동시에 선언하고 초기화, 사용
  - [x] inline함수의 리턴을 명확하게 수정 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878021037))
  - [x] require 함수 활용 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878022149))
  - [x] 정규식은 생성비용이 높아 미리 생성하는게 좋다👍 ([review](https://github.com/next-step/kotlin-lotto/pull/269#discussion_r878023153))
