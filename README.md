# kotlin-lotto

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능개발
- 구입금액을 받아 데이터를 파싱하고 validation 하는 로직을 작성한다
- 로또를 구매하는 로직을 작성한다
- 구매한 로또의 갯수만큼 로또 번호를 생성하는 로직을 작성한다
- 지난주 로또 번호를 입력 받고 데이터를 파싱하고 validation 하는 로직을 작성한다
- 당첨 통계 로직을 작성하고 결과를 출력한다
- 당첨 타입에 보너스 볼 일치 타입을 추가한다
- 당첨 번호 갯수만으로 등수를 지정할수 없으므로 보너스번호를 포함하여 등수를 지정하도록 로직을 수정한다
- 보너스 볼을 입력하는 로직을 추가한다
- 보너스 볼이 추가된 결과 값을 나타내도록 출력하는 로직을 수정한다
- 수동으로 구매할 로또 수를 입력받는다
- 수동으로 구매할 갯수만큼 로또 번호를 입력 받는다
- 로또의 총 갯수에서 수동으로 구매한 갯수를 뺀 나머지는 자동으로 구매하도록 한다
- 예외처리를 하여 에러가 발생하지 않도록 리팩토링한다 
