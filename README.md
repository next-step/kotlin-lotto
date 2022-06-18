# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구사항

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 구분
- [x] 커스텀 구분자를 만들 수 있음
  - [x] 커스텀 구분자는 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 함
- [x] 문자를 숫자로 변환
  - [x] 숫자가 아닌 문자 혹은 음수를 전달할 경우 RuntimeException 발생
- [x] 모든 숫자의 합을 구함
  - [x] 빈 문자열 혹은 null이 들어온 경우 0을 반환
  - [x] 숫자만 들어온 경우 해당 숫자를 반환


## 로또

### 기능 목록

- [x] 로또 번호는 1에서부터 45까지의 숫자로 구성되어 있다.
- [x] 로또 티켓은 중복되지 않는 6장의 로또 번호로 구성되어 있다.
- [ ] 당첨 번호는 로또 티켓과 동일하다.
- [ ] 당첨 번호를 기반으로 당첨 결과를 구할 수 있다.
  - [ ] 6개 일치, 2_000_000_000원
  - [ ] 5개 일치, 1_500_000원
  - [ ] 4개 일치, 50_000원
  - [ ] 3개 일치, 5_000원
  - [ ] 그 외, 0원
- [ ] 구입 금액은 로또를 구입하기 위한 금액이다.
  - [ ] 로또 구입은 1_000원 단위로 이루어진다.
- [ ] 로또 당첨 결과를 구입 금액을 기반으로 총 수익률을 구할 수 있다.
