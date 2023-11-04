# kotlin-lotto

## 문자열 덧셈 계산기 기능 목록
- [x] 커스텀 구분자 있는지 확인
- [x] 구분자 파싱
- [x] 특정 구분자로 문자열을 파싱한다
- [x] 쉼표(,) 또는 콜론(;)을 구분자로 문자열 파싱한다 
- [x] 모든 문자가 0보다 큰 숫자 인지 확인한다
- [x] 문자가 0보다 큰 숫자 인지 큰 숫자인지 확인한다 
- [x] 숫자들의 합을 구한다
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 RuntimeException 예외를 던진다
- [x] 통합 

## 로또
### 기능목록
- [x] 구입금액을 입력 요청 기능
- [x] 받은 돈은 1000이상이고 1000원단위이여야 하는 검증 기능 
- [x] 받은 돈으로 로또 티켓 개수를 계산하는 기능 
- [x] (받은 돈/티켓가격) 만큼 티켓을 생성하는 기능
- [x] 티켓 개수 만큼 티켓을 생성하는 기능
- [x] 자동으로 서로 다른 로또번호를 6개 생성하는 기능
- [x] 로또번호는 1보다 크고 45이하인 지 확인 하는 기능
- [x] 생성한 로또번호를 오름차순으로 정렬하는 기능
- [x] 생성한 로또번호로 티켓을 만드는 기능
- [x] 서로 다른 6개 로또 번호가 아니면 예외던지는 기능
- [x] 당첨 번호를 입력 요청 기능
- [x] 입력 내용을 당첨 번호로 파싱하는 기능
- [x] 당첨 번호 생성시 중복된 로또 번호를 허용하지 않는 기능
- [x] 티켓과 로또번호 리스트와 비교하여 매칭 카운트를 확인하는 기능
- [x] 당첨 번호와 구입한 티켓들과 비교하여 당첨 결과 추출하는 기능
- [x] 받은 금액과 비교하여 계산하는 기능
- [x] 매칭 결과 가져와서 통계 결과를 만든다
- [x] 당첨 통계를 출력하는 기능
