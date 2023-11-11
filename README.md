# kotlin-lotto

---

# 로또 - 자동

## 요구사항 분석
- 입력
  - [x] 구입금액을 입력 받는다.
  - [] 당첨 번호를 입력 받는다.

- 출력
  - [x] 구입금액을 입력받는 텍스트를 출력한다.
  - [x] 구매한 로또의 갯수를 출력한다.
  - [x] 구매한 로또의 숫자를 출력한다.
  - [] 당첨 번호 입력 텍스트를 출력한다.
  - [] 결과 화면을 출력한다.
    - [] 당첨 번호와 일치한 구매 로또 갯수를 출력한다.
    - [] 수익률을 출력한다. 

- 도메인
  - [] 당첨번호가 있다.
  - [x] 로또 상점에서 로또를 구매한다.
    - [x] 로또는 여러개 구매할 수 있다.
    - [x] 로또는 6개의 숫자를 가진다.
      - [x] 로또의 숫자는 정렬되어 있다.
  - [x] 로또 상점이 있다.
    - [x] 로또 한 장의 가격은 1000원이다.
    - [x] 로또의 숫자는 자동 생성된다.


## 프로그래밍 요구 사항
- 모든 기능을 TDD 단위로 구현해 단위 테스트가 존재해야 한다.
- 들여쓰기는 2depth를 넘지 않도록 한다.
- 함수의 길이는 15라인을 넘어가지 않도록 한다.



---

# 문자열 덧셈 계산기

## 요구 사항 분석
- [x] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

## 문자열 계산기 기능

- [x] 문자열 덧셈 계산기가 있다.
- [x] 문자열 계산기는 문자를 입력받는다.
  - [x] 빈 문자열을 입력할 경우 0을 반환한다.
  - [x] null을 입력할 경우 0을 반환한다.
  - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
  - [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다
  - [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다
  - [x] 음수를 전달할 경우 예외가 발생한다.
