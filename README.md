# kotlin-lotto

## step1 문자열 계산기 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    - [x] 문자열 구분자 변환기 구현 (핵심 도메인 엔티티)
        - [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
            - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
        - [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
    - [x] 원시값을 포장한 도메인객체 구현
        - [x] 연산자 오버라이딩 구현

## 로또 (자동) 기능 요구사항
- [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - [ ] 금액은 0 이상이다.
  - [ ] 1000원 이하는 거스름돈이다.
- [ ] 로또 1장의 가격은 1000원이다.
