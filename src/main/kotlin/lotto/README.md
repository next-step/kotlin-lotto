## 2단계 - 로또 (자동)

### 기능 요구사항
- 입력
  - 사용자는 구입할 로또 금액을 입력할 수 있다.
    - 로또 1장의 금액은 1000원이며, 금액만큼 로또를 발급한다.
  - 지난 주 당첨 번호를 입력할 수 있다.
    - ,로 구분된 1~45 사이의 6개 숫자를 입력할 수 있다.
- 출력
  - 구매한 로또 개수와 구입하고 거스름돈을 출력한다.
  - 1~45 사이의 ,로 구분된 6개의 숫자를 출력한다.
  - 당첨 통계를 출력한다.
    - 일치한 개수는 3~6개까지 출력한다.
    - 수익률을 출력한다.
- 로또
  - 1장당 랜덤하게 생성된 숫자 6개를 가진다.
  - 숫자는 중복될 수 없다.
  - 1장당 1000원이다.
  - 두 로또 값 사이의 중복된 개수 (=일치하는 개수)를 구한다.
- 로또 모음
  - 구입 금액을 바탕으로 구매할 수 있는 최대 금액만큼 로또를 생성한다.
  - 구입 금액을 바탕으로 거스름돈을 구한다.
  - 당첨 번호를 받아 로또 당첨 결과를 반환한다.
- 로또 구입 금액
  - 사용자가 입력한 로또 금액을 의미한다.
  - 로또는 1000원부터 구매할 수 있다.
- 로또 숫자 생성기
  - 1~45 사이의 숫자 6개를 랜덤하게 생성한다.
  - 로또 숫자는 중복될 수 없다.
- 로또 결과
  - 로또 당첨 개수가 3~6개면 일치하는 개수에 따라 결과를 저장한다.