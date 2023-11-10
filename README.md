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
[O]입력 받은 금액을 검증한다.
- [O] 숫자 포멧이 아니라면 에러를 던진다.
- [O] 입력갑이 정수가 아니라면 에러를 던진다.
- [O] 1,000원 미만의 값을 입력받았다면 에러를 던진다.
- [O] 100,000원 초과된 값을 입력했다면 에러를 던진다.

로또를 구매한다.
- [] 구매 가능한 최대 수량을 반환한다. (1000원 == 1장)
- [] 구매 가능 수량만큼 6개의 숫자를 랜덤하게 배출한다.(ASC)

당첨 번호를 입력 받는다.
- [O] 콤마(,)를 기준으로 문자열을 분리한다.
- [] 분리된 값의 포멧이 숫자 아니라면 에러를 던진다.
- [] 입력된 숫자가 6개가 아니면 에러를 던진다.
- [] 1 ~ 45사이의 숫자가 아니라면 에러를 던진다.

당첨 여부를 확인한다
- [] 구매한 번호화 당첨 번호를 비교하여 일치하는 숫자의 개수를 반환한다.
- [] 일치하는 수를 기준으로 구분하여 기록한다. (일치하는 수 3개 이상만 기록)

수익률을 구한다.
- [] 구매 금액과 당첨 금액을 사용하여 수익률을 반환한다.
