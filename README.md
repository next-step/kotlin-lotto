# kotlin-lotto
###StringStringCalculator

1. InputView, StringConverter, StringCalculator 구조
2. StringCalculator
    - 숫자 합 구하기
    - "" 입력시, 0 리턴
    - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw
3. StringConverter
    - String 에서 숫자 분리
    - Custom 구분자 추가
4. InputView,ResultView
5. TestCase 
    - StringCalculator
        - 정상 숫자 합 구하기 
        - 0 합 구하기 
        - 음수 및 숫자 아닌 경우, RuntimeException
    - StringConverter
        - ,; 로 구성된 String Test
        - \n,// 가 추가된 String Test
    -InputView 입력 테스트
    
##Lotto

1. Prize Enum , lotto , LottoNumberGenerater , lottoManager ,MoneyManager , inputView, resultView
2. Prize 
    - 당첨금 Enum
    - 당첨금 환산  
3. lotto
    - Numbers
    - getPrize 
4. LottoNumberGenerater 
    - RandomNumberGenerater
5. lottoManager
    - lottos 관리
    - 지난주 번호로 당첨 처리
6. MoneyManager
    - 입력된 돈으로 buy lotto 
    - 수익률 계산
7. TestCase 
    - lotto Generator Test 
    - lotto Prize Test
    
요구사항 
- 로또 1개는 1000원
- 입력된 금액으로 로또 구입 