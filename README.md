# kotlin-lotto


## 기능요구사항 목록
- [X] 기본 구분자 (컴마, 콜론) 를 사용하는지 검증한다
- [X] 커스텀 구분자를 지정할 수 있다 
- [X] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- [X] 분리한 숫자들을 더한 값을 반환한다

## 생각의 흐름
기능요구사항에 따라서, 일단 (1)번인 '기본 구분자를 사용하는지 검증한다' 라는 단위를 테스트하려고한다
그런데, 결국에는 입력값을 구분자를 기준으로 분리해주는 책임을 가지는 객체가 필요할 것이고
그 객체의 내부 로직에서 기본 구분자를 사용하는지, 커스텀 구분자를 사용하는지 판단해서 분리해줄수있으니
굳이 이것을 구분하는 객체가 별도로 있어야하나?..
하지만 구분하는 객체가 별도로 있고, 이 구분하는 객체와 나누는 객체가 각자 책임을 갖고 협력하는것도 좋을듯하다
정확히는 기본 구분자를 사용하는지, 커스텀 구분자를 사용하는지 나누는것이 아니라
구분자가 무엇인지 반환하는 객체면 좋을듯

하다보니 SeparatorExtractor 보다는 StringSeparator 객체를 만들어서
주어진 입력을 구분자를 기준으로 나눠서 반환하는 객체가 더 의미있을것같다. 
그렇게 StringSeparator 를 생각해내고나니, 커스텀 구분자를 포함하는지 아닌지 여부를 
StringSeparator 가 판단하기보다는 별도의 객체의 책임으로 가지고 있는게 맞아보여서
CustomSeparatorRecognizer 라는 객체를 도입해본다

Recognizer 보다는 커스텀 구분자를 추출해서 반환하는 CustomSeparatorExtractor 가 더 나을것같다

CustomSeparatorExtractor 를 구현하다보니 
여기서는 커스텀 구분자를 반환하게 되는데
클라이언트 입장에서 커스텀 구분자를 사용한다는 것은 아는데
커스텀 구분자를 위한 심볼들이 어디부터 어디까지 있었는지 알 수 없어서
문자열을 제대로 split 할 수 없다.

따라서 CustomSeparatorStringSplitter 같은 객체를 만들어서
커스텀 구분자가 있으면 커스텀 구분자를 기준으로 split 해서 내려주는게 더 나을듯

CustomSeparatorStringSplitter 로 구현을 완료했고 좋은 접근방법인것같다. 
이제 DefaultSeparatorStringSplitter 를 구현하고
CustomSeparatorStringSplitter 과 DefaultSeparatorStringSplitter 를 체이닝해서
인풋값을 분할하면 될 것 같다
