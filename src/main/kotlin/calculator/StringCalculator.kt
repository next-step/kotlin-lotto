package calculator

object StringCalculator {

    fun add(input: String): Int {
        // 1. 입력값에서 구분자 분리하기
        val delimiters = DelimiterParser.extractDelimiters(input)
        delimiters.validateInput(input)

        // 2. 커스텀 구분자 선언부를 뺀 순수 입력  값 추출하기
        val pureInput = DelimiterParser.extractInputWithoutDelimiterDeclarations(input)

        // 3. 입력값에서 숫자 분리하기
        val positiveNumbers = delimiters.extractPositiveNumbers(pureInput)

        // 4. 각 숫자들을 모두 더하기
        return positiveNumbers.sum()
    }
}

fun main() {
    val result = StringCalculator.add(readln())
    println(result)
}
