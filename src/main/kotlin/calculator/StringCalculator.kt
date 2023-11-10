package calculator

fun main() {
    // 1. 입력값 받기
    val inputString = readln()

    // 2. 입력값에서 구분자 분리하기
    val delimiters = DelimiterParser.extractDelimiters(inputString)
    delimiters.validateInput(inputString)

    // 3. 커스텀 구분자 선언부를 뺀 순수 입력값 추출하기
    val pureInput = DelimiterParser.extractPureInput(inputString)

    // 4. 입력값에서 숫자 분리하기
    val positiveNumbers = delimiters.extractPositiveNumbers(pureInput)

    // 5. 각 숫자들을 모두 더하기
    val result = positiveNumbers.sum()

    // 6. 결과물 출력하기
    println(result)
}
