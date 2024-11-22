# kotlin-lotto

StringCalculator
요구사항
- [x] 문자열 계산기는 입력으로 문자열을 받는다
- [x] ,와 :을 구분자로 숫자들이 오면 모든 숫자를 더한다
- [x] //와\n 사이에 문자를 지정하면 그 문자도 구분자에 추가한다
- [x] 문자열의 음수가 오는 경우 예외를 던진다
- [x] 문자열의 숫자 자리가 문자가 오면 예외를 던진다
- [x] 구분자 이외의 문자가 오면 예외를 던진다

Lotto
- [x] 로또 구매금액을 입력받는다
- [x] 로또 한장의 가격은 1000원이다
- [x] 로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다
- [x] 로또 번호는 1부터 45까지 번호 중 6개의 랜덤 조합이다
- [x] 로또 구매 갯수만큼 로또 번호를 생성한다
- [x] 당첨 번호를 입력받는다
- [x] 당첨 번호과 로또 번호들을 비교하여 번호의 일치 갯수를 구한다
- [] 일치한 갯수 별로 분류한다
- [] 갯수별 금액과 갯수를 곱해 수익금을 만든다
- [] 수익금을 구매금액으로 나누어 수익률을 구한다
- [] 수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다