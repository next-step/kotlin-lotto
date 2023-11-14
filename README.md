# kotlin-lotto

## 🚀 1단계 - 문자열 덧셈 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### TODO
#### 프로그래밍 요구 사항
- [x] kotest 사용

#### 기능 요구 사항
- [x] 문자열 계산기는 문자열을 입력받을 수 있다.
- [x] 입력 문자열은 쉼표(,) 또는 콜론(:)을 구분자로 가지고, 이로 구분한 숫자는 모두 더한다.
- [x] 입력 문자열은 커스텀한 구분자를 입력할 수 있다.
- [x] 입력 문자열은 그 외에는 양수의 숫자만 입력할 수 있다. (음수인 경우 RuntimeException 예외 발생)
- [x] 문자열 계산기의 결과는 구분자를 기준으로 분리한 각 숫자의 합이다.


## 🚀 2단계 - 로또(자동)

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### TODO
- [x] 로또 번호는 1 ~ 45 사이의 숫자이다.
- [x] 로또 티켓은 로또 번호를 6개 가지고 있고, 생성하는 방법을 두 가지가 있다.
  - [x] 자동 생성 규칙은 1 ~ 45 사이의 숫자 중 6개를 랜덤으로 생성한다.
  - [x] 수동 생성 규칙은 1 ~ 45 사이의 숫자 중 6개를 직접 입력한다.
- [x] 로또 티켓은 서로 다른 6개의 번호를 갖는다.
- [x] 로또 당첨 기계는 당첨 번호에 해당하는 로또를 갖는다.
- [x] 로또 당첨 기계는 입력받은 로또와 당첨 번호 로또를 비교하여 몇 개의 번호가 일치하는지 알 수 있다.
  - 해당 로또 티켓에 결과를 물어보는 형태 
- [x] 로또 당첨 기계는 통계가 담긴 로또 결과를 반환할 수 있다.
  - 당첨 금액을 계산할 수 있다.
- [x] 위 과정을 콘솔로 입력받고 출력한다.


## 🚀 3단계 - 로또(2등)

### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다

### 프로그래밍 요구사항
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.

### TODO
- [x] LottoTicket은 2등을 위해 보너스 볼 번호를 갖는다.
- [x] 5개 일치 & 보너스 볼 번호 일치 rank(2등)를 추가한다.
- [x] LottoWinningMachine에 보너스 로또 번호를 추가한다.
- [x] 콘솔 입력 시 보너스 볼 번호도 입력받는다.
- [x] 콘솔 출력에 당첨 통계 2등도 추가한다.


## 🚀 4단계 - 로또(수동)

### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구사항
- 모든 원시값과 문자열을 포장한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.

### TODO
- [x] LottoNumbers 객체는 로또 번호 6개 집합을 생성하는 역할을 갖는다.
  - LottoNumber를 생성하는 Rule을 LottoNumbers를 생성하는 Rule로 변경한다.
  - 로또 번호는 1 ~ 45 사이의 숫자로 정해져있어 캐싱을 통해 생성된 객체를 재사용한다.
  - 캐싱은 LottoNumbers 객체에서 관리한다.
  - value class 이므로 객체를 생성하지 않아서 캐싱을 할 필요는 없어보인다.
  - (캐싱을 하면 수동 생성에서 예외 메시지를 LottoNumbers에서만 관리하기가 어렵다.)
- [x] LottoTicket은 LottoNumbers 객체 생성과 매칭 결과를 계산하는 역할을 한다.
- [ ] LottoTicketMachine은 금액 및 수동 번호 개수를 입력받아 로또 티켓을 생성하는 역할을 한다.
- [ ] 콘솔에서 수동으로 구매할 로또 개수를 입력받는다.
- [ ] 콘솔에서 수동으로 구매할 로또 번호를 입력받는다.
- [ ] 콘솔에서 수동, 자동으로 몇 장씩 구매했는지와 로또 번호 결과를 출력한다.
- [ ] 예외 처리를 통해 에러가 발생하지 않도록 한다.
