# kotlin-lotto
## 문자열 덧셈 계산기

### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 구현할 기능 정의
#### 기본 기능
- [ ] 빈 문자열을 입력할 경우 0을 반환한다.
- [x] 쉼표(,) 또는 콜론(:)을 기준으로 문자열을 분리한다.
- [ ] 분리된 문자열을 숫자로 변환한다.
- [ ] 변환된 숫자 리스트를 더해서 합계를 반환한다.

#### 커스텀 구분자 지원
- [ ] 문자열의 앞부분에서 "//"와 "\n" 사이에 커스텀 구분자가 있는지 확인한다.
- [ ] 커스텀 구분자가 존재할 경우 해당 구분자를 기준으로 문자열을 분리한다.

#### 예외 처리
- [ ] 숫자 이외의 값이 포함된 경우 `RuntimeException`을 throw 한다.
- [ ] 음수가 포함된 경우 `RuntimeException`을 throw 한다.
- [ ] 공백이 포함된 경우 이를 무시하거나 올바르게 처리한다.
