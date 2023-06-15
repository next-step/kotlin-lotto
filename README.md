# kotlin-lotto

## [문자열 덧셈 계산기]
### 기능 목록

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 구분자를 기준으로 분리한다.
- [x] 구분자를 기준으로 분리된 문자열을 더한다.
- [x] “//”와 “\n” 사이 문자를 커스텀 구분자로 지정한다.
- [x] 숫자 이외의 값 or 음수가 전달되면 RuntimeException 예외를 발생시킨다

### 기능 요구 사항

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  <br /> (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. <br /> 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. <br />예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다


## [로또]
### 기능 요구 사항
- [x] 로또를 구매할 구입금액을 입력받아 로또 번호를 자동으로 생성합니다.
- [ ] 지난 주 당첨 번호와 당첨에 대한 통계를 출력합니다.

### 기능 목록
- [x] '구입금액을 입력해주세요' 메시지를 출력합니다. - InputView
- [x] 구입금액을 입력받습니다. - InputView

- [x] 'N개를 구매했습니다' 메시지를 출력합니다. - OutputView 
- [x] 구매개수 만큼 랜덤한 6개의 수를 가진 로또를 생성합니다. (6개의 랜덤한 수, 범위: 1~45) - LottoStore => Lotto
- [x] 구매개수 만큼 생성된 로또의 번호들을 출력합니다. (구분자 : ,) - OutputView 

- [ ] '지난주 당첨 번호를 입력해 주세요.' 메시지를 출력합니다. - InputView
- [ ] 지난주 당첨 번호를 입력받습니다. (6개 입력, 범위: 1~45) - InputView
 
- [ ] 각 로또마다 일치하는 개수를 계산합니다. - Lotto
- [ ] 모든 로또의 일치하는 개수를 통한 통계를 냅니다. - LottoStore? Person?
- [ ] 전체 로또에 대한 수익률을 계산합니다. - LottoStore? Person?
- [ ] 당첨 통계와 총 수익률을 출력합니다. - OutputView


### 추가 설계 목표
- Lotto 의 종류는 다양하다 => 추상화
- 각 LottoStore 는 해당하는 Lotto를 '생성' / '판매' / '추첨' 한다
- Person은 LottoStore로부터 Lotto를 구매한다?