# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기
### 구현대상
1. 표현식에서 구문과 구분자를 build 할 수 있다
```kotlin
Expression("1,2").delimiters() // [",", ";"]
Expression("//;\n1;2;3").delimiters() // [";"]
Expression("1,2").syntax() // "1,2"
```

2. 표현식으로부터 글자 리스트 표현한다
```kotlin
Letters(Expression("1,2")) // ["1", "2"]
```

3. 숫자 리스트를 빌드한다
```kotlin
PositiveIntList(["1", "2"]) // [1, 2]
```

4. 숫자 리스트를 모두 더한다
```kotlin
Sum([1, 2]) // 3
```
