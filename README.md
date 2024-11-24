# kotlin-lotto

## STEP 2

### 기능 구현 사항

- [x] 구입 금액을 받아 로또를 발행(Issuer)하는 객체를 생성한다
  - [x] 발행자는 로또의 금액을 관리하고 로또를 발행하는 역할을 한다
- [ ] 로또 숫자 객체를 생성한다.
  - [ ] 로또 숫자는 랜덤한 숫자를 생성이 주요 역할이다. 
- [ ] 로또 숫자 객체들을 관리하는 객체가 존재한다.
  - [ ] 로또 숫자 객체들은 중복되지 않는 숫자들로 이루어지지 않는 책임을 가진다.
  - [ ] 로또 숫자들이 정해진 개수만큼 생성되는지에 대해 보장해야 한다.
- [ ] 지난주 당첨 번호를 입력받으면 당첨 통계를 구한다.
  - [ ] match 메서드는 협력한다.
    - 필드
      - List<LottoResult>
        - LottoResult
          - rank: Rank
            - Rank
              - FIRST
              - SECOND
              - THIRD
              - FOURTH
          - count: Int
    - 파라미터
      - List<LottoNumbers> -> 구매한 로또 번호
      - LottoNumbers -> 당첨 번호
- [ ] return List<LottoResult>를 하기 때문에 수익률은 Controller(Main)에서 계산한다
  - 추후 확장되면 별도 객체로 분리한다

### 기능 요구 사항

- 로또 구입 금액을 입력하면 금액만큼 로또를 발행한다.
- 로또 1장의 가격은 1000원이다.
  - 추후 로또의 가격은 바뀔수도 있다는 점도 생각
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- 로또 자동 생성은 shuffled()을 활용한다.
  - sorted()를 활용해 정렬한다
  - contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

---

## STEP 1

### 셀프 피드백

- JvmStatic, JvmInline 알아보기
- 테스트코드 동적 파라미터 전달 방법 알아보기
- 클래스 종류 정리하기
  - data class
  - object class
  - companion object
  - inline class (<-> value class와의 차이도 알아보기)
    - [정리 완료](https://jaesa5221.notion.site/Kotlin-Value-Class-inline-class-1480fbcd609d80fab544f347693b4fd4?pvs=4)
  - class
- 확장함수에 대해서 알아보기
  - let
  - with
  - run
  - apply
  - also

### 기능 요구 사항

- 구분자를 기준으로 분리한 숫자의 합을 반환한다
  - 커스텀 구분자는 문자열 맨 앞부분에 "//"와 "\n" 사이에 존재하는 문자 값이다 (없을수도 있다)
- 숫자 이외의 값 또는 음수를 전달하는 경우 예외(RuntimeException)가 발생한다
  - 1차 필터: default(',', ':'), custom(//{{무엇}}\n)
  - 2차 필터: 숫자 하나를 문자열로 입력할 경우('1') 또는 빈 문자열, null인 상황도 있으니 숫자로 정규식 추출
    - 이때, 숫자에 대한 검증을 해야함
      - 음수, 숫자가 아닌 값
  

### 협력 도메인

- 구분자
- 문자열 (표현식)
- 계산기

### 시퀀스 

- 커스텀 구분자가 있는지 확인한다
  - 없다면 default 구분자로 문자열을 분리한다
  - 있다면 커스텀 구분자도 포함하여 문자열을 분리한다
- 토크나이징하여 List<String>에 담는다
  - 이때, 커스텀 구분자를 포함한 구분자와 값이 들어간다
