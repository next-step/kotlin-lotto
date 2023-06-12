# kotlin-lotto

```
쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
```

- [x] 공백을 입력하는 경우 0이 입력된다.
- [x] 연산자 없이 숫자만 입력되는 경우 숫자를 그대로 반환한다.
- [x] 숫자가 아닌 문자가 입력되는 경우 예외가 발생된다.
- [x] 음수가 입력되는 경우 예외가 발생된다.
- [x] 쉼표(,)가 입력되는 경우 숫자의 합을 반환한다.
- [x] 콜론(:)이 입력되는 경우 숫자의 합을 반환한다.
- [x] 문자열의 앞에 "//"와 "\n" 사이에 문자열을 입력하는 경우 해당 문자를 커스텀 구분자로 사용하여 합을 반환한다.

## 로또(자동)
```
로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다.
```
### money
- [x] 돈은 0원 미만이 될 수 없다.
- [x] 1000원 미만인데 로또를 사려하면 예외가 발생한다.

### lotteryNumber
- [x] 로또 번호는 1-45 외의 수가 저장되려하는 경우 예외가 발생한다.

### lotteryNumber
- [x] 로또 번호가 6개 입력되지 않는 경우 예외가 발생한다.
- [x] 로또 번호가 중복되어 입력될 경우 예외가 발생한다.
- [x] 로또 번호 6개를 가지고 있다.
- [x] 당첨 로또와 비교하여 몇개 맞추었는지 반환할 수 있다.

### lotteries
- [x] 당첨 로또와 비교하여 모든 로또의 통계를 반환할 수 있다.

### rank
- [x] 1등은 6개가 일치하며 당첨금액은 2_000_000_000원이다.
- [x] 2등은 5개가 일치하며 당첨금액은 1_500_000원이다.
- [x] 3등은 4개가 일치하며 당첨금액은 50_000원이다.
- [x] 4등은 3개가 일치하며 당첨금액은 5_000원이다.
- [x] 3개 미만인 경우 당첨금액은 없다.
- [x] matchCount가 룰에 벗어나는 값이면 예외가 발생한다.
- [x] Rank map에 없는 값은 0으로 채워 반환한다.

### lottery result
- [ ] 수익률을 확인할 수 있다.

### input view
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
```
- [x] 구입금액을 입력할 수 있다.
- [ ] 구입된 로또번호 목록을 출력하여야 한다.

### output view
```
당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```
- [ ] 일치한 개수를 출력한다.
- [ ] 총 수익률을 출력한다.
