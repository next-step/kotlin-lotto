# kotlin-lotto

<details>
<summary>문자열 덧셈 계산기</summary>
## 문자열 덧셈 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - “” => 0, 
  - "1,2" => 3
  - "1,2,3" => 6
  - “1,2:3” => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
### 요구 사항 정의
#### 피연산자(Operand)
- [x] 숫자인 값을 가질 수 있다.
- [x] 다른 피연산자와 더할 수 있다.
- [x] 음수를 입력 받으면 예외를 발생시킨다.

#### 구분자(Separator)
- [x] 구분자로 사용할 문자를 가질 수 있다.
- [x] 구분자의 길이가 1이 아니라면 예외를 발생시킨다.
- [x] 구분자가 숫자인 경우 예외를 발생시킨다.

#### 구분자 목록(Separators)
- [x] 쉼표`,`와 콜론`:`을 기본 구분자로 가진다.
- [x] 유효한 구분자를 추가할 수 있다.
- [x] 구분자는 중복될 수 없다.
- [x] 모든 구분자에 해당하는 정규식을 표현할 수 있다.

#### 문자열 토크나이저(StringTokenizer)
- [x] 입력받은 문자열을 구분자를 사용해 토큰화할 수 있다.
- [x] 문자열에 포함된 커스텀 구분자를 추출할 수 있다.

#### 문자열 덧셈 계산기
- [x] 입력된 문자열이 null 혹은 비어있으면 0을 반환한다.
- [x] 문자열을 입력받아 숫자의 합을 반환할 수 있다.
</details>

## 로또

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다
- 로또 1장의 가격은 1000원이다

### 기능 명세

#### 로또 번호(LottoNumber)
- [x] 1 ~ 45까지의 번호를 가진다.
- [x] 유효한 번호 범위를 벗어나면 예외를 발생시킨다.

#### 로또(Lotto)
- [ ] 6개의 고유한 로또 번호를 가진다.
- [ ] 로또 번호의 개수가 6개가 아니면 예외를 발생시킨다.
- [ ] 다른 로또와 비교해 일치하는 로또 번호의 개수를 알 수 있다.

#### 로또 생성기(LottoGenerator)
- [ ] 로또를 생성할 수 있다.

#### 로또 뭉치(LottoBundle)
- [ ] 1개 이상의 로또를 가진다.
- [ ] 보유한 로또가 없으면 예외를 발생시킨다.
- [ ] 입력받은 로또와 보유한 모든 로또를 비교해 로또 당첨 결과를 알 수 있다.

#### 로또 판매자(LottoSeller)
- [ ] 받은 금액만큼 로또를 생성해 판매한다.
- [ ] 받은 금액이 로또 1개의 가격보다 적은 경우 예외를 발생시킨다. 

#### 로또 구매자(LottoBuyer)
- [ ] 보유한 금액을 알 수 있다.
- [ ] 로또 판매자에게 로또를 구입할 수 있다.
- [ ] 지난주 당첨 번호를 통해 로또 당첨 결과를 확인할 수 있다.
