# kotlin-lotto

## 문자열 계산기 요구사항
1. 문자열을 입력받는다.
2. 쉼표로 연결된 숫자들은 더한다.
3. 콜론으로 연결된 숫자들을 더한다.
4. 쉼표와 콜론이 섞여서 연결된 숫자들을 더한다.
5. //와 \n 사이에 문자열을 입력받으면 커스텀 구분자로 인식한다.
6. 커스텀 구분로 연결된 숫자들을 더한다.
7. 커스텀 구분자와 일반 구분자(콜론과 쉼표)가 섞여있는 숫자들을 더한다.
8. 음수 또는 숫자 이외의 값을 전달하는 경우 throw.
9. 빈 문자열 또는 null을 입력받은 경우 0을 반환한다.
10. 숫자 하나를 입력한 경우, 이를 반환한다.
11. 커스텀 문자열이 처음 위치에 있지 않은 경우 throw

## 로또(자동) 요구사항
1. 구입 금액을 입력받는다.
2. 구입 금액을 1000을 나눠서 구매 횟수를 구한다.
3. 구매 횟수를 출력한다.
4. 구매 횟수 만큼 로또 번호를 랜덤으로 출력하고 저장한다.
5. 지난 주 당첨 번호를 입력받는다.
6. 각 로또 번호와 당첨 번호의 일치 횟수를 찾는다.
7. 일치 갯수(3, 4, 5, 6개)에 따른 로또 개수를 저장한다.
8. 수익률을 계산한다.
9. 로또 티켓이 있다.
10. 로또 티켓은 로또 숫자 6개를 가지고 있다.
10. 로또 티켓은 당첨 번호와 몇 개가 매칭되었는지를 확인해서 리턴한다.
11. 로또 티켓 컬렉션은 로또들의 통계를 만든다.
11. 로또 티켓 생성기는 6개의 랜덤 숫자를 만들어서 로또 티켓을 만든다.(중복된 숫자는 없다. 정렬되어있다.) 

