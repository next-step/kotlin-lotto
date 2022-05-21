# 1단계 - 문자열 덧셈 계산기

## 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
    - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
      예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 포로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.

## 명시된 테스트 케이스

- [ ] "" 을 입력한 경우 0 이 반환된다
- [ ] null 을 입력한 경우 0 이 반환된다
- [ ] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
- [ ] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
- [ ] 구분자 문자로 콜론(:)을 사용할 수 있다.
- [ ] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다
- [ ] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.

## 추가한 테스트 케이스

#### 예외 케이스

- [ ] 커스텀 구분자 가 아닌 경우 숫자, ',' ':' 를 제외한 문자 입력시 IllegalArgumentException 발생
- [ ] 커스텀 구분자 인 경우 `;n` 이후에 숫자, ',' ':' 를 제외한 문자 입력시 IllegalArgumentException 발생
- [ ] 커스텀 구분자 가 숫자인 경우 IllegalArgumentException 발생

# 도메인

## 계산 영역

### calculateNumber

- 분리된 숫자

### numberListManager

- 분리된 숫자를 관리한다

### Calculator

- `calculateNumbers` 에서 숫자를 받고 총합 값을 내보낸다 - sumAll

## 문자 분리 하기 위한 영역

### Separators

- 구분자들을 관리한다.

### InputDto

- 연산식 문자에 유효성 검사를 합니다
    - 커스텀 구분자 가 아닌 경우 숫자, ',' ':' 를 제외한 문자 입력시 IllegalArgumentException 발생
    - 커스텀 구분자 인 경우 `;n` 이후에 숫자, ',' ':' 를 제외한 문자 입력시 IllegalArgumentException 발생

### StringExpressionParser

- 연산식에서 구분자, 숫자 문자열을 분리한다.
- 연산식에서 구분자(`Separator`)를 사용하여 숫자들을 가지고 온다.
- 숫자 유효성 검사

### StringSeparatorParser

- 구분자

### StringNumbersParser
- 

### Separator

- 구분자를 관리한다
- 연산식에서 커스텀 구분자를 가져옵니다.
- 구분자 유효성 검사
    - 커스텀 구분자 가 숫자인 경우 IllegalArgumentException 발생

## 작업 리스트

- [x] InputDto 구현
- [ ] StringExpressionParser 구현
- [ ] Separator 구현
- [ ] Calculator 구현