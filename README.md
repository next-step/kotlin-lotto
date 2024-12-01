# kotlin-lotto

## STEP 4

## 기능 구현 사항
- [ ] 수동으로 로또를 구매
  - [ ] 구매할 로또 수량을 입력받는다.
  - [ ] 로또 수량만큼 로또를 발행한다.
    - [ ] 수동 발행 로또와 자동 발행 로또를 merge한다 (불변 지키기)
- [ ] 수동과 자동으로 구매한 수량을 나타내는 메시지가 수정된다.

## 기능 요구 사항

- [ ] 수동으로 로또를 구매할 수 있다.
  - [ ] 로또 수량을 입력 받을 수 있다.
    - [ ] 수동으로 구매할 로또 수량은 0이 될 수 있다.
  - [ ] 로또 수량만큼 로또를 발행할 수 있다.
- [ ] 수동과 자동으로 구매한 수량을 나타내는 메시지가 수정돼야 한다.

## STEP 3

### 로또 당첨 도메인

- 당첨번호가 1,2,3,4,5,6 
- 보너스번호가 7
  - 1등이 6개 
  - 2등이 5개 + 보너스번호가 맞아야 함
  - 3등이 5개

### 피드백 - 1

- [x] LottoNumber.generate 메서드 제거
- [x] LottoResultHandler.match (v1) 메서드 제거
- [x] LottoNumbers.matchBonus 메서드 네이밍 시그니처 변경
- [x] LottoNumbers의 countMatch를 O(n^2)에서 O(n)으로 개선
- [x] 코틀린헤더를 코틀린 관습에 맞게 변경
  - [x] WinningNumbers
- [x] LottoNumbersTest 테스트 커버리지 100% 적용

### 기능 구현 사항

- [x] VIEW 주석 제거
- [x] UI 로직의 get 메서드를 덮어씌우지 않도록 변경
- [x] LottoResult의 count를 래핑하고 불변하게 처리되도록 변경
  - [x] count 메서드명을 더 명확하게 변경
  - [x] count 프로퍼티를 래핑하고 불변하게 처리되도록 변경
- [x] 피드백 반영 및 구현 사항을 커밋 메시지에 명시
- [x] 보너스 번호를 추가한다
- [x] 당첨 통계에 2등도 추가된다

### 기능 요구 사항
- [x] 보너스 번호를 추가한다
- [x] 당첨 통계에 2등도 추가된다
- [x] 열거 클래스를 적용해 프로그래밍을 구현한다
- [x] 일급 컬렉션을 사용한다

---

## STEP 2

### 피드백 - 1

- [x] (리뷰 코멘트) backing properties를 쓰지 않았을 때 대비 장단점
- [x] 컬렉션 선언 -> 엘리먼트 추가 -> 컬렉션 리턴하는 방식을 체이닝으로 풀어내기
  - [x] LottoIssuer (`List(size: Int, init: (index: Int) -> T)`)
  - [x] LottoResultHandler (map, fold 등)
- [x] LottoNumbers의 generateNumbers와 generate를 하나로 처리하도록 개선
  - [x] 체이닝 형태로 풀어내기
- [x] (리뷰 코멘트) InputView에 get 메서드를 덮어씌운 이유
- [x] (리뷰 코멘트) 주석을 남긴 이유
- [x] LottoNumber의 random을 외부에서 주입받도록 분리
- [x] 외부로 노출할 필요없는 프로퍼티 private으로 변경
- [x] StringBuilder 대신 StringTemplate 사용하도록 변경
- [x] LottoNumbers.countMatch를 O(n^2)에서 O(n)으로 개선


### 셀프 피드백

- backing field / property 에 대해 알아
- Kotest Testing Styles 다뤄보기
  - [x] StringSpec
  - [ ] FunSpec
  - [x] BehaviorSpec
  - [ ] DescribeSpec
- Price를 BigDecimal로 변경하기
  - 1등인 상황으로 LottoResultTest를 작성하다가 count를 호출해서 대상자가 2명이 됐을 때 오버플로우 발행해서 음수값으로 바뀜 

### 기능 구현 사항

- [x] 구입 금액을 받아 로또를 발행(Issuer)하는 객체를 생성한다
  - [x] 발행자는 로또의 금액을 관리하고 로또를 발행하는 역할을 한다
- [x] 로또 숫자 객체를 생성한다.
  - [x] 로또 숫자는 랜덤한 숫자를 생성이 주요 역할이다. 
- [x] 로또 숫자 객체들을 관리하는 객체가 존재한다.
  - [x] 로또 숫자 객체들은 중복되지 않는 숫자들로 이루어지지 않는 책임을 가진다.
    - [x] LottoNumber는 equals, hashCode를 오버라이딩 해야 한다 -> value class
  - [x] 로또 숫자들이 정해진 개수만큼 생성되는지에 대해 보장해야 한다.
    - while문 조건식이 있기 때문에 별도 validate는 없어도 될 것 같..기도..?
  - [x] 로또 생성에 대한 책임을 발행하는 객체(Issuer)가 가진다.
    - 외부에서 반복하는 것도 생각했으나 발행자가 구매 개수를 관리하는 책임도 가지기 때문에 발행자가 가지는 것이 맞다고 생각함 
- [x] 지난주 당첨 번호를 입력받으면 당첨 통계를 구한다.
  - [x] 당첨 결과는 어떠한 형태로 다룰 것인가
    - 방법1. Map<Rank, Int> -> Rank에 대한 카운트를 가지고 있는 방법
    - 방법2. List<LottoResult> -> Rank와 카운트를 가지고 있는 방법
    - 방법3. List<Int> -> 카운트만 가지고 있는 방법
  - [x] match 메서드는 협력한다.
    - 파라미터
      - List<LottoNumbers> -> 구매한 로또 번호
      - LottoNumbers -> 당첨 번호
- [x] ~~return List<LottoResult>를 하기 때문에 수익률은 Controller(Main)에서 계산한다~~
  - ~~추후 확장되면 별도 객체로 분리한다~~
  - 별도 객체로 나누는 것이 더 적절할듯
    - View는 계산보다 단순히 값을 받아 처리하는 것이 나중에 변경에 유리해서
  - [x] LottoResults를 만든다
    - [x] LottoResults는 List<LottoResult>를 가지고 있다
      - [x] LottoResult는 Rank와 카운트를 가지는데, 생성과 동시에 값을 세팅하는 것이 적절한가?
    - [x] LottoResults는 수익률을 계산하는 메서드를 가지고 있다

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
