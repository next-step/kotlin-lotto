# 문자열 덧셈 계산기
## 기능 요구사항

* [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  * [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
* [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

# 로또(자동)
## 기능요구사항
* [x] 로또 구입금액으로 로또구매 개수를 리턴한다 - Receipt
* [x] 구매개수만큼 로또번호를 발급한다 - Lotto
  * [x] 로또번호는 1~45 사이 숫자, 6개를 발급한다.
  * [x] 생성된 로또번호는 중복을 허용하지 않는다.
* [x] 지난당첨번호와 일치하는 개수를 확인한다- Checker
  * [x] 지난당첨번호는 6개의 숫자이다
  * [x] 지난당첨번호는 중복 숫자를 허용하지 않는다
* [x] 로또번호를 발급하고 당첨여부를 판단한다 - LottoMachine
* [x] 당첨통계 데이터를 관리한다 - Stat
  * [x] 로또번호들의 일치하는 번호개수를 확인한다 - Stat
  * [x] 구매한 로또들의 합산금액을 확인한다 - Stat
* [x] 로또당첨금액에 대한 수익률을 계산한다 - Profit
* [x] 데이터 입력기능을 만든다 - InputView
  * [x] 구매금액을 입력받는다
  * [x] 지난주당첨금액을 입력받는다
* [x] 데이터를 view 기능을 만든다 - ResultView
  * [x] 로또 구매개수를 보여준다
  * [x] 로또발급번호를 보여준다
  * [x] 당첨통계를 보여준다
  * [x] 수익률을 보여준다

# 로또(자동)
## refactor list
* [x] 패키지 정리
* [x] 지불금액은 1원이상의 숫자여야 한다 - Receipt
* [x] view layer에서 관리되어야할 변수들 이동
* [x] 로또번호 하나를 객체로 포장한다 - LottoNumber
  * [x] 지난 로또번호 입력받아 저장하는 로직도 LottoNumber 객체로 변경
* [x] generateList를 별도 LottoGenerator 메소드로변경하고 검증로직 추가
  * [x] generateList 테스트코드 추가
* [x] intersect 적용 - Checker
* [x] MatchState 관련 구조변경
* [x] Stat 도메인 책임을 LottoTickets, MatchStates 분리하다보니 StatResult로 대체 
* [x] 일급컬렉션으로 변경
  * [x] List<LottoNumber> -> LottoTicket
  * [x] List<LottoTicket> -> LottoTickets
  * [x] List<MatchState> -> MatchStates
  * [x] List<StatResult> -> StatResults
* [x] 수익률 계산방식 변경
* [x] view 호출로직 최소화(마지막에 한번만 하면되지 않을까?)
