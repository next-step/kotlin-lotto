# kotlin-lotto

## Number 클래스
1. 음수값은 들어갈수없다.
2. 0은 들어갈수없다.
3. 공백값은 들어갈수없다.
4. 숫자이외의 값은 들어갈수없다.
5. null값은 들어갈수없다.

## SixNumbers 클래스
1. 1번 부터 45번 까지 존재한다.
2. 랜덤으로 번호 6개가 있는 리스트가 만들어진다.
3. 같은 숫자는 들어갈수없으며 작은수에서 큰수로 리스트를 정렬한다.
4. 여기에 속하는 숫자들은 Int타입이 아닌 Number클래스로 만든다.

## Lotto라는 클래스
1. 구입금액에 대한 SixNumbers를 생성한다.
2. SixNumbers에서 만들어진 숫자 리스트에 당첨 번호가 몇개 들어있는지 확인한다.
3. 당첨된 개수에 따라 순위를 정한다.
4. 순위에 따른 당첨금과 구매한 금액에 따른 수익률을 계산한다.
