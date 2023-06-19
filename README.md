# kotlin-lotto

## 1. 문자열 계산기
### 1.1. 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
  - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 1.2. TDD로 구현한 점
#### 1.2.1. 먼저 기능 요구 사항을 README에 copy & paste
#### 1.2.2. 각 기능을 쪼개고 각각에 대해 무조건 실패하는 테스트를 작성 후 구현

첫 번째 기능 : 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - [x] Test1 : null이나 빈 문자열을 전달하면 0을 반환한다
    - 컴파일 에러를 하나씩 해결해 가면서 구현
    - 일단 무조건 0을 반환하게 처리함
  - [x] Test2 : 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
    - Integer.parseInt(text)를 이용해서 구현
    - Test1이 통과 안되기 때문에 예외처리 추가
  - [x] Test3 : 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다
    - split으로 구분시킨 후 sumOf를 이용해서 구현
  - [x] Test4 : 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
    - split함수를 살펴보니 구분자를 varargs로 받고있어서 그냥 ":"도 넣어줬더니 성공했다
    
두 번째 기능 : 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 "여러개" 지정할 수 있다.(한 개라는 말은 없으니)
  - [x] Test5 : //와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.
    - //로 시작하는 경우 \n을 찾아서 사이에 있는 문자들을 커스텀 구분자로 지정하게 함
    - \n이후의 문자들을 기존과 동일하게 더하도록 함
    - //로 시작하지 않으면 바로 기존의 메서드와 동일하게 더하도록 함

세 번째 기능 : 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- [x] Test6 : "-1"을 전달한다.
  - 원래 toInt()로 변환하던걸 numberConverter를 구현하여 대체
- [x] Test7 : "A:B"를 전달한다.
  - numberConverter 때문에 자동으로 통과
- [x] Text8 : 커스텀 구분자로 "-"가 들어가도 RutimeException던지도록 한다.
  - 구분자로 "-"가 들어갈 수 없도록 getCustomizedDelimiter에서 "-"가 들어가면 RuntimeException 던지도록 수정

## 2. 로또 (자동)
### 2.1. 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. 
- 로또 1장의 가격은 1000원이다.

### 2.2. TDD로 구현한 점
#### 2.2.1. 기능 요구 사항을 세부 기능으로 분할하기
- 구입금액을 입력받는다.
- 입력받은 구입금액으로 최대로 구입 가능한 로또 갯수를 출력한다.
  - 임의로 추가) 구입 가능한 갯수가 0개거나 1000개가 넘어가면 다시 입력 받는다.
- 1부터 45까지의 숫자 중 랜덤으로 6개를 오름차순으로 정렬한 배열을 구입한 로또 갯수만큼 출력한다.
- 당첨 번호 6개를 입력 받는다.
  - 임의로 추가) 당첨 번호가 1~45 범위를 벗어나거나 6개가 아니면 다시 입력 받는다.
- 당첨 통계를 출력한다.
  - 3개, 4개, 5개, 6개 일치한 갯수를 출력한다.
  - 구입한 금액으로 총 상금을 나눈 수익률을 소숫점 두자리까지 출력한다.
  - 수익률 기준으로 손해인지 이득인지 출력한다.

#### 2.2.2. 각 세부 기능에 대해 무조건 실패하는 테스트를 작성 후 구현
첫 번째 기능 : 입력받은 구입금액으로 구입 가능한 로또 갯수를 출력한다.
- [x] Test1 : 입력받은 구입금액을 1000으로 나눈 몫을 출력한다.
  - 로또 buy 함수는 정수를 받는 것으로 구현
- [ ] Test2 : 0원이나 100만원 이상을 입력 받으면 다시 입력을 받는다.


두 번째 기능 : 
- [ ] Test2 : 