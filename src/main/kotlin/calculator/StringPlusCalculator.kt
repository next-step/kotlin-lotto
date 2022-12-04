package calculator

class StringPlusCalculator {
    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) { "빈 문자열 또는 null 을 입력할 수 없습니다." }
        val expressionSplitter = ExpressionSplitter()
        val splitted = expressionSplitter.split(expression = expression)
        val operands = splitted.map { Operand.from(it) }
        return operands.fold(0) { acc, operand -> acc + operand.value }
    }
}
