# 1단계 - 문자열 덧셈 계산기

## 🎯 기능 목록

- [x] 문자열 파서에 쉼표(,) 또는 콜론(:)을 구분자로 하는 숫자들을 전달하는 경우 구분자를 기준으로 숫자를 분리하여 반환한다
- [x] 문자열 파서에 빈 문자열 또는 null을 전달하는 경우 0을 반환한다.
- [x] 문자열 파서에 "//" 과 "\n" 으로 둘러싸인 문자를 전달하는 경우 해당 문자를 구분자로 추가할 수 있다.
- [x] 문자열 파서에 숫자 이외의 값이 전달되면 예외를 던진다.
- [x] 문자열 계산기는 숫자를 전달하면 합을 구한다.
- [x] 문자열 계산기에 음수를 전달하는 경우 예외를 던진다.

# 2단계 - 로또 (자동)

## 🎯 기능 목록

- [x] 로또는 숫자 6개를 가진다.
- [x] 로또의 상태를 출력하면 부여받은 숫자 6개를 출력한다.  
- [x] 로또에 적힌 숫자 개수가 6개를 넘는다면 예외가 발생한다.
- [x] 로또에 적힌 숫자는 1부터 45 사이의 숫자다.
- [x] 로또에 적힌 숫자가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.
- [x] 로또에 적힌 숫자가 중복된다면 예외가 발생한다.
- [x] 로또에 6개의 숫자를 전달하면 일치 개수를 계산할 수 있다.
- [x] 일치 개수를 계산할 때, 로또에 6개가 아닌 숫자를 전달하면 예외가 발생한다.
- [x] 일치 개수를 계산할 때, 로또에 1부터 45 외의 숫자를 전달하면 예외가 발생한다.
- [x] 랜덤 숫자 생성기에 숫자A, 숫자B, N을 전달하면 숫자A ~ 숫자B 숫자를 N개 반환한다.
- [x] 랜덤 숫자 생성기의 전달될 숫자A가 숫자B보다 크면 예외가 발생한다.
- [x] 랜덤 숫자 생성기의 전달될 숫자A~숫자B 사이의 개수보다 N이 크면 예외가 발생한다.
- [x] 로또 생성기는 6개의 숫자를 골라 로또 한 장을 생성한다.
- [x] 로또 생성기가 고른 숫자는 1 ~ 45 숫자이다.
- [x] 로또 생성기는 숫자 N을 입력받아 N개의 로또를 생성한다.
- [x] 로또 게임은 N개의 로또를 가진다.
- [x] 로또 게임은 지난 주 당첨 번호를 가진다.
- [x] 로또 게임은 3-6개 일치 로또의 개수를 계산할 수 있다.
- [x] 로또 게임은 총 수익률을 계산할 수 있다.
- [x] 로또 게임의 수익률은 `수익금 / 원금` 으로 계산된다.
- [x] 로또 게임의 수익률은 소수점 2번째 자리까지 표현한다.
- [x] 로또 게임으로부터 각 등수가 몇명인지 알 수 있다.
- [x] 로또 게임결과의 상태를 출력하면 등수별 인원수, 총 수익률이 출력된다.

# 3단계 - 로또 (2등)

## 🎯 기능 목록

- [x] 로또 게임은 보너스 번호를 가질 수 있다.
- [x] 보너스 번호는 1부터 45 사이의 숫자다.
- [x] 보너스 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.
- [x] 보너스 번호는 어떤 숫자그룹에 자신의 값이 속해있는지 알 수 있다.
- [x] 당첨번호는 6자리 번호와 보너스 번호를 갖는다.
- [x] 당첨번호의 6자리 번호와 보너스번호가 중복되면 예외가 발생한다.
- [x] 당첨번호와 로또를 비교하여 일치 개수 및 보너스 일치 여부를 계산 할 수 있다.
- [x] 로또 게임의 2등 인원을 찾아낼 수 있다.
- [x] 2등의 조건은 당첨번호 5개 일치 + 보너스 번호 일치이다.
- [x] 2등의 당첨 금액은 30000000원이다.
- [x] 로또 게임결과의 상태를 출력하면 2등이 몇명인지 출력된다.
- [x] 1등의 조건은 당첨번호 6개 일치이다.
- [x] 1등의 당첨 금액은 2_000_000_000원이다.
- [x] 2등의 조건은 당첨번호 5개 일치 + 보너스 번호 일치이다.
- [x] 2등의 당첨 금액은 30_000_000원이다.
- [x] 3등의 조건은 당첨번호 5개 일치 + 보너스 번호 불일치이다.
- [x] 3등의 당첨 금액은 1_500_000원이다.
- [x] 4등의 조건은 당첨번호 4개 일치 + 보너스 번호 상관없음 이다.
- [x] 4등의 당첨 금액은 50_000원이다.
- [x] 5등의 조건은 당첨번호 3개 일치 + 보너스 번호 상관없음 이다.
- [x] 5등의 당첨 금액은 5_000원이다.

# 4단계 - 로또(수동)

## 🎯 기능 목록

- [x] 구입금액은 숫자이다.
- [x] 구입금액이 1000원 단위가 아니면 예외가 발생한다.
- [x] 구입금액이 음수라면 예외가 발생한다.
- [ ] 입력받은 수동 로또 수는 숫자이다.
- [ ] 입력받은 수동 로또 수가 음수라면 예외가 발생한다. 
- [ ] 입력받은 수동 로또 수가 구입금액을 초과하면 예외가 발생한다.
- [ ] 사용자로부터 입력받는 로또 번호 6자리는 아래의 규칙을 따른다.
  - [ ] 로또 번호는 쉼표(,)로 구분된다.
  - [ ] 로또 번호를 쉼표(,) 외의 문자로 구분하면 예외가 발생한다.
  - [ ] 로또 번호는 숫자 6개이다.
  - [ ] 로또 번호가 숫자 6개가 아니라면 예외가 발생한다.
  - [ ] 로또 번호(또는 보너스번호)는 숫자 1~45이다.
  - [ ] 로또 번호(또는 보너스번호)가 숫자 1~45가 아니라면 예외가 발생한다.
  - [ ] 로또 번호는 중복되지 않는다.
  - [ ] 로또 번호가 중복된다면 예외가 발생한다.
- [ ] 구매 방법(수동/자동)에 따라 구매 로또를 구분한다.
- [ ] 구매 방법(수동/자동)에 따른 구매 로또 수를 출력한다.

# 학습 내용
- Operator overloading
  - [PR](https://github.com/next-step/kotlin-lotto/pull/932)에서 언급된 내용을 [공식문서](https://kotlinlang.org/docs/operator-overloading.html#binary-operations)를 통해 학습
  - 미리 정의된 연산자 집합에 대한 사용자 지정 구현을 커스텀할 수 있다.
  - 하단 예제 및 [lottoNumbers](src/main/kotlin/lotto/domain/LottoNumbers.kt)의 `contains`, [WinningNumbers](src/main/kotlin/lotto/domain/WinningNumbers.kt)의 `!in` 참조
  ```kotlin
  data class Point(val x:Int, val y:Int)
  
  operator fun Point.unaryMinus() = Point(-x, -y)
  
  val point = Point(10, 20)
  
  fun main() {
    println(-point) // "Point(x=-10, y=-20)"
  }
  ```
