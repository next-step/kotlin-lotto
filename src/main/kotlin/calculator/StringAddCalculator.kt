package calculator

class StringAddCalculator {
    fun add(inputExpression: String?): Int {
        var resultCalculator = 0

        if (inputExpression.isNullOrEmpty()) return resultCalculator

        val expressionParser = ExpressionParser(inputExpression)
        val numberArray = expressionParser.numberString.split(*expressionParser.customSeperator)

        for (i in numberArray) resultCalculator = add(resultCalculator, i)
        return resultCalculator
    }

    private fun add(firstElement: Int, secondElement: String): Int {
        check(secondElement.toInt() >= 0) { "더할 숫자는 모두 양수로 입력해야합니다" }
        return firstElement + secondElement.toInt()
    }
}
