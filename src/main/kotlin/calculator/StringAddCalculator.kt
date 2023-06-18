package calculator

object StringAddCalculator {
    fun sumByExpression(inputExpression: String?) =
        if (inputExpression.isNullOrEmpty()) 0
        else NumberExtractor().extractNumbers(inputExpression).sumOf { target -> toInt(target) }

    private fun toInt(element: String): Int {
        check(element.toInt() >= 0) { "더할 숫자는 모두 양수로 입력해야합니다" }
        return element.toInt()
    }
}
