# kotlin-lotto

### step1 문자열 덧셈 계산기

+ [] 문자열 덧셈 계산기 구현
    + [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력
    + [x] 입력 값이 음수 혹은 숫자가 아닌 경우 `RuntimeException` 발생
    + [x] 빈 문자열 또는 null 입력한 경우 `RuntimeException` 발생
    + [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
    + [] 커스텀 구분자를 지정할 수 있도록 구현
        + [] 커스텀 구분자는 문자열 앞부분의 `//`와 `\n` 사이에 위치
        + [] 커스텀 구분자는 한 개 지정 가능
        + [] 커스텀 구분자와 기본 구분자를 함께 사용할 수 있음
    + [x] 구분자를 기준으로 분리한 각 숫자의 합을 반환