# Step 1 - 문자열 덧셈 계산기

## 기능 요구 사항

1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
   예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 목록

- [O] 입력받은 문자열을 쉼표(,) 또는 콜론(:)을 구분자로 나눈다.
- [O] 분리된 문자열의 합을 구한다.
- [O] 빈 문자열 또는 null을 입력할 경우 0을 반환해야한다.
- [O] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [O] 입력 받은 문자열의 //과 \n 사이에 위치하는 값을 커스텀 구분자로 사용할 수 있다.
- [O] 숫자 이외의 값 혹은 음수 전달 시 RuntimeException 예외를 throw 한다.

# Step 2 - 로또(자동)

## 기능 요구사항

1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.
3. 당첨 번호를 입력한다.
4. 소수 2자리 까지 수익률을 구한다. (당첨 금액 / 구매 금액)

## 기능 목록

로또 번호 (object)

- [O] 범위 1 ~ 45

로또 (Data)

- [O] 로또 번호를 6개를 가지고 있어야한다.
- [O] 중복이 없는 로또 번호를 가지고 있어야한다.

로또 머신 (object)

- [O] 입력받은 번호로 구성된 로또로 생성한다.
- [O] 당첨 여부 검증

로또 게임 (class)

- [O] 랜덤한 6개의 수를 생성한다.
- [O] 입력받은 금액의 최대 수량만큼 로또를 구해한다.
- [O] 당첨 통계를 낸다.

inputView (object)

- [O] 입력된 금액 포맷 검증
    - [O] 숫자 포맷 검증
    - [O] 금액 범위는 1,000원 이상 100,000원 이하의 정수
- [O] 지난 당첨 번호 포맷 검증
    - [O] 콤마(,)를 기준으로 나눈다
    - [O] 숫자 포맷 검증
