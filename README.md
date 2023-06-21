# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 목록

- [x] 빈 문자열 또는 null 을 입력하면 0을 반환한다
- [x] 숫자 하나를 입력하면 해당 숫자를 반환한다
- [x] 두 개 이상의 숫자를 쉼표 또는 콜론으로 입력하면 덧셈 결과를 반환한다
- [x] 문자열을 기본 구분자(, 또는 :) 로 분리한다
- [x] 커스텀 구분자를 지정할 수 있다
- [x] 문자열 앞부분의 //와 \n사이에 존재하는 커스텀 구분자를 식별할 수 있다
- [x] 커스텀 구분자로 문자열을 분리한다
- [x] 분리한 숫자들의 합을 구한다
- [x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException을 throw 한다

#### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    - ex) “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - ex) “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

#### 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - ex) while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

## 로또(자동)

### 기능 목록

- [x] 로또는 6개의 숫자가 1 ~ 45 중 하나의 숫자로 중복 없이 생성된다
- [x] 금액만큼 로또를 구매한다
- [x] 당첨 번호로 일치하는 숫자의 개수를 구한다
- [x] 수익률을 소수 두 번째 자리까지 구해서 보여준다
- [x] 구매한 로또에 대해서 통계를 제공한다

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
- 로또 1장의 가격은 1000원

### 프로그래밍 요구 사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 함 (UI 로직은 제외)
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직 구분
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현 (1까지만 허용)
    - ex) while문 안에 if문이 있으면 들여쓰기는 2가 됨
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 됨
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가

## 로또(2등)

### 기능 목록

- [ ] 추가 번호 입력을 받는다
- [ ] 번호 5개 + 보너스 번호가 일치한 경우에 2등으로 처리한다
- [ ] 당첨 통계에 2등을 추가한다

### 기능 요구 사항

- 2등을 위해 추가 번호를 하나 더 추첨
- 당첨 통계에 2등도 추가

### 프로그래밍 요구 사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 함 (UI 로직은 제외)
- Enum 클래스 적용
- 일급 컬렉션 사용
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현 (1까지만 허용)
    - ex) while문 안에 if문이 있으면 들여쓰기는 2가 됨
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가
