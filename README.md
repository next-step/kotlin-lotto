# kotlin-lotto

## 1단계 프로그래밍 요구사항

- 인덴트 depth를 2를 넘지 않도록 구현한다. 1까지만 허용
- 함수의 길이가 10 라인을 넘어가지 않도록 구현한다

## 1단계 - 문자열 덧셈 계산기

### 기능 요구사항

- 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우, 구분자 기준으로 분리한 각 숫자의 합을 반환한다
- 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n"사이에 위치한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException을 던진다.

### 기능 명세서

- 문자를 숫자로 반환한다
    - [x] 입력받은 문자가 양수면 숫자로 처리한다
    - [x] null, 공백을 입력 받으면 0으로 반환한다
- 익셉션 처리 기능
    - [x] 숫자가 아닌 경우 RunTimeException을 전달한다
    - [x] 음수를 찾는 경우 RunTimeException을 전달한다
- 구분자로 문자열을 나눈다
    - [x] 쉼표 구분자로 숫자 문자열을 나눈다
    - [x] 콜론 구분자로 숫자 문자열을 나눈다
    - [x] 쉼표 또는 콜론 구분자로 문자열을 나눈다
    - [x] 커스텀 구분자를 지정한다
    - [x] 문자열에 커스텀 구분자를 찾는다
    - [x] 문자열에 커스텀 구분자 찾은걸 삭제한다
- [x] 계산기는 입력받은 숫자 문자열을 더한 결과를 반환한다.

## 2단계 - 로또(자동)

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원 이다.

### 기능 목록
- [x] 구매 금액에 맞는 로또를 생성한다
- [x] 구매 금액이 적으면 로또를 생성하지 못한다.  
- [x] 로또 번호는 중복되지 않는 1-45 숫자 6개를 선택한다
- [x] 로또 번호는 오름 순서대로 출력한다
- [x] 지난주 당첨 번호 문자열을 입력한다
- [x] 지난주 당첨 번호와 일치하는 갯수를 확인한다
- [x] 로또 티켓을 전달하면, 등수를 반환한다 
- [x] 당첨 번호와 일치하는 번호 갯수에 따라 로또 등수와 금액을 반환한다
- [x] 당첨번호 문자를 각 숫자 리스트로 변경한다
- [x] 구매한 로또가 당첨여부를 확인한다
- [x] 당첨된 로또에 대해 손익률을 계산한다
- [x] 당첨된 로또의 갯수가 몇개인지 결과를 반환한다


## 3단계 - 로또(2등)

### 기능 요구사항
- 2등을 위해 추가번호 하나 더 추첨한다
- 당첨 통계에 2등도 추가한다

### 기능 목록
- [ ] 2등 보너스 번호를 입력한다
- [x] 2등 보너스 번호에 지난당첨 번호가 있으면 익셉션을 발생시킨다
- [x] 로또 등수 계산 할 때 보너스 번호 유무에 따라서 2,3등을 구분한다
    - 5개 맞춤 && 보너스번호가 있으면 2등이다
    - 5개 맞춤 && 보너스 번호가 없으면 3등이다
