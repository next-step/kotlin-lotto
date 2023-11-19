## 로또(자동)

## 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 프로그래밍 요구 사항

- **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.** 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 기능 명세

- [x] 티켓은 생성 될 때 6개의 랜덤 수로 생성된다
- [x] 티켓에 당첨 번호를 넣으면 몇개나 맞는지 결과가 도출된다
- [x] 로또 생성기에 로또 개수를 넣으면 해당 갯수만큼 로또 번호를 생성한다
- [x] 로또 검증기에 당첨 번호와 티켓들을 넣으면 티켓들이 몇개나 맞았는지 결과가 도출 된다
- [x] 수익률 검증기에 구매한 개당 로또 가격, 티켓들이 몇개나 맞았는지 결과와 일치당 수령 당첨금 데이터를 넣으면 수익률이 계산된다

## 적용 해볼 것

- [ ] 확장 함수 써보기

## 리뷰 받은 것

### 1차

- [x] TICKET_LENGTH, TICKET_RANGE 는 LottoGenerator의 책임은 아닐까요?
- [x] 0, 0, 0, 5000, 50000, 1500000, 2000000000가 무슨 리스트인지 알수 있을까요? enum을 활용해보는건 어떨까요?
- [x] 리턴타입은 모두 명시해주는 것은 어떨까요?
- [x] Ticket은 무슨 책임을 가지고 있을까요? length, range는 어떤 이유로 생성시점에 받을까요? 내부에 상수로 관리해도 좋을거같아요 init절에서 null체크를 하는데, 굳이 nullable
  가능한 값을 받을필요가 있을까요?
- [x] 복잡도가 너무 높은거 같아요!
- [x] 로또 번호를 생성하는건 누구의 책임일까요? LottoGenerator는 어떤 책임이 있나요?
- [x] TICKET_PRICE 라는 상수를 이용해보아요, View 관련 객체에서는 입/출력 외의 계산은 분리해주세요!


### 2차

- [x] 리턴 값 명시하기
- [x] WinningMoney enum 을 등수로 생각해보기 - matchCount, prize 둘다 활용
- [x] IntRange는 고정되어 있지 않나, LottoNumber객체 미리 생성해두는 방식 적용, 랜덤기능 인터페이스로 분리
- [x] getMatchedList 매서드의 반환 리스트는 무엇인지 명시하기
- [x] LottoOrganizer의 책임 생각 해보기 - 주어진 돈을 가지고, 로또를 구매하는 책임은 따로 분리해보면 어떨까요?
- [x] LottoValidator의 책임 생각 해보기 - winningNumbers, lottoTickets등을 관리하는 책임어떨지
- [x] scope function 제대로 알고 쓰기

### 3차
- [x] LottoPerson 에게 단순히 티켓수를 묻기보단, 아래처럼 생성된 티켓을 반환하면 어떨까요?
- [x] LottoResults에서는 전체 lottoTickets과 winningNumbers을 몰라도 되지않을까요?
- [x] 모든 matchCount를 Map의 key값으로 들고 있을 필요가 있을까요? results: MutableMap<Prize, Int>  이런 구조는 어떨까요?
- [x] 2 뎁스 이상입니다! 함수를 분리해보면 어떨까요? !! 은 null일 경우, 비정상종료되는 구조예요! 좀더 nullsafe한방법을 활용해봐도 좋을거같아요!
- [x] getMatchCount는 winningNumbers , lottoTicket이 가져야할 책임이 아닌지 고민해봐요 디미터의 법칙을 고민해보아요! https://dkswnkk.tistory.com/687
- [ ] Given절을 좀더 활용하면 어떨까요? 
  ```kotlin
     Given(" 당첨번호가 1, 2, 3, 4, 5, 6일때") {
        When("로또가 1, 2, 3, 4, 5, 6이면") {
                Then("6개 모두 일치하여, 1등이다") {
        When("로또가 11, 2, 3, 4, 5, 6이면") {
                Then("5개 일치하여, 2등이다") {
  ```
- [ ] 다른 클래스들의 모든 테스트 케이스를 작성해보면 어떨까요?

### 4차
- [x] LottoGenerator을 LottoPerson생성시점에 주입받으면 어떨까요? 생성에 대한 책임은 LottoGenerator에게 구매에 대한 책임은 LottoPerson에게 위입해보면 어떨까요?
- [x] lottoTickets을 내부 프로퍼티로 가질 필요가 있을까요?
- [x] LottoResults의 책임은 무엇일까요? 당첨번호에 대한 책임, 로또 결과에 대한 책임 등 여러책임이 엮여있지는 않은지 고민해보아요!
  - 실제 LottoResults의 구조는 getResults의 리턴값 구조이지않을까요? class LottoResults(private val result:  Map<Prize, Int>)
- [x] isBonus에 대한 체크는 Prize내에서 처리되면 어떨까요? 숫자 5는 무엇을 의미할까요? Prize.Second의 matched가 변경된다면 문제가 생기진 않을까요?
- [x] groupBy,associateWith 등의 키워드를 활용해봐도 좋을거같네요!
- [x] bonus 볼 여부 또한 Prize에서 가지고 있어야할 정보는 아닐까요?

### 5차
- [x] 파라미터가 3개 이상이라면 책임분리의 신호일수도 있어요!
  ```kotlin
  // ASIS
  val lottoResult = LottoResultFactory.getLottoResult(lottoTickets, winningNumbers, bonusNumber)
  
  // TOBE
  val winningLotto = WinningLotto(winningNumbers, bonusNumber)
  val lottoResult = winningLotto.getLottoResult(lottoTickets)
  ```
- [x] 기본 값 활용하기
  ```kotlin
  enum class Prize(
      val matched: Int, val prize: Int, val bonus: Boolean = false // 필요한 곳에만 true
  ```
- [x] Prize에서는 List나 LottoNumber를 몰라도 되지않을까요?
  - getKeyWithMatched의 파라미터처럼 matched, bonus 만 받아와도 좋을거같아요!
- [x] Prize의 복잡한 When 문 하나씩 맵핑하는것보다, enum.values, find등의 함수를 활용해보는건 어떨까요?
- [ ] Prize 테스트 코드를 작성해보아요!
- [x] 보통 2중첩이상의 분기문부터는 가독성도 좋지않고, 실수발생률이 커진다고 합니다! 요구사항을 습관화해보아요!
- [x] 결과에 대한 테스트 코드를 구체적으로 작성해보면 어떨까요?  2등, 3등의 케이스도 검증하면좋을거같아요!
- [x] 구체적인 케이스명을 활용하면 어떨까요?> getLottoResult라는 네이밍은 너무 모호하네요!

### 6차
- [ ] 미리 로또번호들을 생성해놓고 재활용해보면 어떨까요?
- [x] LottoGenerator은 로또 생성에 대한 책임을 가지고 있어요, generateTickets해야하는 티켓 수량만 관심이 있지않을까요?
- [x] isBonus 외부에서 노출될 필요가 있을까요?
- [x] manualNumbers 또한 LottoGenerator에게 객체생성 책임을 부여해도 좋을거같아요!
- 
## 챗 지피티와의 대화

### DDD에서 도메인이 풍부해질수록 단일책임원칙을 위반하는것 아닐까
    - 아닙니다. 도메인 주도 설계(DDD)에서는 단일 책임 원칙(SRP, Single Responsibility Principle)을 강조합니다. 객체가 하나의 책임만을 가져야 한다는 원칙을 준수하는 것이 좋은
      소프트웨어 설계의 핵심입니다.
    - SRP는 클래스 또는 모듈이 변경의 이유를 하나만 가져야 함을 의미합니다. 하지만 '도메인이 풍부해지다'는 것은 많은 클래스 또는 모듈이 함께 작동하여 복잡한 기능을 수행한다는 의미이며, 이는 각 클래스가
      단일 책임 원칙을 위반하는 것이 아니라, 단일 책임 원칙을 준수하며 협력하는 클래스의 집합을 의미합니다.
    - 도메인이 풍부해짐으로써 복잡해져도, 각각의 클래스는 자신이 맡은 책임을 수행하며 이는 디자인 패턴에 매우 부합하는 개념입니다. 따라서 도메인이 풍부해질수록 단일 책임 원칙을 위반하는 것이 아닌, 오히려 더
      잘 준수하게 될 가능성도 있습니다.
### data class, value class, enum class 차이
Kotlin에서는 data class, value class, enum class 등 다양한 클래스 타입을 제공합니다. 이들 각각의 역할과 기능은 다릅니다.

data class : 주로 데이터를 보유하는 클래스에 사용됩니다. equals(), hashCode(), toString() 등 일반적으로 필요한 여러 메서드를 자동으로 생성해줍니다. 데이터 클래스는 주로 데이터를
전달하는데 사용됩니다.

```kotlin
data class User(var name: String, val email: String)
```

value class : Kotlin 1.5.0에서 도입된 개념으로, 래퍼형 클래스를 런타임 오버헤드 없이 선언할 수 있습니다. 즉, 객체 생성없이 더 효율적이게 값을 래핑할 수 있게 해줍니다.

```kotlin
@JvmInline
value class Password(val value: String)
```

enum class : 열거하는 상수 집합을 위한 특수한 클래스 타입입니다. 인스턴스 수가 제한되며, 각 인스턴스는 해당 열거 타입의 객체입니다.

```kotlin
enum class Color {
    RED, GREEN, BLUE
}
```

이들 클래스의 중요한 차이점은, data class는 데이터를 보관하고 처리하는데, value class는 특정한 싱글 값을 안전하게 래핑 하는데, enum class는 제한된 값 집합을 표현하는데 사용된다는
것입니다.

### with, also, apply, run, let의 차이

Kotlin의 표준 라이브러리는 다양한 스코프 함수를 제공해 객체의 범위 내에서 작업을 수행하는 것을 돕습니다. with, also, apply, run, let은 모두 이런 종류의 함수들입니다.

다음은 이 함수들의 차이와 사용 예제입니다:

with: null이 아닌 receiver 객체를 받아 사용합니다

```kotlin
with(person) {
    name = "John"
    age = 30
}
```

also: 리시버 객체를 처리하거나 수정하고, 리시버 그대로를 반환합니다.

```kotlin
val numbers = mutableListOf("one", "two", "three")
numbers.also { it.add("four") }
```

apply: 객체의 초기화 작업이나 수정 작업 등을 수행하고, 객체 자신을 반환 합니다 .

```kotlin
val person = Person().apply {
    name = "John"
    age = 30
}
```

run: 객체의 범위 내에서 처리 작업을 수행하며 처리 결과를 반환합니다.

```kotlin
val loginResult = run {
    val username = getUsername()
    val password = getPassword()
    login(username, password)
}

```

let: Nullable한 객체를 처리할 때 좋으며, 객체를 receiver 대신 파라미터로 받습니다.

```kotlin
person?.let {
    it.age++
}
```

let은 체이닝, 검사 및 처리를 위한 블록을 제공하고, 새로운 값을 반환합니다. 단일 파라미터가 람다 결과로 전달되며, let 함수 내부에서는 해당 파라미터를 이용해서 작업을 수행합니다. 이 함수는 주로 null
체크를 할 때 사용합니다. 다른 Scope 함수와 가장 크게 다른 점은 객체를 파라미터로 받아와 처리한다는 점입니다.

모든 스코프 함수는 람다 내의 마지막 표현식을 결과로 반환합니다. apply 와 also를 '값을 설정하는 객체'로 생각하고, let, run, with은 '값을 계산하거나 동작하는 객체'로 생각하면 좀 더 이해하기
쉽습니다. 추가적으로, this가 필요하면 apply, run, with을 사용하고, it이 필요하면 also, let을 사용하시면 됩니다


```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}

fun main() {
    val person = Person()

    // also
    val result1 = person.also { it.name = "John" }
    println(result1.name)  // 결과: "John"

    // apply
    val result2 = person.apply { name = "Doe" }
    println(result2.name)  // 결과: "Doe"

    // run
    val result3 = person.run { name = "Kim"; age = 20; "Finished" }
    println(result3)  // 결과: "Finished"

    // let
    val result4 = person.let { it.name = "Lee"; it.age = 30; "Complete" }
    println(result4)  // 결과: "Complete"

    // with
    val result5 = with(person) { name = "Park"; age = 40; "Done" }
    println(result5)  // 결과: "Done"
}
```

- 정리
  - with 는 명시적으로 인자를 적용 할때 쓴다. 나머지는 암시적으로 인자가 넘어온다
  - let run with는 결과 값을 반환하고 apply, also는 인자로 받은 객체를 반환한다
  - 값계산을 원하면 let run with 사용하고 설정을 원하면 apply, also를 사용한다 
  - this가 필요하면 apply, run, with을 사용하고, it이 필요하면 also, let을 사용한다
  - 대표적인 사용규칙
    - apply는 수신된 객체를 사용하지 않고 초기화하고 그대로 반환할때 사용한다., this사용, 초기화 할때 사용
    - also는 수신된 객체를 사용하지 않고 초기화도 안하고 그대로 반환할때 사용한다. , it사용, 검증 함수나 print 함수할 때 쓰면 좋을듯
    - let은 null 체이닝 하거나 단일 지역 변수의 범위를 제한하고 값을 리턴할 때 사용한다, it사용, 체이닝 할때 사용
    - run은 범위를 제한하고 값을 리턴할때 사용한다 , this사용, 체이닝 할때 사용
    - with는 인자를 사용할때 사용하고 아무런 리턴을 못한다., this사용, 자체로 끝낼때 사용

### 확장 함수에 대해
- 확장 함수는 해당 함수가 정의된 파일 또는 해당 파일을 import하는 곳에서 사용할 수 있습니다. 즉, 확장 함수는 해당 파일 범위 내에서만 사용 가능합니다.
- 따라서 확장 함수를 전역적으로 사용하기 위해서는 해당 확장 함수를 정의한 파일을 다른 파일에서 import해야 합니다. 예를 들어, 확장 함수를 정의한 파일을 Util.kt로 만들고, 다른 파일에서 이를 사용하려면 import 문을 통해 Util.kt 파일을 임포트해야 합니다.
```kotlin
// Util.kt
package com.example.util

fun String.reverse(): String {
    return this.reversed()
}
```
```kotlin
// Main.kt
import com.example.util.reverse

fun main() {
    val originalString = "Hello, Kotlin!"
    val reversedString = originalString.reverse()

    println(reversedString) // Output: !niltoK ,olleH
}
```
- 위의 예시에서 Util.kt 파일에서 reverse라는 확장 함수를 정의하고, Main.kt 파일에서 이를 사용하기 위해 import com.example.util.reverse를 통해 Util.kt 파일을 임포트합니다. 이제 reverse 확장 함수를 String의 인스턴스에서 사용할 수 있습니다.
- 확장 함수는 확장하는 대상 클래스의 멤버 함수인 것처럼 사용할 수 있지만, 이는 확장 함수를 정의한 파일 또는 임포트한 파일의 범위에서만 가능하다는 점을 명심해야 합니다. 전역적으로 사용하고자 한다면 해당 파일을 다른 파일에서 import하여 사용해야 합니다.


## 궁금한 것 답변해 주신 것

- 티켓이라는 도메인을 좀더 풍부하기위해 번호 생성 및 당첨 번호 검증 이라는 역할을 부여했는데 도메인이 여러 책임을 가지는게 좋지 않는건지 궁금합니다!
    - 객체지향 5대 원칙(SOLID) 중 단일 책임 원칙(SRP)을 수행해보면 어떨까요?
    - 여러 책임을 가지기보단, 책임마다 객체를 분리하고, 객체끼리 협력하는 구조를 고민해보면 좋을거같아요!
- 생성시 numbers를 받으면 해당 number로 로또 티켓을 생성하고 아니면 length와 range로 랜덤 생성하려고하는데 어떻게 표한할지도 궁금해요!
    - 해당 책임은 분리해보셔도 되고, 팩토리함수를 이용한 가짜생성자를 활용해보셔도 좋을거 같아요!
- TDD로 구현하다보니 초기 설계와 다르게 테스트가 시키는 방향대로 구현되는 경향이 있는 거 같습니다. step1 과제는 유닛 테스트가 주가 되다 보니 기능에 초점이 맞춰져서 개발이 되었습니다. 이런식으로 테스트를
  한다고 생각하고 설계를 하게되면 객체들이 협력하는 큰 플로우 보다는 뭔가 작은 메서드 단위로 생각하는 경향이 생길 것 같은데요 다음 로또 과제부터는 BDD를 이용한 TDD를 해보려고 하는데 BDD를 이용해서 통합
  테스트를 짜면 제가 생각한 플로우 대로 테스트 코드는 만들어질거 같기도한데 이런 식으로 풀어가는게 맞는지 궁금합니다
    - 초기에 작성된 테스트 케이스에 의존된 구조가 되는 부분 공감하네요! TDD는 작은 단위의 기능에 대한 부분이 중점이 되다보니까, 설계적인 부분을 놓치기는 경우가 있기도합니다! 이번 강의를 통해 그런 부분을
      보완할수 있는 테스트 케이스 작성과 설계에 대한 부분을 고민하고, 학습하시면 좋을거같아요 😄 물론 BDD를 이용한 TDD를 하게되면 좀더 가독성있는 구조가 될수 있을거 같아요물론 BDD를 이용한 TDD를
      하게되면 좀더 가독성있는 구조가 될수 있을거 같아요 어떤 개발 방식이든, 정답은 없는 부분이니 시도를 통해 현제님의 스타일을 찾아가는것도 중요한거 같아요! 구현전에 단순 요구사항을 정리하기보다,
      ReadMe파일에 테스트 케이스를 작성하면서 설계또한 고민해보시면 좋을거같습니다!