# 문자열 덧셈 계산기

1. 쉼표(,) 또는 콜론(:)을 구분자 문자열 -> 숫자의 합을 반환
2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
3. `//?\n` 에서 ?에 커스텀 구분자
4. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 생각한 점

1. 각각의 구분자들을 인터페이스 또는 추상클래소 묶어서 관리 
2. require 사용하려 했으나, RuntimeException 발생으로 할거면 null 을 받도록 한 후 검증 처리 
3. 구분자에 대한 클래스가 있으면 좋을 것 같다. 
4. 각각의 구분자들의 클래스를 모은 일급 컬렉션 구분자를 사용하고 각각의 구분자를 더해서 문자열로 만드는 작업하면 될 듯 
5. 문자열을 getter 하고 split 하는 방법도 있지만 구분자에서 값을 받으면 나눈 값을 반환해도 좋을 듯  
  
## 설계      
* [ ] Expression : 입력된 문자열      
  * 입력된 문자열에 대한 VO 클래스 
  * Null 체크
  * 공백으로만 이루어졌는지 체크
* [ ] Separator : 구분자
  * 하나의 구분자에 대한 VO 클래스
  * Null 체크
  * 공백으로만 이루어졌는지 체크
  * 숫자로 이루어졌다면? 이건 좀 고민해봐야할 듯 
* [ ] Separators : 구분자 일급 컬렉션
  * 일급 컬렉션 VO 클래스 
  * `Set<Seperator>` 를 가지고 있는 일급 컬렉션
  * Null 체크, 
  * empty() 체크 
  * 알맞게 분리한 문자열 반환 
* [ ] CalculationResult : 결과값 -> 팩토리 메서드로 조작 가능      
  * 결과값에 대한 VO 클래스
  * get()를 지원해서 View 에서 사용
* [ ] CalculationStrategy : 계산 자체에 대한 인터페이스   
  * AddCalculationStrategyStrategy : 덧셈 연산에 대한 작업 
* [ ] Calculator : 계산기
  * 싱글턴 객체로 사용 
  * Service 전용 클래스 
* [ ] CalculatorApplication  
  * 싱글턴 객체로 사용   
  * Input/Output 받는 Controller     
* [ ] InputView   
  * 싱글턴이면 좋지만 프로퍼티 들어오면 그냥 사용  
* [ ] ResultView  
  * 싱글턴이면 좋지만 프로퍼티 들어오면 그냥 사용  
* [ ] InputStrategy : 입력 방식에 대한 전략    
    * [ ] ConsoleInputStrategy : 콘솔 입력에 대한 방식   
* [ ] ConsoleOutputStrategy : 출력 방식에 대한 전략    
    * [ ] ConsoleOutputStrategy : 콘솔 출력에 대한 방식 