## 기능 요구사항
[ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
[ ] 로또 1장의 가격은 1000원이다.

```aidl
지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

[ 클래스 다이어그램 ]

![Untitled Diagram drawio](https://user-images.githubusercontent.com/91591854/173190669-6fea0bc0-57ae-48fd-b634-3930c3b7666b.png)

## 구현할 기능 목록

[X] Lotto: play(): 로또를 구매하고 매칭해 결과를 반환받는다.
[X] InputView : 유저에게 입력받는 객체
[X] ResultView: 결과를 보여주는 객체
[X] Wallet: input으로 들어온 돈을 가지고 있다.
[X] Person ```<<Interface>>```
- [x] purchase(): 티켓을 구매한다.
- [X] wallet: 플레이어는 wallet 을 가지고 있다.
- [X] PersonImpl: 자동으로 구매하는 사람
- [ ] ManualPersonImpl: 수동으로 구매한 사람
  [X] LottoTicketMachine: Player가 티켓을 구매하면 자동으로 티켓을 생성한다.
- [X] print(): 로또 티켓을 만든다.
- [X] getRandomNumber(): 무작위의 6자리 숫자를 만든다
- [X] printMaxTicket(money: Int): 구매가능한 최대로 로또티켓을 출력한다.
  [X] LottoTicket: 숫자를 6자리 가지고 있는 티켓
  [ ] Matcher: 지난 주 당첨번호를 입력받아 Person이 가진 tickets와 매칭한다.
- [X] winningNumber: 당첨번호 나열을 property로 갖는다.
- [X] matchOneTicket(): 당첨번호와 한 장의 티켓을 매칭해 결과를 리턴한다.
- [X] matchAllTickers(): 구매한 모든 티켓에 대한 결과를 매칭한다.
  [X] Rank: 등수, 상금의 정보를 가지고 있는 enum class


## 프로그래밍 요구 사항
[ ] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
[X] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
[X] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
[X] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
[X] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
[ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
[X] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
[ ] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 힌트
[X] 로또 자동 생성은 shuffled()을 활용한다.
[ ] sorted()를 활용해 정렬 가능하다.
[X] contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.