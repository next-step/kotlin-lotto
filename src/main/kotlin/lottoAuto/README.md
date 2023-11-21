# README
## Step 2 구현 리스트

구현 리스트 

- [x]  역할 분리 및 담당 객체 생성
- [x]  Domain (TDD 기반으로 생성)
    - [x]  LottoNumber 테스트 추가, 기능 구현
    - [x]  LottoNumbers 테스트 추가, 기능 구현
    - [x]  Lotto 테스트 추가, 기능 구현
    - [x]  LottoFactory 테스트 추가, 기능 구현
    - [x]  LottoRanker 테스트 추가, 기능 구현
    - [x]  LottoStatsEngine 테스트 추가 기능 구현
- [x]  View
    - [x]  InputView 생성
        - [x]  사용자에게 구매 금액을 입력받는다.
        - [x]  사용자에게 당첨 번호를 입력받는다.
    - [x]  OutputView 생성
        - [x]  로또 발급 개수를 출력한다.
        - [x]  로또 번호 리스트를 출력한다.
        - [x]  당첨 통계를 출력한다.
        - [x]  수익률을 출력한다.
- [x]  Controller
    - [x]  LottoController 구현
        - [x]  View-Domain 통합 로직 수행

기능 점검 리스트

- [x]  1~45 범위 숫자 중 랜덤으로 6자리 번호를 생성하고 로또를 발급한다.
- [x]  로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 리스트를 반환한다. (로또 금액: 1000원)
- [x]  당첨 번호와 발급된 로또를 비교해 당첨 통계를 산정하고 반환한다.
- [x]  로또 구입 금액과 수익 금액을 비교해 이익률을 계산하고 반환한다.

## Step3 구현 리스트 

2단계 피드백 반영

- [x] LottoNumber 캐시 
- [x] Lotto 클래스 테스트 전용 메서드(match) 제거
- [x] LottoNumbers 제거, Lotto를 일급 컬렉션으로 수정
- [x] LottoNumber 중복 생성 방지 로직 추가 
- [x] LottoRank from 메서드 시그니처 변경
- [x] LottoRanks 일급 컬렉션 생성, rank 정보 기반 집계 담당
- [x] 클래스명, 메서드명 변경 - 역할과 책임 명확히 드러나도록
- [x] LottoNumber 정적 팩토리 메서드 제거, 확장 함수 생성으로 대체
- [x] winningLotto 객체 생성 및 당첨 번호 매칭 담당하도록 메서드 구현
- [x] LottoStatsEngine 네이밍 변경 및 역할 분리
- [x] 모델-뷰 분리, 뷰는 원시값만 인풋으로 받도록 처리
- [x] 로또 당첨 확률 외부 파라미터로 전달

3단계 기능 구현 리스트 

- [x] 2등을 위한 보너스 넘버 추가 
  - [x] Lotto에서 보너스볼 포함 여부 확인 메서드 부여
  - [x] Lotto에서 보너스볼 포함 여부 확인 메서드 테스트
  - [x] LottoRank 정적 팩토리 메소드 시그니처 변경
  - [x] LottoRank 시그니처 변경에 따른 테스트 추가
  - [x] InputView 변경
- [x] 당첨 통계에 2등 정보 추가
  - [x] LottoRanker rank 함수 시그니처 변경 (보너스 번호 받도록)
  - [x] LottoRanker 함수 시그니처 변경에 따라 테스트 수정
  - [x] OutputView 변경

4단계 기능 구현 리스트 

- [x] 3단게 리뷰 반영  
  - [x] OutputView.printStatistics 리팩터링
  - [x] WinningLotto는 Lotto를 조합해 생성
  - [x] winningLotto의 로또 번호와 bonus 번호 중복되지 않도록 처리
    
- [ ] 로또 수동 생성 기능 구현
  - [x] 사용자가 구매할 로또 수 입력하도록 InputView 기능 추가 
  - [x] 사용자가 추첨 번호 직접 입력할 수 있도록 InputView 기능 추가
  - [ ] 구매한 추천 번호 리스트를 출력하는 OutputView 기능 추가
  - [x] 사용자가 입력한 번호를 Lotto 객체로 생성하는 기능 구현
  - [ ] 로또 수동, 자동 생성 기능 모두 제공하는 LottoFactory 구현
