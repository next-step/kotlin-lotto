# kotlin-lotto
1. 문자열 계산기 덧셈 기능
- [x] 쉼표 또는 콜론을 구분자로 가지는 문자열을 구분자 기준으로 분리한다.
- [x] 분리된 숫자의 합을 반환한다.
- [x] 커스텀 구분자는 "//"와 "\n" 사이에 위치하는 문자열이다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException을 throw 한다.

2. 로또(자동) 기능
- [x] 구입 금액을 입력한다.
- [x] 구입금액으로 구입할 수 있는 로또의 개수를 구한다.
- [x] 로또는 6개의 랜덤 숫자로 구성된다.
- [x] 로또 숫자는 작은 수부터 큰 수 순서로 정렬된다.
- [x] 당첨은 3개의 숫자를 맞춘 사람부터 6개 맞춘 사람까지이다.
- [x] 수익률은 로또 구매 금액 대비 당첨 금액이다.

3. 로또(2등) 기능
- [x] 보너스 볼을 입력한다.
- [x] 5개 일치하고 보너스 볼까지 일치하는 등급이 있다.
- [x] 일급 클래스를 사용해보자.

4. 로또(수동) 기능
- [x] 로또의 수동 개수를 입력한다.
- [x] 로또의 수동 번호를 입력한다.
- [x] 로또의 자동 수동을 합해서 로또를 만든다.
- [ ] 로또 출력을 자동과 수동을 합쳐서 한다.