# kotlin-lotto

## 문자열 덧셈 계산기
### 기능 요구 사항
- [x] input 이 0 이나 null 일 경우 0 반환
- [x] input 에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외 throw
- [x] input 에 숫자 하나가 전달될 경우 그 숫자를 반환
- [x] input 에 쉼표(,) or 콜론(:)을 구분자로 가지는 문자열이 전달될 경우 구분자를 기준으로 숫자의 합을 반환
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다
  - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다

### 프로그래밍 요구 사항
- [x] indent는 depth가 2를 넘지 않도록 구현
  - ex) while 문 안에 if 문이 있으면 들여쓰기는 2이다
- [x] 함수의 길이가 10개 Line을 넘어가지 않도록 구현
  - 함수가 한 가지 일만 잘 하도록 구현


  
## 로또(자동)
### 기능 요구 사항
- [x] 구입한 금액에 해당하는 구매 갯수 반환
- [ ] 천원 단위가 아닐 경우 내림
- [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다

### 프로그래밍 요구 사항
- [x] InputView 생성
- [ ] indent는 depth가 2를 넘지 않도록 구현
- [ ] 함수의 길이가 15 라인을 넘어가지 않도록 구현
- [ ] ResultView 생성

