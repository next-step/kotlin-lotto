# Nextstep 4기 - 로또 (TDD)

## 1단계 - 문자열 덧셈 계산기

### 기능 요구 사항

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과
  같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.

### 프로그래밍 요구 사항

* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 체크 리스트

* [x] 문자열로 된 입력으로 `덧셈`만을 수행하는 계산기를 구현
    * [x] 단위 테스트를 먼저 작성하고 구현은 나중에 하기
    * [x] 유효하지 않은 문자열을 입력하는 경우 0을 반환
        * [x] null
        * [x] 빈 문자열
    * [x] 숫자 하나를 입력하는 경우 해당 숫자를 반환
    * [x] 숫자 두개와 구분자로 입력할 경우 두 숫자의 합을 반환
        * [x] 컴마(,) 구분자
        * [x] 콜론(:) 구분자
    * [x] `//`와 `\n` 문자 사이에 커스텀 구분자를 지정하여 합을 반환
    * [x] 음수가 전달되는 경우 RuntimeException 예외 발생
* [x] 인덴트 2 Depth 미만으로 유지
* [x] 함수가 단일 기능만을 수행하도록 구현
* [x] 함수가 10라인을 넘어가지 않도록 구현

## 2단계 - 로또(자동)

### 기능 요구 사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구 사항

* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 체크 리스트

* [x] 6개의 숫자를 포함하는 로또 티켓 구현
    * [x] 6개 이하로 가지고 있으면 예외 발생
    * [x] 6개 이상으로 가지고 있으면 예외 발생
* [x] 로또 티켓 발급기 구현
    * [x] 1-45 사이의 무작위 6개를 가지는 번호를
    * [x] 발급된 번호를 오름차순으로 정렬
    * [x] 로또 티켓을 발급
        * [x] 1개
        * [x] n개
* [x] 로또 판매점 구현
    * [x] 1000원 = 1개 로또번호 발행
    * [x] ? x 1000원 = ?개 로또 번호 발행
    * [x] 1000원 미만으로 구입하려는 경우 예외 발생
    * [x] 한번에 100개 이상 구매하려고 하는 경우 예외 발생
* [x] 로또 통계 구현
    * [x] 3, 4, 5, 6개 각각 일치하는 개수를 반환
    * [x] 총 구매비용을 입력하면 수익율을 반환
* [x] 로또 UI 구현
    * [x] 로또를 구매할 수 있는 화면
        * [x] 구매 금액 입력 화면
        * [x] 지난 주 당첨번호 입력 화면
    * [x] 구매한 로또 번호 목록을 확인할 수 있는 화면
    * [x] 당첨된 로또 통계를 확인 할 수 있는 화면
        * [x] 로또 통계로 각(3,4,5,6) 일치 개수로 정렬하여 표시
        * [x] 총 수익률을 하단에 표시
* [x] 로또 메인 구현

## 3단계 - 로또(2등)

### 기능 요구 사항

* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구 사항

* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* Enum 클래스를 적용해 프로그래밍을 구현한다.
* 일급 컬렉션을 쓴다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 체크 리스트

* [x] 로또 통계 구현
    * [x] 5개 번호 일치 + 보너스 번호 일치 개수 반환
* [x] 로또 UI 구현
    * [x] 보너스 번호를 입력할 수 있는 화면
    * [x] 5개 번호 일치 + 보너스 번호 일치되는 결과 화면
* [x] 로또 메인 구현
    * [x] 보너스 번호 입력 + 보너스 번호 일치 결과 화면 연결
* [ ] 일급 컬렉션으로 구현
    * [x] 로또 티켓 목록
    * [x] 지난주 당첨 번호
    * [x] 통계
    * [x] 일치

## 4단계 - 로또(수동)

### 기능 요구 사항

* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구 사항

* 모든 원시값과 문자열을 포장한다.
* 예외 처리를 통해 에러가 발생하지 않도록 한다.
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* Enum 클래스를 적용해 프로그래밍을 구현한다.
* 일급 컬렉션을 쓴다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 체크 리스트

* [x] 원시타입 Wrapping 하기
    * [x] 번호 : LottoNumber
    * [x] 입력 금액: PurchaseMoney
* [x] 수동 번호 입력 기능
    * [x] 수동 횟수 입력
    * [x] 수동 로또 번호 입력
* [x] 에러 처리
    * [x] 구입 금액 에러 처리
    * [x] 수동 구매 횟수 입력 에러 처리
    * [x] 수동 입력 번호 에러 처리
    * [x] 지난주 당첨번호 입력 에러 처리
    * [x] 보너스 번호 입력 에러 처리
    * [x] 논리적 오류 이외에는 예외 발생하지 않도록 수정
