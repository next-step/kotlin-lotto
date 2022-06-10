## 기능 요구사항
[ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
[ ] 로또 1장의 가격은 1000원이다.

## 구현할 기능 목록
[ ] Lotto: play(): 로또를 구매하고 매칭해 결과를 반환받는다.
[ ] InputView, resultView 생성
[ ] Wallet: input으로 들어온 돈을 가지고 있다.
[ ] Player: 티켓을 구매한다. 플레이어는 wallet 을 가지고 있다.
[ ] Lotto Ticket Machine: Player가 티켓을 구매하면 티켓을 생성한다. interface (전략 패턴)
    [ ] AutoMachine(Impl): 자동으로 6자리의 값을 생성한다.
    [ ] ManualMachine(Impl): 수동으로 6자리 값을 생성한다.
[ ] Ticket: 숫자를 6자리 가지고 있는 티켓
[ ] Matcher: 지난 주 당첨번호를 입력받아 Person이 가진 tickets와 매칭한다. MatchingReuslt 객체를 리턴한다. interface
    [ ] WithoutBonusMatcher(Impl): 보너스 공이 없는 매칭
    [ ] Matcher(Impl): (단일 원칙 책임으로 수정)
[ ] MatcherResult: 매칭 결과를 가지고 있는 data class
[ ] Rank: 등수, 상금의 정보를 가지고 있는 enum class

## 프로그래밍 요구 사항
[ ] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
[ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
[X] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
[ ] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
[ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
[ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
[ ] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
[ ] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 힌트
[ ] 로또 자동 생성은 shuffled()을 활용한다.
[ ] sorted()를 활용해 정렬 가능하다.
[ ] contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.