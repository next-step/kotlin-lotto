# kotlin-lotto

## 기능 목록
### 메인 애플리케이션 진입점
- MyLottoApplication.kt
- view 와 비즈니스 로직을 연결
- 종료 안시키고 무한루프로 입력
- 종료는 ctrl c로

### View
#### InputView
##### 구입 금액 입력
- `구입금액을 입력해 주세요.`
- 입력된 금액을 반환
- 1000원 단위
- 0원 초과
- 검증 실패 -> `다시 입력하세요`

##### 수동으로 구매할 로또 티켓 수 입력
- `수동으로 구매할 로또 수를 입력해 주세요.`
- 입력된 정수를 반환
- 검증 실패 -> `다시 입력하세요`

##### 수동으로 구매할 로또 번호 입력
- `수동으로 구매할 번호를 입력해 주세요.`
- 위에서 입력한 수만큼 티켓 번호를 입력 받음
- 입력된 6개 번호 set을 받아서 각 티켓마다 LottoNumbers를 반환
- 콤마로 구분
- 검증 실패 -> `다시 입력하세요`

##### 당첨 번호 입력
- `지난 주 당첨 번호를 입력해 주세요.`
- 입력된 6개 당첨번호 set을 받아서 LottoNumbers를 반환
- 콤마로 구분
- 검증 실패 -> `다시 입력하세요`

##### 보너스볼 입력
- `보너스 볼을 입력해 주세요.`
- 입력된 정수를 반환
- 검증 실패 -> `다시 입력하세요`

#### ResultView
##### 구매한 매수 및 번호 출력
- LottoTicket 일급 컬렉션 리스트를 입력으로 받음
- `수동으로 3장, 자동으로 11개를 구매했습니다.`
- `[8, 21, 23, 41, 42, 43]`

##### 당첨 통계 출력
- LottoResult 를 입력으로 받음
- 일치 개수 별로 당첨된 개수 및 수익률 및 훈수 메세지

### Domain
#### LottoNumber
- 숫자 하나.
    - 1~45 사이 숫자

#### LottoWinningNumbers
- 6개 짜리 LottoNumber Set이 있음. (나중에 보너스볼 추가될 예정)
- 검증 메소드
    - 중복 불가

#### LottoTicket
- 6개 짜리 LottoNumber Set이 있음.

#### Rank enum
- 등수별로 당첨 금액

#### LottoResult
- 티켓 n개에 대해서 결과를 가지고 있음. + 수익률 계산

#### LottoService
- generateLottoTickets
    - 구입 금액 입력 받아서 LottoTicket 리스트 반환하는 method
    - shuffled sorted 사용
- matchLottoTicket
    - LottoTicket + 당첨 번호 입력 받아서 당첨된 Rank를 반환하는 method
- matchLottoTickets
    - LottoTicket 리스트 + 당첨 번호 입력 받아서 LottoResult 반환하는 method
    - 위의 단건 매칭 method를 내부에서 사용

## 기능 구현 단위
- domain 객체 뼈대 구현 + service 뼈대 구현
- 뼈대에 대한 테스트 작성
- domain 객체 및 service 로직 작성
- view 로직 구현
- application 구현
