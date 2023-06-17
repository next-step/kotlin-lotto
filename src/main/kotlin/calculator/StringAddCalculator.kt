package calculator

object StringAddCalculator {
    fun sumByExpression(inputExpression: String?): Int {
        var resultCalculator = 0

        if (inputExpression.isNullOrEmpty()) return resultCalculator

        val numberArray = NumberExtractor().extractNumbers(inputExpression)

        resultCalculator = numberArray.sumOf { target -> toInt(target) }
        return resultCalculator
    }

    private fun toInt(element: String): Int {
        check(element.toInt() >= 0) { "더할 숫자는 모두 양수로 입력해야합니다" }
        return element.toInt()
    }
}
